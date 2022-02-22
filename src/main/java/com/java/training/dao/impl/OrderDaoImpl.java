package com.java.training.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.training.dao.OrderDao;
import com.java.training.entity.OrderProduct;
import com.java.training.entity.Product;

@Repository
public class OrderDaoImpl implements OrderDao {
	static List<OrderProduct> orderList = new ArrayList<OrderProduct>();
	static Integer counter=0;

	@Override
	public OrderProduct addOrder(OrderProduct order) {
		counter++;
		order.setOrderId(counter);
		double total = 0;
		for(Product product : order.getProductList()) {
			total = total + (product.getProductPrice()*product.getProductQuantity());
		}
		order.setTotal(total);
		order.setDate(LocalDate.now());
		orderList.add(order);
		return order;
	}

	@Override
	public OrderProduct getOrder(Integer userId) {
		for(OrderProduct order : orderList) {
			if(order.getUserId()==userId) {
				return order;
			}
		}
		return null;
	}

	@Override
	public  List<OrderProduct> getOrderList(Integer userId) {
		return orderList;
	}



}
