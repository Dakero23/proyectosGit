/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.hitss.wshitss.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author kevrodriguez
 */
@Entity
@Table(name = "USUARIO")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUSUARIO")
    private Integer idusuario;
    
    @Size(max = 30)
    @Column(name = "NOMBREUSUARIO")
    private String nombreusuario;
    
    @Size(max = 60)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Size(max = 60)
    @Column(name = "APELLIDO")
    private String apellido;
    
    @Column(name = "NUMERODOCUMENTO")
    private Integer numerodocumento;
    
    @Size(max = 30)
    @Column(name = "AUDUSUARIO")
    private String audusuario;
    
    @Column(name = "AUDFECHA")
    @Temporal(TemporalType.DATE)
    
    private Date audfecha;
    @JoinColumn(name = "TIPODOCUMENTO", referencedColumnName = "TIPODOCUMENTO")
    @ManyToOne
    private TipoDocumento tipodocumento;
    @JoinColumn(name = "IDTIPOUSUARIO", referencedColumnName = "IDTIPOUSUARIO")
    @ManyToOne
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.hitss.wshitss.entidad.Usuario[ idusuario=" + idusuario + " ]";
    }

}
