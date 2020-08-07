/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author RAKA
 */
@Embeddable
public class PengumumanBarangPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_barang")
    private String idBarang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_anggota")
    private String idAnggota;

    /**
     *
     */
    public PengumumanBarangPK() {
    }

    /**
     *
     * @param idBarang
     * @param idAnggota
     */
    public PengumumanBarangPK(String idBarang, String idAnggota) {
        this.idBarang = idBarang;
        this.idAnggota = idAnggota;
    }

    /**
     *
     * @return
     */
    public String getIdBarang() {
        return idBarang;
    }

    /**
     *
     * @param idBarang
     */
    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    /**
     *
     * @return
     */
    public String getIdAnggota() {
        return idAnggota;
    }

    /**
     *
     * @param idAnggota
     */
    public void setIdAnggota(String idAnggota) {
        this.idAnggota = idAnggota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBarang != null ? idBarang.hashCode() : 0);
        hash += (idAnggota != null ? idAnggota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PengumumanBarangPK)) {
            return false;
        }
        PengumumanBarangPK other = (PengumumanBarangPK) object;
        if ((this.idBarang == null && other.idBarang != null) || (this.idBarang != null && !this.idBarang.equals(other.idBarang))) {
            return false;
        }
        if ((this.idAnggota == null && other.idAnggota != null) || (this.idAnggota != null && !this.idAnggota.equals(other.idAnggota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adm.model.PengumumanBarangPK[ idBarang=" + idBarang + ", idAnggota=" + idAnggota + " ]";
    }
    
}
