package org.sync.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.sync.dao.ChannelDao;
import org.sync.model.AllDashboard;
import org.sync.model.Channel;
import org.sync.model.Filter;
import org.sync.model.Search;

public class ChannelDaoImpl implements ChannelDao{
	@Autowired
	AirtimeLogic airtimeLogic;
	@Value("${channelUrl}")
	String channelLogoUrl;
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<AllDashboard> hourlyPlayoutForChannel(Filter f) {
		try {
			StringBuilder query=new StringBuilder();
			String channelid=f.getStreamid();
			if(!(channelid==null ||"".equals(channelid))){
				if(!channelid.contains("'")) {
					channelid="'"+channelid+"'";
				}		
			}
			String streamname=f.getStreamname();
			if(!(streamname==null ||"".equals(streamname))){
				if(!streamname.contains("'")) {
					streamname="'"+streamname+"'";
				}		
			}

			if("Playout".equalsIgnoreCase(f.getTime())){
								query.append("select count(count)");
							}
							else {
								query.append("select sum(duration_ms/1000)");	
							}
							query.append(" time_duration ,hour(timestamp_utc) hour  from all_channels_1 "
									+" where date(timestamp_utc) "
									+ " between '"+f.getStartdate()+"' "
											+ "and '"+f.getEnddate()+"'");
				            if(!("".equals(f.getProductname()) || f.getProductname()==null)) {
				            query.append("and product='"+f.getProductname()+"'");	
				            } 
				            if(!("".equals(f.getStreamname()) || f.getStreamname()==null)) {
				            	  query.append("and stream_name IN ("+streamname+")");	
				            } 
				            if(!("".equals(f.getGenre()) || f.getGenre()==null)) {
				            	  query.append("and stream_type IN ("+f.getGenre()+")");	
				            } 
				             
				            if(!(f.getLanguage()==null || "".equals(f.getLanguage()))) {
				                query.append(" and stream_language IN ("+f.getLanguage()+")  ");	
				                }
				            
				        
						
			            query.append("  group by hour order by time_duration "+f.getOrder()+"");
			              
			    
			String finalQuery=new String(query);
			System.out.println("hourly playout query: " +finalQuery);
			return jdbcTemplate.query(finalQuery,
					new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList=new ArrayList<AllDashboard>();
					Map<Integer,Integer> hourlyPlayoutData=new HashMap<Integer,Integer>();
					
					
					while(rs.next()) { 

					/*	channelData.setTimeduration(rs.getInt("time_duration"));
						channelData.setHours(rs.getInt("hour"));*/
						hourlyPlayoutData.put(rs.getInt("hour"),
								rs.getInt("time_duration"));
					
					}
					//for(int i=0;i<24;i++) {
					
					int i=0;	
					while(i<24) {
						AllDashboard channelData=new AllDashboard();
						int j=i;
						//System.out.println("hours" +j);
						channelData.setHours(i);
					channelData.setDuration_name(f.getTime());
						//System.out.println("hours : "+i);
						if(hourlyPlayoutData.containsKey(i)) {
						channelData.setTimeduration(hourlyPlayoutData.get(i));	
						}else {
							channelData.setTimeduration(0);		
						}
						productList.add(channelData);
					    i++; 
					}  
					return productList;
				}				});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}

	@Override
	public List<AllDashboard> dailyPlayoutForChannel(Filter f) {
		try { 
			StringBuilder query=new StringBuilder();
			String channelid=f.getStreamid();
			String streamname=f.getStreamname();
			if(!(streamname==null ||"".equals(streamname))){
				if(!streamname.contains("'")) {
					streamname="'"+streamname+"'";
				}		
			}

						if("Playout".equalsIgnoreCase(f.getTime())){
							query.append("select count(count)");
						}
						else {
							query.append("select sum(duration_ms/1000)");	
						} 
						query.append(" time_duration ,date(timestamp_utc) date  from all_channels_1 "
								+" where date(timestamp_utc) "
								+ " between '"+f.getStartdate()+"' "
										+ "and '"+f.getEnddate()+"'");
			            if(!("".equals(f.getProductname()) || f.getProductname()==null)) {
			            query.append("and product='"+f.getProductname()+"'");	
			            }
			            if(!("".equals(f.getStreamname()) || f.getStreamname()==null)) {
			            	  query.append("and stream_name IN ("+streamname+")");	
			            } 
			            
			            if(!("".equals(f.getGenre()) || f.getGenre()==null)) {
			            	  query.append("and stream_type IN ("+f.getGenre()+")");	
			            }
			            
			            if(!("".equals(f.getLanguage()) || f.getLanguage()==null)) {
			            	  query.append("and stream_language IN ("+f.getLanguage()+")");	
			            }
			            
			            
			        
					
		            query.append("  group by date order by time_duration "+f.getOrder()+"");
		              
		     
		   System.out.println("query for daily playout "+query);
			String finalQuery=new String(query);
			return jdbcTemplate.query(finalQuery,
					new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList=new ArrayList<AllDashboard>();
					Map<LocalDate, Integer> mp=new HashMap<LocalDate,Integer>();
					while(rs.next()) {
						mp.put(LocalDate.parse(rs.getString("date")), 
								rs.getInt("time_duration"));
					}
					String s = f.getStartdate();
					String e = f.getEnddate();
					LocalDate start = LocalDate.parse(s);
					LocalDate end = LocalDate.parse(e);
					while (!start.isAfter(end)) {
						AllDashboard channelData=new AllDashboard();
						
						channelData.setDuration_name(f.getTime());
					
						System.out.println(start);
						
						channelData.setDate(start.toString());
						if(mp.containsKey(start)) {
					channelData.setTimeduration(mp.get(start));
						}else {
						channelData.setTimeduration(0);
						}
					    start = start.plusDays(1);
						productList.add(channelData);	
					}

					return productList;
				}				});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}

	@Override
	public List<AllDashboard> channelsDatacount() {
    String query=("select count(distinct cid) cid, count(distinct language) language, count(distinct type) type from channel_master2");
   System.out.println("query for channels data count: " + query);
    try {
		return jdbcTemplate.query(query,
				new ResultSetExtractor<List<AllDashboard>>() {
			public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<AllDashboard> channelList=new ArrayList<AllDashboard>();
			
				while(rs.next()) {
				 AllDashboard count=new AllDashboard();
				 count.setGenre(rs.getString("type"));
				 count.setLanguage(rs.getString("language"));
				 count.setCid(rs.getInt("cid")); 
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
	public List<AllDashboard> channelsList(Filter f) {
    try {
    	System.out.println("channel filter data: " +f);
		String product=f.getProductname();
		if(!(product==null ||"".equals(product))){
			if(!(product.startsWith("'") && product.endsWith("'"))) {
				product="'"+product+"'";
			}	 	
		}      
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

	StringBuilder query=new StringBuilder();
    if("Playout".equals(f.getTime())) {
    query.append("SELECT count(p1.count) ");	
    }
    else {
    query.append("SELECT SUM(p1.duration_ms/1000) ");	
    } 
    query.append(" time_duration,p1.stream_name streamname, p1.cid cid, "
    + " cm.filename imageurl,p1.cid cid FROM all_channels_1 "
    + " p1 left join channel_master2 cm on  "
    + "      p1.stream_name= cm.streamname   "
    + "  where date(p1.timestamp_utc) "
    + " between '"+f.getStartdate()+"' and '"+f.getEnddate()+"' ");
    
    if(!(f.getProductname()==null || "".equals(f.getProductname()))) {
        query.append(" and p1.product IN ("+product+")  ");	
        }   
   if(!(f.getCreative()==null || "".equals(f.getCreative()))) {
        query.append(" and p1.title = '"+f.getCreative()+"'  ");	
        }  
   if(!(f.getBrandname()==null || "".equals(f.getBrandname()))) {
        query.append(" and p1.brand IN ("+brand+")  ");	
        }   
    if(!(f.getCategory()==null || "".equals(f.getCategory()))) {
        query.append(" and p1.categories ='"+f.getCategory()+"'               ");	
        }   

    
    if(!(f.getGenre()==null || "".equals(f.getGenre()))) {
    query.append(" and p1.stream_type  IN ("+f.getGenre()+") ");	
    }
  
    if(!(f.getStreamname()==null || "".equals(f.getStreamname()))) {
    query.append(" and p1.stream_name IN ("+streamname+")  ");	
    }   
    if(!(f.getLanguage()==null || "".equals(f.getLanguage()))) {
        query.append(" and p1.stream_language IN ("+f.getLanguage()+")  ");	
        }
    query.append("  group by streamname order by time_duration   ");
    
    if(f.getLimit()==null || "".equals(f.getLimit())) {
    query.append("  "+f.getOrder() + "");	
    }
    else {
    query.append("   "+f.getOrder() + "  limit  "+f.getLimit()+" " );	 	
    }
    String finalQuery= new String(query);
    System.out.println("query for channel list: " + finalQuery );
    return jdbcTemplate.query(finalQuery,
			new ResultSetExtractor<List<AllDashboard>>() {
		public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<AllDashboard> channelList=new ArrayList<AllDashboard>();
		 
			while(rs.next()) {
            AllDashboard channels =new AllDashboard();
            //channels.setTimeduration(rs.getString("time_duration"));
			channels.setStreamname(rs.getString("streamname"));
		    channels.setDuration_name(f.getTime()); 
			channels.setCid(rs.getInt("cid"));
		    String imageurl=rs.getString("imageurl");
			Integer sec=rs.getInt("time_duration"); 
			channels.setLogoUrl(channelLogoUrl);
			channels.setTimeduration(rs.getInt("time_duration"));							
			if(imageurl==null || "null".equalsIgnoreCase(imageurl)) {
				channels.setLogo("NA");
			}
			else {
				channels.setLogo(imageurl);
			}
			channelList.add(channels);
			}
			return channelList;

    }
    
    });
    
    
	}
    catch(Exception e) {
    	e.printStackTrace();
    	return null;
    }
		
	}

	@Override
	public List<AllDashboard> getDataByTopProduct(Filter f) {
	StringBuilder query=new StringBuilder();
	String streamname=f.getStreamname();
	if(!(streamname==null ||"".equals(streamname))){
		if(!streamname.contains("'")) {
			streamname="'"+streamname+"'";
		}		
	}

	try {
	if("Playout".equalsIgnoreCase(f.getTime())) {
		query.append("select count(count)  time_duration  , ");	
	}
	else {
		query.append("select sum(duration_ms/1000)  time_duration  , ");	
	}
	if(!("".equals(f.getProductname()) || f.getProductname()==null))
	{	
		query.append("  product from all_channels_1 where date(timestamp_utc) between '"+f.getStartdate()+"' and '"+f.getEnddate()+"' and  cm.streamname='"+streamname+"' group by product   order by time_duration "+f.getOrder()+"");
	}
	if(!(f.getCategory()=="" || f.getCategory()==null))
	{	
		query.append("  product from all_channels_1 where date(timestamp_utc) between '"+f.getStartdate()+"' and '"+f.getEnddate()+"' and  categories='"+f.getCategory()+"' group by product   order by time_duration "+f.getOrder()+"");
	}	
	 String finalQuery= new String(query);
	    System.out.println("query for top product list: " + finalQuery );
	    return jdbcTemplate.query(finalQuery,
				new ResultSetExtractor<List<AllDashboard>>() {
			public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<AllDashboard> channelList=new ArrayList<AllDashboard>();
			 
				while(rs.next()) { 
	            AllDashboard products =new AllDashboard();
	            products.setTimeduration(rs.getInt("time_duration"));
                products.setProductname(rs.getString("product"));
	            channelList.add(products);
				}
				return channelList;

	    }
	    
	    });
	    
	    
		}
	catch(Exception e) {
	e.printStackTrace();	
	return null;
	}

}

	@Override
	public List<AllDashboard> DataBySingleChannel(Integer cid, String startdate, String enddate) {
    String query = " select count(p1.count) playout,sum(p1.duration_ms/1000)"
    + " airtime,GROUP_CONCAT(distinct p1.stream_type) genre ,"
    + "cm.streamname streamname, sum((p1.duration_ms/1000)/cm.spendUnit*cm.spend) spend,"
    + "GROUP_CONCAT(distinct p1.stream_language) language"
    + " FROM all_channels_1 p1 left join channel_master2 cm on "
    + "cm.cid= p1.cid "
    + "  where date(p1.timestamp_utc) "
    + "between '"+startdate+"' and '"+enddate+"' and p1.cid="+cid+"";
		System.out.println("query for single channel: " + query);
		try {

			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					while (rs.next()) {
						AllDashboard channelData = new AllDashboard();
						channelData.setCount(rs.getInt("playout"));
						Integer sec=rs.getInt("airtime");
					    String airtime=airtimeLogic.getTimeFormat(sec);
						channelData.setAirtime(airtime);
						channelData.setLanguage(rs.getString("language"));
                        channelData.setGenre(rs.getString("genre"));
                        channelData.setSpend(rs.getDouble("spend"));
                        channelData.setStreamname(rs.getString("streamname"));
						productList.add(channelData);
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
	public List<AllDashboard> getDatabyBrands(Filter f) {
		try {
			StringBuilder query = new StringBuilder();
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
				query.append("time_duration ,brand  from all_channels_1 " + " where date(timestamp_utc) "
						+ "between '" + f.getStartdate() + "' " + "and '" + f.getEnddate() + "'");
				if (!(f.getProductname() == "" || f.getProductname() == null)) {
					query.append("and product='" + f.getProductname() + "'");
				}
				if (!(f.getStreamname() == "" || f.getStreamname() == null)) {
					query.append("and stream_name IN (" + streamname + ")");
				} 
				if (!(f.getGenre() == "" || f.getGenre() == null)) {
				query.append("and stream_type IN (" + f.getGenre() + ")");
			}


//			} else {
				/*if ("Playout".equalsIgnoreCase(f.getTime())) {
					query.append("select count(ac1.count)");
				} else {
					query.append("select sum(ac1.duration_ms/1000)");
				}
				query.append(" time_duration ,ac1.brand Categories  from all_channels_1 ac1"
						+ " inner join channel_master2 cm on ac1.cid=cm.cid"
						+ " where date(ac1.timestamp_utc) " + " between '" + f.getStartdate() + "' " + "and '"
						+ f.getEnddate() + "'");
				if (!(f.getProductname() == "" || f.getProductname() == null)) {
					query.append("and ac1.product='" + f.getProductname() + "'");
				}
				if (!(f.getCid() == "" || f.getCid() == null)) {
					query.append("and cm.cid IN (" + f.getCid() + ")");
				} 
				if (!(f.getGenre() == "" || f.getGenre() == null)) {
				query.append("and cm.type IN (" + f.getGenre() + ")");
			}
*/			query.append("  group by brand order by time_duration");

			if (f.getLimit() == "" || f.getLimit() == null) {
				query.append(" " + f.getOrder() + " ");
			} else {
				query.append(" " + f.getOrder() + "  limit " + f.getLimit() + " ");
			}

			String finalquery = new String(query);
			System.out.println("query for get data by brand" + finalquery);
			return jdbcTemplate.query(finalquery, new ResultSetExtractor<List<AllDashboard>>() {
				public List<AllDashboard> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<AllDashboard> productList = new ArrayList<AllDashboard>();
					while (rs.next()) {
						AllDashboard channelData = new AllDashboard();
						channelData.setTimeduration(rs.getInt("time_duration"));
						channelData.setBrand(rs.getString("brand"));
						channelData.setDuration_name(f.getTime());
						productList.add(channelData);
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
	public List<Search> brandSearch(Search term) {
		List<Search> result = new ArrayList<Search>();
		try {
			
			String str="Select distinct(brand) brand from all_channels_1 where Brand like '"+term.getTerm().trim()+"%'";
             System.out.println("query for brand search: " +str);
			jdbcTemplate.query(str, new ResultSetExtractor<List<Search>>(){
					
				    public List<Search> extractData(ResultSet rs) throws SQLException  {
				    	//System.out.println("before result set");
							while(rs.next()){
								DateTimeFormatter format =
						                DateTimeFormatter.ofPattern("yyyy-MM-dd");

						            LocalDateTime now = LocalDateTime.now();
						            LocalDateTime then = now.minusDays(6);
						            String startdate=then.format(format).toString();
						            String enddate=now.format(format).toString();
								
						            Search search=new Search();
								search.setTerm(rs.getString("brand"));
								search.setType("Brand");
								search.setStartdate(startdate);
								search.setEnddate(enddate);
								result.add(search);
							}
							//System.out.println("sharad fail" );
							return result;
				    }
		
			});
			
		}
		catch(Exception e){	
			return null;
		}
		return result;
	}

	@Override
	public List<Search> productSearch(Search obj2) {
		
		List<Search> result = new ArrayList<Search>();
		try {
			
			String str="Select distinct(product) product from all_channels_1 where product like '"+obj2.getTerm().trim()+"%'";
			 System.out.println("query for product search: " +str);
			jdbcTemplate.query(str, new ResultSetExtractor<List<Search>>(){
					
				
				    public List<Search> extractData(ResultSet rs) throws SQLException  {
				    	//System.out.println("before result set");
							while(rs.next()){
								DateTimeFormatter format =
						                DateTimeFormatter.ofPattern("yyyy-MM-dd");

						            LocalDateTime now = LocalDateTime.now();
						            LocalDateTime then = now.minusDays(6);
						            String startdate=then.format(format).toString();
						            String enddate=now.format(format).toString();
								
						            Search search=new Search();
								search.setTerm(rs.getString("product"));
								search.setType("Product");
								search.setStartdate(startdate);
								search.setEnddate(enddate);
								result.add(search);
							}
							//System.out.println("sharad fail" );
							return result;
				    }
		
			});
			
		}
		catch(Exception e){	
			return null;
		}
		return result;
	}

	@Override
	public List<Search> categorySearch(Search obj3) {

		List<Search> result = new ArrayList<Search>();
		try {
			
			String str="Select distinct(categories) categories from all_channels_1 where categories like '"+obj3.getTerm().trim()+"%'";
			 System.out.println("query for category search: " +str);
			jdbcTemplate.query(str, new ResultSetExtractor<List<Search>>(){
					
				    public List<Search> extractData(ResultSet rs) throws SQLException  {
				    	//System.out.println("before result set");
							while(rs.next()){
								DateTimeFormatter format =
						                DateTimeFormatter.ofPattern("yyyy-MM-dd");

						            LocalDateTime now = LocalDateTime.now();
						            LocalDateTime then = now.minusDays(6);
						            String startdate=then.format(format).toString();
						            String enddate=now.format(format).toString();
								
						            Search search=new Search();
								search.setTerm(rs.getString("categories"));
								search.setType("Category");
								search.setStartdate(startdate);
								search.setEnddate(enddate);
								result.add(search);
							}
							//System.out.println("sharad fail" );
							return result;
				    }
		
			});

			
		}
		catch(Exception e){	
			return null;
		}
		return result;
	}

	@Override
	public List<Search> channelSearch(Search obj4) {
		List<Search> result = new ArrayList<>();
		try {
			
			String str="Select  distinct(stream_name) stream_name ,cid cid  from  all_channels_1   where stream_name like '"+obj4.getTerm().trim()+"%' group by stream_name,cid ";
			 System.out.println("query for channel search: " +str);
			jdbcTemplate.query(str, new ResultSetExtractor<List<Search>>(){
					
				    public List<Search> extractData(ResultSet rs) throws SQLException  {
				    	//System.out.println("before result set");
							while(rs.next()){
								DateTimeFormatter format =
						                DateTimeFormatter.ofPattern("yyyy-MM-dd");
						            LocalDateTime now = LocalDateTime.now();
						            LocalDateTime then = now.minusDays(6);
						            String startdate=then.format(format).toString();
						            String enddate=now.format(format).toString();
								
						            Search search=new Search();
								search.setTerm(rs.getString("stream_name"));
								search.setType("Channel");
								search.setCid(rs.getInt("cid"));
								search.setStartdate(startdate);
								search.setEnddate(enddate);
								result.add(search);

							}
							//System.out.println("sharad fail" );
							return result;
				    }
		
			});
			
		}
		catch(Exception e){	
			return null;
		}
		return result;
	}
	@Override
	public String getStreamIdByStreamName(String streamName) {
		String result = null;
		try {
			//System.out.println("hiiiiiiiii  streamName");
			
			String str="Select streamId from channel_master2 where streamName='"+streamName+"'";
		//System.out.println("hiii" +str);
			result = jdbcTemplate.query(str, new ResultSetExtractor<String>(){
					
				    public String extractData(ResultSet rs) throws SQLException  {
				    	//System.out.println("before result set");
				    	String streamname=null;
				    	while(rs.next()) {
							  streamname=rs.getString("streamId");
							
								//System.out.println("zaheen" +result);
							//System.out.println("sharad fail" );
				    	}
							return streamname;
				    }
		
			});
			
		}
		catch(Exception e){	
			return null;
		}
		return result;
	}
   
	@Override
	public List<String> totalLanguages() {
		try {
			 String query="select distinct(language) language  from channel_master2 where language!=''";  
			return jdbcTemplate.query(query, new ResultSetExtractor<List<String>>() {
						public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<String> data = new ArrayList<String>();
							while (rs.next()) {
                            String language=rs.getString("language").trim(); 
								data.add(language);
								
							} 
							Collections.sort(data);
							return data;
						}
					});
				} catch (Exception e) {
					System.out.println(e);
					return null;
				}	}

	@Override
	public Channel channelLogo(Integer cid) {
		   String query="select filename  logo,streamname,type,language from channel_master2  where cid="+cid+"";
				System.out.println("query for  channel data: " + query);
				try { 
					return jdbcTemplate.query(query, new ResultSetExtractor<Channel>() {
						public Channel extractData(ResultSet rs) throws SQLException, DataAccessException {
							Channel channelData = new Channel();
							while (rs.next()) {
								String imgurl=rs.getString("logo");
								channelData.setGenre(rs.getString("type"));
								channelData.setLanguage(rs.getString("language"));
								if(imgurl==null || "null".equals(imgurl) ||  "".equals(imgurl) ) {
					 				channelData.setLogo("NA");	
								}
								else {
									channelData.setLogo(imgurl);	
								}
								channelData.setStreamname(rs.getString("streamname"));
							}
					System.out.println("function end");
					return channelData;
						}
					});
				} catch (Exception e) {
					
					System.out.println(e);
					return null;
				}	}
	}

