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
public class JadwalPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_imam")
    private int idImam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_anggota")
    private String idAnggota;

    /**
     *
     */
    public JadwalPK() {
    }

    /**
     *
     * @param idImam
     * @param idAnggota
     */
    public JadwalPK(int idImam, String idAnggota) {
        this.idImam = idImam;
        this.idAnggota = idAnggota;
    }

    /**
     *
     * @return
     */
    public int getIdImam() {
        return idImam;
    }

    /**
     *
     * @param idImam
     */
    public void setIdImam(int idImam) {
        this.idImam = idImam;
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
        hash += (int) idImam;
        hash += (idAnggota != null ? idAnggota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JadwalPK)) {
            return false;
        }
        JadwalPK other = (JadwalPK) object;
        if (this.idImam != other.idImam) {
            return false;
        }
        if ((this.idAnggota == null && other.idAnggota != null) || (this.idAnggota != null && !this.idAnggota.equals(other.idAnggota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adm.model.JadwalPK[ idImam=" + idImam + ", idAnggota=" + idAnggota + " ]";
    }
    
}
