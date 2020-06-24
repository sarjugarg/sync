package com.framework.daoImplement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import com.framework.dao.UserDao;
import com.framework.model.Pass;
import com.framework.model.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

	/*
	 * @Autowired User user;
	 */
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int createUser(User user, String modifiedBy) {
		return jdbcTemplate.update("INSERT INTO user(usertype,username,password,modifiedBy) VALUES(?,?,?,?)",
				user.getUsertype(), user.getUsername(), user.getPassword(), modifiedBy);
	}

	@Override
	public User getUser(User user) {
		System.out.println("select * from user where username='" + user.getUsername() + "'");
		try {
			return jdbcTemplate.query("select * from user where username='" + user.getUsername() + "'",
					new ResultSetExtractor<User>() {

						@Override
						public User extractData(ResultSet rs) throws SQLException, DataAccessException {
							User user1 = new User();
							while (rs.next()) {
								user1.setId(rs.getInt("id"));
								user1.setUsername(rs.getString("username"));
								user1.setUsertype(rs.getString("usertype"));
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

	@Override
	public List<User> getAllUser() {
		try {
			System.out.println("select * from user where fwstatus=1");
			return jdbcTemplate.query("select * from user where fwstatus=1", new ResultSetExtractor<List<User>>() {

				@Override
				public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<User> users = new ArrayList<User>();
					while (rs.next()) {
						User user = new User();
						user.setId(rs.getInt("id"));
						user.setUsername(rs.getString("username"));
						user.setUsertype(rs.getString("usertype"));
						user.setPassword(rs.getString("password"));
						user.setModifiedOn(rs.getString("modifiedOn"));
						user.setCreatedOn(rs.getString("createdOn"));
						users.add(user);
					}
					return users;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public int deleteUser(User user, String modifiedBy) {
		return jdbcTemplate.update("UPDATE user SET fwstatus=?,modifiedBy=? where id=?", 0, user.getModifiedBy(),
				user.getId());
	}

	@Override
	public int updateUser(User user, String modifiedBy) {
		return jdbcTemplate.update("UPDATE user SET usertype=?,username=?,password=?,modifiedBy=? where id=?",
				user.getUsertype(), user.getUsername(), user.getPassword(), modifiedBy, user.getId());
	}

	public int changepassword(Pass pass, String username) {
		User user = new User();
		user.setUsername(username);
		User serveruser = getUser(user);
		if (serveruser.getPassword().equals(pass.getOldpass())) {
			return jdbcTemplate.update("UPDATE user SET password=?,modifiedBy=? where id=?", pass.getNewpass(), "Hemu",
					serveruser.getId());
		} else {
			return 0;
		}
	}

}
