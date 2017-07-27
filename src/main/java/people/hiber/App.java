package people.hiber;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
    	ud.setUserId(2);
    	ud.setUserName("Pedro");
    	ud.setAddress("Av Belgrano 955");
    	ud.setJoinedDate(new Date());
    	ud.setDescription("some descritpion");
    	// create a session factory
    	SessionFactory factory;// = new Configuration().configure().buildSessionFactory();
    	
    	factory = new MetadataSources( 
    			new StandardServiceRegistryBuilder()
    				.configure("hibernate.cfg.xml").build()
        	).buildMetadata().buildSessionFactory();
    	
    	
    	Session session = factory.openSession();
    	
    	// transaction
    	session.beginTransaction();
    	session.save(ud);
    	session.getTransaction().commit();
    	//sf.close();
    	
    	Session ss = factory.openSession();
    	ss.beginTransaction();
    	UserDetails user = ss.get(UserDetails.class, 2);
    	System.out.println( "user recovered: " + user.getUserName() );
    	
    	ss.getTransaction().commit();
    	ss.close();
    	
        System.out.println( "Finsh!" );
    }
}
