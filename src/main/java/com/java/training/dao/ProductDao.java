package com.java.training.dao;

import java.util.List;

import com.java.training.entity.Product;

public interface ProductDao {
	public List<Product> getProductList();

	public void addToCart(Product product);
}
