package org.sync.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.sync.daoimpl.BrandDaoImpl;
import org.sync.model.AllDashboard;
import org.sync.model.Filter;
import org.sync.service.BrandService;

public class BrandServiceImpl implements BrandService{
	@Autowired
	BrandDaoImpl brandDao;

	@Override
	public List<AllDashboard> hourlyPlayoutForBrand(Filter f) {
		return brandDao.hourlyPlayoutForBrand(f);
	}

	@Override
	public List<AllDashboard> dailyPlayoutForBrand(Filter f) {
		return brandDao.dailyPlayoutForBrand(f);
	}

	@Override
	public Integer brandDatacount() {
		return brandDao.brandDatacount();
	}

	@Override
	public List<AllDashboard> brandList(Filter f) {
		return brandDao.brandList(f);
	}

	@Override
	public List<AllDashboard> DataBySingleBrand(String brand, String startdate, String enddate) {
		return brandDao.DataBySingleBrand(brand, startdate, enddate);
	}

	@Override
	public List<String> getAllBrand() {
		return brandDao.getAllBrand();
	}

	@Override
	public List<String> singleBrandByProduct(String brand, String startdate, String enndate) {
		return brandDao.singleBrandByProduct(brand, startdate, enndate);
	}
 
	@Override
	public List<AllDashboard> BrandDataBySeparateProduct(Filter f) {
		return brandDao.BrandDataBySeparateProduct(f);
	}

	@Override
	public String brandLogo(String brand) {
		return brandDao.brandLogo(brand);
	}

	
}
