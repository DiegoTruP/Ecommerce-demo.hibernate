package com.java.training.dao;

import com.java.training.entity.User;

public interface UserDao {
	public void saveUser(User user);

	public User authenticaUser(String name, String password);
}
