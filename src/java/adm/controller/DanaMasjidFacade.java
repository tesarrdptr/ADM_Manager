/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.controller;

import adm.model.DanaMasjid;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RAKA
 */
@Stateless
public class DanaMasjidFacade extends AbstractFacade<DanaMasjid> {

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
    public DanaMasjidFacade() {
        super(DanaMasjid.class);
    }
    
    public List<DanaMasjid> getDataPemasukan() {
        return em.createNamedQuery("DanaMasjid.findPemasukan", DanaMasjid.class)
                .getResultList();
    }
    
}
