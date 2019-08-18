package com.ducat.controllers;

import java.util.Optional;
import javax.validation.Valid;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ducat.daos.UserDao;
import com.ducat.entities.User;
import com.ducat.validators.MailValidator;

@Controller
@RequestMapping(path="/userapp")
public class UserController {

	
	@Autowired
	UserDao dao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	MailValidator validator;
	
	// method to serve the home page
	@RequestMapping(path="/",method= RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("user", new User());
		return mav;
	}
	
	// method to register a user
	@RequestMapping(path="/register",method= RequestMethod.POST)
	public ModelAndView signup(
		@Valid @ModelAttribute	User user,
		BindingResult validationResult) {
		// predefined validations are applied, apply
		// the custom validation before checking errors
		validator.validate(user, validationResult);
		
		ModelAndView mav = new ModelAndView();
		
		if(validationResult.hasErrors()) {
			System.out.println("Validation failed.");
			mav.setViewName("register");
			mav.addObject("user",user);
			
		} else {
		System.out.println("no validation failed.");	
		// user object is saved in the DB.
		dao.save(user);
		mav.setViewName("registered");
		}
		return mav;
	}
	
	// method to login a user
	@RequestMapping(path="/login",method= RequestMethod.POST)
	public String login(
		@ModelAttribute	User user) {
		// user object is fetched from the DB using mailId
		Optional<User> optional = dao.findByMailId(user.getMailId());
		if(optional.isPresent())
		{
			User found = optional.get();
			// password are compared
			if(found.getPassword().equals(user.getPassword()))
			{
				// found user is saved in session.
				session.setAttribute("found", found);
				System.out.println(found.getName()+" is saved in session.");
				return "home";
			}
		}
		return "relogin";
	}
	
	// method to logout a user
		@RequestMapping(path="/logout",method= RequestMethod.GET)
		public String logout() {	
			// session is invalidated.
			session.invalidate();
			return "loggedOut";
		}	
}
