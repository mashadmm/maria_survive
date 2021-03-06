package com.muni.fi.pa165.entities;

import com.muni.fi.pa165.enums.WeaponClass;
import com.muni.fi.pa165.enums.WeaponType;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Auron
 */
@Entity
@Table(name = "WEAPON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Weapon.findAll", query = "SELECT w FROM Weapon w"),
    @NamedQuery(name = "Weapon.findById", query = "SELECT w FROM Weapon w WHERE w.id = :id"),
    @NamedQuery(name = "Weapon.findByCaliber", query = "SELECT w FROM Weapon w WHERE w.caliber = :caliber"),
    @NamedQuery(name = "Weapon.findByDescription", query = "SELECT w FROM Weapon w WHERE w.description = :description"),
    @NamedQuery(name = "Weapon.findByName", query = "SELECT w FROM Weapon w WHERE w.name = :name"),
    @NamedQuery(name = "Weapon.findByRange", query = "SELECT w FROM Weapon w WHERE w.range = :range"),
    @NamedQuery(name = "Weapon.findByRounds", query = "SELECT w FROM Weapon w WHERE w.rounds = :rounds"),
    @NamedQuery(name = "Weapon.findByWeaponclass", query = "SELECT w FROM Weapon w WHERE w.weaponclass = :weaponclass"),
    @NamedQuery(name = "Weapon.findByWeapontype", query = "SELECT w FROM Weapon w WHERE w.weapontype = :weapontype")})
public class Weapon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CALIBER")
    private Double caliber;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "NAME")
    private String name;
    @Column(name = "RANGE")
    private Integer range;
    @Column(name = "ROUNDS")
    private Integer rounds;
    @Column(name = "WEAPONCLASS")
    @Enumerated(EnumType.ORDINAL)
    private WeaponClass weaponclass;
    @Column(name = "WEAPONTYPE")
    @Enumerated(EnumType.ORDINAL)
    private WeaponType weapontype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weapon")
    private Collection<Monsterweapon> monsterweaponCollection;

    public Weapon() {
    }

    public Weapon(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCaliber() {
        return caliber;
    }

    public void setCaliber(Double caliber) {
        this.caliber = caliber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getRounds() {
        return rounds;
    }

    public void setRounds(Integer rounds) {
        this.rounds = rounds;
    }

    public WeaponClass getWeaponclass() {
        return weaponclass;
    }

    public void setWeaponclass(WeaponClass weaponclass) {
        this.weaponclass = weaponclass;
    }

    public WeaponType getWeapontype() {
        return weapontype;
    }

    public void setWeapontype(WeaponType weapontype) {
        this.weapontype = weapontype;
    }



    @XmlTransient
    public Collection<Monsterweapon> getMonsterweaponCollection() {
        return monsterweaponCollection;
    }

    public void setMonsterweaponCollection(Collection<Monsterweapon> monsterweaponCollection) {
        this.monsterweaponCollection = monsterweaponCollection;
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
        if (!(object instanceof Weapon)) {
            return false;
        }
        Weapon other = (Weapon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.muni.fi.pa165.entities.Weapon[ id=" + id + " ]";
    }
    
}
