package com.yogesh.assetmanagement.util;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.hibernate.sql.Template;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

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
	
	public static <T> boolean validationCheck(T t) {
		
		boolean  flag = true ;
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		Set<ConstraintViolation<T>> violations = validator.validate(t);
		Iterator<ConstraintViolation<T>> iterator = violations.iterator();
		
		while (iterator.hasNext()) {
			ConstraintViolation<T> obj = iterator.next();
			System.out.println("Error:" + obj.getPropertyPath() + " - " + obj.getMessage());
			flag = false;
		}
		
		return flag;
	}
}
