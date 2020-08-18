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
@Table(name = "ETUDIANT", catalog = "", schema = "BAGGINS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e")
    , @NamedQuery(name = "Etudiant.findByIdEtudiant", query = "SELECT e FROM Etudiant e WHERE e.idEtudiant = :idEtudiant")
    , @NamedQuery(name = "Etudiant.findByPrenomEtudiant", query = "SELECT e FROM Etudiant e WHERE e.prenomEtudiant = :prenomEtudiant")
    , @NamedQuery(name = "Etudiant.findByNomEtudiant", query = "SELECT e FROM Etudiant e WHERE e.nomEtudiant = :nomEtudiant")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ETUDIANT")
    private Integer idEtudiant;
    @Size(max = 50)
    @Column(name = "PRENOM_ETUDIANT")
    private String prenomEtudiant;
    @Size(max = 50)
    @Column(name = "NOM_ETUDIANT")
    private String nomEtudiant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiant")
    private Collection<ExamenResultat> examenResultatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiant")
    private Collection<PresenceEtudiant> presenceEtudiantCollection;

    public Etudiant() {
    }

    public Etudiant(Integer idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public Integer getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Integer idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    @XmlTransient
    public Collection<ExamenResultat> getExamenResultatCollection() {
        return examenResultatCollection;
    }

    public void setExamenResultatCollection(Collection<ExamenResultat> examenResultatCollection) {
        this.examenResultatCollection = examenResultatCollection;
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
        hash += (idEtudiant != null ? idEtudiant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.idEtudiant == null && other.idEtudiant != null) || (this.idEtudiant != null && !this.idEtudiant.equals(other.idEtudiant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Etudiant[ idEtudiant=" + idEtudiant + " ]";
    }
    
}
