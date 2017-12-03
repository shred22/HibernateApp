package mapping;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class PersonDAOUtil {
	public static void main(String args[]) {

		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession();

		Person person = new Person();
		Person person1 = new Person();
		Vehicle vehicle = new Vehicle();

		vehicle.setName("Triumph");
		Vehicle vehicle1 = new Vehicle();

		vehicle1.setName("BMW");

		person.setName("Debu");
		person1.setName("Nick");
		
		person.getVehicle().add(vehicle);
		person1.getVehicle().add(vehicle);
		
		vehicle.getOwner().add(person);
		vehicle1.getOwner().add(person);
		
		session.beginTransaction();

		session.persist(vehicle);
		session.persist(vehicle1);
		session.persist(person);
		session.persist(person1);

		session.getTransaction().commit();

		System.out.println("Done");
		
			
		Vehicle vehicle2 = (Vehicle) session.get(Vehicle.class, 1);
		
		System.out.println(vehicle2.getName());
		
	}
}
