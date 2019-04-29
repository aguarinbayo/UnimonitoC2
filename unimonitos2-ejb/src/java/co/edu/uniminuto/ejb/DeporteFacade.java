/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.ejb;

import co.edu.uniminuto.entidades.Deporte;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Onescreen
 */
@Stateless
public class DeporteFacade extends AbstractFacade<Deporte> implements DeporteFacadeLocal {

    @PersistenceContext(unitName = "unimonitos2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeporteFacade() {
        super(Deporte.class);
    }
    
}
