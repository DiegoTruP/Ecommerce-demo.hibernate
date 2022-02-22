package com.java.training.service;

import java.util.List;

import com.java.training.entity.Product;
import com.java.training.entity.User;

public interface ProductService {
	
	public List<Product> getProducts();

	public void addToCart(Product product);
	
	public void discountProducts(Integer userId);

	public Product getProduct(Integer productId);

	public List<Product> searchProducts(String productName);
}
