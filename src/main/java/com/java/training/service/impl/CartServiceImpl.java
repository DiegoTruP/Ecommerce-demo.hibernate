package com.java.training.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.training.dao.CartDao;
import com.java.training.entity.Cart;
import com.java.training.entity.Product;
import com.java.training.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDao cartDao;

	@Override
	public void addProduct(Integer userId, Product product) {
		cartDao.addProduct(userId, product);
	}

	@Override
	public void deleteProduct(Integer userId, Integer productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buyCart(Integer userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getCartList(Integer userId) {
		
		return cartDao.getProducts(userId);
	}

	

	@Override
	public Double getTotal(Integer userId) {
		Double total= 0.00;
		for(Product product : getCartList(userId)) {
			double prodtotal = product.getProductPrice() * product.getProductQuantity();
			total = total + prodtotal;
		}
			
			
		return total;
	}

	@Override
	public Cart getCart(Integer userId) {
		
		return cartDao.getCart(userId);
	}

	@Override
	public void deleteCart(Integer user) {
		cartDao.deleteCard(user);
		
	}

}
