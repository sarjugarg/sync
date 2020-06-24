package com.framework.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.framework.daoImplement.ProjectDaoImpl;
import com.framework.model.Project;
import com.framework.serviceimplement.ProjectServiceImpl;

@Controller
public class ProjectManagementController {
	@Autowired
	ProjectServiceImpl projectService;
	
	@Autowired
	ProjectDaoImpl ProjectDao;
	
	@RequestMapping(value = "/projectmanagement", method = RequestMethod.GET)
	public ModelAndView projectmanagement() {
		Project projects = projectService.getProject();
		System.out.println("Controller is working");
        String img = ProjectDao.getLogo();
		//String img = "./resources/images/Apple_Shooter.png";
		ModelAndView mv = new ModelAndView("project_management","img",img);
		mv.addObject("Project", projects);
		return mv;
	}

	// CREATE PROJECT
	@RequestMapping(value = "/addproject", method = RequestMethod.POST)
	public ModelAndView addProject(@ModelAttribute Project project) {
		System.out.println("inside the Create Project Management");
		int servermessage = projectService.CreateProject(project);

		/* String response = project.getLogoPath(); */

		/*
		 * String password=project.getPassword(); String
		 * URL=project.getDataBaseUrl();
		 * 
		 * String username = project.getUsername();
		 * System.out.println("username"+ username) ;
		 */
		/*String name = project.getProjectName();
		System.out.println("project name " + name);*/
		
		/*String image = project.getLogoPath();
		System.out.println("image" + image);*/
		
		
		/*
		 * System.out.println("paSSWORd"+password);
		 * System.out.println("url"+URL);
		 */
		
        ModelAndView mv = new ModelAndView("redirect:./project_management");
		System.out.println("servermessage");
		mv.addObject("servermessage", servermessage);
		return mv;
	}

	//// Image Upload

	@ResponseBody
	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public String upload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("projectName") String projectname, @RequestParam("LogoPath") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		if (!file.isEmpty()) {
			try {
				System.out.println("project name" + projectname);
				Project p = new Project();
				p.setProjectName(projectname);

				byte[] bytes = file.getBytes();
				String rootPath = "D:/Glocks/Java Projects/Framework/src/main/webapp/resources/images/";
				System.out.println(file.getOriginalFilename());
				File dir = new File(rootPath + File.separator);
				if (!dir.exists())
					dir.mkdirs();
				// Create the file on server
				Calendar now = Calendar.getInstance();

				File serverFile = new File(rootPath + file.getOriginalFilename());
				System.out.println("path" + serverFile);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				p.setLogoPath(rootPath + file.getOriginalFilename());
				int servermessage = projectService.CreateProject(p);
				System.out.println("Server File Location=" + serverFile.getAbsolutePath() + "------" + stream);

				return "Home";
			} catch (Exception e) {
				return "Home";
			}
		} else {
			return "Home";
		}
	}
}