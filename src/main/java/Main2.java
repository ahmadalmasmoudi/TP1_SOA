
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.File;

public class Main2 {

    public static void main(String[] args) throws Exception {

        Document document = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(new File("src/main/resources/films.xml"));

        XPath xpath = XPathFactory.newInstance().newXPath();

        XPathExpression expression = xpath.compile(
                "/catalogue/film/titre"
        );

        NodeList titres = (NodeList) expression.evaluate(
                document,
                XPathConstants.NODESET
        );

        for (int i = 0; i < titres.getLength(); i++) {
            System.out.println(titres.item(i).getTextContent());
        }
    }
}
