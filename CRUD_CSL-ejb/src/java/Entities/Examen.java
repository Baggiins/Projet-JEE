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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "EXAMEN", catalog = "", schema = "BAGGINS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e")
    , @NamedQuery(name = "Examen.findByIdExam", query = "SELECT e FROM Examen e WHERE e.idExam = :idExam")
    , @NamedQuery(name = "Examen.findByDateExam", query = "SELECT e FROM Examen e WHERE e.dateExam = :dateExam")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EXAM")
    private Integer idExam;
    @Column(name = "DATE_EXAM")
    @Temporal(TemporalType.DATE)
    private Date dateExam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examen")
    private Collection<ExamenResultat> examenResultatCollection;
    @JoinColumn(name = "ID_SEMESTRE", referencedColumnName = "ID_SEMESTRE")
    @ManyToOne(optional = false)
    private Semestre idSemestre;

    public Examen() {
    }

    public Examen(Integer idExam) {
        this.idExam = idExam;
    }

    public Integer getIdExam() {
        return idExam;
    }

    public void setIdExam(Integer idExam) {
        this.idExam = idExam;
    }

    public Date getDateExam() {
        return dateExam;
    }

    public void setDateExam(Date dateExam) {
        this.dateExam = dateExam;
    }

    @XmlTransient
    public Collection<ExamenResultat> getExamenResultatCollection() {
        return examenResultatCollection;
    }

    public void setExamenResultatCollection(Collection<ExamenResultat> examenResultatCollection) {
        this.examenResultatCollection = examenResultatCollection;
    }

    public Semestre getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Semestre idSemestre) {
        this.idSemestre = idSemestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExam != null ? idExam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.idExam == null && other.idExam != null) || (this.idExam != null && !this.idExam.equals(other.idExam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Examen[ idExam=" + idExam + " ]";
    }
    
}
