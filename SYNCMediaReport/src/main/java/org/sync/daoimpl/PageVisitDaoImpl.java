package org.sync.daoimpl;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.sync.dao.PageVisitDao;
import org.sync.model.PageVisit;
public class PageVisitDaoImpl implements PageVisitDao {
	@Value("${brandUrl}")
	String brandLogoUrl; 
	@Value("${productUrl}") 
	String productUrl;
	@Value("${categoryUrl}") 
	String categoryLogoUrl;
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
	public int saveRecentPageVisit(PageVisit pv) {
		SimpleDateFormat sd = new SimpleDateFormat(
	            "yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
	System.out.println("India current dateTime" +sd.format(date) );
	
    return jdbcTemplate.update("insert into recent_page_visit"
    + "(userId,elementType,elementName,url,recentTimestamp,genre,streamname,language,"
    + " productname,brandname,cardname,logo,cid)"
    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)",pv.getUserId(),pv.getElementType(),pv.getElementName(),pv.getUrl(),
    sd.format(date),pv.getGenre(),pv.getStreamname(),pv.getLanguage(),pv.getProduct(),pv.getBrand(),pv.getCardName(),pv.getLogo(),pv.getCid());
	}
	@Override
	public List<PageVisit> getRecentCards(Integer userId) {
		String query="select * from recent_page_visit where userid="+userId+"  order by recentTimestamp desc";
			System.out.println("query for  get recent cards: " + query);
			try { 
				return jdbcTemplate.query(query, new ResultSetExtractor<List<PageVisit>>() {
					public List<PageVisit> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<PageVisit> recentCardsList=new ArrayList<PageVisit>();
						while (rs.next()) {
							PageVisit recentCard=new PageVisit();
							String elementType=rs.getString("elementType");
							if("SingleProduct".equalsIgnoreCase(elementType)) {
								recentCard.setLogoUrl(productUrl);	
							}
							else if("SingleBrand".equalsIgnoreCase(elementType)) {
								recentCard.setLogoUrl(brandLogoUrl);	
							}
							else if("SingleCategory".equalsIgnoreCase(elementType)) {
								recentCard.setLogoUrl(categoryLogoUrl);		
							}
							else if("SingleChannel".equalsIgnoreCase(elementType)) {
								recentCard.setLogoUrl(channelLogoUrl);	
							}
							recentCard.setRecentId(rs.getInt("recentId"));
							recentCard.setUserId(rs.getInt("userId"));
							recentCard.setElementType(rs.getString("elementType"));
							recentCard.setElementName(rs.getString("elementName"));
							recentCard.setUrl(rs.getString("url"));
							recentCard.setRecentTimestamp(rs.getString("recentTimestamp"));
							recentCard.setGenre(rs.getString("Genre"));
							recentCard.setStreamname(rs.getString("streamname"));
							recentCard.setProduct(rs.getString("productname"));
							recentCard.setBrand(rs.getString("brandname"));
							recentCard.setLanguage(rs.getString("Language"));
							recentCard.setCardName(rs.getString("cardname"));
							recentCard.setCid(rs.getString("cid"));
							String logo=rs.getString("logo");
							if (logo == null || "null".equalsIgnoreCase(logo)) {
								recentCard.setLogo("NA");
							} else {
								recentCard.setLogo(logo);
							}

							recentCardsList.add(recentCard);
						}
						return recentCardsList;
					}
				});
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}	}
	} 