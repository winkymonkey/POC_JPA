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
			
			tx.begin();
			Geek geek = new Geek();
			geek.setName("Gavin");
			person.setWeight(80.00);
			person.setAge(25);
			geek.setFavouriteProgrammingLanguage("Java");
			em.persist(geek);
			geek = new Geek();
			geek.setName("Thomas");
			person.setWeight(90.00);
			person.setAge(42);
			geek.setFavouriteProgrammingLanguage("C#");
			em.persist(geek);
			geek = new Geek();
			geek.setName("Christian");
			person.setWeight(50.00);
			person.setAge(28);
			geek.setFavouriteProgrammingLanguage("Java");
			em.persist(geek);
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
