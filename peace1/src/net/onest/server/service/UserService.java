package net.onest.server.service;

import java.util.List;

import net.onest.server.entity.User;

public interface UserService {

	public List<User> findAllUsers();	
	public User queryByID(User user);
	public boolean insertUser(User u);
	public User queryByPhone(User user);
}
