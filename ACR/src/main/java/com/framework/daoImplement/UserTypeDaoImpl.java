package com.framework.daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.framework.dao.UserTypeDao;
import com.framework.model.UserType;

public class UserTypeDaoImpl implements UserTypeDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addUserType(final UserType usertype) {

		final String INSERT_SQL = "INSERT INTO usertype(usertype,modifiedBy) VALUES(?,?)";

		final KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, usertype.getUsertype());
				ps.setString(2, "Hemu");
				return ps;
			}
		}, keyHolder);
		System.out.println("geting id=" + keyHolder.getKey());
		return keyHolder.getKey().intValue();

		/*
		 * try{jdbcTemplate.
		 * update("INSERT INTO usertype(usertype,modifiedBy) VALUES(?,?)"
		 * ,usertype.getUsertype(),"Hemu"); int id=
		 * jdbcTemplate.query("select id from usertype where usertype='"
		 * +usertype.getUsertype()+"'", new ResultSetExtractor<Integer>() {
		 * 
		 * @Override public Integer extractData(ResultSet rs) throws
		 * SQLException, DataAccessException { Integer id=0; while(rs.next()) {
		 * id=rs.getInt("id"); } return id; } });
		 * System.out.println("Got id="+id); return id; } catch(Exception ex){
		 * System.err.println(ex); return 0; }
		 */
	}

	@Override
	public List<UserType> getAllUserType() {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.query("select * from usertype where fwstatus=1",
					new ResultSetExtractor<List<UserType>>() {

						@Override
						public List<UserType> extractData(final ResultSet rs) throws SQLException, DataAccessException {
							final List<UserType> usertypes = new ArrayList<UserType>();
							while (rs.next()) {
								final UserType usertype = new UserType();
								System.out.println(rs.getInt("id"));
								usertype.setId(rs.getInt("id"));
								System.out.println(rs.getString("usertype"));
								usertype.setUsertype(rs.getString("usertype"));
								usertype.setCreatedOn(rs.getString("createdOn"));
								usertype.setModifiedOn(rs.getString("modifiedOn"));
								usertypes.add(usertype);
							}
							return usertypes;
						}
					});
		} catch (final Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public int updateUserType(final UserType usertype) {
		try {
			return jdbcTemplate.update("Update usertype set usertype=?where id=?", usertype.getUsertype(),
					usertype.getId());
		} catch (final Exception ex) {
			System.out.println(ex);
			System.out.println("Feature Updation faild !!");
			return 0;
		}
	}

	@Override
	public int deleteUserType(final UserType usertype) {
		try {
			return jdbcTemplate.update("Delete from usertype where id=" + usertype.getId());
		} catch (final Exception ex) {
			System.out.println(ex);
			System.out.println("usertype Deletion failed !!");
			return 0;
		}
	}

	@Override
	public UserType getUserType(final String usertype) {
		// TODO Auto-generated method stub
		try {
			System.out
					.println("query to select usertype=" + "select * from usertype where usertype='" + usertype + "'");
			return jdbcTemplate.query("select * from usertype where usertype='" + usertype + "'",
					new ResultSetExtractor<UserType>() {

						@Override
						public UserType extractData(final ResultSet rs) throws SQLException, DataAccessException {
							final UserType userType1 = new UserType();
							while (rs.next()) {
								userType1.setId(rs.getInt("id"));
								System.out.println("usertype id:" + rs.getInt("id"));
								userType1.setUsertype(rs.getString("usertype"));
							}
							return userType1;
						}
					});
		} catch (final Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
