package com.yogesh.assetmanagement.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.yogesh.assetmanagement.modelclass.Asset;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class InputFields {
	
	public Asset setAssetInformation(Asset asset ) {
		
		Scanner scanner = SingletonDesignPattren.buildScannerObject();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			
		scanner.nextLine(); // clears leftover newline
		
		System.out.println("Enter Asset Name :");
		asset.setAssetName(scanner.nextLine());
		
		System.out.println("Select Asset Type :");
		asset.setAssetType(selectAssetType());
		System.out.println("You select :" + asset.getAssetType());
		
		System.out.println("Enter Serial Number :");
		asset.setAssetSerialNo(scanner.next());
		
		boolean flag;
		
		do {
			try {
				System.out.println("Enter Purchase Date :");
				asset.setAssetPurchaseDate(simpleDateFormat.parse(scanner.next()));
				flag = true ;
			}catch (ParseException e) {			
				System.out.println("Please enter valid Date [format must dd-MM-yyyy] ... !!! ");
				flag = false ;
			}
		}while(!flag);
			
		return asset;
	}
	
	public String selectAssetType() {
		
		int choice;
		
		Scanner scanner = SingletonDesignPattren.buildScannerObject();
				
		System.out.println("1.Laptop  2.Printer  3.Scanner  4.Computer-Accesories  5.Other-Electronic");
		
		do {
				System.out.println("Enter Number to Select Choice :");
				choice = scanner.nextInt();
	
				switch (choice) {

					case 1:
						return "Laptop";
							
					case 2:
						return "Printer";
							
					case 3:
						return "Scanner";
		
					case 4:
						return "Computer-Accesories";		
		
					default:
						return "Other-Electronics";	
				}
		} while (choice < 6);

	}

}
