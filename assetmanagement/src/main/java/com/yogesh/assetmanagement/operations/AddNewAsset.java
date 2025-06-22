package com.yogesh.assetmanagement.operations;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yogesh.assetmanagement.modelclass.Asset;
import com.yogesh.assetmanagement.util.InputFields;
import com.yogesh.assetmanagement.util.SingletonDesignPattren;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class AddNewAsset {
	
	/**
	 * This constructor is define for Add New Asset Information in Asset Entity
	 */
	
	public AddNewAsset() {
		
		InputFields inputFields = new InputFields();
		Asset asset = new Asset();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		/**
		 * create Session Object Using SingleDesignPattern Class
		 * in which we define method buildSessionFactoryInstatnce() 
		 * to follow Singleton Design Pattern architecture
		 */
		Session session = SingletonDesignPattren.buildSessionFactoryInstance().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		System.out.println("*** ADD ASSET ***\n");
		
		/**
		 * inputField method define for take data 
		 * code optimization
		 */
	
		try {
			session.save(inputFields.setAssetInformation(asset));
			transaction.commit();
		}catch (ConstraintViolationException e) {
	
			Set<ConstraintViolation<Asset>> violations = validator.validate(asset);
			Iterator<ConstraintViolation<Asset>> iterator = violations.iterator();
			
			while (iterator.hasNext()) {
				ConstraintViolation<Asset> obj = iterator.next();
				System.out.println("Error:"+obj.getPropertyPath()+" - "+obj.getMessage());
			}
		} 
		
		session.close();
	}

	public static void main(String[] args) {
		new AddNewAsset();
	}
}
