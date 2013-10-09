package test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import net.lalotech.xmltojson.XmlToJsonParser;
import net.lalotech.xmltojson.XmlToJsonUtil;
import net.lalotech.xmltojson.model.Placemark;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;

/**
 * Hello world!
 *
 */
public class AppMB {

    public static void main(String[] args) throws Exception {        
        
        String pathDemo = "C:\\Users\\Eduardo\\Desktop\\database.xml";
        String json = XmlToJsonParser.fileNameToJsonObject(pathDemo).toString();             
        
//        String path = "C:\\Users\\Eduardo\\Downloads\\Lnea1MetrobsAvdelosInsurgentes.kml";
//
//        //String r = XmlToJsonParser.fileToJsonObject(new File(path)).toString();
//        JSONObject obj = XmlToJsonParser.fileNameToJsonObject(path);
//        //JSONArray places = XmlToJsonUtil.selectSubArrayJson(obj, "Placemark");
//        JSONArray places = XmlToJsonUtil.selectSubArrayJson(obj, new String[]{"kml", "Document", "Placemark"});
//        //JSONObject name = XmlToJsonUtil.selectSubObjectJson(obj, new String[]{"kml","Document","test"});
//        String r = places.toString();
//        System.out.println(r);
//        Type listType = new TypeToken<List<Placemark>>(){}.getType();
//        List<Placemark> p = new Gson().fromJson(r, listType);
//        System.err.println("places: "+p.size());
        
    }
}
