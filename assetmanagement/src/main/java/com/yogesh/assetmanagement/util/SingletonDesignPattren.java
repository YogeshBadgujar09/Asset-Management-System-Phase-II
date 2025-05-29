package com.yogesh.assetmanagement.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingletonDesignPattren {
	
	private static SessionFactory sessionFactory;
	
	public SingletonDesignPattren() {
		// TODO Auto-generated constructor stub
	}
	
	public static SessionFactory buildSessionFactoryInstance() {
		
		if(sessionFactory == null){
			
			Configuration configuration = new Configuration();
			configuration.configure();
			
			sessionFactory = configuration.buildSessionFactory();	
		}
		
		return sessionFactory;
	}
	
	
}
