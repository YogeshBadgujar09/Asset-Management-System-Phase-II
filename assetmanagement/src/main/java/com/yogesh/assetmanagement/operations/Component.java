package com.yogesh.assetmanagement.operations;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yogesh.assetmanagement.modelclass.ComponentDetail;
import com.yogesh.assetmanagement.util.SingletonDesignPattren;

public class Component {

	public static void main(String[] args) {
		
		System.out.println("**** Component Details **** ");
		
		ComponentDetail componentDetail = new ComponentDetail();
		
		Session session = SingletonDesignPattren.buildSessionFactoryInstance().openSession();
		Transaction transaction = session.beginTransaction();
		
		componentDetail.setOperatingSystsem("Window 11");
		componentDetail.setProcessor("Itel i5");
		componentDetail.setRam("8 GB");
		componentDetail.setStorage("256 GB");
		
		session.save(componentDetail);
		transaction.commit();
		
		session.close();
		
	}

}
