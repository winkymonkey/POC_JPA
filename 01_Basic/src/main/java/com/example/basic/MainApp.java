package com.example.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class MainApp {
	public static void main(String[] args) {
		MainApp main = new MainApp();
		main.doIt();
	}

	public void doIt() {
		EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			factory = Persistence.createEntityManagerFactory("oracle-hibernate");
			em = factory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Person person = new Person();
			person.setName("Homer");
			person.setWeight(70.00);
			person.setAge(30);
			em.persist(person);
			
			tx.commit();
		}
		catch (Exception e) {
			if (null!=tx && tx.isActive())
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			if (em != null)
				em.close();
			if (factory != null)
				factory.close();
		}
	}
}


