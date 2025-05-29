package com.yogesh.assetmanagement.operations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.validator.constraints.ISBN;

import com.yogesh.assetmanagement.modelclass.Asset;
import com.yogesh.assetmanagement.util.SingletonDesignPattren;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolationException;



public class AddNewAsset {
	
	/**
	 * This constructor is define for Add New Asset Information in Asset Entity
	 */
	
	public AddNewAsset() {
		
		
		
		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		Asset asset = new Asset();

		/**
		 * create Session Object Using SingleDesignPattern Class
		 * in which we define method buildSessionFactoryInstatnce() 
		 * to follow Singleton Design Pattern architecture
		 */
		Session session = SingletonDesignPattren.buildSessionFactoryInstance().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		try {
			System.out.println("*** ADD ASSET ***\n");
			
			System.out.println("Enter Asset Name :");
			asset.setAssetName(scanner.nextLine());
			
			System.out.println("SELECT TYPE :");
			asset.setAssetType(scanner.nextLine());
			
			System.out.println("Enter Serial Number :");
			asset.setAssetSerialNo(scanner.next());
			
			System.out.println("Enter Purchase Date :");
			asset.setAssetPurchaseDate(simpleDateFormat.parse(scanner.next()));
		
			session.save(asset);
			transaction.commit();

			
		}catch (ConstraintViolationException e) {
			

			Set<ConstraintViolation<Asset>> violations = validator.validate(asset);
			Iterator<ConstraintViolation<Asset>> iterator = violations.iterator();
			
			while (iterator.hasNext()) {
				ConstraintViolation<Asset> obj = iterator.next();
				System.out.println("Error:"+obj.getPropertyPath()+" - "+obj.getMessage());
	
			}
			
		} catch (ParseException e) {			
			e.printStackTrace();
		}

		session.close();
				
	}
	
}
