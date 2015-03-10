
package br.com.cadei.dao;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            
            sessionFactory = new Configuration().configure("br/com/cadei/config/pgsql_hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            
            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
