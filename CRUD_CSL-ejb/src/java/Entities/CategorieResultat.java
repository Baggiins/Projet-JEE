/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author baggins
 */
@Entity
@Table(name = "CATEGORIE_RESULTAT", catalog = "", schema = "BAGGINS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategorieResultat.findAll", query = "SELECT c FROM CategorieResultat c")
    , @NamedQuery(name = "CategorieResultat.findByResCatCode", query = "SELECT c FROM CategorieResultat c WHERE c.resCatCode = :resCatCode")
    , @NamedQuery(name = "CategorieResultat.findByResNoteBasse", query = "SELECT c FROM CategorieResultat c WHERE c.resNoteBasse = :resNoteBasse")
    , @NamedQuery(name = "CategorieResultat.findByResNoteHaute", query = "SELECT c FROM CategorieResultat c WHERE c.resNoteHaute = :resNoteHaute")
    , @NamedQuery(name = "CategorieResultat.findByResPassEchec", query = "SELECT c FROM CategorieResultat c WHERE c.resPassEchec = :resPassEchec")})
public class CategorieResultat implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resCatCode")
    private Collection<ExamenResultat> examenResultatCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RES_CAT_CODE", nullable = false)
    private Integer resCatCode;
    @Column(name = "RES_NOTE_BASSE")
    private Integer resNoteBasse;
    @Column(name = "RES_NOTE_HAUTE")
    private Integer resNoteHaute;
    @Size(max = 25)
    @Column(name = "RES_PASS_ECHEC", length = 25)
    private String resPassEchec;

    public CategorieResultat() {
    }

    public CategorieResultat(Integer resCatCode) {
        this.resCatCode = resCatCode;
    }

    public Integer getResCatCode() {
        return resCatCode;
    }

    public void setResCatCode(Integer resCatCode) {
        this.resCatCode = resCatCode;
    }

    public Integer getResNoteBasse() {
        return resNoteBasse;
    }

    public void setResNoteBasse(Integer resNoteBasse) {
        this.resNoteBasse = resNoteBasse;
    }

    public Integer getResNoteHaute() {
        return resNoteHaute;
    }

    public void setResNoteHaute(Integer resNoteHaute) {
        this.resNoteHaute = resNoteHaute;
    }

    public String getResPassEchec() {
        return resPassEchec;
    }

    public void setResPassEchec(String resPassEchec) {
        this.resPassEchec = resPassEchec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resCatCode != null ? resCatCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategorieResultat)) {
            return false;
        }
        CategorieResultat other = (CategorieResultat) object;
        if ((this.resCatCode == null && other.resCatCode != null) || (this.resCatCode != null && !this.resCatCode.equals(other.resCatCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CategorieResultat[ resCatCode=" + resCatCode + " ]";
    }

    @XmlTransient
    public Collection<ExamenResultat> getExamenResultatCollection() {
        return examenResultatCollection;
    }

    public void setExamenResultatCollection(Collection<ExamenResultat> examenResultatCollection) {
        this.examenResultatCollection = examenResultatCollection;
    }
    
}
