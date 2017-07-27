package people.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
    	ud.setUserId(1);
    	ud.setUserName("Juan");
    	
    	// create a session factory
    	SessionFactory sf = new Configuration().configure().buildSessionFactory();
    	
//    	sf = new MetadataSources( 
//    			new StandardServiceRegistryBuilder()
//    				.configure("hibernate.cfg.xml").build()
//        	).buildMetadata().buildSessionFactory();
    	
    	
    	Session session = sf.openSession();
    	
    	// transaction
    	session.beginTransaction();
    	session.save(ud);
    	session.getTransaction().commit();
    	
        System.out.println( "Finsh!" );
    }
}
