package classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static {
		try {
			
			sessionFactory=new Configuration()
					.configure("res/hibernate.cfg.xml")
					.buildSessionFactory();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
