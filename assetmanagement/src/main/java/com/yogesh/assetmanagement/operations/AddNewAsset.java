package com.yogesh.assetmanagement.operations;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yogesh.assetmanagement.modelclass.Asset;
import com.yogesh.assetmanagement.util.InputFields;
import com.yogesh.assetmanagement.util.SingletonDesignPattren;

public class AddNewAsset {
	
	/**
	 * This constructor is define for Add New Asset Information in Asset Entity
	 */
	
	public AddNewAsset() {
		
		InputFields inputFields = new InputFields();
		Asset asset = new Asset();
		
		System.out.println("*** ADD ASSET ***\n");
		/**
		 * create Session Object Using SingleDesignPattern Class
		 * in which we define method buildSessionFactoryInstatnce() 
		 * to follow Singleton Design Pattern architecture
		 */
		Session session = SingletonDesignPattren.buildSessionFactoryInstance().openSession();
		
		Transaction transaction = session.beginTransaction();
		

		/**
		 * inputField method define for take data 
		 * code optimization
		 */
		session.save(inputFields.setAssetInformation(asset));
		transaction.commit();

		session.close();
	}

}
