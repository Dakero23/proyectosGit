/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.Hitss.entidad;

import java.io.Serializable;

/**
 *
 * @author kevrodriguez
 */
public class TipoUsuario implements Serializable {

    private Integer idtipousuario;
    private String nomtipousuario;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer idtipousuario, String nomtipousuario) {
        this.idtipousuario = idtipousuario;
        this.nomtipousuario = nomtipousuario;
    }

    public Integer getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(Integer idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    public String getNomtipousuario() {
        return nomtipousuario;
    }

    public void setNomtipousuario(String nomtipousuario) {
        this.nomtipousuario = nomtipousuario;
    }

}
