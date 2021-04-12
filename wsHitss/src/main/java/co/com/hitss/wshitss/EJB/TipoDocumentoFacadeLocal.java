/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.hitss.wshitss.EJB;

import co.com.hitss.wshitss.entidad.TipoDocumento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kevrodriguez
 */
@Local
public interface TipoDocumentoFacadeLocal {

    void create(TipoDocumento tipoDocumento);

    void edit(TipoDocumento tipoDocumento);

    void remove(TipoDocumento tipoDocumento);

    TipoDocumento find(Object id);

    List<TipoDocumento> findAll();

    List<TipoDocumento> findRange(int[] range);

    int count();

    String createTD(TipoDocumento tipoDocumento);
}
