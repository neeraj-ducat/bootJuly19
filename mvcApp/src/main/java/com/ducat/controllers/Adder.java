package com.ducat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/adder")
public class Adder {

	// method to serve the home page
	@RequestMapping(path="/",method= RequestMethod.GET)
	public String home() {
		System.out.println("home is invoked.");
		return "index";
	}
	// method to serve the home page
	@RequestMapping(path="/add",method= RequestMethod.POST)
	public ModelAndView doSum(
		@RequestParam("num1")	int x, 
		@RequestParam("num2") int y) {
		System.out.println("doSum() is invoked.");
		ModelAndView mav = new ModelAndView();
		int z = x+y;
		mav.setViewName("result");
		mav.addObject("sum",z);
		return mav;
	}
}
