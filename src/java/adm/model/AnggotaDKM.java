/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "anggotaDKM")
@NamedQueries({
    @NamedQuery(name = "AnggotaDKM.findAll", query = "SELECT a FROM AnggotaDKM a"),
    @NamedQuery(name = "AnggotaDKM.findByIdAnggota", query = "SELECT a FROM AnggotaDKM a WHERE a.idAnggota = :idAnggota"),
    @NamedQuery(name = "AnggotaDKM.findByNamaAnggota", query = "SELECT a FROM AnggotaDKM a WHERE a.namaAnggota = :namaAnggota"),
    @NamedQuery(name = "AnggotaDKM.findByEmailAnggota", query = "SELECT a FROM AnggotaDKM a WHERE a.emailAnggota = :emailAnggota"),
    @NamedQuery(name = "AnggotaDKM.findByPassAnggota", query = "SELECT a FROM AnggotaDKM a WHERE a.passAnggota = :passAnggota"),
    @NamedQuery(name = "AnggotaDKM.findByTlpAnggota", query = "SELECT a FROM AnggotaDKM a WHERE a.tlpAnggota = :tlpAnggota"),
    @NamedQuery(name = "AnggotaDKM.findByRoleAnggota", query = "SELECT a FROM AnggotaDKM a WHERE a.roleAnggota = :roleAnggota"),
    @NamedQuery(name = "AnggotaDKM.findByStatus", query = "SELECT a FROM AnggotaDKM a WHERE a.status = :status")})
public class AnggotaDKM implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_anggota")
    private String idAnggota;
    @Size(max = 100)
    @Column(name = "nama_anggota")
    private String namaAnggota;
    @Size(max = 50)
    @Column(name = "email_anggota")
    private String emailAnggota;
    @Size(max = 50)
    @Column(name = "pass_anggota")
    private String passAnggota;
    @Size(max = 20)
    @Column(name = "tlp_anggota")
    private String tlpAnggota;
    @Column(name = "role_anggota")
    private Integer roleAnggota;
    @Column(name = "status")
    private Integer status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anggotaDKM")
    private Collection<Jadwal> jadwalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anggotaDKM")
    private Collection<PengumumanBarang> pengumumanBarangCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anggotaDKM")
    private Collection<DanaMasjid> danaMasjidCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anggotaDKM")
    private Collection<Event> eventCollection;

    /**
     *
     */
    public AnggotaDKM() {
    }

    /**
     *
     * @param idAnggota
     */
    public AnggotaDKM(String idAnggota) {
        this.idAnggota = idAnggota;
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

    /**
     *
     * @return
     */
    public String getNamaAnggota() {
        return namaAnggota;
    }

    /**
     *
     * @param namaAnggota
     */
    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    /**
     *
     * @return
     */
    public String getEmailAnggota() {
        return emailAnggota;
    }

    /**
     *
     * @param emailAnggota
     */
    public void setEmailAnggota(String emailAnggota) {
        this.emailAnggota = emailAnggota;
    }

    /**
     *
     * @return
     */
    public String getPassAnggota() {
        return passAnggota;
    }

    /**
     *
     * @param passAnggota
     */
    public void setPassAnggota(String passAnggota) {
        this.passAnggota = passAnggota;
    }

    /**
     *
     * @return
     */
    public String getTlpAnggota() {
        return tlpAnggota;
    }

    /**
     *
     * @param tlpAnggota
     */
    public void setTlpAnggota(String tlpAnggota) {
        this.tlpAnggota = tlpAnggota;
    }

    /**
     *
     * @return
     */
    public Integer getRoleAnggota() {
        return roleAnggota;
    }

    /**
     *
     * @param roleAnggota
     */
    public void setRoleAnggota(Integer roleAnggota) {
        this.roleAnggota = roleAnggota;
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
    public Collection<Jadwal> getJadwalCollection() {
        return jadwalCollection;
    }

    /**
     *
     * @param jadwalCollection
     */
    public void setJadwalCollection(Collection<Jadwal> jadwalCollection) {
        this.jadwalCollection = jadwalCollection;
    }

    /**
     *
     * @return
     */
    public Collection<PengumumanBarang> getPengumumanBarangCollection() {
        return pengumumanBarangCollection;
    }

    /**
     *
     * @param pengumumanBarangCollection
     */
    public void setPengumumanBarangCollection(Collection<PengumumanBarang> pengumumanBarangCollection) {
        this.pengumumanBarangCollection = pengumumanBarangCollection;
    }

    /**
     *
     * @return
     */
    public Collection<DanaMasjid> getDanaMasjidCollection() {
        return danaMasjidCollection;
    }

    /**
     *
     * @param danaMasjidCollection
     */
    public void setDanaMasjidCollection(Collection<DanaMasjid> danaMasjidCollection) {
        this.danaMasjidCollection = danaMasjidCollection;
    }

    /**
     *
     * @return
     */
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    /**
     *
     * @param eventCollection
     */
    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnggota != null ? idAnggota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnggotaDKM)) {
            return false;
        }
        AnggotaDKM other = (AnggotaDKM) object;
        if ((this.idAnggota == null && other.idAnggota != null) || (this.idAnggota != null && !this.idAnggota.equals(other.idAnggota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return namaAnggota;
    }
    
}
