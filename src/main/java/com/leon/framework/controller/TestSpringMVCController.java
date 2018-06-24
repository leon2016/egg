package com.leon.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leon.framework.service.ITestSpringService;



@Controller
public class TestSpringMVCController {
	@Autowired
	private ITestSpringService testSpringService;
	
	
	@RequestMapping(value="testSpringMVC", method = RequestMethod.GET)
	public String testSpringMVC() {
		// TODO Auto-generated method stub
		return "index";
	}
	
	@RequestMapping(value="testSpring", method = RequestMethod.GET)
	public String testSpring() {
		return testSpringService.testSpring();
	}
}
