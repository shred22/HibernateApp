package criteriaDemos;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

@SuppressWarnings("deprecation")
public class LeagueDAO {
	private static SessionFactory factory;
	
	static {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public static void main(String[] args) {
		//createAndPersistLeagues();
		//leaguesPlayedByRonaldo();
		//findPlayerWhoPlaysAllLeagues();
		findLeagueWithCriteria();
	}
	
	private static void findLeagueWithCriteria() {
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(League.class);
		criteria.setProjection(Projections.rowCount());
		

		List<League> list = criteria.list();
		System.out.println("Row Count in League Table : "+list.get(0));
		criteria.setProjection(Projections.count("winnner"));
		list = criteria.list();
		System.out.println("Count Of winnner column in League table  : "+list.get(0));
		criteria.setProjection(Projections.max("id"));
		list = criteria.list();
		System.out.println("Max Id in League table  : "+list.get(0));
		criteria.setProjection(Projections.sum("id"));
		list = criteria.list();
		System.out.println("Sum of Id column in League table  : "+list.get(0));
		
		
		
		session.getTransaction().commit();
		session.close();
		factory.close();
		
	}

	public static void findPlayerWhoPlaysAllLeagues() {
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		SQLQuery query = session.createSQLQuery("select * from player_leagues");
		List list = query.list();
		System.out.println("Class Name : "+list.get(0).getClass().getName());
		System.out.println(list);
		
		System.out.println("Printing object array");
		Object[] playerLeagues = (Object[])list.get(0);
		for(int i=0;i<playerLeagues.length;i++) {
			System.out.println(playerLeagues[0]);
		}
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	public static void leaguesPlayedByRonaldo() {
		Session session = factory.openSession();
		
		session.beginTransaction();
		Player player = (Player) session.get(Player.class, 1);
		Set<League> leagues = player.getLeagues();
		session.getTransaction().commit();
		System.out.println("Leagues played by ronaldo : "+leagues);
		session.close();
		factory.close();
	}
	
	public static void createAndPersistLeagues() {
		

		League l1 = new League("Barclays Premier League", "Manchester únited");
		League l2 = new League("La Liga", "Barcelona FC");
		League l3 = new League("Ligue 1", "Paris Saint German");
		League l4 = new League("UEFA Premier League", "Real Madrid");
		
		Player p1= new Player("Ronaldo", "Portugese");
		Player p2= new Player("Lio Messi", "Argentina");
		Player p3= new Player("Ibrahimovic", "Sweden");
		Player p4= new Player("T Kroos", "Dutchsland");
		
		p1.getLeagues().add(l1);
		p1.getLeagues().add(l2);
		p1.getLeagues().add(l3);
		p1.getLeagues().add(l4);
		
		p2.getLeagues().add(l1);
		p2.getLeagues().add(l2);
		
		p3.getLeagues().add(l3);
		
		p4.getLeagues().add(l4);
		
		l1.getPlayers().add(p1);
		l1.getPlayers().add(p2);
		
		l2.getPlayers().add(p1);
		l2.getPlayers().add(p2);
		
		l3.getPlayers().add(p1);
		l3.getPlayers().add(p3);
		
		l4.getPlayers().add(p1);
		l4.getPlayers().add(p4);
		
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		
		
		session.save(p1);
		System.out.println("Player with Id : " + p1.getPlayerId() + " persisted.");
		session.save(p2);
		System.out.println("Player with Id : " + p2.getPlayerId() + " persisted.");
		session.save(p3);
		System.out.println("Player with Id : " + p3.getPlayerId() + " persisted.");
		session.save(p4);
		System.out.println("Player with Id : " + p4.getPlayerId() + " persisted.");		
		
		
		
		session.save(l1);
		System.out.println("League with Id : " + l1.getId() + " persisted.");
		session.save(l2);
		System.out.println("League with Id : " + l2.getId() + " persisted.");
		session.save(l3);
		System.out.println("League with Id : " + l3.getId() + " persisted.");
		session.save(l4);
		System.out.println("League with Id : " + l4.getId() + " persisted.");
		
		
		transaction.commit();

		System.out.println(
				"\n\n=====================================Loading Entities now with criteria API========================================\n\n");

		transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(League.class);
		/*
		 * SimpleExpression eq = Restrictions.eq("name","La Liga" );
		 * 
		 * criteria.add(eq);
		 */

		criteria.setProjection(Projections.property("name"));
		criteria.addOrder(Order.asc("name"));

		List<League> l = criteria.list();
		System.out.println("\nReqd League : " + (l.get(0)));

		/*for (Iterator<League> iterator = l.iterator(); iterator.hasNext();) {
			System.out.println((String) iterator.next());
		}*/

		transaction.commit();
		session.close();
		factory.close();

		System.out.println("Demo Done");

	}

}
