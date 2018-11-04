package com.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class MainClass {
	public static void main(String[] args) {
		MainClass main = new MainClass();
		main.run();
	}
	
	@SuppressWarnings({"unused","rawtypes"})
	public void run() {
		EntityManagerFactory emFactory = null;
		EntityManager em = null;
		try {
			emFactory = Persistence.createEntityManagerFactory("xxxxxxxxx");
			em = emFactory.createEntityManager();
			
			
			//1 use getResultList() and Query
			Query query1 = em.createQuery("SELECT c FROM Country c");
			List results1 = query1.getResultList();
			
			
			//2 use getResultList and TypedQuery
			TypedQuery<Country> query2 = em.createQuery("SELECT c FROM Country c", Country.class);
			List<Country> results2 = query2.getResultList();
			
			
			//3 use getSingleResult() and Query
			Query query3 = em.createQuery("SELECT COUNT(c) FROM Country c");
			long countryCount3 = (Long) query3.getSingleResult();
			
			
			//4 use getSingleResult and TypedQuery
			TypedQuery<Long> query4 = em.createQuery("SELECT COUNT(c) FROM Country c", Long.class);
			long countryCount4 = query4.getSingleResult();
			
			
			//5 update query
			int count5 = em.createQuery("UPDATE Country SET area = 0").executeUpdate();
			
			
			//6 delete query
			int count6 = em.createQuery("DELETE FROM Country").executeUpdate();
			
			
			//7 named parameter
			TypedQuery<Country> query7 = em.createQuery("SELECT c FROM Country c WHERE c.name = :nm", Country.class);
			query7.setParameter("nm", "INDIA").getSingleResult();
			
			
			//8 ordinal parameter
			TypedQuery<Country> query8 = em.createQuery("SELECT c FROM Country c WHERE c.name = ?1", Country.class);
	        query8.setParameter(1, "INDIA").getSingleResult();
			
			
			//9 single path-expression
	        TypedQuery<Country> query9 = em.createQuery("SELECT c.name FROM Country c", Country.class);
			List<Country> results9 = query9.getResultList();
			
			
			//10 nested path-expression
			TypedQuery<Country> query10 = em.createQuery("SELECT c.capital.name FROM Country c", Country.class);
			List<Country> results10 = query10.getResultList();
			
			
			//11 multiple path-expression
			TypedQuery<Object[]> query11 = em.createQuery("SELECT c.name, c.capital.name FROM Country AS c", Object[].class);
	        List<Object[]> results11 = query11.getResultList();
			
			
			//12 multiple range variables
	        TypedQuery<Object[]> query12 = em.createQuery("SELECT c1, c2 FROM Country c1, Country c2", Object[].class);
	        List<Object[]> results12 = query12.getResultList();
			
			
	        //13 join (inner join)
	        TypedQuery<Object[]> query13 = em.createQuery("SELECT c1, c2 FROM Country c1 INNER JOIN c1.neighbors c2", Object[].class);
	        List<Object[]> results13 = query13.getResultList();
	        
	        
	        //14 left join (left outer join)
	        TypedQuery<Object[]> query14 = em.createQuery("SELECT c1, c2 FROM Country c1 INNER JOIN c1.neighbors c2", Object[].class);
	        List<Object[]> results14 = query14.getResultList();
			
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
