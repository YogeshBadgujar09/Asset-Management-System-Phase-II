package com.yogesh.assetmanagement.operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yogesh.assetmanagement.modelclass.Asset;
import com.yogesh.assetmanagement.util.SearchAsset;
import com.yogesh.assetmanagement.util.SingletonDesignPattren;

public class DeleteAsset {

	public static void main(String[] args) {
				
		Asset asset = new Asset();
		SearchAsset searchAsset = new SearchAsset();
		
		Session session = SingletonDesignPattren.buildSessionFactoryInstance().openSession();
		
		System.out.println("****** Delete Asset ********\n");
		
		asset = searchAsset.search(session);
		
		System.out.println("Are you sure to Delete Asset :[y/n]");
		String confirmation = new Scanner(System.in).next();
		
		Transaction transaction = session.beginTransaction();
		
		if(confirmation.equalsIgnoreCase("y")) {
			session.remove(asset);
			transaction.commit();
		}
		
		session.close();
	}

}
