package com.ty.onetomanybi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomanybi.dao.*;

public class TestSaveDaos {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Mobile mobile = new Mobile();
		mobile.setName("Samsung");
		mobile.setCost(15000);
	
		Sim sim1 = new Sim();
		sim1.setProvider("Airtel");
		sim1.setType("4G");
		sim1.setMobile(mobile);
	
		Sim sim2 = new Sim();
		sim2.setProvider("BSNL");
		sim2.setType("2G");
		sim2.setMobile(mobile);
		
		List<Sim> list = new ArrayList<Sim>();
		list.add(sim1);
		list.add(sim2);
		
		mobile.setSims(list);
		
		entityTransaction.begin();
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityManager.persist(mobile);
		
		entityTransaction.commit();
	}
}
