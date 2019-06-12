package net.onest.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.onest.server.dao.UserMapper;
import net.onest.server.entity.User;
import net.onest.server.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAllUsers() {
		return userMapper.findAllUsers();
	}

	@Override
	public boolean insertUser(User u) {
		return userMapper.insertUser(u);
	}
	@Override
	public User queryByID(User user) {
		
		return userMapper.queryByID(user);
	}
	
	@Override
	public User queryByPhone(User user) {
		
		return userMapper.queryByPhone(user);
	}
	
	

}
