/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.Hitss.bean;

import co.com.Hitss.entidad.TipoDocumento;
import co.com.Hitss.entidad.TipoUsuario;

/**
 *
 * @author kevrodriguez
 */
public class Tramas {

    /**
     * Nota: Lo ideal crear un procedimiento almacenado donde se encuentre la
     * Tramas para facilitar el manejo de datos desde el quey y modificaciones
     * desde base de datos, o en su defecto importar todas las clases de JAVA WS
     *
     */
    /**
     * Metodo encargado de crear una Tramas para el consumo de WS para tipo
     * Documento
     *
     * @param tipoDocumento
     * @return
     */
    public String tramaTipoDocumento(TipoDocumento tipoDocumento) {
        String tramaXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\""
                + " xmlns:ws=\"http://ws.hitss.com.co/\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <ws:create>\n"
                + "         <tipoDocumento>\n"
                + "            <nomdocumento>" + tipoDocumento.getNomdocumento() + "</nomdocumento>\n"
                + "            <tipodocumento>" + tipoDocumento.getTipodocumento() + "</tipodocumento>\n"
                + "            </tipoDocumento>\n"
                + "      </ws:create>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";
        return tramaXml;
    }

    public String tramaTipoUsuario(TipoUsuario tipoUsuario) {
        String tramaXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\""
                + " xmlns:ws=\"http://ws.hitss.com.co/\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <ws:create>\n"
                + "         <tipoDocumento>\n"
                //                + "            <nomdocumento>" + tipoUsuario.getNomdocumento() + "</nomdocumento>\n"
                //                + "            <tipodocumento>" + tipoUsuario.getTipodocumento() + "</tipodocumento>\n"
                + "            </tipoDocumento>\n"
                + "      </ws:create>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";
        return tramaXml;
    }

}
