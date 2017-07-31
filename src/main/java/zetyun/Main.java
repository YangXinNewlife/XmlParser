package zetyun;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.Document;
import java.io.File;
import java.util.Iterator;

/**
 * Created by ryan on 17-7-31.
 */
public class Main {
    public static void main(String[] args){
        load("./xmlfiles/simple.xml");
    }

    public static void load(String fileName){
        try{
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(fileName));
            Element root = document.getRootElement();

            Iterator it = root.elementIterator();
            while (it.hasNext()) {
                Element element = (Element) it.next();
                Iterator eleIt = element.elementIterator();
                while (eleIt.hasNext()) {
                    Element e = (Element) eleIt.next();
                    System.out.println(e.getName() + ": " + e.getText());
                }
                System.out.println();

            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
