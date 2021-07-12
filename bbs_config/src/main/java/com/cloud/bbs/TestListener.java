package com.cloud.bbs;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext slc = sce.getServletContext();
		System.out.println(slc.getInitParameter("contextConfigLocation"));
		System.out.println("µø¿€!");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
