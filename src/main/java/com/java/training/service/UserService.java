package com.java.training.service;

import com.java.training.entity.User;

public interface UserService {
	public void saveUser(User user);

	public User authenticateUser(String name, String password);

}
