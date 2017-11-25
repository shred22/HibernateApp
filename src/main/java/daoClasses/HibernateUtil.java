package daoClasses;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtil {
	
	
	public static void main(String args[]) {
	
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
	/*	
		UserDetails user1 = new UserDetails("Bob Sinchlar", "bob@gmail.com");
		UserDetails user2 = new UserDetails("Dhammu", "dhammu@gmail.com");
				
		session.beginTransaction();		
		session.persist(user1);
		session.persist(user2);	
		
		session.getTransaction().commit();
		

		session.beginTransaction();
		Address add1 = new Address("Aundh",3,user2.getUserId());
		Address add2 = new Address("Shivaji nagar", 4,user2.getUserId());
		
		session.persist(add1);

		session.persist(add2);
		session.getTransaction().commit();*/
		
		
		session = factory.openSession();
		System.out.println("Loading now......");
	
		
		
	
	
		UserDetails user3 = (UserDetails) session.get(UserDetails.class, 54);
		System.out.println(user3.getEmail());
		List<String> names=user3.getUserAddresses();
       	for(String s:names){
       		System.out.println(s);	
       	}
       	System.out.println("Done verything");
       	
	}
}
