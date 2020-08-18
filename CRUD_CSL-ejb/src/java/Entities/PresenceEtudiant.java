/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author baggins
 */
@Entity
@Table(name = "PRESENCE_ETUDIANT", catalog = "", schema = "BAGGINS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresenceEtudiant.findAll", query = "SELECT p FROM PresenceEtudiant p")
    , @NamedQuery(name = "PresenceEtudiant.findByNbrJour", query = "SELECT p FROM PresenceEtudiant p WHERE p.presenceEtudiantPK.nbrJour = :nbrJour")
    , @NamedQuery(name = "PresenceEtudiant.findByIdEtudiant", query = "SELECT p FROM PresenceEtudiant p WHERE p.presenceEtudiantPK.idEtudiant = :idEtudiant")
    , @NamedQuery(name = "PresenceEtudiant.findByPresentOn", query = "SELECT p FROM PresenceEtudiant p WHERE p.presentOn = :presentOn")})
public class PresenceEtudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresenceEtudiantPK presenceEtudiantPK;
    @Size(max = 3)
    @Column(name = "PRESENT_ON")
    private String presentOn;
    @JoinColumn(name = "NBR_JOUR", referencedColumnName = "NBR_JOUR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Calendrier calendrier;
    @JoinColumn(name = "ID_ETUDIANT", referencedColumnName = "ID_ETUDIANT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etudiant etudiant;

    public PresenceEtudiant() {
    }

    public PresenceEtudiant(PresenceEtudiantPK presenceEtudiantPK) {
        this.presenceEtudiantPK = presenceEtudiantPK;
    }

    public PresenceEtudiant(int nbrJour, int idEtudiant) {
        this.presenceEtudiantPK = new PresenceEtudiantPK(nbrJour, idEtudiant);
    }

    public PresenceEtudiantPK getPresenceEtudiantPK() {
        return presenceEtudiantPK;
    }

    public void setPresenceEtudiantPK(PresenceEtudiantPK presenceEtudiantPK) {
        this.presenceEtudiantPK = presenceEtudiantPK;
    }

    public String getPresentOn() {
        return presentOn;
    }

    public void setPresentOn(String presentOn) {
        this.presentOn = presentOn;
    }

    public Calendrier getCalendrier() {
        return calendrier;
    }

    public void setCalendrier(Calendrier calendrier) {
        this.calendrier = calendrier;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presenceEtudiantPK != null ? presenceEtudiantPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresenceEtudiant)) {
            return false;
        }
        PresenceEtudiant other = (PresenceEtudiant) object;
        if ((this.presenceEtudiantPK == null && other.presenceEtudiantPK != null) || (this.presenceEtudiantPK != null && !this.presenceEtudiantPK.equals(other.presenceEtudiantPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.PresenceEtudiant[ presenceEtudiantPK=" + presenceEtudiantPK + " ]";
    }
    
}
