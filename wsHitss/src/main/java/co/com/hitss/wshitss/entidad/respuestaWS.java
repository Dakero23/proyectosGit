/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.hitss.wshitss.entidad;

import java.util.HashMap;

/**
 *
 * @author kevrodriguez
 */
public class respuestaWS {

    private int codigo;
    private String mensaje;

    public respuestaWS() {
    }

    public respuestaWS(int codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
