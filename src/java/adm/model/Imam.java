/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.model;

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

/**
 *
 * @author RAKA
 */
@Entity
@Table(name = "imam")
@NamedQueries({
    @NamedQuery(name = "Imam.findAll", query = "SELECT i FROM Imam i"),
    @NamedQuery(name = "Imam.findByIdImam", query = "SELECT i FROM Imam i WHERE i.idImam = :idImam"),
    @NamedQuery(name = "Imam.findByNamaImam", query = "SELECT i FROM Imam i WHERE i.namaImam = :namaImam"),
    @NamedQuery(name = "Imam.findByEmailImam", query = "SELECT i FROM Imam i WHERE i.emailImam = :emailImam"),
    @NamedQuery(name = "Imam.findByTlpImam", query = "SELECT i FROM Imam i WHERE i.tlpImam = :tlpImam"),
    @NamedQuery(name = "Imam.findByStatusImam", query = "SELECT i FROM Imam i WHERE i.statusImam = :statusImam")})
public class Imam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_imam")
    private Integer idImam;
    @Size(max = 150)
    @Column(name = "nama_imam")
    private String namaImam;
    @Size(max = 50)
    @Column(name = "email_imam")
    private String emailImam;
    @Size(max = 20)
    @Column(name = "tlp_imam")
    private String tlpImam;
    @Column(name = "status_imam")
    private Integer statusImam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imam")
    private Collection<Jadwal> jadwalCollection;

    /**
     *
     */
    public Imam() {
    }

    /**
     *
     * @param idImam
     */
    public Imam(Integer idImam) {
        this.idImam = idImam;
    }

    /**
     *
     * @return
     */
    public Integer getIdImam() {
        return idImam;
    }

    /**
     *
     * @param idImam
     */
    public void setIdImam(Integer idImam) {
        this.idImam = idImam;
    }

    /**
     *
     * @return
     */
    public String getNamaImam() {
        return namaImam;
    }

    /**
     *
     * @param namaImam
     */
    public void setNamaImam(String namaImam) {
        this.namaImam = namaImam;
    }

    /**
     *
     * @return
     */
    public String getEmailImam() {
        return emailImam;
    }

    /**
     *
     * @param emailImam
     */
    public void setEmailImam(String emailImam) {
        this.emailImam = emailImam;
    }

    /**
     *
     * @return
     */
    public String getTlpImam() {
        return tlpImam;
    }

    /**
     *
     * @param tlpImam
     */
    public void setTlpImam(String tlpImam) {
        this.tlpImam = tlpImam;
    }

    /**
     *
     * @return
     */
    public Integer getStatusImam() {
        return statusImam;
    }

    /**
     *
     * @param statusImam
     */
    public void setStatusImam(Integer statusImam) {
        this.statusImam = statusImam;
    }

    /**
     *
     * @return
     */
    public Collection<Jadwal> getJadwalCollection() {
        return jadwalCollection;
    }

    /**
     *
     * @param jadwalCollection
     */
    public void setJadwalCollection(Collection<Jadwal> jadwalCollection) {
        this.jadwalCollection = jadwalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImam != null ? idImam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imam)) {
            return false;
        }
        Imam other = (Imam) object;
        if ((this.idImam == null && other.idImam != null) || (this.idImam != null && !this.idImam.equals(other.idImam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return namaImam;
    }
    
}
