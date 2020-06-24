package org.sync.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.sync.dao.ChannelDao;
import org.sync.daoimpl.ChannelDaoImpl;
import org.sync.model.Search;
import org.sync.service.ChannelService;
import org.sync.serviceimpl.ChannelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
public class SearchController {
	@Autowired ChannelServiceImpl channelService;

	
	@Autowired ChannelDaoImpl channel;
	
	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public List<Search> search1(@RequestBody Search term) {
		List<Search> value1=channel.brandSearch(term);
		List<Search> value2=channel.productSearch(term);
		List<Search> value3=channel.categorySearch(term);
		List<Search> value4=channel.channelSearch(term);
		List<Search> value =new ArrayList<Search>();
		value.addAll(value1);
		value.addAll(value2);
		value.addAll(value3);
		value.addAll(value4);
		return value;
	}
	
}
