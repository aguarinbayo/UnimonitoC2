/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.ejb;

import co.edu.uniminuto.entidades.Boleteria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Onescreen
 */
@Stateless
public class BoleteriaFacade extends AbstractFacade<Boleteria> implements BoleteriaFacadeLocal {

    @PersistenceContext(unitName = "unimonitos2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BoleteriaFacade() {
        super(Boleteria.class);
    }
    
}
