package com.ustglobal.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernate.onetomany.Pencil;
import com.ustglobal.jpawithhibernate.onetomany.PencilBox;

public class TestManyToOne {
public static void main(String[] args) {
	PencilBox pencilBox=new PencilBox();
	pencilBox.setBid(10);
	pencilBox.setBname("Apsara");

	
	Pencil p=new Pencil();
	p.setPid(1);
	p.setColor("red");
	p.setPencilBox(pencilBox);
	
	Pencil p1=new Pencil();
	p1.setPid(2);
	p1.setColor("blue");
	p1.setPencilBox(pencilBox);
	
	EntityManager em=null;
	EntityTransaction et=null;
	
	try {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
		//PencilBox pencilBo=em.find(Pencil.class,);
		em.persist(p);
		em.persist(p1);
		System.out.println("Record Saved");
		et.commit();
	} catch (Exception e) {
		e.printStackTrace();
		et.rollback();
	}
	em.close();
}
}
