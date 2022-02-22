package com.java.training.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.training.dto.Credential;
import com.java.training.entity.User;
import com.java.training.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showRegistrationPage(Model model) {
		User user = new User();
		model.addAttribute(user);
		
		return "register";
	}
	
	@RequestMapping(value="/saveUser", method = RequestMethod.POST)
	public String doREgistration(@ModelAttribute User user, Model model) {
		Credential credential = new Credential();
		userService.saveUser(user);
		model.addAttribute("credential",credential);
		return "login";
	}
	
	@RequestMapping(value="/log", method = RequestMethod.GET)
	public String doLog(Model model) {
		Credential credential = new Credential();
		model.addAttribute("credential",credential);
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String authenticateUser(@ModelAttribute Credential credential, Model model, RedirectAttributes redirect) {
		User user = userService.authenticateUser(credential.getName(),credential.getPassword());
		if(user == null) return "loginFailure";
		//model.addAttribute("user",user);
		redirect.addFlashAttribute("user", user.getUserId());
		return"redirect:/getProducts";
	}
	
	
	
	
}
