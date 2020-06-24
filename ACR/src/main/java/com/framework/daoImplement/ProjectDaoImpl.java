package com.framework.daoImplement;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.framework.dao.ProjectDao;
import com.framework.model.Project;

public class ProjectDaoImpl implements ProjectDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Project getProject() {
		// TODO Auto-generated method stub

		return jdbcTemplate.query("select * from project_management", new ResultSetExtractor<Project>() {

			@Override
			public Project extractData(ResultSet rs) throws SQLException, DataAccessException {
				Project project = new Project();
				while (rs.next()) {
					/*project.setDataBaseUrl(rs.getString("database_url"));*/
					project.setLogoPath(rs.getString("logo_path"));
					/*project.setUsername(rs.getString("username"));
					project.setPassword(rs.getString("password"));*/
					project.setProjectName(rs.getString("project_name"));
				}
				return project;
			}
		});
	}

	public int createProject(Project project) {
		return jdbcTemplate.update("UPDATE project_management SET logo_path='" + project.getLogoPath() + "',project_name='" + project.getProjectName() + "'");

	}
	  
	public String getLogo() {
        String query = "select logo_path from project_management ";
		return jdbcTemplate.queryForObject(query, new Object[] {},String.class);
		
	}
	
}	


