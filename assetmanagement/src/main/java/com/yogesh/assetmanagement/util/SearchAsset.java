package com.yogesh.assetmanagement.util;

import java.util.Scanner;

import org.hibernate.Session;

import com.yogesh.assetmanagement.modelclass.Asset;


public class SearchAsset {

	
	/**
	 *This method is define for search asset by assetId
	 *Also optimize code
	 * @param session take session object for current session
	 * @return asset if available
	 */
	public Asset search(Session session) {
		
		Asset asset = new Asset();
		Scanner scanner = new Scanner(System.in);
		do {
			
			System.out.println("Enter Asset ID :");
			String assetId = scanner.next();
			
			asset = session.get(Asset.class, assetId);
			
			if(asset == null) {
				System.out.println("\nAsset Not Found .... !!!");
			}else {
				System.out.println("\nData :" + asset.toString());
			}	
		
		}while(asset == null);
		
		scanner.close();
		return asset;
	}
}
