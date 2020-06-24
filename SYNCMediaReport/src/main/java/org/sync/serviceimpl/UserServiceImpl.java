package org.sync.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.sync.dao.UserDao;
import org.sync.daoimpl.UserDaoImpl;
import org.sync.model.User;
import org.sync.service.UserService;

public class UserServiceImpl implements UserService{
@Autowired 
UserDaoImpl userDao;
	@Override
	public String verifyUser(User user) {
		if(user.getUsername()!=null) {
			User serveruser =userDao.getUser(user);
			if(serveruser.getUsername()==null) {
				return "USER DOES NOT EXIST PLEASE CONTACT ADMIN !!";
			}
			else {
				if((user.getPassword().equals(serveruser.getPassword()))) {
					return "True";
				}
				else {
					return "USER NAME AND PASSWORD DOES NOT MATCH !!";
				}
			}
			}
			else {
				return "PLEASE LOGIN FIRST !!";
			}

	}
	@Override
	public User getUser(User u) {
		return userDao.getUser(u);
	}

}
