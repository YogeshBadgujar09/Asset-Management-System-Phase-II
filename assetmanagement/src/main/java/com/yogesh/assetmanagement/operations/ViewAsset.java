package com.yogesh.assetmanagement.operations;

import java.util.List;

import org.hibernate.Session;

import com.yogesh.assetmanagement.modelclass.Asset;
import com.yogesh.assetmanagement.util.SingletonDesignPattren;


public class ViewAsset {
	
	/**
	 * This method is define for retrieve all data from Asset Entity
	 * Use List Interface for list all the rows of Asset Entity
	 */
	
	public ViewAsset() {
		
		System.out.println(" *** View All Asset ***");
		
		/**
		 * create Session Object Using SingleDesignPattern Class
		 * in which we define method buildSessionFactoryInstatnce() 
		 * to follow Singleton Design Pattern architecture
		 */
		Session session = SingletonDesignPattren.buildSessionFactoryInstance().openSession();
		
		List<Asset> assets = session.createQuery("from Asset", Asset.class).list();
		
		for(Asset asset : assets) {
			System.out.println("****************************************************************************************");
			System.out.println("Data :" + asset.toString());
		}
		session.close();
	}

}