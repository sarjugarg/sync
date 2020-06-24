package org.sync.dao;

import java.util.List;

import org.sync.model.AllDashboard;
import org.sync.model.Filter;
import org.sync.model.FilterData;

public interface BrandDao {
	public List<AllDashboard> hourlyPlayoutForBrand(Filter f);
	public List<AllDashboard> dailyPlayoutForBrand(Filter f);
	public Integer brandDatacount();
	public List<AllDashboard> brandList(Filter f);
	public List<String> getAllBrand();
	public List<AllDashboard> DataBySingleBrand(String brand,String startdate,String enddate);
    public List<String> singleBrandByProduct(String brand,String startdate,String enndate);  
	public List<AllDashboard> BrandDataBySeparateProduct(Filter f);
    public String brandLogo(String brand);  
}
