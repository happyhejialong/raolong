package com.bfwk.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class VituralPath implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		String app=e.getServletContext().getContextPath();
		e.getServletContext().setAttribute("app",app);
	}

}
