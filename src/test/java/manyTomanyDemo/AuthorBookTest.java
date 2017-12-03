package manyTomanyDemo;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import embedableIdDemo.EmbedableIdDemo;



public class AuthorBookTest {
	
	private SessionFactory sessionFactory;
    private Session session = null;
	
	
	
	
	
	@Test
	public void bookAuthorDAO() {
		
		
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
		
		
		
		
		Author author = (Author) session.get(Author.class, 2);
		
		Assert.assertEquals(2, author.getAuth_id());
		System.out.println("Done");
		
		
		
	}
	 // Run once, e.g. Database connection, connection pool
    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass - runOnceBeforeClass");
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass - runOnceAfterClass");
    }

    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @Before
    public void runBeforeTestMethod() {
    	System.out.println("@Before ");
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
			
			sessionFactory = new AnnotationConfiguration()
		   .addPackage("manyTomanyDemo")
				   .addProperties(prop)
				   .addAnnotatedClass(Book.class)
				   .addAnnotatedClass(Author.class)
				   .buildSessionFactory();
			
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
    	
    	session = sessionFactory.openSession();
    }

    // Should rename to @AfterTestMethod
    @After
    public void runAfterTestMethod() {
    	System.out.println("@After ");
    	   session.close();
    	   sessionFactory.close();
    }

}
