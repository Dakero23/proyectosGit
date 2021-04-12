/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.hitss.wshitss.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kevrodriguez
 */
@Entity
@Table(name = "TIPO_DOCUMENTO")
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(min = 1, max = 2)
    @Column(name = "TIPODOCUMENTO")
    private String tipodocumento;
    
    @Size(min = 1, max = 40)
    @Column(name = "NOMDOCUMENTO")
    private String nomdocumento;
   
    public TipoDocumento() {
    }

    public TipoDocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public TipoDocumento(String tipodocumento, String nomdocumento) {
        this.tipodocumento = tipodocumento;
        this.nomdocumento = nomdocumento;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNomdocumento() {
        return nomdocumento;
    }

    public void setNomdocumento(String nomdocumento) {
        this.nomdocumento = nomdocumento;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipodocumento != null ? tipodocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.tipodocumento == null && other.tipodocumento != null) || (this.tipodocumento != null && !this.tipodocumento.equals(other.tipodocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.hitss.wshitss.entidad.TipoDocumento[ tipodocumento=" + tipodocumento + " ]";
    }
    
}
