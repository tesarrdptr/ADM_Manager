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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Peminjaman_Buku")
@NamedQueries({
    @NamedQuery(name = "PeminjamanBuku.findAll", query = "SELECT p FROM PeminjamanBuku p"),
    @NamedQuery(name = "PeminjamanBuku.findByIdPinjam", query = "SELECT p FROM PeminjamanBuku p WHERE p.idPinjam = :idPinjam"),
    @NamedQuery(name = "PeminjamanBuku.findByTglPinjam", query = "SELECT p FROM PeminjamanBuku p WHERE p.tglPinjam = :tglPinjam"),
    @NamedQuery(name = "PeminjamanBuku.findByTglKembali", query = "SELECT p FROM PeminjamanBuku p WHERE p.tglKembali = :tglKembali"),
    @NamedQuery(name = "PeminjamanBuku.findByStatus", query = "SELECT p FROM PeminjamanBuku p WHERE p.status = :status"),
    @NamedQuery(name = "PeminjamanBuku.findByIdDenda", query = "SELECT p FROM PeminjamanBuku p WHERE p.idDenda = :idDenda")})
public class PeminjamanBuku implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_pinjam")
    private String idPinjam;
    @Size(max = 50)
    @Column(name = "tgl_pinjam")
    private String tglPinjam;
    @Size(max = 50)
    @Column(name = "tgl_kembali")
    private String tglKembali;
    @Column(name = "status")
    private Integer status;
    @Size(max = 50)
    @Column(name = "id_denda")
    private String idDenda;
    @JoinColumn(name = "id_member", referencedColumnName = "id_member")
    @ManyToOne(optional = false)
    private Member1 idMember;

    /**
     *
     */
    public PeminjamanBuku() {
    }

    /**
     *
     * @param idPinjam
     */
    public PeminjamanBuku(String idPinjam) {
        this.idPinjam = idPinjam;
    }

    /**
     *
     * @return
     */
    public String getIdPinjam() {
        return idPinjam;
    }

    /**
     *
     * @param idPinjam
     */
    public void setIdPinjam(String idPinjam) {
        this.idPinjam = idPinjam;
    }

    /**
     *
     * @return
     */
    public String getTglPinjam() {
        return tglPinjam;
    }

    /**
     *
     * @param tglPinjam
     */
    public void setTglPinjam(String tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    /**
     *
     * @return
     */
    public String getTglKembali() {
        return tglKembali;
    }

    /**
     *
     * @param tglKembali
     */
    public void setTglKembali(String tglKembali) {
        this.tglKembali = tglKembali;
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
    public String getIdDenda() {
        return idDenda;
    }

    /**
     *
     * @param idDenda
     */
    public void setIdDenda(String idDenda) {
        this.idDenda = idDenda;
    }

    /**
     *
     * @return
     */
    public Member1 getIdMember() {
        return idMember;
    }

    /**
     *
     * @param idMember
     */
    public void setIdMember(Member1 idMember) {
        this.idMember = idMember;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPinjam != null ? idPinjam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeminjamanBuku)) {
            return false;
        }
        PeminjamanBuku other = (PeminjamanBuku) object;
        if ((this.idPinjam == null && other.idPinjam != null) || (this.idPinjam != null && !this.idPinjam.equals(other.idPinjam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adm.model.PeminjamanBuku[ idPinjam=" + idPinjam + " ]";
    }
    
}
