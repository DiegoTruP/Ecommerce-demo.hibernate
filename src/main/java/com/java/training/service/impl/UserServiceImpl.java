package com.java.training.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.training.dao.UserDao;
import com.java.training.entity.User;
import com.java.training.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	
	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
		
	}


	@Override
	public User authenticateUser(String name, String password) {
		
		return userDao.authenticaUser(name, password);
	}

}
