package org.sync.dao;
import java.util.List;

import org.sync.model.Filter;
import org.sync.model.FilterData;
import org.sync.model.LogoData;
import org.sync.model.Product;
import org.sync.model.AllDashboard;
import org.sync.model.Channel;
import org.sync.model.TotalAddData;

public interface ProductDao {
	public List<TotalAddData> getAddDataCount();
    public List<String> getAllGenres();
    public List<Channel> getAllChannels();
    public List<String> getAllProducts(); 
    public List<FilterData> getAllCategories();
    
    public List<AllDashboard> getDatabyChannels(Filter f); 
    public List<AllDashboard> getDatabyCategory(Filter f);
    public List<AllDashboard> getDatabyLanguage(Filter f);
    public List<AllDashboard> getDatabyHourlyPlayout(Filter f);
    public List<AllDashboard> getDatabyDailyPlayout(Filter f);
    	
    public List<AllDashboard> channelsByProduct(Filter f);
    public List<AllDashboard> langaugeByProduct(Filter f);
    
    public List<AllDashboard> hourlyPlayoutByProduct(Filter f);
    public List<AllDashboard> dailyPlayoutByProduct(Filter f);
    public Integer totalProduct();
    public Integer totalChannels(); 
    public List<AllDashboard> topProduct(Filter f);
    public List<AllDashboard> topGenreByProduct(Filter f) ;
    public List<AllDashboard> singleProductData(String product,String startdate,String enddate);
    public List<Product> singleProductDescription(String product,String startdate,String enddate);
    public List<AllDashboard> singleProductDataByDesc(Filter f); 
    public String productLogo(String product);  
    public List<String> creativesByProduct(String product, String startdate, String enndate);
	public List<AllDashboard> CreativesData(Filter f);
	
}
