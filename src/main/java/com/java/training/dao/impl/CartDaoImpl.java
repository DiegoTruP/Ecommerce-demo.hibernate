package com.java.training.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.training.dao.CartDao;
import com.java.training.dto.BuyProduct;
import com.java.training.entity.Cart;
import com.java.training.entity.Product;

@Repository
public class CartDaoImpl implements CartDao{
	
	static Map<Integer, Cart> cartList = new HashMap<Integer,Cart>();
	static Integer cartCounter = 0;
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public Cart addCart(Integer userId) {
		Cart cart = new Cart();
		cart.setUserId(userId);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		session.getTransaction().commit();
		session.close();
		return cart;
	}

	@Override
	public Cart getCart(Integer userId) {
		
		Session session = sessionFactory.openSession();  //FOR HIBERNATE
		session.beginTransaction();
		String hql = "From Cart where userId="+userId;
		Query query = session.createQuery(hql);
		List results = query.getResultList();
		session.getTransaction().commit();
		session.close();
		
		
//		return cartList.get(userId);
		if(results.size()>0) {
			return (Cart) results.get(0);
		}
		else {
			return null;
		}
	}

	@Override
	public void addProduct(Integer userId, Product product) {
		Cart cart = getCart(userId);
		if(cart == null) {
			cart=addCart(userId);	
		}
		
		Session session = sessionFactory.openSession(); 
	
		BuyProduct buyProduct = new BuyProduct();
		buyProduct.setUserId(userId);
		buyProduct.setCartId(cart.getCartId());
		buyProduct.setProduct(product);
		session = sessionFactory.openSession();
		session.beginTransaction();
		String hql = "From BuyProduct where userId="+userId+" and productId="+product.getProductId();
		Query query = session.createQuery(hql);
		List results = query.getResultList();
		if(results.size()>0) {
			buyProduct=(BuyProduct) results.get(0);
			int quantity = buyProduct.getQuantity();
			buyProduct.setQuantity(quantity+1);
		}else {
			buyProduct.setQuantity(1);
		}
		session.persist(buyProduct);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public List<Product> getProducts(Integer userId) {
		Session session = sessionFactory.openSession();  //FOR HIBERNATE
		session.beginTransaction();
		String hql = "From BuyProduct as prod inner join prod.product where prod.userId="+userId;
		Query query = session.createQuery(hql);
		List<Object []> results = query.getResultList();
		session.getTransaction().commit();
		session.close();
		
		
		List products = new ArrayList();
		
		for(Object [] objeto: results) {
			BuyProduct buyProductObj= (BuyProduct) objeto[0];
			Product productObj = (Product) objeto[1];
			
			Product product = new Product();
			product.setProductName(productObj.getProductName());
			product.setProductId(productObj.getProductId());
			product.setProductCategory(productObj.getProductCategory());
			product.setProductPrice(productObj.getProductPrice());
			product.setProductQuantity(buyProductObj.getQuantity());
			
			products.add(product);
		}
		
		
		return products;
	}

	@Override
	public void buyCart(Integer userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCard(Integer user) {
		cartList.remove(user);
	}

}
