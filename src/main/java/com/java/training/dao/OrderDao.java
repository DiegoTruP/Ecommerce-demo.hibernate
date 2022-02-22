package com.java.training.dao;

import java.util.List;

import com.java.training.entity.OrderProduct;
import com.java.training.entity.Product;

public interface OrderDao {
	public OrderProduct addOrder(OrderProduct order);
	public OrderProduct getOrder(Integer userId);
	public List<OrderProduct> getOrderList(Integer userId);
}
