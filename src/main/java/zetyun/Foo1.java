package zetyun;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.FileWriter;

/**
 * Created by ryan on 17-8-1.
 */
public class Foo1 {

    /**
     * Create a new xml document
     * @return
     */
    public Document createDocument() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("root");

        Element author1 = root.addElement("author")
                .addAttribute("name", "james")
                .addAttribute("location", "UK")
                .addText("James Strachan");

        Element author2 = root.addElement("author")
                .addAttribute("name", "Bob")
                .addAttribute("location", "US")
                .addText("Bob McWhirter");

        // write xml to a file
        try{
            FileWriter out = new FileWriter("newfile.xml");
        }catch (Exception error){
            error.printStackTrace();
        }
        return document;
    }

}
