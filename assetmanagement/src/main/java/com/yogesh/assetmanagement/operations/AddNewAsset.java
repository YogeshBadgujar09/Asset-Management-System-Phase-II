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


import com.yogesh.assetmanagement.modelclass.Asset;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolationException;



public class AddNewAsset {
	
	public AddNewAsset() {
		
		System.out.println("*** ADD ASSET ***");
		
		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		Asset asset = new Asset();
		
		Configuration configuration = new Configuration();
		configuration.configure();

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			
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
	
	public static void main(String[] args){
		AddNewAsset addNewAsset = new AddNewAsset();
	}

}
