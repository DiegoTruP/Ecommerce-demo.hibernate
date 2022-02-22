package com.java.training.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.training.dao.UserDao;
import com.java.training.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	static Map<String,User> list = new HashMap<String,User>();
	static int counter = 0;

	@Override
	public void saveUser(User user) {
//		counter++;
//		user.setUserId(counter);
		list.put(user.getName(), user);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.persist(user);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public User authenticaUser(String name, String password) {
//		if(list.containsKey(name)) {
//			if(list.get(name).getPassword().equals(password)) {
//				return list.get(name);
//			}
//		}
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String hql = "From User where name='"+name+"' and password='"+password+"'";
		Query query = session.createQuery(hql);
	
		List results = query.getResultList();
		session.getTransaction().commit();
		session.close();
	
		if(results.size()>0) {
			return (User) results.get(0);
		}
		
		return null;
	}

}
