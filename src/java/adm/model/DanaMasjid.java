/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.model;

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

/**
 *
 * @author RAKA
 */
@Entity
@Table(name = "danaMasjid")
@NamedQueries({
    @NamedQuery(name = "DanaMasjid.findAll", query = "SELECT d FROM DanaMasjid d"),
    @NamedQuery(name = "DanaMasjid.findPemasukan", query = "SELECT d FROM DanaMasjid d WHERE d.status = 1"),
    @NamedQuery(name = "DanaMasjid.findByIdDana", query = "SELECT d FROM DanaMasjid d WHERE d.danaMasjidPK.idDana = :idDana"),
    @NamedQuery(name = "DanaMasjid.findByIdAnggota", query = "SELECT d FROM DanaMasjid d WHERE d.danaMasjidPK.idAnggota = :idAnggota"),
    @NamedQuery(name = "DanaMasjid.findByTglDana", query = "SELECT d FROM DanaMasjid d WHERE d.tglDana = :tglDana"),
    @NamedQuery(name = "DanaMasjid.findBySumberDana", query = "SELECT d FROM DanaMasjid d WHERE d.sumberDana = :sumberDana"),
    @NamedQuery(name = "DanaMasjid.findByJmlDana", query = "SELECT d FROM DanaMasjid d WHERE d.jmlDana = :jmlDana"),
    @NamedQuery(name = "DanaMasjid.findByStatus", query = "SELECT d FROM DanaMasjid d WHERE d.status = :status")})
public class DanaMasjid implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @EmbeddedId
    protected DanaMasjidPK danaMasjidPK;
    @Size(max = 50)
    @Column(name = "tgl_dana")
    private String tglDana;
    @Size(max = 50)
    @Column(name = "sumber_dana")
    private String sumberDana;
    @Size(max = 50)
    @Column(name = "jml_dana")
    private String jmlDana;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "id_anggota", referencedColumnName = "id_anggota", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AnggotaDKM anggotaDKM;

    /**
     *
     */
    public DanaMasjid() {
    }

    /**
     *
     * @param danaMasjidPK
     */
    public DanaMasjid(DanaMasjidPK danaMasjidPK) {
        this.danaMasjidPK = danaMasjidPK;
    }

    /**
     *
     * @param idDana
     * @param idAnggota
     */
    public DanaMasjid(String idDana, String idAnggota) {
        this.danaMasjidPK = new DanaMasjidPK(idDana, idAnggota);
    }

    /**
     *
     * @return
     */
    public DanaMasjidPK getDanaMasjidPK() {
        return danaMasjidPK;
    }

    /**
     *
     * @param danaMasjidPK
     */
    public void setDanaMasjidPK(DanaMasjidPK danaMasjidPK) {
        this.danaMasjidPK = danaMasjidPK;
    }

    /**
     *
     * @return
     */
    public String getTglDana() {
        return tglDana;
    }

    /**
     *
     * @param tglDana
     */
    public void setTglDana(String tglDana) {
        this.tglDana = tglDana;
    }

    /**
     *
     * @return
     */
    public String getSumberDana() {
        return sumberDana;
    }

    /**
     *
     * @param sumberDana
     */
    public void setSumberDana(String sumberDana) {
        this.sumberDana = sumberDana;
    }

    /**
     *
     * @return
     */
    public String getJmlDana() {
        return jmlDana;
    }

    /**
     *
     * @param jmlDana
     */
    public void setJmlDana(String jmlDana) {
        this.jmlDana = jmlDana;
    }

    /**
     *
     * @return
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public AnggotaDKM getAnggotaDKM() {
        return anggotaDKM;
    }

    /**
     *
     * @param anggotaDKM
     */
    public void setAnggotaDKM(AnggotaDKM anggotaDKM) {
        this.anggotaDKM = anggotaDKM;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (danaMasjidPK != null ? danaMasjidPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DanaMasjid)) {
            return false;
        }
        DanaMasjid other = (DanaMasjid) object;
        if ((this.danaMasjidPK == null && other.danaMasjidPK != null) || (this.danaMasjidPK != null && !this.danaMasjidPK.equals(other.danaMasjidPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adm.model.DanaMasjid[ danaMasjidPK=" + danaMasjidPK + " ]";
    }
    
}
