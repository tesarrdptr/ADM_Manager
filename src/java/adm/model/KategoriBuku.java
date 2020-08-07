/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Kategori_Buku")
@NamedQueries({
    @NamedQuery(name = "KategoriBuku.findAll", query = "SELECT k FROM KategoriBuku k"),
    @NamedQuery(name = "KategoriBuku.findByIdKategori", query = "SELECT k FROM KategoriBuku k WHERE k.idKategori = :idKategori"),
    @NamedQuery(name = "KategoriBuku.findByKategori", query = "SELECT k FROM KategoriBuku k WHERE k.kategori = :kategori"),
    @NamedQuery(name = "KategoriBuku.findByDenda", query = "SELECT k FROM KategoriBuku k WHERE k.denda = :denda"),
    @NamedQuery(name = "KategoriBuku.findByStatus", query = "SELECT k FROM KategoriBuku k WHERE k.status = :status")})
public class KategoriBuku implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_kategori")
    private Integer idKategori;
    @Size(max = 50)
    @Column(name = "kategori")
    private String kategori;
    @Column(name = "denda")
    private Integer denda;
    @Column(name = "status")
    private Integer status;
    @OneToMany(mappedBy = "kategoriBuku")
    private Collection<Buku> bukuCollection;

    /**
     *
     */
    public KategoriBuku() {
    }

    /**
     *
     * @param idKategori
     */
    public KategoriBuku(Integer idKategori) {
        this.idKategori = idKategori;
    }

    /**
     *
     * @return
     */
    public Integer getIdKategori() {
        return idKategori;
    }

    /**
     *
     * @param idKategori
     */
    public void setIdKategori(Integer idKategori) {
        this.idKategori = idKategori;
    }

    /**
     *
     * @return
     */
    public String getKategori() {
        return kategori;
    }

    /**
     *
     * @param kategori
     */
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    /**
     *
     * @return
     */
    public Integer getDenda() {
        return denda;
    }

    /**
     *
     * @param denda
     */
    public void setDenda(Integer denda) {
        this.denda = denda;
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
    public Collection<Buku> getBukuCollection() {
        return bukuCollection;
    }

    /**
     *
     * @param bukuCollection
     */
    public void setBukuCollection(Collection<Buku> bukuCollection) {
        this.bukuCollection = bukuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKategori != null ? idKategori.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KategoriBuku)) {
            return false;
        }
        KategoriBuku other = (KategoriBuku) object;
        if ((this.idKategori == null && other.idKategori != null) || (this.idKategori != null && !this.idKategori.equals(other.idKategori))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "adm.model.KategoriBuku[ idKategori=" + idKategori + " ]";
        return kategori.toString();
    }
    
}
