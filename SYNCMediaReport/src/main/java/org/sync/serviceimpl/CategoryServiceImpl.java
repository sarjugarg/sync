package org.sync.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.sync.daoimpl.CategoryDaoImpl;
import org.sync.model.AllDashboard;
import org.sync.model.Filter;
import org.sync.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDaoImpl categoryDao;

	@Override
	public List<AllDashboard> hourlyPlayoutForCategory(Filter f) {
		return categoryDao.hourlyPlayoutForCategory(f);
	}

	@Override
	public List<AllDashboard> dailyPlayoutForCategory(Filter f) {
		return categoryDao.dailyPlayoutForCategory(f);
	}

	@Override
	public List<AllDashboard> categoryDatacount() {
		return categoryDao.categoryDatacount();
	}

	@Override
	public List<AllDashboard> categoryList(Filter f) {
		return categoryDao.categoryList(f);
	}

	@Override
	public List<AllDashboard> DataBySingleCategory(String category, String startdate, String enddate) {
		return categoryDao.DataBySingleCategory(category, startdate, enddate);
	}
 
	@Override
	public String categoryLogo(String catgeory) {
		return categoryDao.categoryLogo(catgeory);
	}

}
