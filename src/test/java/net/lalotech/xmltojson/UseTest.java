/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.lalotech.xmltojson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import net.lalotech.xmltojson.model.Placemark;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

/**
 *
 * @author Eduardo
 */
public class UseTest {
    
    @Test
    public void test1() throws Exception{
        System.out.println("call test1");
         String path = "C:\\Users\\Eduardo\\Downloads\\Lnea1MetrobsAvdelosInsurgentes.kml";

        //String r = XmlToJsonParser.fileToJsonObject(new File(path)).toString();
        JSONObject obj = XmlToJsonParser.fileNameToJsonObject(path);
        //JSONArray places = XmlToJsonUtil.selectSubArrayJson(obj, "Placemark");
        JSONArray places = XmlToJsonUtil.selectSubArrayJson(obj, new String[]{"kml", "Document", "Placemark"});
        //JSONObject name = XmlToJsonUtil.selectSubObjectJson(obj, new String[]{"kml","Document","test"});
        String r = places.toString();
        System.out.println(r);
        Type listType = new TypeToken<List<Placemark>>(){}.getType();
        List<Placemark> p = new Gson().fromJson(r, listType);
        System.err.println("places: "+p.size());
    }
}
