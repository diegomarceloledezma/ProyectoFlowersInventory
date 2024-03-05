import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;

import org.w3c.dom.Document;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FeedParserXml implements FeedParser {

    @Override
    public List<Flower> parse(String content) {

        List<Flower> flowersData = new ArrayList<>();
        try {
            InputStream inputStream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            XPathExpression expr = xpath.compile("/root/row");
            NodeList nodeList = (NodeList) expr.evaluate(document, XPathConstants.NODESET);


            for (int i = 0; i < nodeList.getLength(); i++) {
                Node rowNode = nodeList.item(i);

                String id = xpath.evaluate("id", rowNode);
                String name = xpath.evaluate("name", rowNode);
                String stock = xpath.evaluate("stock", rowNode);

                Flower flower = new Flower(Integer.parseInt(id), name, Integer.parseInt(stock));
                flowersData.add(flower);
            }

        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return flowersData;
     }

}