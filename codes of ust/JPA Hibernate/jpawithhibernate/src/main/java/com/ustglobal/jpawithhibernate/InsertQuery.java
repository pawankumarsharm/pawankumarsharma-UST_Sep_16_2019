package com.ustglobal.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernate.dto.Product;

public class InsertQuery {

	public static void main(String[] args) {
			
		Product product=new Product();
		product.setPid(101);
		product.setPname("copy");
		product.setQuantity(101);
		
		EntityTransaction entityTransaction=null;
		EntityManager entityManager=null;;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			 entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(product);
			System.out.println("Record saved");
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();
		
	}//end of main()

}//end of Insertquery
