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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author baggins
 */
@Entity
@Table(name = "SEMESTRE", catalog = "", schema = "BAGGINS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semestre.findAll", query = "SELECT s FROM Semestre s")
    , @NamedQuery(name = "Semestre.findByIdSemestre", query = "SELECT s FROM Semestre s WHERE s.idSemestre = :idSemestre")
    , @NamedQuery(name = "Semestre.findByNomSemestre", query = "SELECT s FROM Semestre s WHERE s.nomSemestre = :nomSemestre")
    , @NamedQuery(name = "Semestre.findByDateDepartSemestre", query = "SELECT s FROM Semestre s WHERE s.dateDepartSemestre = :dateDepartSemestre")
    , @NamedQuery(name = "Semestre.findByDateFinSemestre", query = "SELECT s FROM Semestre s WHERE s.dateFinSemestre = :dateFinSemestre")})
public class Semestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SEMESTRE")
    private Integer idSemestre;
    @Size(max = 25)
    @Column(name = "NOM_SEMESTRE")
    private String nomSemestre;
    @Column(name = "DATE_DEPART_SEMESTRE")
    @Temporal(TemporalType.DATE)
    private Date dateDepartSemestre;
    @Column(name = "DATE_FIN_SEMESTRE")
    @Temporal(TemporalType.DATE)
    private Date dateFinSemestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSemestre")
    private Collection<Examen> examenCollection;

    public Semestre() {
    }

    public Semestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    public Integer getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    public String getNomSemestre() {
        return nomSemestre;
    }

    public void setNomSemestre(String nomSemestre) {
        this.nomSemestre = nomSemestre;
    }

    public Date getDateDepartSemestre() {
        return dateDepartSemestre;
    }

    public void setDateDepartSemestre(Date dateDepartSemestre) {
        this.dateDepartSemestre = dateDepartSemestre;
    }

    public Date getDateFinSemestre() {
        return dateFinSemestre;
    }

    public void setDateFinSemestre(Date dateFinSemestre) {
        this.dateFinSemestre = dateFinSemestre;
    }

    @XmlTransient
    public Collection<Examen> getExamenCollection() {
        return examenCollection;
    }

    public void setExamenCollection(Collection<Examen> examenCollection) {
        this.examenCollection = examenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSemestre != null ? idSemestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semestre)) {
            return false;
        }
        Semestre other = (Semestre) object;
        if ((this.idSemestre == null && other.idSemestre != null) || (this.idSemestre != null && !this.idSemestre.equals(other.idSemestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Semestre[ idSemestre=" + idSemestre + " ]";
    }
    
}
