package com.leon.framework.service.impl;

import org.springframework.stereotype.Service;

import com.leon.framework.service.ITestSpringService;

@Service
public class TestSpringServiceImpl implements ITestSpringService {

	@Override
	public String testSpring() {

		return "index";
	}


}
