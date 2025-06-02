package com.yogesh.assetmanagement.operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yogesh.assetmanagement.modelclass.Asset;
import com.yogesh.assetmanagement.util.SearchAsset;
import com.yogesh.assetmanagement.util.SingletonDesignPattren;

public class DeleteAsset {
		
	public DeleteAsset() {
		
		Scanner scanner = new Scanner(System.in);
		Asset asset = new Asset();
		
		SearchAsset searchAsset = new SearchAsset();
		
		/**
		 * create Session Object Using SingleDesignPattern Class
		 * in which we define method buildSessionFactoryInstatnce() 
		 * to follow Singleton Design Pattern architecture
		 */
		Session session = SingletonDesignPattren.buildSessionFactoryInstance().openSession();
		
		System.out.println("****** Delete Asset ********\n");
		
		/**
		 * search method return asset object
		 * code optimization
		 */
		asset = searchAsset.search(session);
		
		System.out.println("Are you sure to Delete Asset :[y/n]");
		String confirmation = scanner.next();
		
		Transaction transaction = session.beginTransaction();
		
		if(confirmation.equalsIgnoreCase("y")) {
			session.remove(asset);
			transaction.commit();
		}
		
		session.close();
		scanner.close();
	}
}
