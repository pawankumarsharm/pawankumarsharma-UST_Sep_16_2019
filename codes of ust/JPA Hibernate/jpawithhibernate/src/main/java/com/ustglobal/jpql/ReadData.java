package com.ustglobal.jpql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ustglobal.jpawithhibernate.dto.Product;

public class ReadData {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em=emf.createEntityManager();
		
		//String jpql= "from Product";
		String jpql="select pname from Product";
		Query query=em.createQuery(jpql);
		//ArrayList<Product> ar=(ArrayList<Product>) query.getResultList();
		List<String> ar=query.getResultList();
		for (String product : ar) {
			//System.out.println(product.getPid());
			System.out.println(product);
			//System.out.println(product.getQuantity());
		}
	}

}
