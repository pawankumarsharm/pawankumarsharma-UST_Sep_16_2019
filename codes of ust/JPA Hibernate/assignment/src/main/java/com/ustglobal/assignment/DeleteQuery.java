package com.ustglobal.assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.assignment.dto.Department;

public class DeleteQuery {
public static void main(String[] args) {
	
	EntityManager em=null;
	EntityTransaction et=null;
	
	try {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
		Department d = em.find(Department.class, 90);
		em.remove(d);
		System.out.println("Data Deleted");
		et.commit();
	} catch (Exception e) {
		e.printStackTrace();
		et.rollback();
	}
	em.close();
}
}
