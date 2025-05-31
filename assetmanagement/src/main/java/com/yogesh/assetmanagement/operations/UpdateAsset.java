package com.yogesh.assetmanagement.operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yogesh.assetmanagement.modelclass.Asset;
import com.yogesh.assetmanagement.util.InputFields;
import com.yogesh.assetmanagement.util.SingletonDesignPattren;

public class UpdateAsset {

	public static void main(String[] args) {
		
		Transaction transaction ;
		InputFields inputFields = new InputFields();
		
		Session session = SingletonDesignPattren.buildSessionFactoryInstance().openSession();
		
		Asset asset = new Asset();
		
		System.out.println("*** UPDATE ASSET FUNTIONALITY ***\n");
		
		do {
			
			System.out.println("Enter Asset ID :");
			String assetId = new Scanner(System.in).next();
			
			asset = session.get(Asset.class, assetId);
			
			if(asset == null) {
				System.out.println("\nAsset Not Found .... !!!");
			}else {
				System.out.println("\nData :" + asset.toString());
			}	
		
		}while(asset == null);
		
		System.out.println("Enter data for Update ... !!!");
		
		
		asset = inputFields.setAssetInformation(asset);
		
		transaction = session.beginTransaction();
		session.update(asset);
		transaction.commit();
		session.close();
		
	}

}
