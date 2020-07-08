package Project2;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class XMLReader {

    /**
     * location of state capitals xml file
     */
    public static final String STATE_CAPITALS_XML_FILE = "src/main/resources/states.xml";

    /**
     * grabs "raw" content of a particular xpath expression and returns it as a list of string
     *
     * @param expression xpath expression (usually starts with // )
     * @return list of content as strings
     * @throws IOException
     * @throws XPathExpressionException
     */
    public static List<String> getTagContent(String expression) throws IOException, XPathExpressionException {
        XPath xpath = XPathFactory.newInstance().newXPath();
        File file = new File(STATE_CAPITALS_XML_FILE);
        FileInputStream stream = new FileInputStream(file);
        InputSource source = new InputSource(stream);
        // grab data from XML file using XPath
        // https://blog.scrapinghub.com/2016/10/27/an-introduction-to-xpath-with-examples
        XPathExpression expr = xpath.compile(expression);
        NodeList list = (NodeList) expr.evaluate(source, XPathConstants.NODESET);
        List<String> content = new ArrayList<String>();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            content.add(node.getTextContent());
        }
        stream.close();
        return content;
    }

    /**
     * Generate map of state name and state capital of all 50 states of america
     *
     * @return map of 50 american state name and state capital
     * @throws IOException
     * @throws XPathExpressionException
     */
    public static Map<String, String> getStates() throws IOException, XPathExpressionException {
        List<String> stateNames = XMLReader.getTagContent("//state");
        List<String> stateCapitals = XMLReader.getTagContent("//capital");
        Map<String, String> states = new TreeMap<String, String>();
        for (int i = 0; i < stateNames.size(); i++) {
            states.put(stateNames.get(i), stateCapitals.get(i));
        }
        return states;
    }

    public static Map< String,String> getStateCapitals() throws IOException,XPathExpressionException{

       List<String> stateCapitals=XMLReader.getTagContent("//capitals");
       Map<String,String> capitals=new HashMap<>();
        for (int i = 0; i <stateCapitals.size() ; i++) {
            capitals.put(stateCapitals.get(i),stateCapitals.get(i));
        }
        return capitals;
    }


}