package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainApp {
	public static void main(String[] args) {
		MainApp main = new MainApp();
		main.run();
	}

	public void run() {
		EntityManagerFactory emFactory = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("oracle-hibernate");
			em = emFactory.createEntityManager();
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
			if (emFactory != null)
				emFactory.close();
		}
	}
}
