package com.yogesh.assetmanagement.util;

import java.util.Scanner;

import org.hibernate.Session;

import com.yogesh.assetmanagement.modelclass.Asset;

public class SearchAsset {

	public Asset search(Session session) {
		
		Asset asset = new Asset();
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
		
		return asset;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
