/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.Hitss.bean;

import co.com.Hitss.Utilidades.util;
import co.com.Hitss.entidad.TipoDocumento;
import java.io.Serializable;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author kevrodriguez
 */
@ManagedBean(name = "beanTipoDocumento")
@ViewScoped
public class BeanTipoDocumento implements Serializable {

    private Tramas trama;
    private TipoDocumento tipoDocumento;
    private util utilidadesFaces;

    /**
     * Creates a new instance of BeanTipoDocumento
     */
    public BeanTipoDocumento() {

    }

    @PostConstruct
    private void init() {
        tipoDocumento = new TipoDocumento();
        utilidadesFaces = new util();
        trama = new Tramas();
    }

    /**
     * Metodo encargado de consumir servicio para la creacion de un tipo de
     * documento en la BD. leyendo los parametros desde la Base de datos.
     *
     */
    public void crearTipDoc() {

        String endPoint = utilidadesFaces.getPropValues("ENDTipoDocumento");
        String xmlInput = trama.tramaTipoDocumento(tipoDocumento);
        String xmlOutput = utilidadesFaces.getContenidoHTML(endPoint, xmlInput);
        procesarRespuesta(xmlOutput);
        tipoDocumento = null;
    }

    /**
     * Metodo encargado de leer la respuesta del web service mediante la
     * extraccion de datos de cada nodo
     *
     * @param xmlOutput
     */
    private void procesarRespuesta(String xmlOutput) {
        HashMap nodos = new HashMap(), nTemp;
        nodos.put("codigo", null);
        nodos.put("mensaje", null);
        nTemp = utilidadesFaces.procesarRespuesta(xmlOutput, nodos);
        System.out.println(nTemp.get("codigo"));
        if (nTemp.get("codigo").equals("200")) {
            utilidadesFaces.agregaMensaje("INFO", nTemp.get("mensaje").toString());
        } else {
            utilidadesFaces.agregaMensaje("ERROR", nTemp.get("mensaje").toString());
        }
    }

    /**
     * Setter y Getter
     *
     * @return
     */
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

}
