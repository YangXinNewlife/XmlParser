package zetyun;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * Created by ryan on 17-7-31.
 */
public class Main1 {
    public static void main(String[] args){
        load1("./xmlfiles/simple1.xml");
    }

    public static Document load1(String fileName){
        Document document = null;
        try{
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new File(fileName));
            Element root = document.getRootElement();
            List<Element> childElements = root.elements();
            for(Element i : childElements){
                System.out.println(i.getName() + " : " +i.getData());
            }
        }catch(Exception e){
            System.out.println("Not Found");
            e.printStackTrace();
        }
        return document;
    }
}
