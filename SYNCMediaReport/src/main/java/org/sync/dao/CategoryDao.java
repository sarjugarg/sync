package org.sync.dao;

import java.util.List;

import org.sync.model.AllDashboard;
import org.sync.model.Filter;

public interface CategoryDao {
	public List<AllDashboard> hourlyPlayoutForCategory(Filter f);
	public List<AllDashboard> dailyPlayoutForCategory(Filter f);
	public List<AllDashboard> categoryDatacount();
	public List<AllDashboard> categoryList(Filter f);
	public List<AllDashboard> DataBySingleCategory(String category,String startdate,String enddate);
    public String categoryLogo(String catgeory);  
}
