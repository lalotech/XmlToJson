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

    public static JSONArray selectSubArrayJson(JSONObject src, String arrayName) throws Exception {
        return src.getJSONArray(arrayName);
    }

    public static JSONObject selectSubObjectJson(JSONObject src, String objectName) throws Exception {
        return src.getJSONObject(objectName);
    }

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
    public static JSONObject selectSubObjectJson(JSONObject src, String[] root) throws Exception {
        JSONObject temp = src;
        for(String o: root) {
            log.debug("object: " + o);
            temp = temp.getJSONObject(o);
        }
        return temp;
    }
}
