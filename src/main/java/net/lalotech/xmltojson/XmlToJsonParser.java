/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lalotech.xmltojson;

import java.io.File;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;

/**
 *
 * @author Eduardo
 */
public class XmlToJsonParser {

    static Logger log = Logger.getLogger(XmlToJsonParser.class);
    
    /**
     * Simple parser xml to json
     * 
     * @param xmlContent
     * @return
     * @throws Exception 
     */
    public JSONObject xmlStringContentToJsonObject(String xmlContent)throws Exception{
        return XML.toJSONObject(xmlContent);
    }

   /**
     * Metodo que lee un archivo XML y lo comvierte en un Objecto JSON
     *
     * @param filename
     * @return
     * @throws Exception
     */
    public static JSONObject fileNameToJsonObject(String filename) throws Exception {
        return fileToJsonObject(new File(filename));
    }

    /**
     * Metodo que lee un archivo XML y lo comvierte en un Objecto JSON
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static JSONObject fileToJsonObject(File file) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);

        //optional, but recommended
        //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        doc.getDocumentElement().normalize();

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        String output = writer.getBuffer().toString().replaceAll("\n|\r", "");
        output = output.replaceAll("'", "\'");
        log.debug(output);
        return XML.toJSONObject(output);
    }
}
