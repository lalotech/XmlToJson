package com.mycompany.xmltojson;

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
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;

/**
 * Hello world!
 *
 */
public class AppMB {

    public static void main(String[] args) {
        try {
            String path = "E:\\developer\\proyectos\\MiCiudad\\db\\";
            File fXmlFile = new File(path+"places.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

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
            JSONObject jsonObject = XML.toJSONObject(output);          
            
            /*FileWriter jsonFile = new FileWriter(path+"places.json");
            BufferedWriter bw = new BufferedWriter(jsonFile);
            
            bw.write(jsonObject.toString());
            bw.close();*/
            String db ="hospitales-df";
            Integer typeId = 5;
            
            JSONObject places = jsonObject.getJSONObject("places");
            JSONObject gimnasios = places.getJSONObject(db);            
            Type listType = new TypeToken<List<Placemark>>() {}.getType();
            List<Placemark> p = new Gson().fromJson(gimnasios.getJSONArray("Placemark").toString(),listType);
            
            System.out.println("p "+p.size());
            /*for (Placemark pl : p) {
                System.out.println("------------------------------");
                System.out.println(pl.getName());
                System.out.println(pl.getDescription());   
                String[] arr = pl.getPoint().getCoordinates().split(",");
                System.out.println(arr[0]+" "+arr[1]);
            }*/
            StringBuilder sb = new StringBuilder();
            sb.append("-- ----------------------------\n");
            sb.append("-- -- Records of "+db+" \n");
            sb.append("-- ----------------------------\n");
            
            for (Placemark pl : p) {                
                String[] arr = pl.getPoint().getCoordinates().split(",");
                String row = "INSERT INTO place (name,description,coordinates,idType) VALUES ('"+pl.getName()+"','"+pl.getDescription()+"','"+arr[0]+","+arr[1]+"',"+typeId+");";
                sb.append(row+"\n");
            }
            
            //Export to sql file
            BufferedWriter bw = new BufferedWriter(new FileWriter(path+db+".sql"));             
            bw.write(sb.toString());
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
