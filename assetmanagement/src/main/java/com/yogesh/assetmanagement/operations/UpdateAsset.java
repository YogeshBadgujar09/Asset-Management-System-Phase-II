package com.yogesh.assetmanagement.operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yogesh.assetmanagement.modelclass.Asset;
import com.yogesh.assetmanagement.util.InputFields;
import com.yogesh.assetmanagement.util.SearchAsset;
import com.yogesh.assetmanagement.util.SingletonDesignPattren;

public class UpdateAsset {

	public UpdateAsset() {
		
		Transaction transaction ;
		SearchAsset searchAsset = new SearchAsset();
		InputFields inputFields = new InputFields();
		Scanner scanner = new Scanner(System.in);
		
		/**
		 * create Session Object Using SingleDesignPattern Class
		 * in which we define method buildSessionFactoryInstatnce() 
		 * to follow Singleton Design Pattern architecture
		 */
		Session session = SingletonDesignPattren.buildSessionFactoryInstance().openSession();
		
		Asset asset = new Asset();
		
		System.out.println("*** UPDATE ASSET FUNTIONALITY ***\n");
		
		/**
		 * search method return asset object
		 * code optimization
		 */
		asset = searchAsset.search(session);
		
		System.out.println("Enter data for Update ... !!!");
		
		/**
		 * inputField method define for take data 
		 * code optimization
		 */
		asset = inputFields.setAssetInformation(asset);
		
		transaction = session.beginTransaction();
		
		System.out.println("Are You Sure To Update Data : [y/n]");
		String confirmation = scanner.next();
		
		if(confirmation.equalsIgnoreCase("y")) {
			session.update(asset);
			transaction.commit();
		}
		
		session.close();
		
	}
}
