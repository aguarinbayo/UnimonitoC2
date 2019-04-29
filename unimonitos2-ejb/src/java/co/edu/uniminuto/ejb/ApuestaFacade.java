/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.ejb;

import co.edu.uniminuto.entidades.Apuesta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Onescreen
 */
@Stateless
public class ApuestaFacade extends AbstractFacade<Apuesta> implements ApuestaFacadeLocal {

    @PersistenceContext(unitName = "unimonitos2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApuestaFacade() {
        super(Apuesta.class);
    }
    
}
