/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessionbean;

import Entities.CategorieResultat;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author baggins
 */
@Local
public interface CategorieResultatFacadeLocal {

    void create(CategorieResultat catégorieRésultat);

    void edit(CategorieResultat catégorieRésultat);

    void remove(CategorieResultat catégorieRésultat);

    CategorieResultat find(Object id);

    List<CategorieResultat> findAll();

    List<CategorieResultat> findRange(int[] range);

    int count();
    
}
