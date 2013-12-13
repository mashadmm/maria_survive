package com.muni.fi.pa165.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Auron
 */
@Entity
@Table(name = "GENERICENTITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genericentity.findAll", query = "SELECT g FROM Genericentity g"),
    @NamedQuery(name = "Genericentity.findById", query = "SELECT g FROM Genericentity g WHERE g.id = :id"),
    @NamedQuery(name = "Genericentity.findByName", query = "SELECT g FROM Genericentity g WHERE g.name = :name")})
public class Genericentity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    public Genericentity() {
    }

    public Genericentity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genericentity)) {
            return false;
        }
        Genericentity other = (Genericentity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.muni.fi.pa165.dao.impl.Genericentity[ id=" + id + " ]";
    }
    
}
