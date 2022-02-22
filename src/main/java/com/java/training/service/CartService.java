package com.java.training.service;

import java.util.List;
import java.util.Map;

import com.java.training.entity.Cart;
import com.java.training.entity.Product;

public interface CartService {

	public void addProduct(Integer userId, Product product);
	public void deleteProduct(Integer userId, Integer productId);
	public void buyCart(Integer userId);
	public List<Product> getCartList(Integer userId);
	public Double getTotal(Integer userId);
	public Cart getCart(Integer userId);
	public void deleteCart(Integer user);
}
