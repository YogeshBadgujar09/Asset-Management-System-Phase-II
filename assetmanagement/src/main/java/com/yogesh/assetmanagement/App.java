package com.yogesh.assetmanagement;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.sqm.sql.BaseSqmToSqlAstConverter.AdditionalInsertValues;
import org.hibernate.service.spi.SessionFactoryServiceContributor;

import com.yogesh.assetmanagement.modelclass.Asset;
import com.yogesh.assetmanagement.operations.AddNewAsset;

import jakarta.transaction.Transaction;

import java.nio.channels.NonWritableChannelException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;

/**
 * Hello world!
 */
public class App {
		
    public static void main(String[] args)  {
    	
    	AddNewAsset addNewAsset = new AddNewAsset();
       
    }
}
