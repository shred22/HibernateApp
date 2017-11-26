package embedableIdDemo;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



@SuppressWarnings("deprecation")
public class EmbedableIdDAO {
	private static final SessionFactory concreteSessionFactory;
	static {
		try {

			Properties prop= new Properties();
			prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
			prop.setProperty("hibernate.connection.username", "root");
			prop.setProperty("hibernate.connection.password", "root");
			prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");
			prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			prop.setProperty("hbm2ddl.auto", "create-drop");
			prop.setProperty("show_sql", "true");
			
			prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
			
			concreteSessionFactory = new AnnotationConfiguration()
		   .addPackage("daoClasses")
				   .addProperties(prop)
				   .addAnnotatedClass(EmbedableIdDemo.class)
				   .buildSessionFactory();
			
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static Session getSession() throws HibernateException {
		return concreteSessionFactory.openSession();
	}
	
public static void main(String... args) {
		
		Session session = getSession();
		session.beginTransaction();
		
		IDclass id = new IDclass();
		IDclass id1 = new IDclass();
		
		
		id.setName("Jeff");id.setRollNo("A1");
		id1.setName("Shawn");id1.setRollNo("A2");

		EmbedableIdDemo s = new EmbedableIdDemo();
		s.setValue("Test Value Embeded 1");
		s.setId(id);
		
		EmbedableIdDemo s1 = new EmbedableIdDemo();
		s1.setValue("Test Value Embeded 2");
		s1.setId(id1);
		session.save(s);
		session.save(s1);
		session.getTransaction().commit();
		session.close();
		System.out.println("Done");
	}
}
