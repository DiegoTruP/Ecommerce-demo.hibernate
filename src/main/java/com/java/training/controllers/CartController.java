package com.java.training.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.FormSubmitEvent.MethodType;

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

import com.java.training.dto.BuyProduct;
import com.java.training.dto.ProductCart;
import com.java.training.entity.Cart;
import com.java.training.entity.Product;
import com.java.training.entity.User;
import com.java.training.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@RequestMapping(value="/addToCartList")
	public String addProduct(Model model, @ModelAttribute ProductCart productCart,RedirectAttributes redirect) {
		
		cartService.addProduct(productCart.getUserId(), productCart.getProduct());//add the product to the cart
		redirect.addFlashAttribute("user", productCart.getUserId());//send the userId to the product view to keep "logged"
		
		return "redirect:/getProducts";
	}
	
	@RequestMapping(value="/deleteCart")
	public String deleteCart(Model model,@ModelAttribute("user") Integer user,@ModelAttribute("orderId") Integer orderId, RedirectAttributes redirect) {
		cartService.deleteCart(user);
		redirect.addFlashAttribute("user", user);
		redirect.addFlashAttribute("orderId", orderId);
		return "redirect:orderDone";
	}
	
	@RequestMapping(value="/viewCart/{userId}", method = RequestMethod.GET)
	public String showCart(Model model,@PathVariable("userId") Integer userId, RedirectAttributes redirect) {
		
		List<Product> cart = cartService.getCartList(userId);//get list of products of an specified cart
		
		Double total = cartService.getTotal(userId);//get total to pay for the cart products
		
		Map<String, List> cartList = new HashMap<String,List>();//Cart list to add the products to the model
		cartList.put("cart", cart);

		
		model.addAllAttributes(cartList);
		model.addAttribute("total", total);
		model.addAttribute("user", userId);
		
		return "viewCart";
	}
	
	@RequestMapping(value="/buy")
	public String buyCart(Model model,@RequestParam("userId") Integer user, RedirectAttributes redirect) {
		Cart cart =  cartService.getCart(user);
		redirect.addFlashAttribute("cart", cart);
		return"redirect:order";
	}
	
	@RequestMapping(value="/viewBack")
	public ModelAndView backToProducts(ModelAndView modelAndView,@RequestParam("userId") Integer user,RedirectAttributes redirect) {
		redirect.addAttribute("user", user);
		modelAndView.setViewName("redirect:getProducts");
		return modelAndView;
	}
	
	
}
