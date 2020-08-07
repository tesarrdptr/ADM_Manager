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
@Table(name = "jadwal")
@NamedQueries({
    @NamedQuery(name = "Jadwal.findAll", query = "SELECT j FROM Jadwal j"),
    @NamedQuery(name = "Jadwal.findByIdImam", query = "SELECT j FROM Jadwal j WHERE j.jadwalPK.idImam = :idImam"),
    @NamedQuery(name = "Jadwal.findByIdAnggota", query = "SELECT j FROM Jadwal j WHERE j.jadwalPK.idAnggota = :idAnggota"),
    @NamedQuery(name = "Jadwal.findByTglJadwal", query = "SELECT j FROM Jadwal j WHERE j.tglJadwal = :tglJadwal"),
    @NamedQuery(name = "Jadwal.findByWaktuSholat", query = "SELECT j FROM Jadwal j WHERE j.waktuSholat = :waktuSholat"),
    @NamedQuery(name = "Jadwal.findByStatus", query = "SELECT j FROM Jadwal j WHERE j.status = :status")})
public class Jadwal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @EmbeddedId
    protected JadwalPK jadwalPK;
    @Size(max = 50)
    @Column(name = "tgl_jadwal")
    private String tglJadwal;
    @Size(max = 50)
    @Column(name = "waktu_sholat")
    private String waktuSholat;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "id_anggota", referencedColumnName = "id_anggota", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AnggotaDKM anggotaDKM;
    @JoinColumn(name = "id_imam", referencedColumnName = "id_imam", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Imam imam;

    /**
     *
     */
    public Jadwal() {
    }

    /**
     *
     * @param jadwalPK
     */
    public Jadwal(JadwalPK jadwalPK) {
        this.jadwalPK = jadwalPK;
    }

    /**
     *
     * @param idImam
     * @param idAnggota
     */
    public Jadwal(int idImam, String idAnggota) {
        this.jadwalPK = new JadwalPK(idImam, idAnggota);
    }

    /**
     *
     * @return
     */
    public JadwalPK getJadwalPK() {
        return jadwalPK;
    }

    /**
     *
     * @param jadwalPK
     */
    public void setJadwalPK(JadwalPK jadwalPK) {
        this.jadwalPK = jadwalPK;
    }

    /**
     *
     * @return
     */
    public String getTglJadwal() {
        return tglJadwal;
    }

    /**
     *
     * @param tglJadwal
     */
    public void setTglJadwal(String tglJadwal) {
        this.tglJadwal = tglJadwal;
    }

    /**
     *
     * @return
     */
    public String getWaktuSholat() {
        return waktuSholat;
    }

    /**
     *
     * @param waktuSholat
     */
    public void setWaktuSholat(String waktuSholat) {
        this.waktuSholat = waktuSholat;
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

    /**
     *
     * @return
     */
    public Imam getImam() {
        return imam;
    }

    /**
     *
     * @param imam
     */
    public void setImam(Imam imam) {
        this.imam = imam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jadwalPK != null ? jadwalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jadwal)) {
            return false;
        }
        Jadwal other = (Jadwal) object;
        if ((this.jadwalPK == null && other.jadwalPK != null) || (this.jadwalPK != null && !this.jadwalPK.equals(other.jadwalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adm.model.Jadwal[ jadwalPK=" + jadwalPK + " ]";
    }
    
}
