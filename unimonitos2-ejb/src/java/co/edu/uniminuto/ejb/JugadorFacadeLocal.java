/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.ejb;

import co.edu.uniminuto.entidades.Jugador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Onescreen
 */
@Local
public interface JugadorFacadeLocal {

    void create(Jugador jugador);

    void edit(Jugador jugador);

    void remove(Jugador jugador);

    Jugador find(Object id);

    List<Jugador> findAll();

    List<Jugador> findRange(int[] range);

    int count();
    
}
