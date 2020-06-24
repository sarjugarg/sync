package org.sync.service;

import org.sync.model.User;

public interface UserService {
	public String verifyUser(User user);
	public User getUser(User u);
}
