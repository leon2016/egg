package com.leon.framework.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(InitServlet.class);

	public void init() {
		logger.info("[初始化上下文]");
		logger.info("InitServlet init started.");

		logger.info("InitServlet init completed.");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	public String getServletInfo() {
		return super.getServletInfo();
	}

	public void destroy() {
	}

	public void performTask(HttpServletRequest request, HttpServletResponse response) {
	}
}