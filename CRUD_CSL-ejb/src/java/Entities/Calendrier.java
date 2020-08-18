/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author baggins
 */
@Entity
@Table(name = "CALENDRIER", catalog = "", schema = "BAGGINS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendrier.findAll", query = "SELECT c FROM Calendrier c")
    , @NamedQuery(name = "Calendrier.findByNbrJour", query = "SELECT c FROM Calendrier c WHERE c.nbrJour = :nbrJour")
    , @NamedQuery(name = "Calendrier.findByDateJour", query = "SELECT c FROM Calendrier c WHERE c.dateJour = :dateJour")})
public class Calendrier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NBR_JOUR")
    private Integer nbrJour;
    @Column(name = "DATE_JOUR")
    @Temporal(TemporalType.DATE)
    private Date dateJour;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calendrier")
    private Collection<PresenceEtudiant> presenceEtudiantCollection;

    public Calendrier() {
    }

    public Calendrier(Integer nbrJour) {
        this.nbrJour = nbrJour;
    }

    public Integer getNbrJour() {
        return nbrJour;
    }

    public void setNbrJour(Integer nbrJour) {
        this.nbrJour = nbrJour;
    }

    public Date getDateJour() {
        return dateJour;
    }

    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
    }

    @XmlTransient
    public Collection<PresenceEtudiant> getPresenceEtudiantCollection() {
        return presenceEtudiantCollection;
    }

    public void setPresenceEtudiantCollection(Collection<PresenceEtudiant> presenceEtudiantCollection) {
        this.presenceEtudiantCollection = presenceEtudiantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nbrJour != null ? nbrJour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendrier)) {
            return false;
        }
        Calendrier other = (Calendrier) object;
        if ((this.nbrJour == null && other.nbrJour != null) || (this.nbrJour != null && !this.nbrJour.equals(other.nbrJour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Calendrier[ nbrJour=" + nbrJour + " ]";
    }
    
}
