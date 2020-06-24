package com.framework.serviceimplement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.framework.daoImplement.FeatureDaoImpl;
import com.framework.model.Feature;
import com.framework.service.FeatureService;

public class FeatureServiceImpl implements FeatureService {
	@Autowired
	FeatureDaoImpl featureDaoImpl;

	@Override
	public List<Feature> getAllFeatures() {
		return featureDaoImpl.getAllFeatures();
	}

	@Override
	public String createFeature(Feature feature, String[] usertypes) {
		return featureDaoImpl.createFeature(feature, usertypes);
	}

	@Override
	public String fwDeleteFeature(Feature feature) {
		int i=featureDaoImpl.fwDeleteFeature(feature);
		if(i==1) {
			return "Feature Deleted Sucessfully!!";
		}
		else{
			return "Feature Delition failed!!";
		}
	}

	@Override
	public String updateFeature(Feature feature) {
		int i=featureDaoImpl.updateFeature(feature);
		if(i==1) {
			return "Feature Updation Sucessfully!!";
		}
		else{
			return "Feature Updation failed!!";
		}
	}

	@Override
	public Feature getFeature(String feature) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

}
