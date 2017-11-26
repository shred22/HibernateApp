package daoClasses;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class TableGenDAO {
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
				   .addAnnotatedClass(TableGenDemo.class)
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
		
		TableGenDemo s = new TableGenDemo();
		s.setValue("Test Value 1");
		
		TableGenDemo s1 = new TableGenDemo();
		s1.setValue("Test Value 2");
		
		session.save(s);
		session.save(s1);
		session.getTransaction().commit();
		session.close();
		System.out.println("Done");
	}
	
}
