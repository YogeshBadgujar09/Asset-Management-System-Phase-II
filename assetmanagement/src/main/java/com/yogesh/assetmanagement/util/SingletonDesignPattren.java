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
	
	/**
	 * This function define for building SessionFactory Instance
	 * Also follow SingletonDesignPattern and optimize code 
	 * @return {@link SessionFactory} Instance
	 */
	public static SessionFactory buildSessionFactoryInstance() {
		
		if(sessionFactory == null){
			
			Configuration configuration = new Configuration();
			configuration.configure();
			
			sessionFactory = configuration.buildSessionFactory();	
		}
		
		return sessionFactory;
	}
	
	/**
	 * This function define for creating Scanner Object
	 * Also Optimize code 
	 * @return Scanner Object if scanner is null 
	 */
	
	public static Scanner buildScannerObject() {
		
		if(scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
	
}
