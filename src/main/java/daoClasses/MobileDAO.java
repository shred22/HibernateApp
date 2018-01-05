package daoClasses;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MobileDAO {
	public static void main(String args[]) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();

		
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		Mobile m = new Mobile();
		m.setId(1);
		m.setModelName("HTC");

		//session.refresh(m);
		
		Mobile mob = (Mobile)session.get(Mobile.class, 1);
		Criteria criteria = session.createCriteria(Mobile.class);
		
		Query query = session.createQuery("from Mobile where id=1");
		List l = query.list();
		System.out.println("Query Res : "+l);
		List<Mobile> list = criteria.list();
		session.getTransaction().commit();
		System.out.println(list);
		System.out.println(mob.getId()+" "+mob.getModelName());
		System.out.println("Done");
		session.close();
		
	}
}
