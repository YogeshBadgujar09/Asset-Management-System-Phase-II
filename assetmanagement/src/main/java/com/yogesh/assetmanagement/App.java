package com.yogesh.assetmanagement;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.sqm.mutation.internal.temptable.ExecuteWithoutIdTableHelper;
import org.hibernate.query.sqm.sql.BaseSqmToSqlAstConverter.AdditionalInsertValues;
import org.hibernate.service.spi.SessionFactoryServiceContributor;

import com.yogesh.assetmanagement.modelclass.Asset;
import com.yogesh.assetmanagement.operations.AddNewAsset;
import com.yogesh.assetmanagement.operations.DeleteAsset;
import com.yogesh.assetmanagement.operations.UpdateAsset;
import com.yogesh.assetmanagement.operations.ViewAsset;

import jakarta.transaction.Transaction;

import java.nio.channels.NonWritableChannelException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import org.hibernate.Session;

/**
 * Hello world!
 */
public class App {
		
	public App() {
		
		int choice;
		Scanner scanner = new Scanner(System.in);

		System.out.println("**** WELCOME TO Asset-Management-System ****" + "\n1.Add Asset \n2.View All Asset \n3.Update Asset \n4.Delete Asset \n5.Exit Application" );
		
		
		do {
			System.out.println("Enter Your Choice ");
			choice = scanner.nextInt();
			
			switch (choice) {
			case 1: 
				new AddNewAsset();
				break;
				
			case 2: 
				new ViewAsset();
				break;
				
			case 3: 
				new UpdateAsset();
				break;
				
			case 4: 
				new DeleteAsset();
				break;
				
			case 5: 
				System.exit(0);
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			
			
		}while(choice > 6 && choice < 1 );
		
	
	}	
	
    public static void main(String[] args)  {
    	new App();
    }
}
