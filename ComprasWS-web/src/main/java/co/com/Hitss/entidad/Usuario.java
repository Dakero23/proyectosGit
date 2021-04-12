/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.Hitss.entidad;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author kevrodriguez
 */
public class Usuario implements Serializable {

    private Integer idusuario;
    private String nombreusuario;
    private String nombre;
    private String apellido;
    private Integer numerodocumento;
    private String audusuario;
    private Date audfecha;
    private TipoDocumento tipodocumento;
    private TipoUsuario idtipousuario;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(Integer numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getAudusuario() {
        return audusuario;
    }

    public void setAudusuario(String audusuario) {
        this.audusuario = audusuario;
    }

    public Date getAudfecha() {
        return audfecha;
    }

    public void setAudfecha(Date audfecha) {
        this.audfecha = audfecha;
    }

    public TipoDocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(TipoDocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public TipoUsuario getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(TipoUsuario idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

}
