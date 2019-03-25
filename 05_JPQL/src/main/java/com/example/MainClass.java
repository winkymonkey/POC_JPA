package com.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


@SuppressWarnings("unused")
public class MainClass {

	public static void main(String[] args) {
		MainClass main = new MainClass();
		main.doIt();
	}

	public void doIt() {
		EntityManagerFactory emFactory = null;
		EntityManager em = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("xxxxxxxxx");
			em = emFactory.createEntityManager();
			
			/* ----------------------------------------------------------------------------------------------------- */
				//Use getResultList() and TypedQuery
			TypedQuery<Country> query1 = em.createQuery("SELECT c FROM Country c", Country.class); 		// Query query1 = em.createQuery("SELECT c FROM Country c");
			List<Country> results1 = query1.getResultList(); 											// List results1 = query1.getResultList();

				//Use getSingleResult and TypedQuery
			TypedQuery<Long> query2 = em.createQuery("SELECT COUNT(c) FROM Country c", Long.class); 	// Query query2 = em.createQuery("SELECT COUNT(c) FROM Country c");
			long countryCount2 = query2.getSingleResult(); 												// long countryCount2 = (Long) query2.getSingleResult();

			/* ----------------------------------------------------------------------------------------------------- */
				//Update query
			int count3 = em.createQuery("UPDATE Country SET area = 0").executeUpdate();

				//Delete query
			int count4 = em.createQuery("DELETE FROM Country").executeUpdate();

			/* ----------------------------------------------------------------------------------------------------- */
				//Named Parameter
			TypedQuery<Country> query5 = em.createQuery("SELECT c FROM Country c WHERE c.name = :nm", Country.class);
			Country country5 = query5.setParameter("nm", "INDIA").getSingleResult();

				//Ordinal Parameter
			TypedQuery<Country> query6 = em.createQuery("SELECT c FROM Country c WHERE c.name = ?1", Country.class);
			Country country6 = query6.setParameter(1, "INDIA").getSingleResult();

			/* ----------------------------------------------------------------------------------------------------- */
				//Projection (single path expression)
			TypedQuery<String> query7 = em.createQuery("SELECT c.name FROM Country c", String.class);
			List<String> results7 = query7.getResultList();

				//Projection (nested path expression)
			TypedQuery<String> query8 = em.createQuery("SELECT c.capital.name FROM Country c", String.class);
			List<String> results8 = query8.getResultList();

				//Projection (multiple path expression)
			TypedQuery<Object[]> query9 = em.createQuery("SELECT c.name, c.capital.name FROM Country AS c", Object[].class);
			List<Object[]> results9 = query9.getResultList();

				//Multiple Range Variables
			TypedQuery<Object[]> query10 = em.createQuery("SELECT c1, c2 FROM Country c1, Country c2", Object[].class);
			List<Object[]> results10 = query10.getResultList();

				//Inner Join
			TypedQuery<Object[]> query11 = em.createQuery("SELECT c1, c2 FROM Country c1 INNER JOIN c1.neighbors c2", Object[].class);
			List<Object[]> results11 = query11.getResultList();

				//Left Outer Join
			TypedQuery<Object[]> query12 = em.createQuery("SELECT c1, c2 FROM Country c1 LEFT OUTER JOIN c1.neighbors c2", Object[].class);
			List<Object[]> results12 = query12.getResultList();
			
			/* ----------------------------------------------------------------------------------------------------- */
			
			
		}
		catch (Exception e) {
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
