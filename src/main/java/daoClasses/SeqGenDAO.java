package daoClasses;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Property;

public class SeqGenDAO {
	private static final SessionFactory concreteSessionFactory;
	static {
		try {

			Properties prop= new Properties();
			prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate");
			prop.setProperty("hibernate.connection.username", "root");
			prop.setProperty("hibernate.connection.password", "");
			prop.setProperty("hibernate.hbm2ddl.auto", "update");
			prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			prop.setProperty("hbm2ddl.auto", "create-drop");
			prop.setProperty("show_sql", "true");
			
			prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
			
			concreteSessionFactory = new AnnotationConfiguration()
		   .addPackage("daoClasses")
				   .addProperties(prop)
				   .addAnnotatedClass(SeqDemo.class)
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
		
		SeqDemo s = new SeqDemo();
		s.setValue("Test Value");
		
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}

}
