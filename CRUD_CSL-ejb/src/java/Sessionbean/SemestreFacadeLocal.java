/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessionbean;

import Entities.Semestre;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author baggins
 */
@Local
public interface SemestreFacadeLocal {

    void create(Semestre semestre);

    void edit(Semestre semestre);

    void remove(Semestre semestre);

    Semestre find(Object id);

    List<Semestre> findAll();

    List<Semestre> findRange(int[] range);

    int count();
    
}
