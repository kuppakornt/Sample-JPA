package web;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

class Terminal {
	public static void main(String[] data) {
		var factory = Persistence.createEntityManagerFactory("primary");
		var manager = factory.createEntityManager();
		
		String jpql = " select s from Staff s   " +  " where s.salary >= :slr  ";
		Query q = manager.createQuery(jpql);
		q.setParameter("slr", 70000);
		ArrayList a = (ArrayList)q.getResultList();
		for (int i = 0; i < a.size(); i++) {
			entity.Staff s = (entity.Staff)a.get(i);
			System.out.println(s.firstName);
		}
		manager.close(); factory.close();
	}
	
	public static void main1(String[] data) {
		System.out.println("Welcome to market.");
		entity.Staff s = new entity.Staff();
		s.firstName = "Noon";
		s.lastName  = "THONG";
		s.email     = "NoonT@gmail.com";
		s.salary    = 60000;
		
		EntityManagerFactory factory;
		factory = Persistence.createEntityManagerFactory("primary");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(s);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}