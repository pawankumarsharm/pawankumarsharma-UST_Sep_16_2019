package com.ustglobal.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernate.dto.Product;

public class UpdateQuery {

	public static void main(String[] args) {
			
		EntityTransaction entityTransaction=null;
		EntityManager entityManager=null;;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			 entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			 Product productInfo=  entityManager.find(Product.class,101);
			productInfo.setPname("Mobile");
			 System.out.println("Update Record");
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();
		
	}//end of main()

}//end of UpdateQuery
