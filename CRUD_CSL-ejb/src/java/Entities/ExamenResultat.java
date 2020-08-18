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
@Table(name = "EXAMEN_RESULTAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamenResultat.findAll", query = "SELECT e FROM ExamenResultat e")
    , @NamedQuery(name = "ExamenResultat.findByIdExam", query = "SELECT e FROM ExamenResultat e WHERE e.examenResultatPK.idExam = :idExam")
    , @NamedQuery(name = "ExamenResultat.findByIdEtudiant", query = "SELECT e FROM ExamenResultat e WHERE e.examenResultatPK.idEtudiant = :idEtudiant")
    , @NamedQuery(name = "ExamenResultat.findByClasse", query = "SELECT e FROM ExamenResultat e WHERE e.classe = :classe")})
public class ExamenResultat implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExamenResultatPK examenResultatPK;
    @Size(max = 50)
    @Column(name = "CLASSE")
    private String classe;
    @JoinColumn(name = "RES_CAT_CODE", referencedColumnName = "RES_CAT_CODE")
    @ManyToOne(optional = false)
    private CategorieResultat resCatCode;
    @JoinColumn(name = "ID_ETUDIANT", referencedColumnName = "ID_ETUDIANT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etudiant etudiant;
    @JoinColumn(name = "ID_EXAM", referencedColumnName = "ID_EXAM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Examen examen;

    public ExamenResultat() {
    }

    public ExamenResultat(ExamenResultatPK examenResultatPK) {
        this.examenResultatPK = examenResultatPK;
    }

    public ExamenResultat(int idExam, int idEtudiant) {
        this.examenResultatPK = new ExamenResultatPK(idExam, idEtudiant);
    }

    public ExamenResultatPK getExamenResultatPK() {
        return examenResultatPK;
    }

    public void setExamenResultatPK(ExamenResultatPK examenResultatPK) {
        this.examenResultatPK = examenResultatPK;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public CategorieResultat getResCatCode() {
        return resCatCode;
    }

    public void setResCatCode(CategorieResultat resCatCode) {
        this.resCatCode = resCatCode;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examenResultatPK != null ? examenResultatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenResultat)) {
            return false;
        }
        ExamenResultat other = (ExamenResultat) object;
        if ((this.examenResultatPK == null && other.examenResultatPK != null) || (this.examenResultatPK != null && !this.examenResultatPK.equals(other.examenResultatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ExamenResultat[ examenResultatPK=" + examenResultatPK + " ]";
    }
    
}
