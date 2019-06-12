package net.onest.server.dao;

import java.util.List;


import net.onest.server.entity.User;


public interface UserMapper {

	public List<User> findAllUsers();
	public boolean insertUser(User u);
	public User queryByID(User user);
	public User queryByPhone(User user);
}
