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
import org.sync.dao.BrandDao;
import org.sync.model.AllDashboard;
import org.sync.model.Filter;

public class BrandDaoImpl implements BrandDao{
	@Autowired
	AirtimeLogic airtimeLogic;

	private JdbcTemplate jdbcTemplate;
	@Value("${brandUrl}")
	String brandLogoUrl; 
	@Value("${productUrl}") 
	String productUrl;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
   
	@Override
	public List<AllDashboard> hourlyPlayoutForBrand(Filter f) {
		try {
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
						query.append("SELECT count(count)  ");
					} else {
						query.append(" SELECT SUM(duration_ms/1000) ");
					}
					query.append("  time_duration,hour(timestamp_utc)hour  FROM all_channels_1 ac1 "
							+ " where date(timestamp_utc) " + "between '" + f.getStartdate() + "' " + "and '"
							+ f.getEnddate() + "'");
					if (!("".equals(f.getBrandname()) || f.getBrandname() == null)) {
						query.append("and brand in (" + brand + ") ");
					}
					if (!("".equals(f.getGenre()) || f.getGenre() == null)) {
						query.append("and stream_type in (" + f.getGenre() + ") ");	
					}
					if (!("".equals(f.getStreamname()) || f.getStreamname() == null)) {
						query.append("and stream_name IN ("+streamname+")");
					}
				
				//} else {
				/*	if ("Playout".equalsIgnoreCase(f.getTime())) {
						query.append("select count(ac1.count)");
					} else {
						query.append("select sum(ac1.duration_ms/1000)");
					}
					query.append(" time_duration ,hour(ac1.timestamp_utc) hour  from all_channels_1 ac1"
							+ " inner join channel_master2 cm on ac1.cid=cm.cid"
							+ " where date(ac1.timestamp_utc) " + " between '" + f.getStartdate() + "' " + "and '"
							+ f.getEnddate() + "'");
					if (!("".equals(f.getBrandname()) || f.getBrandname() == null)) {
						query.append("and ac1.brand in (" + brand + ") ");
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
					List<AllDashboard> brandList = new ArrayList<AllDashboard>();
					Map<Integer, Integer> hourlyPlayoutData = new HashMap<Integer, Integer>();
					while (rs.next()) {
						hourlyPlayoutData.put(rs.getInt("hour"), rs.getInt("time_duration"));

					}

					int i = 0;
					while (i < 24) {
						AllDashboard brandData = new AllDashboard();
						brandData.setHours(i);
						brandData.setDuration_name(f.getTime());
						if (hourlyPlayoutData.containsKey(i)) {
							    	 brandData.setTimeduration( hourlyPlayoutData.get(i));            	
		                    
						} else {
							brandData.setTimeduration(0);
						}
						brandList.add(brandData);
						i++;
					}
					return brandList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<AllDashboard> dailyPlayoutForBrand(Filter f) {
		try {
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
			StringBuilder query = new StringBuilder();
					if ("Playout".equalsIgnoreCase(f.getTime())) { 
						query.append("SELECT count(count)");
					} else {
						query.append("SELECT SUM(duration_ms/1000)");
					}
					query.append("time_duration,DATE(timestamp_utc) date FROM all_channels_1 "
							+ " where date(timestamp_utc) " + "between '" + f.getStartdate() + "' " + "and '"
							+ f.getEnddate() + "'");
					if (!("".equals(f.getBrandname()) || f.getBrandname() == null)) {
						query.append("and brand in (" + brand + ") ");
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
					if (!("".equals(f.getBrandname()) || f.getBrandname() == null)) {
						query.append("and ac1.brand in(" +brand+ ") ");
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
					List<AllDashboard> brandList = new ArrayList<AllDashboard>();
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
						AllDashboard brandData = new AllDashboard();

						brandData.setDuration_name(f.getTime());

						System.out.println(start);

						brandData.setDate(start.toString());
						if (mp.containsKey(start)) {
							// System.out.println("yes");
							brandData.setTimeduration(mp.get(start));

						} else {
							// System.out.println("no");
							brandData.setTimeduration(0);
						}
						start = start.plusDays(1);
						brandList.add(brandData);
					}

					return brandList;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Integer brandDatacount() {
		 String query=("select count(distinct brand) brand from all_channels_1");
		   System.out.println("query for brand data count: " + query);
		    try {
				return jdbcTemplate.query(query,
						new ResultSetExtractor<Integer>() {
					public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
						Integer brandcount = null;
						while(rs.next()) {
						 brandcount=rs.getInt("brand");
						}
						return brandcount;
 					  	
					}				});
					}
		    catch(Exception e) {
		    	return null;	
		    }	}

	@Override
	public List<AllDashboard> brandList(Filter f) {
		try {
			String brand=f.getBrandname();
			if(!(brand==null ||"".equals(brand))){
				if(!brand.contains("'")) {
					brand="'"+brand+"'";
				}		
			} 
			
			String category=f.getCategory();
			
			if(!(category==null ||"".equals(category))){
				if(!category.contains("'")) {
					category="'"+category+"'";
				}		
			}
			
			String streamname=f.getStreamname();
			if(!(streamname==null ||"".equals(streamname))){
				if(!streamname.contains("'")) {
					streamname="'"+streamname+"'";
				}		
			}
 
			StringBuilder query = new StringBuilder();
			if ("Playout".equalsIgnoreCase(f.getTime())) {
				query.append("SELECT count(b1.count) ");
			} else {
				query.append("SELECT SUM(b1.duration_ms/1000) ");
			}
			query.append("  time_duration, b1.brand brand ," + "  br.filename logo FROM all_channels_1 b1 "
					+ "  LEFT JOIN brand_backup29APR br ON br.brandName " + " = b1.brand  ");
 
				query.append(" where "
						+ " date(b1.timestamp_utc) between '" + f.getStartdate() + "'" + " and '" + f.getEnddate()
						+ "' " );
				if (!(f.getGenre() == null || "".equals(f.getGenre()))) {
                 query.append("  and b1.stream_type in (" + f.getGenre() + ") " );
				}
				
				if (!("".equals(f.getStreamname()) || f.getStreamname() == null)) {
					query.append(" and b1.stream_name IN ("+streamname+")");
				}
				
				if (!("".equals(f.getCategory()) || f.getCategory() == null)) {
					query.append(" and b1.categories  IN (" +category+ " )");
				}
				
				if (!("".equals(f.getBrandname()) || f.getBrandname() == null)) {
					query.append(" and b1.brand IN (" + brand + " )");
				}
					query.append(" GROUP BY brand order by time_duration  ");
			 if(f.getLimit()==null || "".equals(f.getLimit())) {
				    query.append("  "+f.getOrder() + "");	
				    }
				    else {
				    query.append("   "+f.getOrder() + "  limit "+f.getLimit()+" " );	 	
		
				    }
			String finalQuery = new String(query);
			System.out.println("query for brand List: " + finalQuery);
			return jdbcTemplate.query(finalQuery, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					while (rs.next()) {
						// LocalDate startDate =null;

						AllDashboard brandData = new AllDashboard();
						brandData.setTimeduration(rs.getInt("time_duration"));
						brandData.setBrand(rs.getString("brand"));
						brandData.setDuration_name(f.getTime());
						
						String brandLogo = rs.getString("logo");
						if (brandLogo == null || "null".equalsIgnoreCase(brandLogo)) {
							brandData.setLogo("NA");
						} else {
							
							brandData.setLogo(brandLogo);
						}
						brandData.setLogoUrl(brandLogoUrl);
						productList.add(brandData);
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
	public List<AllDashboard> DataBySingleBrand(String brand, String startdate, String enddate) {
	 try {
	  String query="select count(p1.count) playout,brand, sum(p1.duration_ms/1000) airtime ,count(distinct p1.cid) cid ,  sum((p1.duration_ms/1000)/cm.spendunit*cm.spend) spend  FROM all_channels_1 p1  left join channel_master2 cm on p1.stream_id=cm.streamid where date(p1.timestamp_utc) between  '"+startdate+"' and '"+enddate+"' and p1.brand='"+brand+"'";
		System.out.println("query for single brand: "+ query);	
	  return jdbcTemplate.query(query, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> data = new ArrayList<AllDashboard>();
					while (rs.next()) {
						AllDashboard brandData = new AllDashboard();
						brandData.setCount(rs.getInt("playout"));
					    Integer sec=rs.getInt("airtime");
					    String airtime=airtimeLogic.getTimeFormat(sec);
						brandData.setAirtime(airtime);
						brandData.setBrand(rs.getString("brand"));
						brandData.setCid(rs.getInt("cid"));
						brandData.setSpend(rs.getDouble("spend"));
						data.add(brandData);
					}
					return data; 
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	}

	@Override
	public List<String> getAllBrand() {
		try {
			 String query="select distinct(brand) brand  from all_channels_1 where brand!='' ";  
			return jdbcTemplate.query(query, new ResultSetExtractor<List<String>>() {
						public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<String> data = new ArrayList<String>();
							while (rs.next()) {
                             String brand=rs.getString("brand").trim(); 
								data.add(brand);
								Collections.sort(data);
							}
							return data;
						}
					});
				} catch (Exception e) {
					System.out.println(e);
					return null;
				}	}

	@Override
	public List<String> singleBrandByProduct(String brand, String startdate, String enndate) {
		try {
			 String query="select distinct(product) product  from all_channels_1 where "
					+ "   date(timestamp_utc) between '"+startdate+"' and '"+enndate+"' and brand ='"+brand+"'";  
			System.out.println("query for single brand data by product:  " +query);
			 return jdbcTemplate.query(query, new ResultSetExtractor<List<String>>() {
						public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<String> data = new ArrayList<String>();
							while (rs.next()) {
                            String brand=rs.getString("product"); 
								data.add(brand);
								Collections.sort(data);
							} 
							return data;
						}
					});
				} catch (Exception e) {
					System.out.println(e);
					return null;
				}	}

	@Override
	public List<AllDashboard> BrandDataBySeparateProduct(Filter f) {
		String query = "SELECT product, count(p1.count) count,GROUP_CONCAT(distinct p1.categories) categories,GROUP_CONCAT(distinct p1.stream_language) language,sum(p1.duration_ms/1000) airtime , count(distinct p1.cid) cid,sum((p1.duration_ms/1000)/cm.spendunit*cm.spend) spend,  pro.filename imgurl  FROM all_channels_1 p1 LEFT JOIN product_backup29APR pro ON pro.productName = p1.product  left join channel_master2 cm on p1.stream_name=cm.streamname   where date(p1.timestamp_utc) between  '"+f.getStartdate()+"' and '"+f.getEnddate()+"' and p1.brand='" +f.getBrandname()+ "'  and p1.product='"+f.getProductname()+"'  ";
		System.out.println("query for single product: " + query);
			try { 
 
				return jdbcTemplate.query(query, new ResultSetExtractor<List<AllDashboard>>() {
					public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<AllDashboard> productList = new ArrayList<AllDashboard>();
						while (rs.next()) {
							AllDashboard brandData = new AllDashboard();
							brandData.setCount(rs.getInt("count"));
							Integer sec=rs.getInt("airtime");
							String airtime=airtimeLogic.getTimeFormat(sec);
							brandData.setProductname(rs.getString("product"));
							String imgurl=rs.getString("imgurl");
							if(imgurl==null || "null".equals(imgurl)) {
								brandData.setLogo("NA");	
							}
							else {
								brandData.setLogo(rs.getString("imgurl"));	
							}
							brandData.setLogoUrl(productUrl);
							brandData.setCategoryname(rs.getString("categories"));
							brandData.setLanguage(rs.getString("language"));
							brandData.setAirtime(airtime);
							brandData.setCid(rs.getInt("cid"));
	                        brandData.setSpend(rs.getDouble("spend"));
							productList.add(brandData); 
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
	public String brandLogo(String brand) {
		   String query="select distinct(filename) logo from brand_backup29APR  where brandname"
		   		+ "='"+brand+"'";
			System.out.println("query for  brand logo: " + query);
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
}
	


