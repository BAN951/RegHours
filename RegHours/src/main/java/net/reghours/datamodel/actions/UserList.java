/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.datamodel.actions;

import java.util.List;
import net.reghours.datamodel.HibernateUtil;
import net.reghours.datamodel.entities.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class UserList {
    
    public UserList() {}
    
    public List<User> getAllUsers() throws HibernateException {
       
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        Query q = session.createQuery("FROM User");
        List<User> users = q.list();

        session.close();

        return users;
     
    }
    
    public void addNewUser(User newUser) throws HibernateException {
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        session.save(newUser);
        
        session.getTransaction().commit();
        session.close();
        
    }
    
    public User getUserByUsername(String username) throws HibernateException {
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        Query q = session.createQuery("FROM User WHERE username = '" + username + "'");
        List result = q.list();
        User user = (User) result.get(0);
        
        session.close();
        
        return user;
    }
    
}
