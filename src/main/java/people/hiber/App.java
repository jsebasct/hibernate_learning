package people.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import people.hiber.dto.Address;
import people.hiber.dto.BankAccount;
import people.hiber.dto.UserDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	UserDetails ud = new UserDetails();
    	//ud.setUserId(2);
    	ud.setUserName("Pedro");
//    	ud.setAddress("Av Belgrano 955");
//    	ud.setJoinedDate(new Date());
//    	ud.setDescription("some descritpion");
    	
    	Address address = new Address();
    	address.setCity("Cochabamaba");
    	address.setStreet("Heroinas");
    	address.setPinCode("1234");
    	address.setState("someState");
    	
    	ud.setAddress(address);
    	
    	
    	BankAccount ac1 = new BankAccount();
    	ac1.setNumber(123456);
    	BankAccount ac2 = new BankAccount();
    	ac2.setNumber(234567);
    	
    	ud.getAccounts().add(ac1);
    	ud.getAccounts().add(ac2);
    	
    	// create a session factory
    	
//    	UserDetails ud2 = new UserDetails();
//    	ud2.setUserName("Juan Valdez");
    	
    	SessionFactory factory;// = new Configuration().configure().buildSessionFactory();
    	
    	factory = new MetadataSources( 
    			new StandardServiceRegistryBuilder()
    				.configure("hibernate.cfg.xml").build()
        	).buildMetadata().buildSessionFactory();
    	
    	
    	Session session = factory.openSession();
    	
    	// transaction
    	session.beginTransaction();
    	
    	// a mi me tira error pero no a los del video
//    	session.save(ac1);
//    	session.save(ac2);
    	
    	session.save(ud);
//    	session.save(ud2);
    	session.getTransaction().commit();
    	//sf.close();
    	
    	Session ss = factory.openSession();
    	ss.beginTransaction();
    	UserDetails user = ss.get(UserDetails.class, 1);
    	System.out.println( "user recovered: " + user.getUserName() );
    	
    	ss.getTransaction().commit();
    	ss.close();
    	
        System.out.println( "Finsh!" );
    }
}
