/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessionbean;

import Entities.Calendrier;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author baggins
 */
@Stateless
public class CalendrierFacade extends AbstractFacade<Calendrier> implements CalendrierFacadeLocal {

    @PersistenceContext(unitName = "CRUD_CSL-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalendrierFacade() {
        super(Calendrier.class);
    }
    
}
