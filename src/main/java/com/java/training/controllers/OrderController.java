package com.java.training.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RedirectAttributesMethodArgumentResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.training.dto.BuyProduct;
import com.java.training.dto.ProductCart;
import com.java.training.entity.Cart;
import com.java.training.entity.OrderProduct;
import com.java.training.entity.Product;
import com.java.training.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/order", method = RequestMethod.GET)
	public String buyCart(Model model,@ModelAttribute("cart") Cart cart, RedirectAttributes redirect) {
		OrderProduct order = orderService.addOrder(cart);
		redirect.addFlashAttribute("cart", cart);
		redirect.addFlashAttribute("orderId",order.getOrderId());
		return"redirect:discountProduct";
	}
	
	@RequestMapping(value="/orderDone")
	public String orderDone(Model model,@ModelAttribute("orderId") Integer orderId) {
		OrderProduct order = orderService.getOrderByOrderId(orderId);
		
		List<Product> orderList = order.getProductList();//get list of products of an specified order
		
		Map<String, List> list = new HashMap<String,List>();//Cart list to show the products
		list.put("orderList", orderList);
		
		model.addAllAttributes(list);
		model.addAttribute("userId", order.getUserId());
		model.addAttribute("order",order);
		
		return "orderDone";
	}
	
	@RequestMapping(value="/back")
	public String back(Model model, @ModelAttribute ProductCart productCart,RedirectAttributes redirect) {
		redirect.addFlashAttribute("user", productCart.getUserId());
		return"redirect:getProducts";
	}
	
	
	@RequestMapping(value="/viewOrders/{userId}")
	public String showOrders(Model model,@PathVariable("userId") Integer userId) {
		OrderProduct order = orderService.getOrderByUserId(userId);
		
		List<OrderProduct> ordersList = orderService.getOrders(userId);//get list of products of an specified order
		
		Map<String, List> list = new HashMap<String,List>();//Cart list to show the products
		list.put("orderList", ordersList);
		
		model.addAllAttributes(list);
		model.addAttribute("userId", userId);
		//model.addAttribute("order",order);
		
		return "viewOrders";
	}
	
	@RequestMapping(value="/viewOrder/{orderId}")
	public String showOrder(Model model,@PathVariable("orderId") Integer orderId) {
		OrderProduct order = orderService.getOrderByOrderId(orderId);
		
		List<Product> orderList = order.getProductList();//get list of products of an specified order
		
		Map<String, List> list = new HashMap<String,List>();//Cart list to show the products
		list.put("orderList", orderList);
		
		model.addAllAttributes(list);
		model.addAttribute("userId", order.getUserId());
		model.addAttribute("order",order);
		
		return "viewOrder";
	}
	
	
	
	@RequestMapping(value="/orderBack")
	public ModelAndView backToProducts(ModelAndView modelAndView,@RequestParam("userId") Integer user,RedirectAttributes redirect) {
		redirect.addAttribute("user", user);
		modelAndView.setViewName("redirect:getProducts");
		return modelAndView;
	}
	
}
