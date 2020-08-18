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
public class ExamenResultatPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EXAM")
    private int idExam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ETUDIANT")
    private int idEtudiant;

    public ExamenResultatPK() {
    }

    public ExamenResultatPK(int idExam, int idEtudiant) {
        this.idExam = idExam;
        this.idEtudiant = idEtudiant;
    }

    public int getIdExam() {
        return idExam;
    }

    public void setIdExam(int idExam) {
        this.idExam = idExam;
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
        hash += (int) idExam;
        hash += (int) idEtudiant;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenResultatPK)) {
            return false;
        }
        ExamenResultatPK other = (ExamenResultatPK) object;
        if (this.idExam != other.idExam) {
            return false;
        }
        if (this.idEtudiant != other.idEtudiant) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ExamenResultatPK[ idExam=" + idExam + ", idEtudiant=" + idEtudiant + " ]";
    }
}
