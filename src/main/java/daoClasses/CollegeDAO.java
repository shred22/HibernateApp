package daoClasses;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CollegeDAO {

	public static void main(String args[]) {
		SessionFactory factory = new Configuration().
		         configure().
		         //addPackage("com.xyz") //add package if used.
		         //addAnnotatedClass(Student.class).
		         buildSessionFactory();
		
		Session session=factory.openSession();
    	session.beginTransaction();
    	
    	College c=new College(1,"S.S.P.C");
    	session.persist(c);
        Student s1=new Student(1,"Atul",1);
        session.persist(s1);
        Student s2=new Student(2,"Saurabh",1);
        session.persist(s2);
    		    	
       	session.getTransaction().commit();
       	session.refresh(c);
       	College ob=(College)session.get(College.class, new Integer(1));
       	Set<String> names=ob.getStudents();
       	for(String s:names){
       		System.out.println(s);	
       	}
		
	}
}
