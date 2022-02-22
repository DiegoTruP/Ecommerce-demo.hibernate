package com.java.training.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.training.dao.*;
import com.java.training.entity.Product;


@Repository
public class ProductDaoImpl implements ProductDao{
	
	static List<Product> productList = new ArrayList<Product>();
	static List<Product> cartList = new ArrayList<Product>();
	
	@Autowired
	private SessionFactory sessionFactory;
	
	static {
		Product product1 = new Product();
		product1.setProductId(1);
		product1.setProductName("Samsung S22");
		product1.setProductCategory("Smartphone");
		product1.setProductPrice(1200.00);
		product1.setProductQuantity(5);
		
		Product product2 = new Product();
		product2.setProductId(2);
		product2.setProductName("Ipad mini");
		product2.setProductCategory("Tablet");
		product2.setProductPrice(350.00);
		product2.setProductQuantity(7);
		
		Product product3 = new Product();
		product3.setProductId(3);
		product3.setProductName("SmartTv Samsung");
		product3.setProductCategory("TV");
		product3.setProductPrice(400.00);
		product3.setProductQuantity(3);
		
		
		Product product4 = new Product();
		product4.setProductId(4);
		product4.setProductName("Bluetooth speaker");
		product4.setProductCategory("Speaker");
		product4.setProductPrice(150.00);
		product4.setProductQuantity(10);
		
		Product product5 = new Product();
		product5.setProductId(5);
		product5.setProductName("PlayStation 5");
		product5.setProductCategory("Videogames");
		product5.setProductPrice(450.00);
		product5.setProductQuantity(9);
		
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		productList.add(product5);
		
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.persist(product1);
//		session.persist(product2);
//		session.persist(product3);
//		session.persist(product4);
//		session.persist(product5);
//		
//		session.getTransaction().commit();
//		session.close();
		
	}

	@Override
	public List<Product> getProductList() {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String hql = "From Product";
		Query query = session.createQuery(hql);
	
		List results = query.getResultList();
		session.getTransaction().commit();
		session.close();
		
//		return productList;
		return results;
	}

	@Override
	public void addToCart(Product product) {
		cartList.add(product);
		System.out.println(cartList.get(0).getProductName());
		
	}

}
