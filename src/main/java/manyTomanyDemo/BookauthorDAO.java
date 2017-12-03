package manyTomanyDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;

public class BookauthorDAO {

	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		
		Session session=factory.openSession();
		session.beginTransaction();
		
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		Book b4 = new Book();
		Author a1 = new Author();
		Author a2 = new Author();
		
		b1.setName("Spring in Action");
		b2.setName("Hibernate in action");
		b3.setName("JAX-RS in action");
		b4.setName("Spring boot in action in action");
		
		a1.setAuth_id(1);
		a2.setAuth_id(2);
		
		a1.setAuth_Name("Khalid Mughal");
		a1.setAuth_Name("Kathy Sierra");
		
		b1.getAuth().add(a1);
		b1.getAuth().add(a2);
		b3.getAuth().add(a2);
		b2.getAuth().add(a2);
		
		
		
		
		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		
		Author author = (Author) session.get(Author.class, 2);
		
		Assert.assertEquals(2, author.getAuth_id());
		System.out.println("Done");
		session.close();
	}
}
