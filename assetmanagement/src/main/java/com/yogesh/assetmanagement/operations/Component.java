package com.yogesh.assetmanagement.operations;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yogesh.assetmanagement.modelclass.Asset;
import com.yogesh.assetmanagement.modelclass.ComponentDetail;
import com.yogesh.assetmanagement.util.SingletonDesignPattren;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class Component {

	public static void main(String[] args) {
		
		Scanner scanner = SingletonDesignPattren.buildScannerObject();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		System.out.println("**** Component Details **** ");
		
		ComponentDetail componentDetail = new ComponentDetail();
		
		Session session = SingletonDesignPattren.buildSessionFactoryInstance().openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Enter Operating System :");
		componentDetail.setOperatingSystsem(scanner.nextLine());
		
		System.out.println("Enter Processor :");
		componentDetail.setProcessor(scanner.nextLine());
		
		System.out.println("Enter RAM :");
		componentDetail.setRam(scanner.nextLine());
		
		System.out.println("Enter Storage :");
		componentDetail.setStorage(scanner.nextLine());
		
		Set<ConstraintViolation<ComponentDetail>> violation = validator.validate(componentDetail);
		
		Iterator<ConstraintViolation<ComponentDetail>> iterator = violation.iterator();
		
		while (iterator.hasNext()) {
			ConstraintViolation<ComponentDetail> obj = iterator.next();
			System.out.println("Error:"+obj.getPropertyPath() + " - " + obj.getMessage());

		}
		
		session.save(componentDetail);
		transaction.commit();
		
		session.close();		
	}
}
