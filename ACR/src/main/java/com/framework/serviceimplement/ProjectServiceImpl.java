package com.framework.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;

import com.framework.daoImplement.ProjectDaoImpl;
import com.framework.model.Project;
import com.framework.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDaoImpl projectDaoImpl;

	@Override
	public Project getProject() {
		return projectDaoImpl.getProject();
	}

	public int CreateProject(Project projects) {
		return projectDaoImpl.createProject(projects);

	}
	/*/// get image
	public String getLogo(){
		return projectDaoImpl.getLogo();
	}*/

	@Override
	public int createProject(Project project) {
		// TODO Auto-generated method stub
		return createProject(project);
	}

}
