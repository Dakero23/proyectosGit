/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.hitss.ws;

import co.com.hitss.wshitss.EJB.TipoDocumentoFacadeLocal;
import co.com.hitss.wshitss.entidad.TipoDocumento;
import co.com.hitss.wshitss.entidad.respuestaWS;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author kevrodriguez
 */
@WebService(serviceName = "service/wsTipoDocumento")
public class wsTipoDocumento {

    @EJB
    private TipoDocumentoFacadeLocal tipoDocumentoFacade;

    @WebMethod(operationName = "create")
    public respuestaWS create(@WebParam(name = "tipoDocumento") TipoDocumento tipoDocumento) {
        respuestaWS respuesta = new respuestaWS();
        String mensaje;
        try {
            System.out.println(tipoDocumento.getNomdocumento());
            System.out.println(tipoDocumento.getTipodocumento());
            mensaje = tipoDocumentoFacade.createTD(tipoDocumento);

            respuesta.setCodigo(200);
            respuesta.setMensaje(mensaje);
        } catch (Exception e) {
            if (e.getCause() != null && e.getCause().getCause().getMessage().contains("SQLIntegrityConstraintViolationException")) {
                DatabaseException sqlErm = (DatabaseException) e.getCause().getCause();
                if (sqlErm.getCause() instanceof SQLIntegrityConstraintViolationException) {
                    respuesta.setCodigo(sqlErm.getErrorCode());
                    respuesta.setMensaje(sqlErm.getMessage());
                } else {
                    respuesta.setCodigo(sqlErm.getDatabaseErrorCode());
                    respuesta.setMensaje(sqlErm.getMessage());
                }
            } else {
                respuesta.setCodigo(100);
                respuesta.setMensaje(e.getCause().getMessage());
            }

        }
        return respuesta;
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "tipoDocumento") TipoDocumento tipoDocumento) {
        tipoDocumentoFacade.edit(tipoDocumento);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "tipoDocumento") TipoDocumento tipoDocumento) {
        tipoDocumentoFacade.remove(tipoDocumento);
    }

    @WebMethod(operationName = "find")
    public TipoDocumento find(@WebParam(name = "id") Object id) {
        return tipoDocumentoFacade.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<TipoDocumento> findAll() {
        return tipoDocumentoFacade.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<TipoDocumento> findRange(@WebParam(name = "range") int[] range) {
        return tipoDocumentoFacade.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return tipoDocumentoFacade.count();
    }

}
