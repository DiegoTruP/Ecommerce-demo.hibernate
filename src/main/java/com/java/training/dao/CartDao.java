package com.java.training.dao;

import java.util.List;

import com.java.training.entity.Cart;
import com.java.training.entity.Product;

public interface CartDao {
	public Cart addCart(Integer userId);
	public Cart getCart(Integer userId);
	public void addProduct(Integer userId, Product product);
	public List<Product> getProducts(Integer userId);
	public void buyCart(Integer userId);
	public void deleteCard(Integer user);

}
