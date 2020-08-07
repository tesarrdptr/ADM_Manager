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
@Table(name = "pengumumanBarang")
@NamedQueries({
    @NamedQuery(name = "PengumumanBarang.findAll", query = "SELECT p FROM PengumumanBarang p"),
    @NamedQuery(name = "PengumumanBarang.findByIdBarang", query = "SELECT p FROM PengumumanBarang p WHERE p.pengumumanBarangPK.idBarang = :idBarang"),
    @NamedQuery(name = "PengumumanBarang.findByIdAnggota", query = "SELECT p FROM PengumumanBarang p WHERE p.pengumumanBarangPK.idAnggota = :idAnggota"),
    @NamedQuery(name = "PengumumanBarang.findByTglLapor", query = "SELECT p FROM PengumumanBarang p WHERE p.tglLapor = :tglLapor"),
    @NamedQuery(name = "PengumumanBarang.findByNamaBarang", query = "SELECT p FROM PengumumanBarang p WHERE p.namaBarang = :namaBarang"),
    @NamedQuery(name = "PengumumanBarang.findByDeskripsiBarang", query = "SELECT p FROM PengumumanBarang p WHERE p.deskripsiBarang = :deskripsiBarang"),
    @NamedQuery(name = "PengumumanBarang.findByNikPenemu", query = "SELECT p FROM PengumumanBarang p WHERE p.nikPenemu = :nikPenemu"),
    @NamedQuery(name = "PengumumanBarang.findByNamaPenemu", query = "SELECT p FROM PengumumanBarang p WHERE p.namaPenemu = :namaPenemu"),
    @NamedQuery(name = "PengumumanBarang.findByTlpPenemu", query = "SELECT p FROM PengumumanBarang p WHERE p.tlpPenemu = :tlpPenemu"),
    @NamedQuery(name = "PengumumanBarang.findByFotoPenemu", query = "SELECT p FROM PengumumanBarang p WHERE p.fotoPenemu = :fotoPenemu"),
    @NamedQuery(name = "PengumumanBarang.findByNikPemilik", query = "SELECT p FROM PengumumanBarang p WHERE p.nikPemilik = :nikPemilik"),
    @NamedQuery(name = "PengumumanBarang.findByNamaPemilik", query = "SELECT p FROM PengumumanBarang p WHERE p.namaPemilik = :namaPemilik"),
    @NamedQuery(name = "PengumumanBarang.findByTlpPemilik", query = "SELECT p FROM PengumumanBarang p WHERE p.tlpPemilik = :tlpPemilik"),
    @NamedQuery(name = "PengumumanBarang.findByFotoPemilik", query = "SELECT p FROM PengumumanBarang p WHERE p.fotoPemilik = :fotoPemilik"),
    @NamedQuery(name = "PengumumanBarang.findByStatus", query = "SELECT p FROM PengumumanBarang p WHERE p.status = :status")})
public class PengumumanBarang implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @EmbeddedId
    protected PengumumanBarangPK pengumumanBarangPK;
    @Size(max = 50)
    @Column(name = "tgl_lapor")
    private String tglLapor;
    @Size(max = 100)
    @Column(name = "nama_barang")
    private String namaBarang;
    @Size(max = 2147483647)
    @Column(name = "deskripsi_barang")
    private String deskripsiBarang;
    @Size(max = 50)
    @Column(name = "nik_penemu")
    private String nikPenemu;
    @Size(max = 100)
    @Column(name = "nama_penemu")
    private String namaPenemu;
    @Size(max = 50)
    @Column(name = "tlp_penemu")
    private String tlpPenemu;
    @Size(max = 100)
    @Column(name = "foto_penemu")
    private String fotoPenemu;
    @Size(max = 50)
    @Column(name = "nik_pemilik")
    private String nikPemilik;
    @Size(max = 50)
    @Column(name = "nama_pemilik")
    private String namaPemilik;
    @Size(max = 50)
    @Column(name = "tlp_pemilik")
    private String tlpPemilik;
    @Size(max = 100)
    @Column(name = "foto_pemilik")
    private String fotoPemilik;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "id_anggota", referencedColumnName = "id_anggota", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AnggotaDKM anggotaDKM;

    /**
     *
     */
    public PengumumanBarang() {
    }

    /**
     *
     * @param pengumumanBarangPK
     */
    public PengumumanBarang(PengumumanBarangPK pengumumanBarangPK) {
        this.pengumumanBarangPK = pengumumanBarangPK;
    }

    /**
     *
     * @param idBarang
     * @param idAnggota
     */
    public PengumumanBarang(String idBarang, String idAnggota) {
        this.pengumumanBarangPK = new PengumumanBarangPK(idBarang, idAnggota);
    }

    /**
     *
     * @return
     */
    public PengumumanBarangPK getPengumumanBarangPK() {
        return pengumumanBarangPK;
    }

    /**
     *
     * @param pengumumanBarangPK
     */
    public void setPengumumanBarangPK(PengumumanBarangPK pengumumanBarangPK) {
        this.pengumumanBarangPK = pengumumanBarangPK;
    }

    /**
     *
     * @return
     */
    public String getTglLapor() {
        return tglLapor;
    }

    /**
     *
     * @param tglLapor
     */
    public void setTglLapor(String tglLapor) {
        this.tglLapor = tglLapor;
    }

    /**
     *
     * @return
     */
    public String getNamaBarang() {
        return namaBarang;
    }

    /**
     *
     * @param namaBarang
     */
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    /**
     *
     * @return
     */
    public String getDeskripsiBarang() {
        return deskripsiBarang;
    }

    /**
     *
     * @param deskripsiBarang
     */
    public void setDeskripsiBarang(String deskripsiBarang) {
        this.deskripsiBarang = deskripsiBarang;
    }

    /**
     *
     * @return
     */
    public String getNikPenemu() {
        return nikPenemu;
    }

    /**
     *
     * @param nikPenemu
     */
    public void setNikPenemu(String nikPenemu) {
        this.nikPenemu = nikPenemu;
    }

    /**
     *
     * @return
     */
    public String getNamaPenemu() {
        return namaPenemu;
    }

    /**
     *
     * @param namaPenemu
     */
    public void setNamaPenemu(String namaPenemu) {
        this.namaPenemu = namaPenemu;
    }

    /**
     *
     * @return
     */
    public String getTlpPenemu() {
        return tlpPenemu;
    }

    /**
     *
     * @param tlpPenemu
     */
    public void setTlpPenemu(String tlpPenemu) {
        this.tlpPenemu = tlpPenemu;
    }

    /**
     *
     * @return
     */
    public String getFotoPenemu() {
        return fotoPenemu;
    }

    /**
     *
     * @param fotoPenemu
     */
    public void setFotoPenemu(String fotoPenemu) {
        this.fotoPenemu = fotoPenemu;
    }

    /**
     *
     * @return
     */
    public String getNikPemilik() {
        return nikPemilik;
    }

    /**
     *
     * @param nikPemilik
     */
    public void setNikPemilik(String nikPemilik) {
        this.nikPemilik = nikPemilik;
    }

    /**
     *
     * @return
     */
    public String getNamaPemilik() {
        return namaPemilik;
    }

    /**
     *
     * @param namaPemilik
     */
    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    /**
     *
     * @return
     */
    public String getTlpPemilik() {
        return tlpPemilik;
    }

    /**
     *
     * @param tlpPemilik
     */
    public void setTlpPemilik(String tlpPemilik) {
        this.tlpPemilik = tlpPemilik;
    }

    /**
     *
     * @return
     */
    public String getFotoPemilik() {
        return fotoPemilik;
    }

    /**
     *
     * @param fotoPemilik
     */
    public void setFotoPemilik(String fotoPemilik) {
        this.fotoPemilik = fotoPemilik;
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
        hash += (pengumumanBarangPK != null ? pengumumanBarangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PengumumanBarang)) {
            return false;
        }
        PengumumanBarang other = (PengumumanBarang) object;
        if ((this.pengumumanBarangPK == null && other.pengumumanBarangPK != null) || (this.pengumumanBarangPK != null && !this.pengumumanBarangPK.equals(other.pengumumanBarangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adm.model.PengumumanBarang[ pengumumanBarangPK=" + pengumumanBarangPK + " ]";
    }
    
}
