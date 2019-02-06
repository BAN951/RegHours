/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import net.reghours.datamodel.entities.User;
import java.util.List;
import net.reghours.datamodel.HibernateUtil;
import org.hibernate.HibernateException;

/**
 *
 * @author admin
 */
public class DBtest {
    
    public static void main(String[] args) {
    
        try {
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
    
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM User");
            List<User> users = query.list();

            int i = 1;
            System.out.println("All users in database: \n");
            for(User u : users) {
                System.out.println("User " + i);
                System.out.println("Username: " + u.getUsername());
                System.out.println("First name: " + u.getFirstname());
                System.out.println("Last name: " + u.getLastname());
                System.out.println("Email: " + u.getEmail());
                System.out.println("ID: " + u.getUserId());
                i++;
            }

            session.getTransaction().commit();
            session.close();
        
        } catch(HibernateException e) {
            e.getMessage();
        }
        
    }
}
