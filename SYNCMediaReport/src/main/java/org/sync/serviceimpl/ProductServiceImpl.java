package org.sync.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.sync.daoimpl.ProductDaoImpl;
import org.sync.model.Filter;
import org.sync.model.FilterData;
import org.sync.model.LogoData;
import org.sync.model.Product;
import org.sync.model.AllDashboard;
import org.sync.model.Channel;
import org.sync.model.TotalAddData;
import org.sync.service.ProductService;
public class ProductServiceImpl implements ProductService{

@Autowired 
ProductDaoImpl productDao;

	public List<AllDashboard> getPlayoutByProduct(Filter f) {
		
		return productDao.getPlayoutByProduct(f);
	}

		@Override
	public List<TotalAddData> getAddDataCount() {
		return productDao.getAddDataCount();
	}

	
	
	@Override
	public List<String> getAllGenres() {
		return productDao.getAllGenres();
	}

	@Override
	public List<Channel> getAllChannels() {
		return productDao.getAllChannels();
	}

	@Override
	public List<String> getAllProducts() {
		return productDao.getAllProducts();
	}

	

	@Override
	public List<FilterData> getAllCategories() {
		return productDao.getAllCategories();
	}

	@Override
	public List<AllDashboard> getDatabyChannels(Filter f) {
		return productDao.getDatabyChannels(f);
	}

	@Override
	public List<AllDashboard> getDatabyCategory(Filter f) {
		return productDao.getDatabyCategory(f);
	}

	@Override
	public List<AllDashboard> getDatabyLanguage(Filter f) {
		return productDao.getDatabyLanguage(f);
	}

	@Override
	public List<AllDashboard> getDatabyHourlyPlayout(Filter f) {
		return productDao.getDatabyHourlyPlayout(f);
	}

	@Override
	public List<AllDashboard> getDatabyDailyPlayout(Filter f) {
		return productDao.getDatabyDailyPlayout(f);
	}

	@Override
	public Integer totalProduct() {
		return productDao.totalProduct();
	}

	@Override
	public Integer totalChannels() {
		return productDao.totalChannels();
	}

	@Override
	public List<AllDashboard> topProduct(Filter f) {
		return productDao.topProduct(f);
	}

	@Override
	public List<AllDashboard> topGenreByProduct(Filter f) {
		return productDao.topGenreByProduct(f);
	}

	@Override
	public List<AllDashboard> singleProductData(String product,String startdate,String enddate) {
		return productDao.singleProductData(product,startdate,enddate);
	}

	@Override
	public List<Product> singleProductDescription(String product, String startdate, String enddate) {
		return productDao.singleProductDescription(product, startdate, enddate);
	}

	@Override
	public List<AllDashboard> singleProductDataByDesc(Filter f) {
		return productDao.singleProductDataByDesc(f);
	}

	@Override
	public String productLogo(String product) {
		return productDao.productLogo(product);
	} 

	@Override
	public List<String> creativesByProduct(String product, String startdate, String enddate) {
		return productDao.creativesByProduct(product, startdate, enddate);
	}

	@Override
	public List<AllDashboard> CreativesData(Filter f) {
		return productDao.CreativesData(f);
	}

}
