/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.Hitss.entidad;

/**
 *
 * @author kevrodriguez
 */
public class TipoDocumento {

    private String tipodocumento;
    private String nomdocumento;

    public TipoDocumento() {
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

}
