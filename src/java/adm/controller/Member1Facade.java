/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adm.controller;

import adm.model.Member1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RAKA
 */
@Stateless
public class Member1Facade extends AbstractFacade<Member1> {

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
    public Member1Facade() {
        super(Member1.class);
    }
    
}
