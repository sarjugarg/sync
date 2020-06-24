package org.sync.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.sync.dao.UserDao;
import org.sync.model.User;

public class UserDaoImpl implements UserDao{
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User getUser(User user) {
		String query="select * from user where username='" + user.getUsername() + "'";
		System.out.println("get User query: "+query);
		try {
			return jdbcTemplate.query(query,
					new ResultSetExtractor<User>() {

						@Override
						public User extractData(ResultSet rs) throws SQLException, DataAccessException {
							User user1 = new User();
							while (rs.next()) {
								user1.setUserid(rs.getInt("id"));
								user1.setUsername(rs.getString("username"));
								user1.setPassword(rs.getString("password"));
							}
							return user1;
						}
					});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
