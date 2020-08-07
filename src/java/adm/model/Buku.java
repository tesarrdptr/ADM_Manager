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
@Table(name = "buku")
@NamedQueries({
    @NamedQuery(name = "Buku.findAll", query = "SELECT b FROM Buku b"),
    @NamedQuery(name = "Buku.findByIdBuku", query = "SELECT b FROM Buku b WHERE b.idBuku = :idBuku"),
    @NamedQuery(name = "Buku.findByJudulBuku", query = "SELECT b FROM Buku b WHERE b.judulBuku = :judulBuku"),
    @NamedQuery(name = "Buku.findByPenerbitBuku", query = "SELECT b FROM Buku b WHERE b.penerbitBuku = :penerbitBuku"),
    @NamedQuery(name = "Buku.findByStokBuku", query = "SELECT b FROM Buku b WHERE b.stokBuku = :stokBuku"),
    @NamedQuery(name = "Buku.findByStatusBuku", query = "SELECT b FROM Buku b WHERE b.statusBuku = :statusBuku"),
    @NamedQuery(name = "Buku.findByKeteranganBuku", query = "SELECT b FROM Buku b WHERE b.keteranganBuku = :keteranganBuku")})
public class Buku implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_buku")
    private String idBuku;
    @Size(max = 50)
    @Column(name = "judul_buku")
    private String judulBuku;
    @Size(max = 150)
    @Column(name = "penerbit_buku")
    private String penerbitBuku;
    @Column(name = "stok_buku")
    private Integer stokBuku;
    @Column(name = "status_buku")
    private Integer statusBuku;
    @Size(max = 100)
    @Column(name = "keterangan_buku")
    private String keteranganBuku;
    @JoinColumn(name = "kategori_buku", referencedColumnName = "id_kategori")
    @ManyToOne
    private KategoriBuku kategoriBuku;

    /**
     *
     */
    public Buku() {
    }

    /**
     *
     * @param idBuku
     */
    public Buku(String idBuku) {
        this.idBuku = idBuku;
    }

    /**
     *
     * @return
     */
    public String getIdBuku() {
        return idBuku;
    }

    /**
     *
     * @param idBuku
     */
    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }

    /**
     *
     * @return
     */
    public String getJudulBuku() {
        return judulBuku;
    }

    /**
     *
     * @param judulBuku
     */
    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    /**
     *
     * @return
     */
    public String getPenerbitBuku() {
        return penerbitBuku;
    }

    /**
     *
     * @param penerbitBuku
     */
    public void setPenerbitBuku(String penerbitBuku) {
        this.penerbitBuku = penerbitBuku;
    }

    /**
     *
     * @return
     */
    public Integer getStokBuku() {
        return stokBuku;
    }

    /**
     *
     * @param stokBuku
     */
    public void setStokBuku(Integer stokBuku) {
        this.stokBuku = stokBuku;
    }

    /**
     *
     * @return
     */
    public Integer getStatusBuku() {
        return statusBuku;
    }

    /**
     *
     * @param statusBuku
     */
    public void setStatusBuku(Integer statusBuku) {
        this.statusBuku = statusBuku;
    }

    /**
     *
     * @return
     */
    public String getKeteranganBuku() {
        return keteranganBuku;
    }

    /**
     *
     * @param keteranganBuku
     */
    public void setKeteranganBuku(String keteranganBuku) {
        this.keteranganBuku = keteranganBuku;
    }

    /**
     *
     * @return
     */
    public KategoriBuku getKategoriBuku() {
        return kategoriBuku;
    }
    
    /**
     *
     * @return
     */
    public String getNamaKategoriBuku() {
        return kategoriBuku.getKategori();
    }

    /**
     *
     * @param kategoriBuku
     */
    public void setKategoriBuku(KategoriBuku kategoriBuku) {
        this.kategoriBuku = kategoriBuku;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBuku != null ? idBuku.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buku)) {
            return false;
        }
        Buku other = (Buku) object;
        if ((this.idBuku == null && other.idBuku != null) || (this.idBuku != null && !this.idBuku.equals(other.idBuku))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adm.model.Buku[ idBuku=" + idBuku + " ]";
    }
    
}
