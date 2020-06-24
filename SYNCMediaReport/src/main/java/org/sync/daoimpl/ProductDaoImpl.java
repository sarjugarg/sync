package org.sync.daoimpl;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.sync.dao.ProductDao;
import org.sync.model.Filter;
import org.sync.model.FilterData;
import org.sync.model.Product;
import org.sync.model.AllDashboard;
import org.sync.model.Channel;
import org.sync.model.ChannelComparator;
import org.sync.model.TotalAddData;
import org.sync.daoimpl.AirtimeLogic;
public class ProductDaoImpl implements ProductDao {
	@Autowired
	AirtimeLogic airtimeLogic;

	@Value("${productUrl}")
	String productUrl;

	@Value("${titleUrl}")
	String titleUrl;

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public List<AllDashboard> getPlayoutByProduct(Filter f) {
		try {
			StringBuilder query = new StringBuilder();
			if (f.getLimit() == null || ("").equals(f.getLimit())) {
				query.append("select count(count),product from all_channels_1 group by product " + f.getOrder() + " ");
			} else {
				query.append("select count(count),product from all_channels_1 group by product " + f.getOrder()
				+ " limit " + f.getLimit() + "");
			}
			String queryfinal = new String(query);
			return jdbcTemplate.query(queryfinal, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					while (rs.next()) {
						AllDashboard productData = new AllDashboard();
						productData.setCount(rs.getInt("sum(count)"));
						productData.setProductname(rs.getString("product"));
						productList.add(productData);
					}
					return productList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}



	@Override
	public List<TotalAddData> getAddDataCount() {
		try {
			String query=" select count(distinct ac1.categories) categories,count(distinct ac1.brand) brand,count(distinct ac1.product) product,sum(ac1.duration_ms/1000) airtime,count(ac1.count) playout,sum((ac1.duration_ms/1000)/cm.spendunit*cm.spend)  spend   from all_channels_1 ac1 left join channel_master2 cm on ac1.stream_name=cm.streamname   ";
			System.out.println("query for all count data " +query);
			return jdbcTemplate.query(query,
					new ResultSetExtractor<List<TotalAddData>>() {
				public List<TotalAddData> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<TotalAddData> productList = new ArrayList<TotalAddData>();
					while (rs.next()) {
						TotalAddData addData = new TotalAddData();
						addData.setTotalcategories(rs.getString("categories"));
						addData.setTotalbrands(rs.getString("brand"));
						addData.setTotalproducts(rs.getString("product"));
						Integer sec=rs.getInt("airtime");
						addData.setTotalairtime(airtimeLogic.getTimeFormat(sec));
						addData.setTotalplayout(rs.getInt("playout"));
						addData.setSpend(rs.getDouble("spend"));
						productList.add(addData); 
					}
					return productList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}


	@Override
	public List<String> getAllGenres() {

		try {
			return jdbcTemplate.query("select distinct(type) type from channel_master2 where type!=''",
					new ResultSetExtractor<List<String>>() {
				public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<String> genreList = new ArrayList<String>();
					while (rs.next()) {
						//FilterData filter = new FilterData();
						//filter.setGenre();
						//Collections.sort(genreList, new FilterData());
						genreList.add(rs.getString("type").trim());
						Collections.sort(genreList);
					}

					return genreList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Channel> getAllChannels() {
		try {
			return jdbcTemplate.query("select distinct cid , streamname from channel_master2 where streamname!='' ",
					new ResultSetExtractor<List<Channel>>() {
				public List<Channel> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<Channel> filterList = new ArrayList<Channel>();
					while (rs.next()) {
						Channel filter = new Channel();
						filter.setStreamname(rs.getString("streamname").trim());
						filter.setCid(rs.getInt("cid"));						
						filterList.add(filter);
					}  
					Collections.sort(filterList,new ChannelComparator());  
					return filterList;
				} 
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<String> getAllProducts() {
		try {
			return jdbcTemplate.query("select distinct(product) product from all_channels_1 where product!=''",
					new ResultSetExtractor<List<String>>() {
				public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<String> filterList = new ArrayList<String>();
					while (rs.next()) {
						filterList.add(rs.getString("product").trim());
						Collections.sort(filterList);
					}
					return filterList;
				}

			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<FilterData> getAllCategories() {
		try {
			return jdbcTemplate.query("select distinct categories from all_channels_1 ",
					new ResultSetExtractor<List<FilterData>>() {
				public List<FilterData> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<FilterData> filterList = new ArrayList<FilterData>();
					while (rs.next()) {
						FilterData filter = new FilterData();
						filter.setCategory(rs.getString("categories"));
						filterList.add(filter);
					}
					return filterList;
				}

			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// select sum(played_duration) airtime, b.streamName from all_channels_1 a inner
	// join channel_master2 b on a.stream_id=b.streamId group by a.stream_id order by
	// airtime desc
	@Override
	public List<AllDashboard> getDatabyChannels(Filter f) {
		try {
			String product=f.getProductname();
			if(!(product==null ||"".equals(product))){
				if(!product.contains("'")) {
					product="'"+product+"'";
				}		
			}
			String brand=f.getBrandname();
			if(!(brand==null ||"".equals(brand))){
				if(!brand.contains("'")) {
					brand="'"+brand+"'";
				}		
			}
			String streamname=f.getStreamname();
			if(!(streamname==null ||"".equals(streamname))){
				if(!streamname.contains("'")) {
					streamname="'"+streamname+"'";
				}		
			}


			System.out.println("filter data " + f);
			StringBuilder query = new StringBuilder();
			if ("Playout".equalsIgnoreCase(f.getTime())) {
				query.append("select count(count) timeduration,");
			} else {
				query.append("select sum(duration_ms/1000) timeduration,");
			}
			query.append("stream_name,cid from all_channels_1 " + " channel_master2 b on b.stream_name=b.streamname"
					+ " where  date(timestamp_utc) between '" + f.getStartdate() + "' and '" + f.getEnddate() + "'");
			if (!(f.getBrandname() == null || "".equals(f.getBrandname()))){
				query.append("and brand in ("+brand+")");
			}

			if (!(f.getCategory() == null || "".equals(f.getCategory()))) {
				query.append("and categories = ('"+f.getCategory()+"')");
			}

			if (!("".equals(f.getProductname()) || f.getProductname() == null)) {
				query.append("and product IN (" + product + ") ");
			}

			if(!("".equals(f.getStreamname()) || f.getStreamname()==null)) {
				query.append("and stream_name IN ("+streamname+")");

			}


			if (!(f.getGenre() == null || "".equals(f.getGenre()))) {
				query.append("and stream_type IN (" + f.getGenre() + ")");
			}



			if ("".equals(f.getLimit()) || f.getLimit() == null) {
				query.append(" group by stream_name order by timeduration " + f.getOrder() + " ");
			} else {
				query.append("  group by stream_name  order by timeduration  " + f.getOrder() + " limit " + f.getLimit()
				+ "");
			}

			String finalquery = new String(query);
			System.out.println("final query: " + finalquery);
			return jdbcTemplate.query(finalquery, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					while (rs.next()) {
						AllDashboard productData = new AllDashboard();
						productData.setTimeduration( rs.getInt("timeduration"));            	

						productData.setStreamname(rs.getString("stream_name"));
						productData.setCid(rs.getInt("cid"));
						productData.setDuration_name(f.getTime());
						productList.add(productData);

					}
					return productList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<AllDashboard> getDatabyCategory(Filter f) {
		try {
			StringBuilder query = new StringBuilder();
			String product=f.getProductname();
			if(!(product==null ||"".equals(product))){
				if(!product.contains("'")) {
					product="'"+product+"'";
				}		
			}
			String streamname=f.getStreamname();
			if(!(streamname==null ||"".equals(streamname))){
				if(!streamname.contains("'")) {
					streamname="'"+streamname+"'";
				}		
			}


			if ("Playout".equalsIgnoreCase(f.getTime())) {
				query.append("select count(count)");
			} else {
				query.append("select sum(duration_ms/1000)");
			}
			query.append("time_duration ,Categories  from all_channels_1 " + " where date(timestamp_utc) "
					+ "between '" + f.getStartdate() + "' " + "and '" + f.getEnddate() + "'");
			if (!("".equals(f.getProductname()) || f.getProductname() == null)) {
				query.append("and product IN (" + product + ") ");
			}
			if(!("".equals(f.getStreamname()) || f.getStreamname()==null)) {
				query.append("and stream_name IN ("+streamname+")");

			}
			if (!("".equals(f.getGenre()) || f.getGenre() == null)) {
				query.append("and stream_type IN (" + f.getGenre() + ")");
			}					  

			/*	else {
				if ("Playout".equalsIgnoreCase(f.getTime())) {
					query.append("select count(ac1.count)");
				} else {
					query.append("select sum(ac1.duration_ms/1000)");
				}
				query.append(" time_duration ,ac1.categories Categories  from all_channels_1 ac1"
						+ " inner join channel_master2 cm on ac1.stream_name=cm.streamname"
						+ " where date(ac1.timestamp_utc) " + " between '" + f.getStartdate() + "' " + "and '"
						+ f.getEnddate() + "'");

				if (!("".equals(f.getProductname()) || f.getProductname() == null)) {
					query.append("and ac1.product IN (" + f.getProductname() + ") ");
				}
				  if(!("".equals(f.getStreamname()) || f.getStreamname()==null)) {
					  query.append("and cm.cid IN ("+f.getCid()+")");

					  }
			if (!("".equals(f.getGenre()) || f.getGenre() == null)) {
				query.append("and cm.type IN (" + f.getGenre() + ")");
			} */
			query.append("  group by Categories order by time_duration");

			if ("".equals(f.getLimit()) || f.getLimit() == null) {
				query.append(" " + f.getOrder() + " ");
			} else {
				query.append(" " + f.getOrder() + "  limit " + f.getLimit() + " ");
			}

			String finalquery = new String(query);
			System.out.println("query for get data by category" + finalquery);
			return jdbcTemplate.query(finalquery, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					while (rs.next()) {
						AllDashboard productData = new AllDashboard();
						productData.setTimeduration(rs.getInt("time_duration"));            	
						productData.setCategoryname(rs.getString("Categories"));
						productData.setDuration_name(f.getTime());
						productList.add(productData);
					}
					return productList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<AllDashboard> getDatabyLanguage(Filter f) {
		try {
			StringBuilder query = new StringBuilder();
			String product=f.getProductname();
			if(!(product==null ||"".equals(product))){
				if(!(product.startsWith("'") && product.endsWith("'"))) {
					product="'"+product+"'";
				}	 	
			}      
			String streamname=f.getStreamname();
			if(!(streamname==null ||"".equals(streamname))){
				if(!streamname.contains("'")) {
					streamname="'"+streamname+"'";
				}		
			}


			String brand=f.getBrandname();
			if(!(brand==null ||"".equals(brand))){
				if(!(brand.startsWith("'") && brand.endsWith("'"))) {
					brand="'"+brand+"'";
				}		
			}
			query.append(" SELECT DISTINCT(language), sum(timeduration) timeduration FROM (SELECT  cm.language as language, ");
			if ("Playout".equalsIgnoreCase(f.getTime())) {
				query.append(" count(ac.count)   ");
			} 
			else {
				query.append("  sum(ac.duration_ms/1000)"); 
			}
			query.append(" as timeduration FROM all_channels_1 ac  LEFT JOIN channel_master2 cm ON cm.streamId = ac.stream_Id where DATE(ac.timestamp_utc) BETWEEN "
					+ " '"+f.getStartdate()+"' and  '"+f.getEnddate()+"' ");

			if (!("".equals(f.getProductname()) || f.getProductname() == null)) {
				query.append(" and ac.product IN ("+product+") ");
			}
						if (!("".equals(f.getCreative()) || f.getCreative() == null)) {
				query.append(" and ac.title='" + f.getCreative()+ "'");
			}
			 			if (!(f.getBrandname() == null || "".equals(f.getBrandname()))) {
				 query.append(" and ac.brand in ("+brand+")");
			 }
			 if(!(f.getLanguage()==null || "".equals(f.getLanguage()))) {
				 query.append(" and ac.stream_language IN ("+f.getLanguage()+")  ");	
			 }

			 if (!(f.getCategory() == null || "".equals(f.getCategory()))) {
				 query.append("and ac.categories = ('"+f.getCategory()+"')");
			 }

			 if(!("".equals(f.getStreamname()) || f.getStreamname()==null)) {
				 query.append("and ac.stream_name IN ("+streamname+")");

			 }
			 if (!("".equals(f.getGenre()) || f.getGenre() == null)) {
				 query.append(" and ac.stream_type IN (" + f.getGenre() + ")");
			 }
			 query.append(" GROUP BY cm.streamName ORDER BY timeduration  DESC ");

			 if (!("".equals(f.getLimit()) || f.getLimit() == null)) {
				 query.append(" LIMIT 10 ");
			 } 

			 query.append(" ) as lang group by language order by timeduration desc "); 

			 String finalquery = new String(query);                         
			 System.out.println("query for get data by Language " + finalquery);
			 return jdbcTemplate.query(finalquery, new ResultSetExtractor<List<AllDashboard>>() {
				 public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					 List<AllDashboard> productList = new ArrayList<AllDashboard>();
					 while (rs.next()) {
						 AllDashboard productData = new AllDashboard();
						 productData.setTimeduration(rs.getInt("timeduration"));            	
						 productData.setLanguage(rs.getString("language"));
						 productData.setDuration_name(f.getTime());
						 productList.add(productData);
					 }
					 return productList;
				 }
			 });
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	} 

	@Override
	public List<AllDashboard> getDatabyHourlyPlayout(Filter f) {
		try {
			StringBuilder query = new StringBuilder();
			String product=f.getProductname();
			if(!(product==null ||"".equals(product))){
				if(!(product.startsWith("'") && product.endsWith("'"))) {
					product="'"+product+"'";
				}	 	
			}      
			String streamname=f.getStreamname();
			if(!(streamname==null ||"".equals(streamname))){
				if(!streamname.contains("'")) {
					streamname="'"+streamname+"'";
				}		
			}


			String brand=f.getBrandname();
			if(!(brand==null ||"".equals(brand))){
				if(!(brand.startsWith("'") && brand.endsWith("'"))) {
					brand="'"+brand+"'";
				}		
			}
			if ("Playout".equalsIgnoreCase(f.getTime())) {
				query.append("SELECT count(count)");
			} else {
				query.append(" SELECT SUM(duration_ms/1000)");
			}
			query.append(" time_duration,hour(timestamp_utc) hour  FROM all_channels_1 ac1   where date(timestamp_utc) " +
					"between '" + f.getStartdate() + "' " + "and '"
					+ f.getEnddate() + "'"); 
			if (!("".equals(f.getProductname()) || f.getProductname() == null)) {
				query.append("and product IN (" + product + ") ");
			}
			if (!("".equals(f.getCreative()) || f.getCreative()== null)) {
				query.append(" and title='" + f.getCreative()+ "'");
			} 				
			if(!("".equals(f.getStreamname()) || f.getStreamname()==null)) {
				query.append("and stream_name IN ("+streamname+")");

			}				
			if(!("".equals(f.getGenre()) || f.getGenre() == null)) {
				query.append("and stream_type IN (" + f.getGenre() + ")");
			}
			//				} else {
			/*			if ("Playout".equalsIgnoreCase(f.getTime())) {
						query.append("select count(ac1.count)");
					} else {
						query.append("select sum(ac1.duration_ms/1000)");
					}
					query.append(" time_duration ,hour(ac1.timestamp_utc) hour  from all_channels_1 ac1"
							+ " inner join channel_master2 cm on ac1.stream_name=cm.streamname"
							+ " where date(ac1.timestamp_utc) " + " between '" + f.getStartdate() + "' " + "and '"
							+ f.getEnddate() + "'");
					if (!("".equals(f.getProductname()) || f.getProductname() == null)) {
						query.append("and ac1.product IN (" + product + " )");
					}
					if (!("".equals(f.getDescription()) || f.getDescription() == null)) {
						query.append(" and ac1.description='" + f.getDescription()+ "'");
					}
					if(!("".equals(f.getStreamname()) || f.getStreamname()==null)) {
						  query.append("and cm.cid IN ("+f.getCid()+")");

						  }				
					if(!("".equals(f.getGenre()) || f.getGenre() == null)) {
					query.append("and cm.type IN (" + f.getGenre() + ")");
				}*/

			query.append("  group by hour order by time_duration " + f.getOrder() + "");

			/*	} else {
				if ("Playout".equalsIgnoreCase(f.getTime())) {
					query.append("SELECT count(count) ");
				} else {
					query.append(" SELECT sum(duration_ms/1000) ");
				}
				query.append(" time_duration, hour(timestamp_utc) hour from " + " all_channels_1  "
						+ " WHERE date(timestamp_utc)  BETWEEN " + "'" + f.getStartdate() + "' AND '" + f.getEnddate()
						+ "' and product='" + f.getProductname() + "' GROUP BY hour ");*/
			/*if (!("".equals(f.getProductname()) || f.getProductname() == null)) {
					query.append(" and product='" + f.getProductname() + " '  ");
				}*/

			//query.append(" GROUP BY hour  ORDER BY time_duration");


			String finalQuery = new String(query);
			System.out.println("hourly playout query: " + finalQuery);
			return jdbcTemplate.query(finalQuery, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					Map<Integer, Integer> hourlyPlayoutData = new HashMap<Integer, Integer>();
					while (rs.next()) {
						/*
						 * productData.setTimeduration(rs.getInt("time_duration"));
						 * productData.setHours(rs.getInt("hour"));
						 */
						hourlyPlayoutData.put(rs.getInt("hour"), rs.getInt("time_duration"));

					}
					// for(int i=0;i<24;i++) {

					int i = 0;
					while (i < 24) {
						AllDashboard productData = new AllDashboard();
						// System.out.println("hours" +j);
						productData.setHours(i);
						productData.setDuration_name(f.getTime());
						// System.out.println("hours : "+i);
						if (hourlyPlayoutData.containsKey(i)) {
							productData.setTimeduration(hourlyPlayoutData.get(i));            	
						} else {
							productData.setTimeduration(0);
						}
						productList.add(productData);
						i++;
					}
					return productList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	@Override
	public List<AllDashboard> getDatabyDailyPlayout(Filter f) {
		try { 
			StringBuilder query = new StringBuilder();
			String streamname=f.getStreamname();
			if(!(streamname==null ||"".equals(streamname))){
				if(!streamname.contains("'")) {
					streamname="'"+streamname+"'";
				}		
			}
			String product=f.getProductname();
			if(!(product==null ||"".equals(product))){
				if(!(product.startsWith("'") && product.endsWith("'"))) {
					product="'"+product+"'";
				}	 	
			}      
			if ("Playout".equalsIgnoreCase(f.getTime())) {
				query.append("SELECT count(count)");
			} else {
				query.append("SELECT SUM(duration_ms/1000)");
			}
			query.append("time_duration,DATE(timestamp_utc)" + 
					" date  FROM all_channels_1 "
					+ "where date(timestamp_utc) " + "between '" + f.getStartdate() + "' " + "and '"
					+ f.getEnddate() + "'");
			if (!("".equals(f.getProductname()) || f.getProductname() == null)) {
				query.append("and product IN (" + product + ") ");
			} 
			if (!("".equals(f.getCreative()) || f.getCreative()== null)) {
						query.append(" and title='" + f.getCreative()+ "'");
					} 
			if(!(f.getLanguage()==null || "".equals(f.getLanguage()))) {
				query.append(" and stream_language IN ("+f.getLanguage()+")  ");	
			}

			if(!("".equals(f.getStreamname()) || f.getStreamname()==null)) {
				query.append("and stream_name IN ("+streamname+")");
			}				

			if (!("".equals(f.getGenre()) || f.getGenre() == null)) {
				query.append("and stream_type IN (" + f.getGenre() + ")");
			}

			/*				} else {
					if ("Playout".equalsIgnoreCase(f.getTime())) {
						query.append("select count(ac1.count)");
					} else {
						query.append("select sum(ac1.duration_ms/1000)");
					}
					query.append(" time_duration ,date(ac1.timestamp_utc) date  from all_channels_1 ac1"
							+ " inner join channel_master2 cm on ac1.stream_name=cm.streamname"
							+ " where date(ac1.timestamp_utc) " + " between '" + f.getStartdate() + "' " + "and '"
							+ f.getEnddate() + "'");
					if (!("".equals(f.getProductname()) || f.getProductname() == null)) {
						query.append("and ac1.product IN (" + product+ ") ");
					}
					if (!("".equals(f.getDescription()) || f.getDescription() == null)) {
						query.append(" and ac1.description='" + f.getDescription()+ "'");
					}
				    if(!(f.getLanguage()==null || "".equals(f.getLanguage()))) {
				        query.append(" and ac1.language IN ("+f.getLanguage()+")  ");	
				        }


				    if(!("".equals(f.getStreamname()) || f.getStreamname()==null)) {
						  query.append("and cm.cid IN ("+f.getCid()+")");
						  }				

					if (!("".equals(f.getGenre()) || f.getGenre() == null)) {
					query.append("and cm.type IN (" + f.getGenre() + ")");
					}
			 */					

			query.append("  group by date order by time_duration " + f.getOrder() + "");

			/*} else {
				if ("Playout".equalsIgnoreCase(f.getTime())) {
					query.append("SELECT count(count) ");
				} else {
					query.append(" SELECT sum(duration_ms/1000) ");
				}
				query.append(" time_duration, date(timestamp_utc) date from" + " all_channels_1  "
						+ " WHERE date(timestamp_utc)  BETWEEN " + "'" + f.getStartdate() + "' AND '" + f.getEnddate()
						+ "' and  product='" + f.getProductname() + "' GROUP BY date ");
				if (!("".equals(f.getProductname()) || f.getProductname() == null)) {
					query.append(" and product='" + f.getProductname() + "' ");
				}
			//	query.append(" GROUP BY date  ORDER BY time_duration");
			}*/
			System.out.println("query for daily playout " + query);
			String finalQuery = new String(query);
			return jdbcTemplate.query(finalQuery, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					Map<LocalDate, Integer> mp = new HashMap<LocalDate, Integer>();

					while (rs.next()) {
						mp.put(LocalDate.parse(rs.getString("date")), rs.getInt("time_duration"));
					}

					String s = f.getStartdate();
					String e = f.getEnddate();
					/*
					 * String s = "2018-04-10"; String e = "2018-04-11";
					 */ // System.out.println("start date: "+s);
					// System.out.println("end date: "+e);
					LocalDate start = LocalDate.parse(s);
					LocalDate end = LocalDate.parse(e);
					// String ee=end.toString();
					// List<LocalDate> totalDates = new ArrayList<>();

					while (!start.isAfter(end)) {
						AllDashboard productData = new AllDashboard();

						productData.setDuration_name(f.getTime());

						System.out.println(start);

						productData.setDate(start.toString());
						if (mp.containsKey(start)) {
							// System.out.println("yes");
							productData.setTimeduration(mp.get(start));            	

						} else {
							// System.out.println("no");
							productData.setTimeduration(0);
						}
						start = start.plusDays(1);
						productList.add(productData);
					}

					return productList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<AllDashboard> channelsByProduct(Filter f) {
		try {
			System.out.println("filter data: " + f);
			String finalquery = "select distinct(stream_name) from all_channels_1where product='Trivago' select distinct(streamname) from all_channels_1 a inner join channel_master2 b on b.stream_name=b.streamname and a.product='"
					+ f.getProductname() + "'";
			System.out.println("get channel by product" + finalquery);
			return jdbcTemplate.query(finalquery, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					while (rs.next()) {
						AllDashboard productData = new AllDashboard();
						productData.setStreamname(rs.getString("streamname"));
						productList.add(productData);
					}
					return productList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<AllDashboard> langaugeByProduct(Filter f) {
		try {
			System.out.println("filter data: " + f);
			String finalquery = "select distinct(stream_language) language from all_channels_1 where product='"
					+ f.getProductname() + "'";
			System.out.println("get language by product" + finalquery);
			return jdbcTemplate.query(finalquery, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					while (rs.next()) {
						AllDashboard productData = new AllDashboard();
						productData.setLanguage(rs.getString("language"));

						productList.add(productData);
					}
					return productList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<AllDashboard> hourlyPlayoutByProduct(Filter f) {
		return null;
	}

	@Override
	public List<AllDashboard> dailyPlayoutByProduct(Filter f) {
		return null;
	}

	@Override
	public Integer totalProduct() {
		try {
			String finalquery = "select count(distinct product) products from all_channels_1 ";
			System.out.println("get total by product" + finalquery);
			return jdbcTemplate.query(finalquery, new ResultSetExtractor<Integer>() {
				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					Integer totalproducts = null;
					while (rs.next()) {
						totalproducts = rs.getInt("products");
					}
					return totalproducts;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Integer totalChannels() {
		try {
			String finalquery = "select count(distinct cid) channels from all_channels_1 ";
			System.out.println("get language by product" + finalquery);
			return jdbcTemplate.query(finalquery, new ResultSetExtractor<Integer>() {
				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					Integer totalproducts = null;
					while (rs.next()) {
						totalproducts = rs.getInt("cid");
					}
					return totalproducts;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<AllDashboard> topProduct(Filter f) {
		try {  
			System.out.println("inside  product method");
			StringBuilder query = new StringBuilder();
			String product=f.getProductname();
			if(!(product==null ||"".equals(product))){
				if(!product.contains("'")) {
					product="'"+product+"'";
				}		
			}

			String streamname=f.getStreamname();
			if(!(streamname==null ||"".equals(streamname))){
				if(!streamname.contains("'")) {
					streamname="'"+streamname+"'";
				}		
			}


			if ("Playout".equalsIgnoreCase(f.getTime())) {
				query.append("SELECT count(p1.count) ");
			} else {
				query.append("SELECT SUM(p1.duration_ms/1000) ");
			}
			query.append("  time_duration,p1.product," + "  img.filename imageurl FROM all_channels_1 p1 "
					+ "  left JOIN product_backup29APR    img "
					+ " ON p1.product= img.productname   ");

			query.append("  where"
					+ " date(p1.timestamp_utc) between '" + f.getStartdate() + "'" + " and '" + f.getEnddate()+"'");
			if (!(f.getGenre() == null || "".equals(f.getGenre()))) {
				query.append("and p1.stream_type in (" + f.getGenre() + ")");	
			}

			if (!("".equals(f.getStreamname()) || f.getStreamname() == null)) {
				query.append(" and p1.stream_name IN (" +streamname+ ")");
			}

			if (!(f.getBrandname() == null || "".equals(f.getBrandname()))) {
				query.append("and p1.brand = ("+f.getBrandname()+")");
			}

			if (!(f.getProductname() == null || "".equals(f.getProductname()))) {
				query.append("and p1.product IN   ("+product+")");
			}

			if (!(f.getCategory() == null || "".equals(f.getCategory()))) {
				query.append("and p1.categories = '"+f.getCategory()+"' ");
			}


			//}
			/* else {
				query.append("  where " + " date(p1.timestamp_utc) between '" + f.getStartdate() + "' " + " and '"
						+ f.getEnddate() + "' ");
				if (!(f.getProductname() == null || "".equals(f.getProductname()))) {
					query.append("and p1.product IN   ("+product+")");
				}

				if (!("".equals(f.getStreamid()) || f.getStreamid() == null)) {
					query.append(" and p1.stream_id IN (" + channelid+ " )");
				}
				if (!(f.getBrandname() == null || "".equals(f.getBrandname()))) {
					query.append("and p1.brand = ('"+f.getBrandname()+"')");
				}

				if (!(f.getCategory() == null || "".equals(f.getCategory()))) {
					query.append("and p1.categories = ('"+f.getCategory()+"')");
				}

			 */	
			//}


			query.append(" GROUP BY product order by time_duration ");
			if(f.getLimit()==null || "".equals(f.getLimit())) {
				query.append("  "+f.getOrder() + "");	
			}
			else {
				query.append("   "+f.getOrder() + "  limit "+f.getLimit()+" " );	 	

			}


			String finalQuery = new String(query);
			System.out.println("query for top product: " + finalQuery);
			return jdbcTemplate.query(finalQuery, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					while (rs.next()) {
						// LocalDate startDate =null;

						AllDashboard productData = new AllDashboard();
						Integer sec=rs.getInt("time_duration");
						productData.setTimeduration(rs.getInt("time_duration"));							
                        productData.setLogoUrl(productUrl);
						productData.setProductname(rs.getString("product"));
						productData.setDuration_name(f.getTime());

						String productlogo = rs.getString("imageurl");
						if (productlogo == null || "null".equalsIgnoreCase(productlogo)) {
							productData.setLogo("NA");
						}
						else {
							productData.setLogo(productlogo);
						}
						productData.setLogoUrl(productUrl);
						productList.add(productData);
					}
					return productList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	@Override
	public List<AllDashboard> topGenreByProduct(Filter f) {

		try {
			System.out.println("filter data: " + f);
			StringBuilder query = new StringBuilder();

			String brand=f.getBrandname();
			if(!(brand==null ||"".equals(brand))){
				if(!(brand.startsWith("'") && brand.endsWith("'"))) {
					brand="'"+brand+"'";
				}		
			}
			String streamname=f.getStreamname();
			if(!(streamname==null ||"".equals(streamname))){
				if(!streamname.contains("'")) {
					streamname="'"+streamname+"'";
				}		
			}


			if ("Playout".equalsIgnoreCase(f.getTime())) {
				query.append("select count(count)");
			} else {
				query.append("select sum(duration_ms/1000)");
			}
			query.append(" time_duration, stream_type type from all_channels_1  "
					+ " where" + " date(timestamp_utc) between '" + f.getStartdate()
					+ "' and " + " '" + f.getEnddate() + "' ");
			if (!("".equals(f.getGenre()) || f.getGenre() == null)) {
				query.append(" and  stream_type IN (" + f.getGenre() + ") ");
			}
			if(!(f.getLanguage()==null || "".equals(f.getLanguage()))) {
				query.append(" and stream_language IN ("+f.getLanguage()+")  ");	
			}

			if (!(f.getBrandname() == null || "".equals(f.getBrandname()))) {
				query.append("and brand in ("+brand+")");
			}

			if (!(f.getCategory() == null || "".equals(f.getCategory()))) {
				query.append("and categories = ('"+f.getCategory()+"')");
			}

			if (!("".equals(f.getProductname()) || f.getProductname() == null)) {
				query.append(" and product='"+f.getProductname()+"'");
			} 

			if (!("".equals(f.getCreative())|| f.getCreative() == null)) {
				query.append(" and title='"+f.getCreative()+"'");
			}
			 

			if(!("".equals(f.getStreamname()) || f.getStreamname()==null)) {
				query.append("and stream_name IN ("+streamname+")");
			}				

			query.append("  group by stream_type order by time_duration");

			if ("".equals(f.getLimit()) || f.getLimit() == null) {
				query.append(" " + f.getOrder() + " ");
			} else {
				query.append(" " + f.getOrder() + "  limit " + f.getLimit() + " ");
			}

			String finalquery = new String(query);
			System.out.println("get genre by product" + finalquery);
			return jdbcTemplate.query(finalquery, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					while (rs.next()) {
						AllDashboard productData = new AllDashboard();
						productData.setGenre(rs.getString("type"));
						productData.setTimeduration(rs.getInt("time_duration"));            	
						productData.setDuration_name(f.getTime());
						productList.add(productData);
					}
					return productList;
				}
			}); 
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	@Override
	public List<AllDashboard> singleProductData(String product, String startdate, String enddate) { 
		String query = "SELECT product,  count(p1.count) count,sum(p1.duration_ms/1000) airtime ,GROUP_CONCAT(distinct p1.categories) categories, count(distinct p1.cid) cid,sum((p1.duration_ms/1000)/cm.spendunit*cm.spend) spend, GROUP_CONCAT(distinct p1.stream_language) language   FROM all_channels_1 p1  left join channel_master2 cm on p1.stream_name=cm.streamname   where date(p1.timestamp_utc) between  '"+startdate+"' and '"+enddate+"' and p1.product='"+product.trim()+"' ";

		System.out.println("query for single product: " + query);
		try {  

			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					while (rs.next()) {
						AllDashboard productData = new AllDashboard();
						productData.setCount(rs.getInt("count"));
						Integer sec=rs.getInt("airtime");
						String airtime=airtimeLogic.getTimeFormat(sec);
						productData.setProductname(product.replaceAll("\'", "'"));
						productData.setAirtime(airtime);
						productData.setCategoryname(rs.getString("categories"));
						productData.setLanguage(rs.getString("language"));
						productData.setCid(rs.getInt("cid"));
						productData.setSpend(rs.getDouble("spend"));
						productList.add(productData); 
					}
					return productList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Product> singleProductDescription(String product, String startdate, String enddate) {
		String query=" select distinct(description) description from all_channels_1 where product='"+product+"' and date(timestamp_utc) between '"+startdate+"' and '"+enddate+"'";
		System.out.println("query for product by  description " +query);
		try { 

			return jdbcTemplate.query(query, new ResultSetExtractor<List<Product>>() {
				public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<Product> productList = new ArrayList<Product>();
					while (rs.next()) {
						Product productData = new Product();
						productData.setDescription(rs.getString("description"));
						productData.setProductname(product);
						productList.add(productData); 
					}

					return productList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}


	@Override
	public List<AllDashboard> singleProductDataByDesc(Filter f) {
		String query = "SELECT  count(p1.count) count,sum(p1.duration_ms/1000) airtime ,GROUP_CONCAT(distinct p1.categories) categories, count(distinct p1.cid) cid,sum((p1.duration_ms/1000)/cm.spendunit*cm.spend) spend, GROUP_CONCAT(distinct p1.stream_language) language  FROM all_channels_1 p1   left join channel_master2 cm on p1.stream_name=cm.streamname   where date(p1.timestamp_utc) between  '"+f.getStartdate()+"' and '"+f.getEnddate()+"' and p1.product='"+f.getProductname()+"' ";
		System.out.println("query for single product: " + query);
		try { 

			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					while (rs.next()) {
						AllDashboard productData = new AllDashboard();
						productData.setCount(rs.getInt("count"));
						Integer sec=rs.getInt("airtime");

						String airtime=airtimeLogic.getTimeFormat(sec);
						productData.setProductname(f.getProductname());
						//productData.setDescription(f.getDescription());
						productData.setAirtime(airtime);
						productData.setCategoryname(rs.getString("categories"));
						productData.setLanguage(rs.getString("language"));
						productData.setCid(rs.getInt("cid"));
						productData.setSpend(rs.getDouble("spend"));
						productList.add(productData); 
					}
					return productList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public String productLogo(String product) {
		// String query="select distinct(img.ImageUrl) logo from product pro inner join product_img img on pro.productid=img.productid  where pro.productname='"+product+"'";
		String query=" select distinct(filename) logo from product_backup29APR   where productname='"+product+"'";
		System.out.println("query for  product logo: " + query);
		try { 

			return jdbcTemplate.query(query, new ResultSetExtractor<String>() {
				public String extractData(ResultSet rs) throws SQLException, DataAccessException {
					String logo = null;
					while (rs.next()) {
						String imgurl=rs.getString("logo");
						if(imgurl==null || "null".equals(imgurl) || "".equals(imgurl)) {
							logo="NA";	
						}
						else {
							logo=imgurl;	
						}
					}
					return logo;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	}

	@Override
	public List<String> creativesByProduct(String product, String startdate, String enddate) {
		String query=" select distinct(title) title from all_channels_1   where product='"+product+"' and date(timestamp_utc)"
				+ "  between '"+startdate+"' and '"+enddate+"'";
		System.out.println("query for  product logo: " + query);
		try { 

			return jdbcTemplate.query(query, new ResultSetExtractor<List<String>>() {
				public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<String> Creatives=new ArrayList<String>();
					while (rs.next()) {
						String creativeName=rs.getString("title");
						 
						Creatives.add(creativeName);
					}
					return Creatives;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}

	@Override
	public List<AllDashboard> CreativesData(Filter f) {
		String query = "SELECT p1.product,p1.title, count(p1.count) count,GROUP_CONCAT(distinct p1.categories) categories,GROUP_CONCAT(distinct p1.stream_language) language,sum(p1.duration_ms/1000) airtime , count(distinct p1.cid) cid,sum((p1.duration_ms/1000)/cm.spendunit*cm.spend) spend,  t.filename filename  FROM all_channels_1 p1 LEFT JOIN Creatives t  ON t.titleName = p1.title  left join channel_master2 cm on p1.stream_name=cm.streamname   where date(p1.timestamp_utc) between  '"+f.getStartdate()+"' and '"+f.getEnddate()+"' and p1.product='" +f.getProductname()+ "'  and p1.title='"+f.getCreative()+"'  ";
		//String query=new  String("SELECT p1.product,p1.title, count(p1.count) count,GROUP_CONCAT(distinct p1.categories) categories,GROUP_CONCAT(distinct p1.stream_language) language,sum(p1.duration_ms/1000) airtime , count(distinct p1.cid) cid,sum((p1.duration_ms/1000)/cm.spendunit*cm.spend) spend  FROM all_channels_1 p1 left join channel_master2 cm on p1.stream_name=cm.streamname   where date(p1.timestamp_utc) between  '"+f.getStartdate()+"' and '"+f.getEnddate()+"' and p1.product='" +f.getProductname()+ "'  and p1.title='"+f.getCreative()+"'  ");
		 		
		System.out.println("query for single creative: " + query);   
			try { 
 
				return jdbcTemplate.query(query, new ResultSetExtractor<List<AllDashboard>>() {
					public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<AllDashboard> productList = new ArrayList<AllDashboard>();
						while (rs.next()) {
							AllDashboard creativeData = new AllDashboard();
							creativeData.setCount(rs.getInt("count"));
							Integer sec=rs.getInt("airtime");
							String airtime=airtimeLogic.getTimeFormat(sec);
							creativeData.setProductname(rs.getString("product"));
							String logo = rs.getString("filename");
							if (logo == null || "null".equalsIgnoreCase(logo)) {
								creativeData.setLogo("NA");
							} else {
								
								creativeData.setLogo(logo);
							}
							creativeData.setLogoUrl(titleUrl);
							creativeData.setCreative(rs.getString("title"));
							creativeData.setCategoryname(rs.getString("categories"));
							creativeData.setLanguage(rs.getString("language"));
							creativeData.setAirtime(airtime);
							creativeData.setCid(rs.getInt("cid"));
							creativeData.setSpend(rs.getDouble("spend"));
							productList.add(creativeData); 
						}
						return productList;
					}
				}); 
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
	} 
}