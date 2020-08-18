/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author baggins
 */
@Embeddable
public class PresenceEtudiantPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NBR_JOUR")
    private int nbrJour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ETUDIANT")
    private int idEtudiant;

    public PresenceEtudiantPK() {
    }

    public PresenceEtudiantPK(int nbrJour, int idEtudiant) {
        this.nbrJour = nbrJour;
        this.idEtudiant = idEtudiant;
    }

    public int getNbrJour() {
        return nbrJour;
    }

    public void setNbrJour(int nbrJour) {
        this.nbrJour = nbrJour;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nbrJour;
        hash += (int) idEtudiant;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresenceEtudiantPK)) {
            return false;
        }
        PresenceEtudiantPK other = (PresenceEtudiantPK) object;
        if (this.nbrJour != other.nbrJour) {
            return false;
        }
        if (this.idEtudiant != other.idEtudiant) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.PresenceEtudiantPK[ nbrJour=" + nbrJour + ", idEtudiant=" + idEtudiant + " ]";
    }
    
}
