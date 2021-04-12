/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.Hitss.Utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author kevrodriguez
 */
public class util {

    /**
     * Metodo encargado de consumir un web service http
     *
     * @param endPoint
     * @param xmlInput
     * @return
     */
    public String getContenidoHTML(String endPoint, String xmlInput) {
        String responseString = "";

        if (endPoint != null && xmlInput != null) {
            URL URLForSOAP;
            try {
                URLForSOAP = new URL(endPoint);
                URLConnection URLConnectionForSOAP = URLForSOAP.openConnection();
                HttpURLConnection Connection = (HttpURLConnection) URLConnectionForSOAP;
                Connection.setDoOutput(true);
                Connection.setDoInput(true);
                Connection.setRequestMethod("POST");
                Connection.setRequestProperty("Host", getHostNameFromUrl(endPoint));
                Connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
                BufferedReader soapRequestReader;
                try (OutputStreamWriter soapRequestWriter = new OutputStreamWriter(Connection.getOutputStream())) {
                    soapRequestWriter.write(xmlInput);
                    soapRequestWriter.flush();
                    soapRequestReader = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
                    String line;
                    while ((line = soapRequestReader.readLine()) != null) {
                        responseString = responseString.concat(line);
                    }
                }
                soapRequestReader.close();
                Connection.disconnect();
            } catch (MalformedURLException ex) {
                System.out.println(" util.getContenidoHTML MalformedURLException: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println(" util.getContenidoHTML IOException: " + ex.getMessage());
            }
        }
        return responseString;
    }

    /**
     * Metodo encargado de obtener el host, en el endpoint de la peticion
     *
     * @param urlString
     * @return
     */
    public static String getHostNameFromUrl(String urlString) {
        return urlString.substring(7, urlString.indexOf("/", 7));
    }

    /**
     * Metodo encargado de crear diferentes alertas en la vista mediante un
     * mensaje growl
     *
     * Method in charge of creating different alerts in the view through message
     * growl
     *
     * @param tipoMensaje
     * @param textoMensaje
     */
    public void agregaMensaje(String tipoMensaje, String textoMensaje) {
        switch (tipoMensaje.toUpperCase()) {
            case "ERROR":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !", textoMensaje));
                break;
            case "FATAL":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal !", textoMensaje));
                break;
            case "INFO":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info !", textoMensaje));
                break;
            case "WARN":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warm !", textoMensaje));
                break;
            case "ERROR2":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, textoMensaje, ""));
                break;
            case "FATAL2":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, textoMensaje, ""));
                break;
            case "INFO2":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, textoMensaje, ""));
                break;
            case "WARN2":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, textoMensaje, ""));
                break;
            default:
                break;
        }
    }

    /**
     * Metodo que trae la URL del servidor donde se encuentra desplegado el
     * aplicativo
     *
     * Method that brings the URL of the server where the application
     *
     * @return
     */
    public String getRequestURL() {
        Object request = FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return ((HttpServletRequest) request).getScheme() + "://" + ((HttpServletRequest) request).getServerName()
                + ":" + ((HttpServletRequest) request).getServerPort() + ((HttpServletRequest) request).getContextPath();
    }

    /**
     * Metodo encargado de leer el archivo config.propertis con la finalidad de
     * leer variable sque pueden cambiar de forma en cualquier momento.
     *
     * Se crea de esta forma con la finalidad de poderse modificar sin tener que
     * realizar un re despliegue de la aplicacion en el servidor.
     *
     * @param keyPropiedad
     * @return
     */
    public String getPropValues(String keyPropiedad) {
        Properties prop = new Properties();
        String propFileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        try {
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                return null;
            }
            String propiedad = prop.getProperty(keyPropiedad);
            return propiedad;
        } catch (IOException e) {
            return null;
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                return null;
            }
        }

    }

    /**
     * Metodo encargado de procesar las respuestas de una tramaws agregando los
     * nodos a un hashMap
     *
     * Nota: Suelo manejarlo mediante un procedimiento almacenado en pl/sql
     * mediante tablas XMLTABLE Oracle para el procesamiento completo del xml
     * resibido con la finalidad de no realizar un redespliegue en el servidor
     * de aplicaciones
     *
     * @param tramaWS
     * @param nodos
     * @return
     */
    public HashMap procesarRespuesta(String tramaWS, HashMap nodos) {
        HashMap respuestaWS = new HashMap();
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource src = new InputSource();
            src.setCharacterStream(new StringReader(tramaWS));

            Document doc = builder.parse(src);
            for (Iterator it = nodos.entrySet().iterator(); it.hasNext();) {
                Map.Entry next = (Map.Entry) it.next();
                respuestaWS.put(next.getKey(), doc.getElementsByTagName(next.getKey().toString()).item(0).getTextContent());
            }
            return respuestaWS;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            respuestaWS.put("codigo", 3000);
            respuestaWS.put("mensaje", ex.getCause());
            return respuestaWS;
        }
    }

}
