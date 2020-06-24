package org.sync.service;

import java.util.List;

import org.sync.model.AllDashboard;
import org.sync.model.Filter;

public interface BrandService {
	public List<AllDashboard> hourlyPlayoutForBrand(Filter f);
	public List<AllDashboard> dailyPlayoutForBrand(Filter f);
	public Integer brandDatacount();
	public List<AllDashboard> brandList(Filter f);
	public List<AllDashboard> DataBySingleBrand(String brand,String startdate,String enddate);
	public List<String> getAllBrand();
    public List<String> singleBrandByProduct(String brand,String startdate,String enndate);  
	public List<AllDashboard> BrandDataBySeparateProduct(Filter f);
    public String brandLogo(String brand);

}
