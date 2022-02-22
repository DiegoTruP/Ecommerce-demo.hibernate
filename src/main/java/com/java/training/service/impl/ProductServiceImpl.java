package com.java.training.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.training.dao.CartDao;
import com.java.training.dao.ProductDao;
import com.java.training.entity.Product;
import com.java.training.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartDao cartDao;

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDao.getProductList();
	}

	@Override
	public void addToCart(Product product) {
		productDao.addToCart(product);
		
	}

	@Override
	public Product getProduct(Integer productId) {
		for(Product prod : productDao.getProductList()) {
			if(prod.getProductId() == productId) {
				return prod;
			}
		}
		return null;
	}

	@Override
	public List<Product> searchProducts(String productName) {
		productName = productName.toLowerCase();
		List<Product> productList = new ArrayList<Product>();
		for(Product product : productDao.getProductList()) {
			if(product.getProductName().toLowerCase().contains(productName)) {
				productList.add(product);
			}
		}
		return productList;
	}

	@Override
	public void discountProducts(Integer userId) {
		
//		List list = cartDao.getProducts(userId);
//		
//		
//		for(Product product : list) {
//			for(Product productStored : productDao.getProductList()) {
//				if(product.getProductId()==productStored.getProductId()) {
//					int quantity = productStored.getProductQuantity() - product.getProductQuantity();
//					productStored.setProductQuantity(quantity);
//				}
//			}
//		}
		
	}
	
	
	
}
