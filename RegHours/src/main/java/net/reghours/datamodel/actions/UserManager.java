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
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class UserManager {
    
    public UserManager() {}
    
    public List<User> getAllUsers() throws HibernateException {
       
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        List<User> users = (List<User>) session.getNamedQuery("User.findAll").list();

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
        
        User user = (User) session.getNamedQuery("User.findByUsername")
                .setParameter("username", username)
                .list()
                .get(0);
        
        session.close();
        
        return user;
    }
    
}
