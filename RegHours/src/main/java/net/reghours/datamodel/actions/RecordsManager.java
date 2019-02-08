/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.datamodel.actions;

import java.util.Date;
import java.util.List;
import net.reghours.datamodel.entities.Timerecord;
import net.reghours.datamodel.entities.User;
import static net.reghours.types.TimerecordType.*;
import net.reghours.datamodel.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Manages a users timerecords. 
 * Works with the basic operations of a CRUD. It creates, reads, updates and deletes
 * records of a user which is selected by username or by the user object itself in some cases.
 * 
 * @author Benjamin Adam Nagy
 */
public class RecordsManager {
    
    public RecordsManager() {}
    
    public void addTimerecord(Enum recordType, User user) {
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        Timerecord tr = new Timerecord();
        tr.setRecord(new Date());
        tr.setType(recordType);
        tr.setUser(user);
        
        session.beginTransaction();
        session.save(tr);
        session.getTransaction().commit();
        session.close();
    }
    
    public void addTimerecord(Timerecord record) {
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        session.beginTransaction();
        session.save(record);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Timerecord> getTimerecords(String username) {
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        List<Timerecord> records = (List<Timerecord>) session
                .createQuery("select t from Timerecord t inner join t.user as u where u.username='" + username + "'")
                .list();
        
        session.close();
        return records;
    }
    
    public Enum getLastRecordType(String username) {

        List<Timerecord> records = getTimerecords(username);
        Timerecord lastRecord = records.get(records.size() - 1);
        
        if("ENTRY".equals(lastRecord.getType()))
            return ENTRY;
        else 
            return EXIT;
    }
    
    public boolean emptyRecordList(String username) {
        
        List<Timerecord> records = getTimerecords(username);
        return records.size() < 1;
        
    }
    
}
