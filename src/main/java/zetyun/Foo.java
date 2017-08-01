package zetyun;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ryan on 17-8-1.
 */
public class Foo {
    public Document parse(URL url) throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }

    public void bar(Document document) throws DocumentException{
        Element root = document.getRootElement();

        // iterate through child elements of root
        for (Iterator<Element> it = root.elementIterator(); it.hasNext(); ){
            Element foo = it.next();
            // do something
        }

        // iterate through child elements of root with element name "foo"
        for (Iterator<Element> it = root.elementIterator("foo"); it.hasNext();){
            Element foo = it.next();
            // do something
        }

        // iterate through attributes of root
        for (Iterator<Attribute> it = root.elementIterator(); it.hasNext();){
            Attribute attribute = it.next();
            // do something
        }

    }

    /**
     * parser the node example
     * @param document
     */
    public void bar1(Document document){
        List<Node> list = document.selectNodes("//foo/bar");
        Node node = document.selectSingleNode("/foo/bar/author");
        String name = node.valueOf("@name");
    }

    /**
     * For example if you wish to find all the hypertext links in an XHTML document the following code woild do the trick
     */
    public void findLinks(Document document) throws DocumentException{
        List<Node> list = document.selectNodes("//a/@href");
        for (Iterator<Node> iter = list.iterator(); iter.hasNext();){
            Attribute attribute = (Attribute) iter.next();
            String url = attribute.getValue();
        }
     }

    /**
     * if you ever have to walk a large XML document tree then for performance we recommend you use the fast looping method which
     * avoids the cost of creating an Iterator object for each loop.
     */
    public void treeWalk(Document document){
        treeWalk(document.getRootElement());
    }

    public void treeWalk(Element element){
        for (int i = 0, size = element.nodeCount(); i < size; i++){
            Node node = element.node(i);
            if (node instanceof  Element){
                treeWalk((Element) node);
            }else{
                // do something
            }
        }
    }



}


