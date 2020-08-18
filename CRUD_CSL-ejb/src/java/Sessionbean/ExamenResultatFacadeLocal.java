/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessionbean;

import Entities.ExamenResultat;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author baggins
 */
@Local
public interface ExamenResultatFacadeLocal {

    void create(ExamenResultat examenResultat);

    void edit(ExamenResultat examenResultat);

    void remove(ExamenResultat examenResultat);

    ExamenResultat find(Object id);

    List<ExamenResultat> findAll();

    List<ExamenResultat> findRange(int[] range);

    int count();
    
}
