/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.Hitss.bean;

import co.com.Hitss.Utilidades.util;
import co.com.Hitss.entidad.TipoDocumento;
import co.com.Hitss.entidad.Usuario;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author kevrodriguez
 */
@Named(value = "beanUsuario")
@ViewScoped
public class BeanUsuario {

    private Tramas trama;
    private Usuario usuario;
    private util utilidadesFaces;

    /**
     * Creates a new instance of BeanUsuario
     */
    public BeanUsuario() {
    }

    @PostConstruct
    private void init() {
        usuario = new Usuario();
        utilidadesFaces = new util();
        trama = new Tramas();
    }

    /**
     * Getter y Setter
     *
     * @return
     */
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
