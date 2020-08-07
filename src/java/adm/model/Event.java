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
@Table(name = "event")
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByIdEvent", query = "SELECT e FROM Event e WHERE e.eventPK.idEvent = :idEvent"),
    @NamedQuery(name = "Event.findByIdAnggota", query = "SELECT e FROM Event e WHERE e.eventPK.idAnggota = :idAnggota"),
    @NamedQuery(name = "Event.findByNamaEvent", query = "SELECT e FROM Event e WHERE e.namaEvent = :namaEvent"),
    @NamedQuery(name = "Event.findByDeskripsiEvent", query = "SELECT e FROM Event e WHERE e.deskripsiEvent = :deskripsiEvent"),
    @NamedQuery(name = "Event.findByJmlJamaah", query = "SELECT e FROM Event e WHERE e.jmlJamaah = :jmlJamaah"),
    @NamedQuery(name = "Event.findByTglEvent", query = "SELECT e FROM Event e WHERE e.tglEvent = :tglEvent"),
    @NamedQuery(name = "Event.findByJamMulai", query = "SELECT e FROM Event e WHERE e.jamMulai = :jamMulai"),
    @NamedQuery(name = "Event.findByJamSelesai", query = "SELECT e FROM Event e WHERE e.jamSelesai = :jamSelesai"),
    @NamedQuery(name = "Event.findByStatus", query = "SELECT e FROM Event e WHERE e.status = :status")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @EmbeddedId
    protected EventPK eventPK;
    @Size(max = 50)
    @Column(name = "nama_event")
    private String namaEvent;
    @Size(max = 2147483647)
    @Column(name = "deskripsi_event")
    private String deskripsiEvent;
    @Column(name = "jml_jamaah")
    private Integer jmlJamaah;
    @Size(max = 50)
    @Column(name = "tgl_event")
    private String tglEvent;
    @Size(max = 50)
    @Column(name = "jam_mulai")
    private String jamMulai;
    @Size(max = 50)
    @Column(name = "jam_selesai")
    private String jamSelesai;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "id_anggota", referencedColumnName = "id_anggota", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AnggotaDKM anggotaDKM;

    /**
     *
     */
    public Event() {
    }

    /**
     *
     * @param eventPK
     */
    public Event(EventPK eventPK) {
        this.eventPK = eventPK;
    }

    /**
     *
     * @param idEvent
     * @param idAnggota
     */
    public Event(String idEvent, String idAnggota) {
        this.eventPK = new EventPK(idEvent, idAnggota);
    }

    /**
     *
     * @return
     */
    public EventPK getEventPK() {
        return eventPK;
    }

    /**
     *
     * @param eventPK
     */
    public void setEventPK(EventPK eventPK) {
        this.eventPK = eventPK;
    }

    /**
     *
     * @return
     */
    public String getNamaEvent() {
        return namaEvent;
    }

    /**
     *
     * @param namaEvent
     */
    public void setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
    }

    /**
     *
     * @return
     */
    public String getDeskripsiEvent() {
        return deskripsiEvent;
    }

    /**
     *
     * @param deskripsiEvent
     */
    public void setDeskripsiEvent(String deskripsiEvent) {
        this.deskripsiEvent = deskripsiEvent;
    }

    /**
     *
     * @return
     */
    public Integer getJmlJamaah() {
        return jmlJamaah;
    }

    /**
     *
     * @param jmlJamaah
     */
    public void setJmlJamaah(Integer jmlJamaah) {
        this.jmlJamaah = jmlJamaah;
    }

    /**
     *
     * @return
     */
    public String getTglEvent() {
        return tglEvent;
    }

    /**
     *
     * @param tglEvent
     */
    public void setTglEvent(String tglEvent) {
        this.tglEvent = tglEvent;
    }

    /**
     *
     * @return
     */
    public String getJamMulai() {
        return jamMulai;
    }

    /**
     *
     * @param jamMulai
     */
    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    /**
     *
     * @return
     */
    public String getJamSelesai() {
        return jamSelesai;
    }

    /**
     *
     * @param jamSelesai
     */
    public void setJamSelesai(String jamSelesai) {
        this.jamSelesai = jamSelesai;
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
        hash += (eventPK != null ? eventPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventPK == null && other.eventPK != null) || (this.eventPK != null && !this.eventPK.equals(other.eventPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adm.model.Event[ eventPK=" + eventPK + " ]";
    }
    
}
