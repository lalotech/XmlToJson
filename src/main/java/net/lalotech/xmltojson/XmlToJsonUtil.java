/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lalotech.xmltojson;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Eduardo
 */
public class XmlToJsonUtil {

    private final static Logger log = Logger.getLogger(XmlToJsonUtil.class);

    /**
     * simple atajo a: selectSubArrayJson(JSONObject src, String[] root);
     * 
     * @param src
     * @param arrayName
     * @return
     * @throws Exception 
     */
    public static JSONArray selectSubArrayJson(JSONObject src, String arrayName) throws Exception {
        return selectSubArrayJson(src, new String[]{arrayName});
    }

    /**
     * Simple atajo a: selectSubObjectJson(JSONObject src, String[] root); 
     *  
     * @param src
     * @param objectName
     * @return
     * @throws Exception 
     */
    public static JSONObject selectSubObjectJson(JSONObject src, String objectName) throws Exception {
        return selectSubObjectJson(src, new String[]{objectName});
    }
    
    /**
     * Metodo para extraer un sub-array contentenido en el objeto json
     * La profundidad esta dada por el parametro root que es un String[] con los niveles
     * ejemplo: 
     * 
     *   Ej-1:   selectSubArrayJson(obj,new String[]{"objecto1","objecto2","array1"}); - 3 niveles dentro del objeto original
     * 
     * donde devolvera el array correspondiente a el ultimo campo para este caso "array1"
     *  
     *   Ej-2:   selectSubArrayJson(obj,new String[]{"array1"}); - simple seleccion
     * 
     * donde devolvera el array en nivel 1 del objeto src.
     * 
     * @param src
     * @param root
     * @return
     * @throws Exception 
     */
    public static JSONArray selectSubArrayJson(JSONObject src, String[] root) throws Exception {
        JSONArray array = null;
        JSONObject temp = src;
        for (int i = 0; i < root.length; i++) {
            //seleciona objeto hasta el penultimo por uqe el ultimo debe ser array
            if ((i + 1) == root.length) {
                //si es el ultimo va sobre el array
                log.debug("object: " + root[i]);
                array = temp.getJSONArray(root[i]);
            } else {
                log.debug("object: " + root[i]);
                temp = temp.getJSONObject(root[i]);
            }
        }
        return array;
    }
    /**
     * Metodo para extraer un sub-objeto contentenido en el objeto json
     * La profundidad esta dada por el parametro root que es un String[] con los niveles
     * ejemplo: 
     * 
     *   Ej-1:   selectSubArrayJson(obj,new String[]{"objecto1","objecto2","objeto3"}); - 3 niveles dentro del objeto original
     * 
     * donde devolvera el objeto correspondiente a el ultimo campo para este caso "objeto3"
     *  
     *   Ej-2:   selectSubArrayJson(obj,new String[]{"objeto1"}); - simple seleccion
     * 
     * donde devolvera el objeto en nivel 1 del objeto src.
     * 
     * @param src
     * @param root
     * @return
     * @throws Exception 
     */
    public static JSONObject selectSubObjectJson(JSONObject src, String[] root) throws Exception {
        JSONObject temp = src;
        for(String o: root) {
            log.debug("object: " + o);
            temp = temp.getJSONObject(o);
        }
        return temp;
    }
}
