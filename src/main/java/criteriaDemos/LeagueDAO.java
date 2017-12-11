package criteriaDemos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

public class LeagueDAO {

	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		League l1 = new League("Barclays Premier League", "Manchester únited");
		League l2 = new League("La Liga", "Barcelona FC");
		League l3 = new League("Ligue 1", "Paris Saint German");
		League l4 = new League("UEFA Premier League", "Real Madira");
		
		
		
		
		Session session = factory.openSession();
		
		
		
		
		
		Transaction transaction = session.beginTransaction();
		
		session.save(l1);
		System.out.println("League with Id : "+l1.getId()+" persisted.");
		session.save(l2);
		System.out.println("League with Id : "+l2.getId()+" persisted.");
		session.save(l3);
		System.out.println("League with Id : "+l3.getId()+" persisted.");
		session.save(l4);
		System.out.println("League with Id : "+l4.getId()+" persisted.");
		
		transaction.commit();
		
		System.out.println("\n\n=====================================Loading Entitis now with criteria API========================================\n\n");
		
		transaction = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(League.class);
		SimpleExpression eq = Restrictions.eq("name","La Liga" );
		
		criteria.add(eq);
		
	List l = criteria.list();
	System.out.println("\nReqd League : "+((League)l.get(0)).getName());
	
	transaction.commit();
	
	System.out.println("Demo Done");
		
		
	}

}
