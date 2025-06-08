package com.yogesh.assetmanagement;

import com.yogesh.assetmanagement.operations.AddNewAsset;
import com.yogesh.assetmanagement.operations.DeleteAsset;
import com.yogesh.assetmanagement.operations.UpdateAsset;
import com.yogesh.assetmanagement.operations.ViewAsset;
import com.yogesh.assetmanagement.util.SingletonDesignPattren;

import java.io.Console;
import java.util.Scanner;

import org.hibernate.engine.jdbc.BlobImplementer;


/**
 * Hello world!
 */
public class App {
		
	public void AppFunction() {
		
		Scanner scanner = SingletonDesignPattren.buildScannerObject();
		
		int choice = 0;

			System.out.println("**** WELCOME TO Asset-Management-System ****" + "\n1.Add Asset \n2.View All Asset \n3.Update Asset \n4.Delete Asset \n5.Exit Application" );
			
				do {
					
					System.out.println("\nEnter Your Choice ");
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
						System.out.println("Exit from Application ... !!!");
						System.exit(0);
						break;
						 
					default:
						System.out.println("enter valid number ... !!!");
						choice = 5;
					}
					
				}while(choice < 6 );

	}
	
    public static void main(String[] args)  {
    	App app = new App();
    	app.AppFunction(); 			
    }
}
