/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessionbean;

import Entities.PresenceEtudiant;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author baggins
 */
@Stateless
public class PresenceEtudiantFacade extends AbstractFacade<PresenceEtudiant> implements PresenceEtudiantFacadeLocal {

    @PersistenceContext(unitName = "CRUD_CSL-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresenceEtudiantFacade() {
        super(PresenceEtudiant.class);
    }
    
}
