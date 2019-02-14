/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.datamodel.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Benjamin Adam Nagy
 */
@Entity
@Table(name = "TIMERECORD", catalog = "REGHOURS", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timerecord.findAll", query = "SELECT t FROM Timerecord t")
    , @NamedQuery(name = "Timerecord.findByIdRecord", query = "SELECT t FROM Timerecord t WHERE t.idRecord = :idRecord")
    , @NamedQuery(name = "Timerecord.findByRecord", query = "SELECT t FROM Timerecord t WHERE t.record = :record")
    , @NamedQuery(name = "Timerecord.findByType", query = "SELECT t FROM Timerecord t WHERE t.type = :type")})
public class Timerecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRecord")
    private Integer idRecord;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "record")
    @Temporal(TemporalType.TIMESTAMP)
    private Date record;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "type")
    private String type;
    
    @JoinColumn(name = "user", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private User user;

    public Timerecord() {}

    public Timerecord(Integer idRecord) {
        this.idRecord = idRecord;
    }

    public Timerecord(Integer idRecord, Date record, String type) {
        this.idRecord = idRecord;
        this.record = record;
        this.type = type;
    }
    
    public Timerecord(Date record, String type, User user) {
        this.record = record;
        this.type = type;
        this.user = user; 
    }
    
    public String getDateTimeDifference(Date dateTime1, Date dateTime2) throws ParseException {
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       
        long diff = dateTime1.getTime() - dateTime2.getTime();
        Date result = new Date(); 
        result.setTime(diff);
        
        String format = df.format(result);
        return format;
    }
    
    /**
     * Returns the difference between two dates in a string format. 
     * Depending on the diference it will return only hours and minutes, 
     * or days, hours and minutes.
     * 
     * @param firstDate
     * @param secondDate
     * @return formatted string describing the difference in date and time
     */
    public String getDifference(Date firstDate, Date secondDate) {
        
        String result = "";
        if(firstDate != null && secondDate != null) {
            try {
                String[] first = firstDate.toString().split(" ");
                String[] second = secondDate.toString().split(" ");

                long days = getDifferenceBetweenDatesInDays(first[0], second[0]);
                long minutes = getDifferenceInTime(first[1], second[1]);

                if(days != 0) result = days + " days ";

                if (minutes == 60) {
                    result = result = "1 hour";
                } else {
                    if (minutes > 60) {
                        result = result + (minutes / 60) + " hours " + (minutes % 60) + " minutes";
                    } else {
                        if(minutes < 1 || minutes == 0) 
                        result = "less then 1 minute";
                        else
                        result = result + minutes + " minutes";
                    }
                }
            } 
            catch (ParseException pe) {
                pe.getMessage(); 
            }
            }
        return result;
    }
    
    /**
     * Take two times in string format: HH:mm:ss; and calculates the diferrence 
     * between them, returns a long representing the minutes passed between the two
     * times.
     * 
     * @return diference in minutes
     */
    private long getDifferenceInTime(String time1, String time2) throws ParseException {
        
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        Date firstTime = timeFormatter.parse(time1);
        Date secondTime = timeFormatter.parse(time2);
        
        long diffMs = Math.abs(secondTime.getTime() - firstTime.getTime());
        return (TimeUnit.MINUTES.convert(diffMs, TimeUnit.MILLISECONDS));
    }
    
    /**
     * 
     * Calculates the difference between two dates in days. Format yyyy-MM-dd.
     * The dates are passed as strings. Returns a long representing the differnce
     * in days between the two dates. Return 0 if it is the same day.
     * 
     * @param date1
     * @param date2
     * @return diference in days
     * @throws ParseException 
     */
    private long getDifferenceBetweenDatesInDays(String date1, String date2) throws ParseException {
        
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate = dateFormatter.parse(date1);
        Date secondDate = dateFormatter.parse(date2);
        
        long diffMs = Math.abs(secondDate.getTime() - firstDate.getTime());
        return (TimeUnit.DAYS.convert(diffMs, TimeUnit.MILLISECONDS));
    }
    
    /**
     * 
     * @param recordType 
     */
    public void setType(Enum recordType) {
        this.type = recordType.toString();
    }
    
    /**
     * Takes the datetime from the database, splits it in two parts 
     * and returns the first part. The date part as a String.
     * Format: yy-mm-dd
     * 
     * @return 
     */
    public String getFormattedDate() {
        return this.record.toString().split(" ")[0];
    }
    
    /**
     * Takes the datetime from the database, splits it in two parts 
     * and returns the second part. The time part as a String.
     * Format: hh:mm:ss
     * 
     * 
     * @return 
     */
    public String getFormattedTime() {
        return this.record.toString().split(" ")[1];
    }

    public Integer getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(Integer idRecord) {
        this.idRecord = idRecord;
    }

    public Date getRecord() {
        return record;
    }

    public void setRecord(Date record) {
        this.record = record;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecord != null ? idRecord.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timerecord)) {
            return false;
        }
        Timerecord other = (Timerecord) object;
        if ((this.idRecord == null && other.idRecord != null) || (this.idRecord != null && !this.idRecord.equals(other.idRecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.reghours.datamodel.entities.Timerecord[ idRecord=" + idRecord + " ]" 
                + ", Record: " + record + ", Type: " + type + ", User: " + user;
    }

    
    
}
