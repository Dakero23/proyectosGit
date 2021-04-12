/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.hitss.wshitss.EJB;

import co.com.hitss.wshitss.entidad.TipoDocumento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author kevrodriguez
 */
@Stateless
public class TipoDocumentoFacade extends AbstractFacade<TipoDocumento> implements TipoDocumentoFacadeLocal {

    @PersistenceContext(unitName = "co.com.Hitss_wsHitss_war_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDocumentoFacade() {
        super(TipoDocumento.class);
    }

    /**
     *
     * @param tipoDoc
     * @return
     */
    @Override
    public String createTD(TipoDocumento tipoDoc) {
        String msj = "";
        try {
            getEntityManager().persist(tipoDoc);
            getEntityManager().flush();
            msj = "Registro creado";
        } catch (ConstraintViolationException e) {
            // Aqui tira los errores de constraint
            for (ConstraintViolation actual : e.getConstraintViolations()) {
                System.out.println(actual.toString());
                msj = actual.toString();
            }
        }
        return msj;
    }

}
