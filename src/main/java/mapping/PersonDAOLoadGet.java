package mapping;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class PersonDAOLoadGet {
	public static void main(String args[]) {

		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		Person2 person = (Person2) session.get(Person2.class, 1);
		
		session.close();
		
		System.out.println(person.getName());
		
	}		
}
