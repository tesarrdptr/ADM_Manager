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
public class EventPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_event")
    private String idEvent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_anggota")
    private String idAnggota;

    /**
     *
     */
    public EventPK() {
    }

    /**
     *
     * @param idEvent
     * @param idAnggota
     */
    public EventPK(String idEvent, String idAnggota) {
        this.idEvent = idEvent;
        this.idAnggota = idAnggota;
    }

    /**
     *
     * @return
     */
    public String getIdEvent() {
        return idEvent;
    }

    /**
     *
     * @param idEvent
     */
    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
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
        hash += (idEvent != null ? idEvent.hashCode() : 0);
        hash += (idAnggota != null ? idAnggota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventPK)) {
            return false;
        }
        EventPK other = (EventPK) object;
        if ((this.idEvent == null && other.idEvent != null) || (this.idEvent != null && !this.idEvent.equals(other.idEvent))) {
            return false;
        }
        if ((this.idAnggota == null && other.idAnggota != null) || (this.idAnggota != null && !this.idAnggota.equals(other.idAnggota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adm.model.EventPK[ idEvent=" + idEvent + ", idAnggota=" + idAnggota + " ]";
    }
    
}
