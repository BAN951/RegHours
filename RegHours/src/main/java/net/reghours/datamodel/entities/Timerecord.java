/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.reghours.datamodel.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
 * @author admin
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
    
    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "type")
    private String type;
    
    @JoinColumn(name = "user", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private User user;
    

    public Timerecord() {
    }

    public Timerecord(Integer idRecord) {
        this.idRecord = idRecord;
    }

    public Timerecord(Integer idRecord, Date record, String type) {
        this.idRecord = idRecord;
        this.record = record;
        this.type = type;
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
        return "net.reghours.datamodel.entities.Timerecord[ idRecord=" + idRecord + " ]";
    }
    
}
