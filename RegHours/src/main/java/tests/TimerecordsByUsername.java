/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.List;
import net.reghours.datamodel.HibernateUtil;
import net.reghours.datamodel.entities.Timerecord;
import net.reghours.datamodel.entities.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class TimerecordsByUsername {
    
    public static void main(String[] args) {
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        User user = (User) session.getNamedQuery("User.findByUsername")
                .setParameter("username", "Benji")
                .list()
                .get(0);
        System.out.println("Username: " + user.getUsername());
        System.out.println("Timerecords:");
        List<Timerecord> records = (List<Timerecord>) user.getTimerecordCollection();
        for(Timerecord record : records) {
            System.out.println("Sifu");
            System.out.println("Record: " + record.getRecord());
        }
        
        
        
//        user.getTimerecordCollection().forEach();
        
//        User u = (User) result.get(0);
//        List<Timerecord> records = (List<Timerecord>) u.getTimerecordCollection();
//        for(Timerecord r : records) {
//            System.out.println("Record ID: " + r.getIdRecord());
//            System.out.println("Record: " + r.getRecord());
//            System.out.println("Type: " + r.getType());
//            System.out.println("User: " + u.getUsername());
//        }
        
        
        session.close();
        
//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session session = sf.openSession();
//        
//        String hql = "SELECT t"
//                   + "FROM Timerecord t LEFT JOIN User u ON t.user = u.userId AND"
//                   + "u.username = '" + "Benji" + "'";
//        Query q = session.createQuery("SELECT * FROM Timerecord");
//        List<Timerecord> records = q.list();
//        
//        for(Timerecord r : records) {
//            System.out.println("idRecord: " + r.getIdRecord());
//            sys
//        }
//        
//        session.close();
    }
}
