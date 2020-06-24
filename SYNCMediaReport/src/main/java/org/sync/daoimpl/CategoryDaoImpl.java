package org.sync.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.sync.dao.CategoryDao;
import org.sync.model.AllDashboard;
import org.sync.model.Filter;

public class CategoryDaoImpl implements CategoryDao{
	@Autowired
	AirtimeLogic airtimeLogic;
	@Value("${categoryUrl}") 
	String categoryLogoUrl;
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public List<AllDashboard> hourlyPlayoutForCategory(Filter f) {
		try {
			String streamname=f.getStreamname();
			if(!(streamname==null ||"".equals(streamname))){
				if(!streamname.contains("'")) {
					streamname="'"+streamname+"'";
				}		
			}

			StringBuilder query = new StringBuilder();
					if ("Playout".equalsIgnoreCase(f.getTime())) {
						query.append("SELECT count(count)  ");
					} else {
						query.append(" SELECT SUM(duration_ms/1000)   ");
					}
					query.append("time_duration,hour(timestamp_utc) hour  FROM all_channels_1 "
							+ " where date(timestamp_utc) " + "between '" + f.getStartdate() + "' " + "and '"
							+ f.getEnddate() + "'");
					if (!("".equals(f.getCategory()) || f.getCategory() == null)) {
						query.append("and categories='" + f.getCategory() + "'");
					}
					if (!("".equals(f.getStreamname()) || f.getStreamname() == null)) {
						query.append("and stream_name IN ("+streamname+")");
					}
					if (!("".equals(f.getGenre()) || f.getGenre() == null)) {	
					query.append("and stream_type IN (" + f.getGenre() + ")");
					}
			//	} else {
					/*if ("Playout".equalsIgnoreCase(f.getTime())) {
						query.append("select count(ac1.count)");
					} else {
						query.append("select sum(ac1.duration_ms/1000)");
					}
					query.append(" time_duration ,hour(ac1.timestamp_utc) hour  from all_channels_1 ac1"
							+ " inner join channel_master2 cm on ac1.cid=cm.cid"
							+ " where date(ac1.timestamp_utc) " + " between '" + f.getStartdate() + "' " + "and '"
							+ f.getEnddate() + "'");
					if (!("".equals(f.getCategory()) || f.getCategory() == null)) {
						query.append("and ac1.categories='" + f.getCategory() + "'");
					}
					if (!("".equals(f.getCid()) || f.getCid() == null)) {
						query.append("and cm.cid IN (" + f.getCid() + ")");
					}
					if (!("".equals(f.getGenre()) || f.getGenre() == null)) {	
					query.append("and cm.type IN (" + f.getGenre() + ")");
				}*/
				query.append("  group by hour order by time_duration " + f.getOrder() + "");

			String finalQuery = new String(query);
			System.out.println("hourly playout query: " + finalQuery);
			return jdbcTemplate.query(finalQuery, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> categoriesList = new ArrayList<AllDashboard>();
					Map<Integer, Integer> hourlyPlayoutData = new HashMap<Integer, Integer>();
					while (rs.next()) {
						/*
						 * categoriesData.setTimeduration(rs.getInt("time_duration"));
						 * categoriesData.setHours(rs.getInt("hour"));
						 */
						hourlyPlayoutData.put(rs.getInt("hour"), rs.getInt("time_duration"));

					}
					// for(int i=0;i<24;i++) {

					int i = 0;
					while (i < 24) {
						AllDashboard categoriesData = new AllDashboard();
						// System.out.println("hours" +j);
						categoriesData.setHours(i);
						categoriesData.setDuration_name(f.getTime());
						// System.out.println("hours : "+i);
						if (hourlyPlayoutData.containsKey(i)) {
							categoriesData.setTimeduration(hourlyPlayoutData.get(i));
						} else {
							categoriesData.setTimeduration(0);
						}
						categoriesList.add(categoriesData);
						i++;
					}
					return categoriesList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	@Override
	public List<AllDashboard> dailyPlayoutForCategory(Filter f) {
		try {
			StringBuilder query = new StringBuilder();
			String streamname=f.getStreamname();
			if(!(streamname==null ||"".equals(streamname))){
				if(!streamname.contains("'")) {
					streamname="'"+streamname+"'";
				}		
			}

					if ("Playout".equalsIgnoreCase(f.getTime())) { 
						query.append("SELECT count(count)   ");
					} else {
						query.append("SELECT SUM(duration_ms/1000) ");
					}
					query.append(" time_duration,DATE(timestamp_utc)" + 
						"date  FROM all_channels_1 "
							+ " where date(timestamp_utc) " + "between '" + f.getStartdate() + "' " + "and '"
							+ f.getEnddate() + "'");
					if (!("".equals(f.getCategory()) || f.getCategory() == null)) {
						query.append("and categories='" + f.getCategory() + "'");
					}
					if (!("".equals(f.getStreamname()) || f.getStreamname() == null)) {
						query.append("and stream_name IN ("+streamname+")");
					}
					if (!("".equals(f.getGenre()) || f.getGenre() == null)) {
					query.append("and stream_type IN (" + f.getGenre() + ")");
				}

					
//				} else {
			
			/*		if ("Playout".equalsIgnoreCase(f.getTime())) {
						query.append("select count(ac1.count)");
					} else {
						query.append("select sum(ac1.duration_ms/1000)");
					}
					query.append(" time_duration ,date(ac1.timestamp_utc) date  from all_channels_1 ac1"
							+ " inner join channel_master2 cm on ac1.cid=cm.cid"
							+ " where date(ac1.timestamp_utc) " + " between '" + f.getStartdate() + "' " + "and '"
							+ f.getEnddate() + "'");
					if (!("".equals(f.getCategory()) || f.getCategory() == null)) {
						query.append("and ac1.categories='" + f.getCategory() + "'");
					}
					if (!("".equals(f.getCid()) || f.getCid() == null)) {
						query.append("and cm.cid IN (" + f.getCid() + ")");
					}
					if (!("".equals(f.getGenre()) || f.getGenre() == null)) {
					query.append("and cm.type IN (" + f.getGenre() + ")");
				}
*/				query.append("  group by date order by time_duration " + f.getOrder() + "");

			System.out.println("query for daily playout " + query);
			String finalQuery = new String(query);
			return jdbcTemplate.query(finalQuery, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> categoriesList = new ArrayList<AllDashboard>();
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
						AllDashboard categoriesData = new AllDashboard();

						categoriesData.setDuration_name(f.getTime());

						System.out.println(start);

						categoriesData.setDate(start.toString());
						if (mp.containsKey(start)) {
							// System.out.println("yes");
							categoriesData.setTimeduration(mp.get(start));

						} else {
							// System.out.println("no");
							categoriesData.setTimeduration(0);
						}
						start = start.plusDays(1);
						categoriesList.add(categoriesData);
					}

					return categoriesList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<AllDashboard> categoryDatacount() {
		 String query=("select count(distinct categories) categories from all_channels_1");
		   System.out.println("query for category data count: " + query);
		    try {
				return jdbcTemplate.query(query,
						new ResultSetExtractor<List<AllDashboard>>() {
					public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<AllDashboard> channelList=new ArrayList<AllDashboard>();
						while(rs.next()) {
						 AllDashboard count=new AllDashboard();
						 count.setCategoryname(rs.getString("categories"));
						 channelList.add(count);
						}
						return channelList;
					  	
					}				});
					}
		    catch(Exception e) {
		    	return null;	
		    }
	}

	@Override
	public List<AllDashboard> categoryList(Filter f) {
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
				query.append("SELECT count(c1.count) ");
			} else {
				query.append("SELECT SUM(c1.duration_ms/1000) ");
			}  
			query.append("  time_duration, c1.categories category, cate.filename logo FROM all_channels_1 c1 "
					+ "  LEFT JOIN category_backup cate ON cate.categoryName  = c1.categories  ");
							query.append("  where"
						+ " date(c1.timestamp_utc) between '" + f.getStartdate() + "'" + " and '" + f.getEnddate()+"' ");
							if (!("".equals(f.getGenre()) || f.getGenre()==null)) {
							query.append("  and c1.stream_type in (" + f.getGenre() + ")");	
							}	

							
							if (!("".equals(f.getStreamname()) || f.getStreamname() == null)) {
					query.append(" and c1.stream_name IN ("+streamname+")");
				} 
				if (!("".equals(f.getProductname()) || f.getProductname()== null)) {
					query.append(" and c1.product IN (" + product+ " )");
				}

			/*	
			} else {
				query.append("  where " + " date(c1.timestamp_utc) between '" + f.getStartdate() + "' " + " and '"
						+ f.getEnddate() + "' ");
				if (!("".equals(f.getStreamid()) || f.getStreamid() == null)) {
					query.append(" and c1.stream_id IN (" + channelid + " )");
				}
				if (!("".equals(f.getProductname()) || f.getProductname()== null)) {
					query.append(" and c1.product IN (" + product+ " )");
				} 
			}*/
			query.append(" and c1.categories!='' GROUP BY category order by time_duration  ");
			 if(f.getLimit()==null || "".equals(f.getLimit())){
				    query.append("  "+f.getOrder() + "");	
				    }
				    else {
				    query.append("   "+f.getOrder() + "  limit "+f.getLimit()+" " );	 	
		 
				    }
			String finalQuery = new String(query);
			System.out.println("query for Category data: " + finalQuery);
			return jdbcTemplate.query(finalQuery, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					while (rs.next()) {
						// LocalDate startDate =null;

						AllDashboard categoryData = new AllDashboard();
			
						
		                        	 categoryData.setTimeduration(rs.getInt("time_duration"));            	
		 	
						categoryData.setCategoryname(rs.getString("category"));
						categoryData.setDuration_name(f.getTime());
						String categorylogo = rs.getString("logo");
						if (categorylogo == null || "null".equalsIgnoreCase(categorylogo)) {
							categoryData.setLogo("NA");
						} else {
							categoryData.setLogo(categorylogo);
						} 
                        categoryData.setLogoUrl(categoryLogoUrl);
						// categoryData.setProductlogo(rs.getString("imageurl"));
						productList.add(categoryData);
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
	public List<AllDashboard> DataBySingleCategory(String category, String startdate, String enddate) {
    try {
	 String query="select count(p1.count) playout, sum(p1.duration_ms/1000) airtime ," 
	 + "count(distinct cm.cid) cid ,  sum((p1.duration_ms/1000)/cm.spendunit*cm.spend) spend FROM all_channels_1 p1  left join channel_master2 cm on p1.cid=cm.cid  where date(p1.timestamp_utc) between  '"+startdate+"' and '"+enddate+"' and p1.categories='"+category+"'";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<AllDashboard>>() {
			public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<AllDashboard> data = new ArrayList<AllDashboard>();
				while (rs.next()) {
					AllDashboard categoryData = new AllDashboard();
					categoryData.setCount(rs.getInt("playout"));
					Integer sec=rs.getInt("airtime");
				    String airtime=airtimeLogic.getTimeFormat(sec);
					categoryData.setAirtime(airtime);
					categoryData.setCid(rs.getInt("cid"));
					categoryData.setCategoryname(category);
					categoryData.setSpend(rs.getDouble("spend"));
					data.add(categoryData);
				}
				return data;
			}
		});
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}

}

	@Override
	public String categoryLogo(String catgeory) {
		   String query="select distinct(filename) logo from category_backup  where categoryname"
			   		+ "='"+catgeory+"'";
				System.out.println("query for  category logo: " + query);
				try { 

					return jdbcTemplate.query(query, new ResultSetExtractor<String>() {
						public String extractData(ResultSet rs) throws SQLException, DataAccessException {
							String logo = null;
							while (rs.next()) {
								String imgurl=rs.getString("logo");
								if(imgurl==null || "null".equals(imgurl) ||"".equals(imgurl) || "".equals(imgurl)) {
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

}	
	


