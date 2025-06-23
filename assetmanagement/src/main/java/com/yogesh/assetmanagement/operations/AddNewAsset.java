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
		
		
		/**
		 * create Session Object Using SingleDesignPattern Class
		 * in which we define method buildSessionFactoryInstatnce() 
		 * to follow Singleton Design Pattern architecture
		 */
		Session session = SingletonDesignPattren.buildSessionFactoryInstance().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		System.out.println("*** ADD ASSET ***\n");	
			
		asset = inputFields.setAssetInformation(asset);
		
		if(asset != null){
			session.save(asset);
			transaction.commit();
			System.out.println("Data Save Successfully ... !!");
		}
		
		session.close();
	}

}
