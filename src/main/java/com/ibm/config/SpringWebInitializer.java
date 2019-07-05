package com.ibm.config;

import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebInitializer implements WebApplicationInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext container=new AnnotationConfigWebApplicationContext();
		container.register(com.ibm.config.SpringWebConfig.class);
		container.setServletContext(servletContext);
		Dynamic servlet=servletContext.addServlet("spring", new DispatcherServlet(container));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(3);		
	}
}
