/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.controller;

import adm.model.PeminjamanBuku;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RAKA
 */
@Stateless
public class PeminjamanBukuFacade extends AbstractFacade<PeminjamanBuku> {

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
    public PeminjamanBukuFacade() {
        super(PeminjamanBuku.class);
    }
    
}
