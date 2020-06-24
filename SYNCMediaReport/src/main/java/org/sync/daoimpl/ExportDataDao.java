package org.sync.daoimpl;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.sync.Util.UtilDownload;
import org.sync.model.AllChannelDetails;

public class ExportDataDao {

    @Value("${csvInMysql}")
    String csvInMysqlpath;
    
    @Value("${csvfilename}")
    String csvfilename;

	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	
	

	
	public List<AllChannelDetails> allChannels(String fromdate, String endate) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="select * from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +endate+"' ORDER BY key1 DESC limit 2500"; 
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							
							
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setStream_url(rs.getString("stream_url"));
								data.setStream_id(rs.getString("stream_id"));
								data.setStatus(rs.getString("status"));
								data.setMsg(rs.getString("msg"));
								data.setCode(rs.getString("code"));
								data.setVersion(rs.getString("version"));
								data.setResult_Type(rs.getString("Result_Type"));
								data.setRecord_timestamp(rs.getString("record_timestamp"));
								data.setTimestamp_utc(rs.getString("timestamp_utc"));
								data.setPlayed_duration(rs.getString("played_duration"));
								data.setType(rs.getString("type"));
								data.setCount(rs.getString("count"));
								data.setPlay_offset_ms(rs.getString("play_offset_ms"));
								data.setSample_begin_time_offset_ms(rs.getString("sample_begin_time_offset_ms"));
								data.setScore(rs.getString("score"));
								data.setTitle(rs.getString("title"));
								data.setSample_end_time_offset_ms(rs.getString("sample_end_time_offset_ms"));
						

								String s=rs.getString("duration_ms");
										int s1=Integer.valueOf(s)/1000;
								data.setDuration_ms(s1);
								
								
								
								data.setBucket_id(rs.getString("bucket_id"));
								data.setDb_begin_time_offset_ms(rs.getString("db_begin_time_offset_ms"));
								data.setDb_end_time_offset_ms(rs.getString("db_end_time_offset_ms"));
								data.setAcrid(rs.getString("acrid"));
								data.setRupa(rs.getString("Rupa"));
								data.setAstral_Pipes(rs.getString("Astral_Pipes"));
								data.setAct_II(rs.getString("Act_II"));
								data.setKey1(rs.getString("key1"));
								data.setExtra1(rs.getString("extra1"));
								data.setExtra2(rs.getString("extra2"));
								data.setSub_Brand(rs.getString("Sub_Brand"));
								data.setDescription(rs.getString("description"));
								data.setCampaign(rs.getString("Campaign"));
								data.setBrand(rs.getString("Brand"));
								data.setProduct(rs.getString("Product"));
								data.setGenre(rs.getString("Genre"));
								data.setSub_Categories(rs.getString("sub_Categories"));
								data.setLanguage(rs.getString("Language"));
								data.setCategories(rs.getString("Categories"));
								data.setSub_Categories_2(rs.getString("Sub_Categories_2"));
								
								data.setStreamName(rs.getString("stream_name"));
								
								data.setLanguage1(rs.getString("stream_language"));
								
								data.setMaster_type(rs.getString("stream_type"));
								data.setCid(rs.getInt("cid"));
								
								channelslist.add(data);
								
									
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
							
							
							
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}
	
	
	public List<AllChannelDetails> allDataExport(String channel,String fromdate,String todate,String brand,String category,String product,String language,String genre) {
		try {
			
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			/*brand=brand.replaceAll("'", "\\\\'");
			product=product.replaceAll("'", "\\\\'");
			*/
			StringBuilder query= new StringBuilder();	
			query.append("select * from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"'");
			if(!(("").equals(channel)  || channel==null))
			{
				 query.append("  and stream_name in  ("+channel+")  ");	
			}
				
			if(!(("").equals(brand)  || brand==null))
			{
				 query.append("  and Brand in  ("+brand+")  ");	
			}
			
			if(!(("").equals(product)  || product==null))
			{
				 query.append("  and Product in  ("+product+")  ");	
			}
			
			if(!(("").equals(category)  || category==null))
			{
				 query.append("  and Categories in  ("+category+")  ");	
			}
			
			if(!(("").equals(language)  || language==null))
			{
				 query.append("  and stream_language in  ("+language+")  ");	
			}
			
			if(!(("").equals(genre)  || genre==null))
			{
				 query.append("  and stream_type in ("+genre+")  ");	
			}
			query.append("  limit 2500  ");
			
			
			String finalquery= new String(query);
			System.out.println("final query ==="+finalquery);
			
		
			return jdbcTemplate.query(finalquery, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							
							
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setStream_url(rs.getString("stream_url"));
								data.setStream_id(rs.getString("stream_id"));
								data.setStatus(rs.getString("status"));
								data.setMsg(rs.getString("msg"));
								data.setCode(rs.getString("code"));
								data.setVersion(rs.getString("version"));
								data.setResult_Type(rs.getString("Result_Type"));
								data.setRecord_timestamp(rs.getString("record_timestamp"));
								data.setTimestamp_utc(rs.getString("timestamp_utc"));
								data.setPlayed_duration(rs.getString("played_duration"));
								data.setType(rs.getString("type"));
								data.setCount(rs.getString("count"));
								data.setPlay_offset_ms(rs.getString("play_offset_ms"));
								data.setSample_begin_time_offset_ms(rs.getString("sample_begin_time_offset_ms"));
								data.setScore(rs.getString("score"));
								data.setTitle(rs.getString("title"));
								data.setSample_end_time_offset_ms(rs.getString("sample_end_time_offset_ms"));
							

								String s=rs.getString("duration_ms");
										int s1=Integer.valueOf(s)/1000;
								data.setDuration_ms(s1);
								
								data.setBucket_id(rs.getString("bucket_id"));
								data.setDb_begin_time_offset_ms(rs.getString("db_begin_time_offset_ms"));
								data.setDb_end_time_offset_ms(rs.getString("db_end_time_offset_ms"));
								data.setAcrid(rs.getString("acrid"));
								data.setRupa(rs.getString("Rupa"));
								data.setAstral_Pipes(rs.getString("Astral_Pipes"));
								data.setAct_II(rs.getString("Act_II"));
								data.setKey1(rs.getString("key1"));
								data.setExtra1(rs.getString("extra1"));
								data.setExtra2(rs.getString("extra2"));
								data.setSub_Brand(rs.getString("Sub_Brand"));
								data.setDescription(rs.getString("description"));
								data.setCampaign(rs.getString("Campaign"));
								data.setBrand(rs.getString("Brand"));
								data.setProduct(rs.getString("Product"));
								data.setGenre(rs.getString("Genre"));
								data.setSub_Categories(rs.getString("sub_Categories"));
								data.setLanguage(rs.getString("Language"));
								data.setCategories(rs.getString("Categories"));
								data.setSub_Categories_2(rs.getString("Sub_Categories_2"));
								
								data.setStreamName(rs.getString("stream_name"));
								
								data.setLanguage1(rs.getString("stream_language"));
								
								data.setMaster_type(rs.getString("stream_type"));
								data.setCid(rs.getInt("cid"));
								
								channelslist.add(data);
								
									
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
							
							
							
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}

	
	public String completeReportExport(String fromdate,String todate,String product,String category, String brand, String channel,String genre,String language ) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			//String query="select * from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and stream_name='"+channel+"'  limit 150"; 
			/*
			 * String
			 * query=" select  stream_name,Product,Brand from  all_channels_1 where  date(timestamp_utc) between '"
			 * +fromdate+ "' and '" +todate+"'    and stream_name like  '%"
			 * +channel+"%' and Brand like '%" +brand+"%' and  Product like '%"
			 * +product+"%' and  Categories like '%"
			 * +category+"%' INTO OUTFILE '/var/lib/mysql-files/SyncReport.csv' FIELDS TERMINATED BY ','ENCLOSED BY '\"' LINES TERMINATED BY '\\r\\n';\r\n "
			 * + "";                                                                                                                                                                                                                                                                                                                                														                                                  
			 */
			StringBuilder query= new StringBuilder();	
			StringBuilder filename=new StringBuilder();
			query.append("SELECT 'record_timestamp','date','time','title','Description','Campaign','Brand','Product','Sub_Categories','Categories','stream_language','stream_type','stream_name'  UNION ALL select  record_timestamp,date(timestamp_utc),time(timestamp_utc),title,Description,Campaign,Brand,Product,Sub_Categories,Categories,stream_language,stream_type,stream_name from  all_channels_1 where  date(timestamp_utc) between '" +fromdate+"' and '" +todate+"'");
			
			if(!(("").equals(channel)  || channel==null))
			{
				filename.append("_Channel");
				 query.append("  and stream_name in  ("+channel+")  ");	
			}
			
			if(!(("").equals(brand)  || brand==null))
			{
				filename.append("_Brand");
				 query.append("  and Brand in  ("+brand+")  ");	
			}
			
			if(!(("").equals(product)  || product==null))
			{
				filename.append("_Product");
				 query.append("  and Product in  ("+product+")  ");	
			}
			
			if(!(("").equals(category)  || category==null))
			{
				filename.append("_Category");
				 query.append("  and Categories in  ("+category+")  ");	
			}
			
			if(!(("").equals(language)  || language==null))
			{
				filename.append("_Language");
				 query.append("  and stream_language in  ("+language+")  ");	
			}
			
			if(!(("").equals(genre)  || genre==null))
			{
				filename.append("_Genre");
				 query.append("  and stream_type in  ("+genre+")  ");	
			}
	//		filename.append(".csv");
			String donloadfile=new String(filename);
			query.append("INTO OUTFILE '"+csvInMysqlpath+csvfilename+donloadfile+".csv"+"' FIELDS TERMINATED BY ','ENCLOSED BY '\"' LINES TERMINATED BY '\\r\\n';\r\n");
			
			UtilDownload util =new UtilDownload();
			File deleteFile=new File(csvInMysqlpath+csvfilename+donloadfile+".csv");
			System.out.println("file namee for delete="+deleteFile);
			if(deleteFile.exists())
			{
			System.out.println("before delete file");
				util.delete(deleteFile);
				System.out.println("delete file successfully");
			}
			String finalquery=new String (query);
			System.out.println("query ....."+finalquery);
			/*String query="SELECT 'stream_url','stream_id','status','msg','code','version','Result_Type','record_timestamp','timestamp_utc','played_duration','type','count','play_offset_ms','sample_begin_time_offset_ms','score','title','sample_end_time_offset_ms','duration_ms','bucket_id','db_begin_time_offset_ms','db_end_time_offset_ms','acrid','Rupa','Astral_Pipes','Act_II','key1','extra1','extra2','Sub_Brand','Description','Campaign','Brand','Product','Genre','Sub_Categories','Language','Categories','Sub_Categories_2','stream_language','stream_type','stream_name','cid'  UNION ALL select  stream_url,stream_id,status,msg,code,version,Result_Type,record_timestamp,timestamp_utc,played_duration,type,count,play_offset_ms,sample_begin_time_offset_ms,score,title,sample_end_time_offset_ms,duration_ms,bucket_id,db_begin_time_offset_ms,db_end_time_offset_ms,acrid,Rupa,Astral_Pipes,Act_II,key1,extra1,extra2,Sub_Brand,Description,Campaign,Brand,Product,Genre,Sub_Categories,Language,Categories,Sub_Categories_2,stream_language,stream_type,stream_name,cid from  all_channels_1 where  date(timestamp_utc) between '" +fromdate+"' and '" +todate+"'    and stream_name like  '%" +channel+"%' and Brand like '%" +brand+"%' and  Product like '%" +product+"%' and  Categories like '%"+category+"%' and stream_type like'%"+genre+"%' and stream_language like '%"+language+"%' INTO OUTFILE '"+csvInMysqlpath+csvfilename+"' FIELDS TERMINATED BY ','ENCLOSED BY '\"' LINES TERMINATED BY '\\r\\n';\r\n"; 
			
			 */
			 jdbcTemplate.execute(finalquery); 	
			 return donloadfile;
			 //System.out.println("all chanels data  in dao......"+channelslist);
			
			} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return "";
				}	
		}

	
	
	public List<AllChannelDetails> allFilterOption(String fromdate,String todate,String channel) {
		try {
			String query="";
			if(channel.isEmpty())
			{
				System.out.println("channel is empty.");
				query="select distinct(Brand) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and Brand is NOT NULL"; 
			}
			else {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
//			 query="select distinct Brand from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and stream_name in ("+channel+") and Brand is NOT NULL order by Brand ASC"; 
			System.out.println("query to fetch all channels....."+query);
			} 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							
							
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								
								data.setBrand(rs.getString("Brand"));
						/*
						 * data.setProduct(rs.getString("Product"));
						 * data.setCategories(rs.getString("Categories"));
						 * data.setStreamName(rs.getString("stream_name"));
						 */
								channelslist.add(data);
								
									
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
							
							
							
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}


	public List<AllChannelDetails> allFilterChanel(String fromdate,String todate) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="select distinct stream_name from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and stream_name is NOT NULL order by stream_name  asc"; 
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setStreamName(rs.getString("stream_name"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}

	
	public List<AllChannelDetails> allFilterCategory(String fromdate,String todate,String channel,String brand) {
		try {
			String query="";
			System.out.println("brand name="+brand);
			if(channel.isEmpty() && brand.isEmpty())
			{
				query="select distinct(categories) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and categories  is NOT NULL order by categories ASC "; 
			}
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			else if(!channel.isEmpty() && brand.isEmpty() )
			{
				query="select distinct(categories) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and stream_name in ("+channel+") and categories  is NOT NULL  order by categories ASC"; 
			}
			else if(channel.isEmpty() && !brand.isEmpty() )
			{
				query="select distinct(categories) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and Brand in ("+brand+") and categories  is NOT NULL  order by categories ASC "; 
			}
			else{
				query="select distinct(categories) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and stream_name in ("+channel+") and Brand in ("+brand+")   and categories  is NOT NULL  order by categories ASC "; 
				}
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setCategories(rs.getString("categories"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}
	
	
	public List<AllChannelDetails> allFilterProduct(String fromdate,String todate,String brand,String channel,String category) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="";
			if(brand.isEmpty() && channel.isEmpty() && category.isEmpty())
				{
				System.out.println("brand,category and cahnnel is empty..");
				query="select distinct (product) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and product  is NOT NULL ";	
				}
			else if (!brand.isEmpty() && channel.isEmpty() && category.isEmpty())
			{
				System.out.println(" cahnnel and category is empty..");
				query="select distinct (product) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and Brand in ("+brand+") and product  is NOT NULL "; 	
	
			}
			else  if(brand.isEmpty() && !channel.isEmpty() && category.isEmpty() )
			{
				System.out.println(" brand and category is empty..");
				query="select distinct (product) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and stream_name in ("+channel+")  and product  is NOT NULL "; 	
			}
			
			else  if(brand.isEmpty() && channel.isEmpty() && !category.isEmpty() )
			{
				System.out.println(" brand and channel is empty..");
				query="select distinct (product) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and categories in ("+category+") and product  is NOT NULL "; 	
			}
			
			else  if(!brand.isEmpty() && !channel.isEmpty() && category.isEmpty() )
			{
				System.out.println(" category  is empty..");
				query="select distinct (product) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and stream_name in ("+channel+") and Brand in ("+brand+") and product  is NOT NULL"; 	
			}
			
			else  if(brand.isEmpty() && !channel.isEmpty() && !category.isEmpty() )
			{
				System.out.println(" brand is empty..");
				query="select distinct (product) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and stream_name in ("+channel+") and categories in ("+category+") and product  is NOT NULL"; 	
			}
			
			else  if(!brand.isEmpty() && channel.isEmpty() && !category.isEmpty() )
			{
				System.out.println(" channel is empty..");
				query="select distinct (product) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and Brand in ("+brand+") and categories in ("+category+") and product  is NOT NULL"; 	
			}
			
			
			else {
				 query="select distinct (product) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"'  and Brand in ("+brand+") and stream_name in ("+channel+") and categories in ("+category+") and product  is NOT NULL"; 	
			}
			
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setProduct(rs.getString("product"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}
	
	
	
	
	public List<AllChannelDetails> allFilterLanguageGenre(String fromdate,String todate,String brand,String channel,String category,String product) {
		try {
			
			String query="";
			if(brand.isEmpty() && channel.isEmpty() && category.isEmpty() && product.isEmpty())
			{
				System.out.println("brand , channel  and category  and product is empty");
				 query="select distinct (stream_language) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and stream_language  is NOT NULL"; 
			}
			else if( !brand.isEmpty() && channel.isEmpty() && category.isEmpty() && product.isEmpty())
			{
				System.out.println(" channel  and category is empty");
				query="select distinct (stream_language) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"'  and Brand in ("+brand+") and stream_language  is NOT NULL  "; 
			}
			else if( brand.isEmpty() && !channel.isEmpty() && category.isEmpty() && product.isEmpty())
			{
				System.out.println("brand   and category is empty");
				query="select distinct (stream_language)  from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"'  and stream_name in ("+channel+")  and stream_language  is NOT NULL";
			}
			else if( brand.isEmpty() && channel.isEmpty() && !category.isEmpty() && product.isEmpty())
			{
				System.out.println("brand and channel  is empty");
				query="select distinct (stream_language)  from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"'  and categories in ("+category+") and stream_language  is NOT NULL ";
			}
			
			else if( brand.isEmpty() && channel.isEmpty() && category.isEmpty() && !product.isEmpty())
			{
				System.out.println("brand and channel and category   is empty");
				query="select distinct (stream_language)  from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and product in ("+product+") and stream_language  is NOT NULL ";
			}
			
			else if( channel.isEmpty() && !category.isEmpty() && !brand.isEmpty() && !product.isEmpty())
			{
				System.out.println(" channel  is empty");
				query="select distinct (stream_language) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and Brand ("+brand+")  and categories in ("+category+") and product in ("+product+"'  and stream_language  is NOT NULL";
			}
			else if( !channel.isEmpty() && category.isEmpty() && !brand.isEmpty()  && !product.isEmpty())
			{
				System.out.println(" category is empty");
				query="select distinct (stream_language) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and Brand in ("+brand+") and stream_name in ("+channel+") and product in ("+product+")  and stream_language  is NOT NULL";	
			}
			
			else if( !channel.isEmpty() && !category.isEmpty() && brand.isEmpty()  && !product.isEmpty())
			{
				System.out.println(" brand is empty");
				query="select distinct (stream_language) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and categories in ("+category+") and stream_name in ("+channel+") and product in ("+product+") and stream_language  is NOT NULL";	
			}
			else if( channel.isEmpty() && !category.isEmpty() && brand.isEmpty()  && !product.isEmpty())
			{
				System.out.println(" brand is empty");
				query="select distinct (stream_language) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and categories in ("+category+")  and product in ("+product+")  and stream_language  is NOT NULL";	
			}
			
			else if( !channel.isEmpty() && !category.isEmpty() && !brand.isEmpty()  && product.isEmpty())
			{
				System.out.println(" brand is empty");
				query="select distinct (stream_language) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and categories in ("+category+") and stream_name in ("+channel+") and Brand in ("+brand+")  and stream_language  is NOT NULL";	
			}
			
			else if( !channel.isEmpty() && !category.isEmpty() && brand.isEmpty() && product.isEmpty())
			{
				query="select distinct (stream_language) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and  stream_name in ("+channel+") and categories in ("+category+") and stream_language  is NOT NULL ";
			}
			
			else if( channel.isEmpty() && !category.isEmpty() && !brand.isEmpty() && product.isEmpty())
			{
				query="select distinct (stream_language) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and  Brand in ("+brand+") and categories in ("+category+")  and stream_language  is NOT NULL";
			}
			else if( channel.isEmpty() && category.isEmpty() && !brand.isEmpty() && !product.isEmpty())
			{
				query="select distinct (stream_language) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and  Brand in ("+brand+") and product in ("+product+")  and stream_language  is NOT NULL";
			}
			else if( !channel.isEmpty() && category.isEmpty() && brand.isEmpty() && !product.isEmpty())
			{
				query="select distinct (stream_language) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and  stream_name in ("+channel+") and product in ("+product+")  and stream_language  is NOT NULL";
			}
			
			else if( !channel.isEmpty() && category.isEmpty() && !brand.isEmpty() && product.isEmpty())
			{
				query="select distinct (stream_language) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and  stream_name in ("+channel+") and Brand in ("+brand+") and stream_language  is NOT NULL";
			}
			
			else {
				System.out.println("not empty");
				 query="select distinct (stream_language) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and Brand in ("+brand+") and stream_name in ("+channel+") and categories in ("+category+") and product in ("+product+")  and stream_language  is NOT NULL"; 
			}
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								//data.setMaster_type(rs.getNString("stream_type"));
								data.setLanguage1(rs.getString("stream_language"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}

	public List<AllChannelDetails> allFilterGenre(String fromdate,String todate,String brand,String channel,String category,String product) {
		try {
			
			String query="";
			if( channel.isEmpty())
			{
				System.out.println("channel is empty..");
				 query="select distinct (stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"'  and stream_type  is NOT NULL"; 
			}
			else {
				System.out.println("not empty");
				 query="select distinct (stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and stream_name in ("+channel+")  and stream_type  is NOT NULL"; 
			}
			/*if(brand.isEmpty() && channel.isEmpty() && category.isEmpty() && product.isEmpty())
			{
				System.out.println("brand , channel  and category and product is empty");
				 query="select distinct (stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"'"; 
			}
			else if( !brand.isEmpty() && channel.isEmpty() && category.isEmpty() && product.isEmpty())
			{
				System.out.println(" channel,product   and category is empty");
				query="select distinct (stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"'  and Brand in ("+brand+") "; 
			}
			else if( brand.isEmpty() && !channel.isEmpty() && category.isEmpty() && product.isEmpty())
			{
				System.out.println("brand ,channel  and category is empty");
				query="select distinct (stream_type)  from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"'  and stream_name in ("+channel+") ";
			}
			else if( brand.isEmpty() && channel.isEmpty() && !category.isEmpty() && product.isEmpty())
			{
				System.out.println("brand,product and channel  is empty");
				query="select distinct (stream_type)  from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"'  and categories in ("+category+")";
			}
			
			else if( brand.isEmpty() && channel.isEmpty() && category.isEmpty() && !product.isEmpty())
			{
				System.out.println("brand,category and channel  is empty");
				query="select distinct (stream_type)  from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"'  and product in ("+product+") ";
			}
			
			else if( channel.isEmpty() && !category.isEmpty() && !brand.isEmpty() && product.isEmpty() )
			{
				System.out.println(" channel and product is empty");
				query="select distinct (stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and Brand in ("+brand+")  and categories in ("+category+")";
			}
			else if( !channel.isEmpty() && category.isEmpty() && !brand.isEmpty() && product.isEmpty() )
			{
				System.out.println(" category ,product is empty");
				query="select distinct (stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and Brand in ("+brand+") and stream_name in ("+channel+") ";	
			}
			else if( !channel.isEmpty() && !category.isEmpty() && brand.isEmpty()  && product.isEmpty())
			{
				query="select distinct (stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and  stream_name in ("+channel+")  and categories in ("+category+")";
			}
			else if( !channel.isEmpty() && category.isEmpty() && brand.isEmpty()  && !product.isEmpty())
			{
				query="select distinct (stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and  stream_name in ("+channel+")  and product in ("+product+") ";
			}
			
			else if( channel.isEmpty() && !category.isEmpty() && brand.isEmpty()  && !product.isEmpty())
			{
				query="select distinct (stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and  categories in ("+category+") and product in ("+product+") ";
			}
			
			else if( channel.isEmpty() && !category.isEmpty() && brand.isEmpty()  && !product.isEmpty())
			{
				query="select distinct (stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and  Brand in ("+brand+") and product in ("+product+") ";
			}
			
			
			
			else if( !channel.isEmpty() && !category.isEmpty() && !brand.isEmpty()  && product.isEmpty())
			{
				query="select distinct (stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and  Brand in ("+brand+") and  stream_name in ("+channel+")  and categories in ("+category+")";
			}

			
			else if( !channel.isEmpty() && !category.isEmpty() && brand.isEmpty()  && !product.isEmpty())
			{
				query="select distinct (stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and  Product='"+product+"' and  stream_name in ("+channel+")  and product in ("+product+") ";
			}
			
			else if( !channel.isEmpty() && category.isEmpty() && !brand.isEmpty()  && !product.isEmpty())
			{
				query="select distinct (stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and  Product='"+product+"' and  stream_name in ("+channel+")  and Brand in ("+brand+")";
			}
			
			else if(channel.isEmpty() && !category.isEmpty() && !brand.isEmpty()  && !product.isEmpty())
			{
				query="select distinct (stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and  Product='"+product+"' and  categories in ("+category+") and Brand in ("+brand+")";
			}
*/			
			
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setMaster_type(rs.getNString("stream_type"));
								//data.setLanguage1(rs.getString("stream_language"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}


	public List<AllChannelDetails> startDateFilter(String fromdate) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="select distinct stream_name from all_channels_1 where date(timestamp_utc)='" +fromdate+ "' and stream_name!='NULL' order by stream_name asc"; 
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setStreamName(rs.getString("stream_name"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}

	public List<AllChannelDetails> endDateFilter(String fromdate,String todate) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="select distinct stream_name from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"'  and stream_name!='NULL'  order by stream_name asc "; 
			System.out.println("query to fetch end date filter channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setStreamName(rs.getString("stream_name"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}
	
	public List<AllChannelDetails> endDateBrandFilter(String fromdate,String todate) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="select distinct(Brand) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"'  and Brand!='NULL' order by Brand asc "; 
			System.out.println("query to fetch end date filter channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setBrand(rs.getString("Brand"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}


	
	public List<AllChannelDetails> endDateCategoryFilter(String fromdate,String todate) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="select distinct(Categories) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and Categories!=''  order by Categories asc "; 
			System.out.println("query to fetch end date filter channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setCategories(rs.getString("Categories"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}
	
	public List<AllChannelDetails> endDateProductFilter(String fromdate,String todate) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="select distinct(Product) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and Product!='NULL' order by product asc "; 
			System.out.println("query to fetch end date filter channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setProduct(rs.getString("Product"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}

	public List<AllChannelDetails> endDateLanguageFilter(String fromdate,String todate) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="select distinct(stream_language) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and stream_language!='NULL'   order by stream_language asc "; 
			System.out.println("query to fetch end date filter channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setLanguage1(rs.getString("stream_language"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}
	
	
	
	public List<AllChannelDetails> endDateGenreFilter(String fromdate,String todate) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="select distinct(stream_type) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and stream_type!='NULL' order by stream_type asc "; 
			System.out.println("query to fetch end date filter channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setMaster_type(rs.getString("stream_type"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}

	//.........................default product...............................................
	public List<AllChannelDetails> defaultProduct(String fromdate,String todate) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="select distinct (product) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' order by product asc"; 
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setProduct(rs.getString("product"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}
	
	public List<AllChannelDetails> defaultCategory(String fromdate,String todate) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="select distinct (Categories) from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and categories  is NOT NULL order by Categories asc"; 
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setCategories(rs.getString("Categories"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}
	
	
	public List<AllChannelDetails> defaultbrand(String fromdate,String todate) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="select distinct (Brand)  from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and Brand  is NOT NULL order by Brand asc "; 
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								data.setBrand(rs.getString("Brand"));
							
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}
	
	public List<AllChannelDetails> defaultgenre(String fromdate,String todate) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="select distinct (stream_type)  from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and stream_type  is NOT NULL order by stream_type asc"; 
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								
								data.setMaster_type(rs.getString("stream_type"));
								
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
	
	}

	
	public List<AllChannelDetails> defaultLanguage(String fromdate,String todate) {
		try {
			// String query="SELECT *,ch.streamId,ch.streamName,ch.streamUrl,ch.language,ch.type,ch.status FROM all_channels_1 ch1 INNER JOIN channel_master ch ON ch1.stream_id=ch.streamId where date(ch1.timestamp_utc) between '" +fromdate+ "' and '" +endate+"' order by ch1.timestamp_utc desc limit 200 ";                         
			String query="select distinct (stream_language)  from all_channels_1 where date(timestamp_utc) between '" +fromdate+ "' and '" +todate+"' and stream_language  is NOT NULL order by  stream_language asc"; 
			System.out.println("query to fetch all channels....."+query);
			 
			return jdbcTemplate.query(query, new ResultSetExtractor<List<AllChannelDetails>>() {
						public List<AllChannelDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<AllChannelDetails> channelslist= new ArrayList<AllChannelDetails>();
							while (rs.next()) {
								AllChannelDetails data = new AllChannelDetails();	 
								
								
								data.setLanguage1(rs.getString("stream_language"));
								channelslist.add(data);
						}
							//System.out.println("all chanels data  in dao......"+channelslist);
							return channelslist;
						}
					});
				} catch (Exception e) {
					System.out.println("exception in fetch all chanels"+e);
					return null;
				}	
		}
}
 