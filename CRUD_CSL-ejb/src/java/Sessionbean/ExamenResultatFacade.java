/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessionbean;

import Entities.ExamenResultat;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author baggins
 */
@Stateless
public class ExamenResultatFacade extends AbstractFacade<ExamenResultat> implements ExamenResultatFacadeLocal {

    @PersistenceContext(unitName = "CRUD_CSL-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExamenResultatFacade() {
        super(ExamenResultat.class);
    }
    
}
