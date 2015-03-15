/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaMysqlDB;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author nullmonkey
 */
@Entity
@Table(name = "person", catalog = "travel", schema = "")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPersonid", query = "SELECT p FROM Person p WHERE p.personid = :personid"),
    @NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name"),
    @NamedQuery(name = "Person.findByJobtitle", query = "SELECT p FROM Person p WHERE p.jobtitle = :jobtitle"),
    @NamedQuery(name = "Person.findByFrequentflyer", query = "SELECT p FROM Person p WHERE p.frequentflyer = :frequentflyer"),
    @NamedQuery(name = "Person.findByLastupdated", query = "SELECT p FROM Person p WHERE p.lastupdated = :lastupdated")})
public class Person implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "personid")
    private Integer personid;
    @Column(name = "name")
    private String name;
    @Column(name = "jobtitle")
    private String jobtitle;
    @Column(name = "frequentflyer")
    private Short frequentflyer;
    @Basic(optional = false)
    @Column(name = "lastupdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdated;

    public Person() {
    }

    public Person(Integer personid) {
        this.personid = personid;
    }
    
public Person(String name) {
           
        this.name = name;
        
     }
    
    
    
   public Person(Integer personid, String name, String jobtitle) {
     
        this.personid = personid;
        this.name = name;
        this.jobtitle = jobtitle;
     }

    public Person(Integer personid, Date lastupdated) {
        this.personid = personid;
        this.lastupdated = lastupdated;
    }

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        Integer oldPersonid = this.personid;
        this.personid = personid;
        changeSupport.firePropertyChange("personid", oldPersonid, personid);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        String oldJobtitle = this.jobtitle;
        this.jobtitle = jobtitle;
        changeSupport.firePropertyChange("jobtitle", oldJobtitle, jobtitle);
    }

    public Short getFrequentflyer() {
        return frequentflyer;
    }

    public void setFrequentflyer(Short frequentflyer) {
        Short oldFrequentflyer = this.frequentflyer;
        this.frequentflyer = frequentflyer;
        changeSupport.firePropertyChange("frequentflyer", oldFrequentflyer, frequentflyer);
    }

    public Date getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Date lastupdated) {
        Date oldLastupdated = this.lastupdated;
        this.lastupdated = lastupdated;
        changeSupport.firePropertyChange("lastupdated", oldLastupdated, lastupdated);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personid != null ? personid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personid == null && other.personid != null) || (this.personid != null && !this.personid.equals(other.personid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaMysqlDB.Person[ personid=" + personid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
