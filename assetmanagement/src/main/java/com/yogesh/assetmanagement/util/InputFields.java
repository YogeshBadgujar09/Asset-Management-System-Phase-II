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
		
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		try {
			
			
			System.out.println("Enter Asset Name :");
			asset.setAssetName(scanner.nextLine());
			
			System.out.println("SELECT TYPE :");
			asset.setAssetType(scanner.nextLine());
			
			System.out.println("Enter Serial Number :");
			asset.setAssetSerialNo(scanner.next());
			
			System.out.println("Enter Purchase Date :");
			asset.setAssetPurchaseDate(simpleDateFormat.parse(scanner.next()));
			
		}catch (ConstraintViolationException e) {
	

			Set<ConstraintViolation<Asset>> violations = validator.validate(asset);
			Iterator<ConstraintViolation<Asset>> iterator = violations.iterator();
			
			while (iterator.hasNext()) {
				ConstraintViolation<Asset> obj = iterator.next();
				System.out.println("Error:"+obj.getPropertyPath()+" - "+obj.getMessage());
	
			}
			
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		scanner.close();
		return asset;
	}
	
}
