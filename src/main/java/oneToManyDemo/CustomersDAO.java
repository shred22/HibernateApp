package oneToManyDemo;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



@SuppressWarnings("deprecation")
public class CustomersDAO {

	
		private static final SessionFactory concreteSessionFactory;
		static {
			try {

				Properties prop= new Properties();
				prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
				prop.setProperty("hibernate.connection.username", "root");
				prop.setProperty("hibernate.connection.password", "root");
				prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");
				prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
				//prop.setProperty("hbm2ddl.auto", "create-drop");
				prop.setProperty("show_sql", "true");
				
				//prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
				
				concreteSessionFactory = new AnnotationConfiguration()
			   .addPackage("oneToManyDemo")
					   .addProperties(prop)
					   .addAnnotatedClass(Customers.class)
					   .addAnnotatedClass(Orders.class)
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
			
			
			Customers c1 = new Customers();
			c1.setCust_id(1);
			c1.setCust_name("Jonas Blue");
			
			Customers c2 = new Customers();
			c2.setCust_id(2);
			c2.setCust_name("David off");
			
			
			Orders o1 = new Orders();
			Orders o2 = new Orders();
			Orders o3 = new Orders();
			
			o1.setOrder_id(100);
			o2.setOrder_id(101);
			o3.setOrder_id(103);
			
			o1.setName("ThermoSteel Milton");
			o2.setName("Hp Mouse");
			o3.setName("Creative speaker");
			
			o1.setCust(c1);
			o2.setCust(c2);
			o3.setCust(c1);
			
			session.persist(c1);
			session.persist(c2);
			session.persist(o1);
			session.persist(o2);
			session.persist(o3);
			
			session.getTransaction().commit();
			session.close();
			
			System.out.println("Done");
		}
	
}
