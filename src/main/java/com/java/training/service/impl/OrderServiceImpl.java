package com.java.training.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.training.dao.CartDao;
import com.java.training.dao.OrderDao;
import com.java.training.entity.Cart;
import com.java.training.entity.OrderProduct;
import com.java.training.entity.Product;
import com.java.training.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public OrderProduct addOrder(Cart cart) {
		OrderProduct order =new OrderProduct();
//		if(order != null) {
//			addProduct(cart.getUserId(),cart.getProductList());
//		}else {
			order.setUserId(cart.getUserId());
			order.setProductList(cartDao.getProducts(cart.getUserId()));
			return orderDao.addOrder(order);
//		}
		
	}

	@Override
	public OrderProduct getOrderByUserId(Integer userId) {
		
		return orderDao.getOrder(userId);
	}



	@Override
	public List<OrderProduct> getOrders(Integer userId) {
		List<OrderProduct> orders = new ArrayList<OrderProduct>();
		
		for(OrderProduct order : orderDao.getOrderList(userId)) {
			if(order.getUserId()==userId) {
				orders.add(order);
			}
		}
		return orders;
	}

	@Override
	public OrderProduct getOrderByOrderId(Integer orderId) {

		for(OrderProduct order : orderDao.getOrderList(orderId)) {
			if(order.getOrderId()==orderId) {
				return order;
			}
		}
		return null;
	}

	@Override
	public List<Product> getProductsByUserId(Integer userId) {
		
		return cartDao.getProducts(userId);
	}

}
