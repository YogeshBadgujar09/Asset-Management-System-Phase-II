package com.yogesh.assetmanagement.util;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingletonDesignPattren {
	
	private static SessionFactory sessionFactory;
	private static Scanner scanner ;
	
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
	
	public static Scanner buildScannerObject() {
		
		if(scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
	
}
