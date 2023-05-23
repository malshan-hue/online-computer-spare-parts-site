package com.sparebyte.service.user;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.sparebyte.models.User;

public interface IUserService {
	
	public static final Logger log = Logger.getLogger(IUserService.class.getName());
	
	public void addUser(User user);
	
	public User getUserByName(String userName);
	
	public void updateUser(String userID, User user);
	
	public void updateUserRole(String userID, User user);
	
	public ArrayList<User> getUsers();

}
