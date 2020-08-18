/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessionbean;

import Entities.PresenceEtudiant;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author baggins
 */
@Local
public interface PresenceEtudiantFacadeLocal {

    void create(PresenceEtudiant presenceEtudiant);

    void edit(PresenceEtudiant presenceEtudiant);

    void remove(PresenceEtudiant presenceEtudiant);

    PresenceEtudiant find(Object id);

    List<PresenceEtudiant> findAll();

    List<PresenceEtudiant> findRange(int[] range);

    int count();
    
}
