package mapping;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class Person2DAO {

	public static void main(String args[]) {

		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Person2 person = new Person2();
		person.setName("John");
		person.setId(1);

		Vehicle2 vehicle = new Vehicle2();
		Vehicle2 vehicle1 = new Vehicle2();

		vehicle.setName("Triumph");
		vehicle.setVehicleId(1);

		vehicle1.setName("BMW");
		vehicle1.setVehicleId(2);

		
		 person.getVehicle().add(vehicle); person.getVehicle().add(vehicle1);
		 

		/*vehicle.setPerson(person);
		vehicle1.setPerson(person);*/

		Session session = factory.openSession();

		session.beginTransaction();

		session.saveOrUpdate(vehicle);
		session.saveOrUpdate(vehicle1);

		session.saveOrUpdate(person);

		session.getTransaction().commit();

		System.out.println(" : Loading data now : \n");

		session = factory.openSession();

		Person2 person2 = (Person2) session.get(Person2.class, 1);

		System.out.println(person2.getName());
		System.out.println(person2.getVehicle().size());
		for (Vehicle2 ve : person2.getVehicle()) {
			System.out.println(ve.getName());
		}

		session.close();
	}
}
