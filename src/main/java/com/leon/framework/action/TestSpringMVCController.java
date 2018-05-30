package com.leon.framework.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestSpringMVCController {
	@RequestMapping(value="toIndex", method = RequestMethod.GET)
	public String toIndex() {
		// TODO Auto-generated method stub
		return "index";
	}
}
