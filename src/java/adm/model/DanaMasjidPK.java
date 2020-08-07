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
public class DanaMasjidPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_dana")
    private String idDana;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_anggota")
    private String idAnggota;

    /**
     *
     */
    public DanaMasjidPK() {
    }

    /**
     *
     * @param idDana
     * @param idAnggota
     */
    public DanaMasjidPK(String idDana, String idAnggota) {
        this.idDana = idDana;
        this.idAnggota = idAnggota;
    }

    /**
     *
     * @return
     */
    public String getIdDana() {
        return idDana;
    }

    /**
     *
     * @param idDana
     */
    public void setIdDana(String idDana) {
        this.idDana = idDana;
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
        hash += (idDana != null ? idDana.hashCode() : 0);
        hash += (idAnggota != null ? idAnggota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DanaMasjidPK)) {
            return false;
        }
        DanaMasjidPK other = (DanaMasjidPK) object;
        if ((this.idDana == null && other.idDana != null) || (this.idDana != null && !this.idDana.equals(other.idDana))) {
            return false;
        }
        if ((this.idAnggota == null && other.idAnggota != null) || (this.idAnggota != null && !this.idAnggota.equals(other.idAnggota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adm.model.DanaMasjidPK[ idDana=" + idDana + ", idAnggota=" + idAnggota + " ]";
    }
    
}
