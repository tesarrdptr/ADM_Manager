/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.controller;

import adm.model.AnggotaDKM;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RAKA
 */
@Stateless
public class AnggotaDKMFacade extends AbstractFacade<AnggotaDKM> {

    @PersistenceContext(unitName = "ADM_ManagerPU")
    private EntityManager em;

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     */
    public AnggotaDKMFacade() {
        super(AnggotaDKM.class);
    }
    
    public boolean getAutentikasi(String email, String password) {
        try {
            em.createQuery("SELECT p FROM AnggotaDKM p WHERE p.emailAnggota = :email and p.passAnggota = :password")
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            return false;
        }
        return em != null;
    }
    
    public List<AnggotaDKM> getData(String email) {
        return em.createQuery("SELECT p FROM AnggotaDKM p WHERE p.emailAnggota = :email")
                .setParameter("email", email)
                .getResultList();
    }
    
}
