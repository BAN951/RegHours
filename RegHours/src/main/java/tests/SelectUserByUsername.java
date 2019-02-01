/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.List;
import net.reghours.datamodel.HibernateUtil;
import net.reghours.datamodel.entities.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class SelectUserByUsername {
    
    public static void main(String[] args) {
        
        String username = "benji";
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        Query q = session.createQuery("FROM User WHERE username = '" + username + "'");
        List result = q.list();
        User user = (User) result.get(0);
        
        System.out.println("User data, select by username: " + username);
        System.out.println("First name: " + user.getFirstname() + "\tLast name: " + user.getLastname());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPasswd());
        
        session.close();
        
    }
    
}
