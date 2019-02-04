/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.List;
import net.reghours.datamodel.HibernateUtil;
import net.reghours.datamodel.entities.Timerecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class GetAllTimerecordsByUsernameOrUSer {
    
    public static void main(String[] args) {
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        String query = "select t.idRecord, t.record, t.type"
                     + "from Timerecord t inner join t.user on user.userId";
        List<Timerecord> result = (List<Timerecord>) session
                .createQuery("select t from Timerecord t inner join t.user as u where u.username='Benji'")
                .list();
        
        for(Timerecord t : result) {
            System.out.println("Result: " + t);
        }
        
        session.close();
    }
}
