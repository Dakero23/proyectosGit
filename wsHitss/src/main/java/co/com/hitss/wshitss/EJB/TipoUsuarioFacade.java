/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.hitss.wshitss.EJB;

import co.com.hitss.wshitss.entidad.TipoUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kevrodriguez
 */
@Stateless
public class TipoUsuarioFacade extends AbstractFacade<TipoUsuario> implements TipoUsuarioFacadeLocal {

    @PersistenceContext(unitName = "co.com.Hitss_wsHitss_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoUsuarioFacade() {
        super(TipoUsuario.class);
    }
    
}
