/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author RAKA
 */
@Entity
@Table(name = "kritikSaran")
@NamedQueries({
    @NamedQuery(name = "KritikSaran.findAll", query = "SELECT k FROM KritikSaran k"),
    @NamedQuery(name = "KritikSaran.findByIdKritikSaran", query = "SELECT k FROM KritikSaran k WHERE k.idKritikSaran = :idKritikSaran"),
    @NamedQuery(name = "KritikSaran.findByTglKritikSaran", query = "SELECT k FROM KritikSaran k WHERE k.tglKritikSaran = :tglKritikSaran"),
    @NamedQuery(name = "KritikSaran.findByKategoriKritikSaran", query = "SELECT k FROM KritikSaran k WHERE k.kategoriKritikSaran = :kategoriKritikSaran"),
    @NamedQuery(name = "KritikSaran.findByIsiKritikSaran", query = "SELECT k FROM KritikSaran k WHERE k.isiKritikSaran = :isiKritikSaran")})
public class KritikSaran implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_kritik_saran")
    private Integer idKritikSaran;
    @Size(max = 50)
    @Column(name = "tgl_kritik_saran")
    private String tglKritikSaran;
    @Size(max = 50)
    @Column(name = "kategori_kritik_saran")
    private String kategoriKritikSaran;
    @Size(max = 2147483647)
    @Column(name = "isi_kritik_saran")
    private String isiKritikSaran;

    /**
     *
     */
    public KritikSaran() {
    }

    /**
     *
     * @param idKritikSaran
     */
    public KritikSaran(Integer idKritikSaran) {
        this.idKritikSaran = idKritikSaran;
    }

    /**
     *
     * @return
     */
    public Integer getIdKritikSaran() {
        return idKritikSaran;
    }

    /**
     *
     * @param idKritikSaran
     */
    public void setIdKritikSaran(Integer idKritikSaran) {
        this.idKritikSaran = idKritikSaran;
    }

    /**
     *
     * @return
     */
    public String getTglKritikSaran() {
        return tglKritikSaran;
    }

    /**
     *
     * @param tglKritikSaran
     */
    public void setTglKritikSaran(String tglKritikSaran) {
        this.tglKritikSaran = tglKritikSaran;
    }

    /**
     *
     * @return
     */
    public String getKategoriKritikSaran() {
        return kategoriKritikSaran;
    }

    /**
     *
     * @param kategoriKritikSaran
     */
    public void setKategoriKritikSaran(String kategoriKritikSaran) {
        this.kategoriKritikSaran = kategoriKritikSaran;
    }

    /**
     *
     * @return
     */
    public String getIsiKritikSaran() {
        return isiKritikSaran;
    }

    /**
     *
     * @param isiKritikSaran
     */
    public void setIsiKritikSaran(String isiKritikSaran) {
        this.isiKritikSaran = isiKritikSaran;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKritikSaran != null ? idKritikSaran.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KritikSaran)) {
            return false;
        }
        KritikSaran other = (KritikSaran) object;
        if ((this.idKritikSaran == null && other.idKritikSaran != null) || (this.idKritikSaran != null && !this.idKritikSaran.equals(other.idKritikSaran))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adm.model.KritikSaran[ idKritikSaran=" + idKritikSaran + " ]";
    }
    
}
