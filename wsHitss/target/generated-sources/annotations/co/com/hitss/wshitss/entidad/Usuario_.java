package co.com.hitss.wshitss.entidad;

import co.com.hitss.wshitss.entidad.TipoDocumento;
import co.com.hitss.wshitss.entidad.TipoUsuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-11T19:44:07")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> nombreusuario;
    public static volatile SingularAttribute<Usuario, Date> audfecha;
    public static volatile SingularAttribute<Usuario, TipoUsuario> idtipousuario;
    public static volatile SingularAttribute<Usuario, String> apellido;
    public static volatile SingularAttribute<Usuario, Integer> numerodocumento;
    public static volatile SingularAttribute<Usuario, String> audusuario;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, Integer> idusuario;
    public static volatile SingularAttribute<Usuario, TipoDocumento> tipodocumento;

}