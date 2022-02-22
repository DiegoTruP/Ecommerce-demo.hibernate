package com.java.training.controllers;

import java.util.ArrayList;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContext;

import com.java.training.dto.ProductCart;
import com.java.training.entity.Cart;
import com.java.training.entity.Product;
import com.java.training.entity.User;
import com.java.training.service.ProductService;

@Controller
public class ProductController {
	
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/getProducts", method = RequestMethod.GET)
	public ModelAndView getAllProducts(ModelAndView modelAndView,@ModelAttribute("user") Integer user, RedirectAttributes redirect) {
		
		List<Product> productList= productService.getProducts();//Product to show
		
		ProductCart productCart = new ProductCart();//dto to store the product and the user id to add it to the cart
		
		Map<String, List> mapList = new HashMap<String,List>();
		mapList.put("productList", productList);
		modelAndView.addObject("productCart", productCart);
		modelAndView.addAllObjects(mapList);
		redirect.addFlashAttribute("user", user);//add the user to create the match product-user inside the form (in the jsp)
		
		modelAndView.setViewName("productsView");
		
		return modelAndView;
		 
	}
	
	
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public ModelAndView addToCart(ModelAndView modelAndView, @ModelAttribute  ProductCart productCart, RedirectAttributes redirect) {

		productCart.setProduct(productService.getProduct(productCart.getProductId()));//This set the product object that will be added 
																					//to the cart, this use as parameter the productId that is
																					//contained in the productCart.
		
		redirect.addFlashAttribute("productCart",productCart);//Sent the productCart to be store in the Cart collection.
		modelAndView.setViewName("redirect:/addToCartList");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/search")
	public ModelAndView searchProduct(ModelAndView modelAndView,@RequestParam("userId") Integer user,@RequestParam("productName") String productName, RedirectAttributes redirect) {
		
		List<Product> productList= productService.searchProducts(productName);//Get the list filtered
		
		ProductCart productCart = new ProductCart();//Create productCart to store the product that will be added
		
		Map<String, List> mapList = new HashMap<String,List>();
		mapList.put("productList", productList);
		
		modelAndView.addObject("productCart", productCart);

		modelAndView.addAllObjects(mapList);
		redirect.addFlashAttribute("user", user);
		modelAndView.addObject("user", user);
		
		modelAndView.setViewName("productsView");
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/discountProduct")
	public String discountProducts(Model model,@ModelAttribute("cart") Cart cart,@ModelAttribute("orderId") Integer orderId, RedirectAttributes redirect) {
		
		//productService.discountProducts();
		redirect.addFlashAttribute("user", cart.getUserId());
		redirect.addFlashAttribute("orderId", orderId);
		
		return "redirect:deleteCart";
	}
	
}
