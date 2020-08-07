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
@Table(name = "member")
@NamedQueries({
    @NamedQuery(name = "Member1.findAll", query = "SELECT m FROM Member1 m"),
    @NamedQuery(name = "Member1.findByIdMember", query = "SELECT m FROM Member1 m WHERE m.idMember = :idMember"),
    @NamedQuery(name = "Member1.findByNamaMember", query = "SELECT m FROM Member1 m WHERE m.namaMember = :namaMember"),
    @NamedQuery(name = "Member1.findByEmailMember", query = "SELECT m FROM Member1 m WHERE m.emailMember = :emailMember"),
    @NamedQuery(name = "Member1.findByPassMember", query = "SELECT m FROM Member1 m WHERE m.passMember = :passMember"),
    @NamedQuery(name = "Member1.findByTlpMember", query = "SELECT m FROM Member1 m WHERE m.tlpMember = :tlpMember"),
    @NamedQuery(name = "Member1.findByStatus", query = "SELECT m FROM Member1 m WHERE m.status = :status")})
public class Member1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_member")
    private String idMember;
    @Size(max = 50)
    @Column(name = "nama_member")
    private String namaMember;
    @Size(max = 50)
    @Column(name = "email_member")
    private String emailMember;
    @Size(max = 50)
    @Column(name = "pass_member")
    private String passMember;
    @Size(max = 50)
    @Column(name = "tlp_member")
    private String tlpMember;
    @Column(name = "status")
    private Integer status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMember")
    private Collection<PeminjamanBuku> peminjamanBukuCollection;

    /**
     *
     */
    public Member1() {
    }

    /**
     *
     * @param idMember
     */
    public Member1(String idMember) {
        this.idMember = idMember;
    }

    /**
     *
     * @return
     */
    public String getIdMember() {
        return idMember;
    }

    /**
     *
     * @param idMember
     */
    public void setIdMember(String idMember) {
        this.idMember = idMember;
    }

    /**
     *
     * @return
     */
    public String getNamaMember() {
        return namaMember;
    }

    /**
     *
     * @param namaMember
     */
    public void setNamaMember(String namaMember) {
        this.namaMember = namaMember;
    }

    /**
     *
     * @return
     */
    public String getEmailMember() {
        return emailMember;
    }

    /**
     *
     * @param emailMember
     */
    public void setEmailMember(String emailMember) {
        this.emailMember = emailMember;
    }

    /**
     *
     * @return
     */
    public String getPassMember() {
        return passMember;
    }

    /**
     *
     * @param passMember
     */
    public void setPassMember(String passMember) {
        this.passMember = passMember;
    }

    /**
     *
     * @return
     */
    public String getTlpMember() {
        return tlpMember;
    }

    /**
     *
     * @param tlpMember
     */
    public void setTlpMember(String tlpMember) {
        this.tlpMember = tlpMember;
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
    public Collection<PeminjamanBuku> getPeminjamanBukuCollection() {
        return peminjamanBukuCollection;
    }

    /**
     *
     * @param peminjamanBukuCollection
     */
    public void setPeminjamanBukuCollection(Collection<PeminjamanBuku> peminjamanBukuCollection) {
        this.peminjamanBukuCollection = peminjamanBukuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMember != null ? idMember.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Member1)) {
            return false;
        }
        Member1 other = (Member1) object;
        if ((this.idMember == null && other.idMember != null) || (this.idMember != null && !this.idMember.equals(other.idMember))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adm.model.Member1[ idMember=" + idMember + " ]";
    }
    
}
