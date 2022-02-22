package com.java.training.service;

import java.util.List;

import com.java.training.entity.Cart;
import com.java.training.entity.OrderProduct;
import com.java.training.entity.Product;

public interface OrderService {
	
	public OrderProduct addOrder(Cart cart);
	public OrderProduct getOrderByUserId(Integer userId);
	public List<OrderProduct> getOrders(Integer userId);
	public OrderProduct getOrderByOrderId(Integer orderId);
	public List<Product> getProductsByUserId(Integer userId);

}
