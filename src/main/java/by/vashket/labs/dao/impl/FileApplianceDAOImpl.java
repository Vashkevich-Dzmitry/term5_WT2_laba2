package by.vashket.labs.dao.impl;

import java.util.ArrayList;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import by.vashket.labs.dao.ApplianceDAO;
import by.vashket.labs.dao.DAOException;
import by.vashket.labs.entity.Appliance;
import by.vashket.labs.entity.ApplianceFactory;
import by.vashket.labs.entity.criteria.Criteria;

public class FileApplianceDAOImpl implements ApplianceDAO{

    private static final String FILE_PATH = "./src/main/resources/appliances_db.xml";

    private Document doc;
    public ArrayList<Appliance> find(Criteria criteria) throws DAOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        ApplianceFactory applianceFactory = new ApplianceFactory();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(FILE_PATH);

            ArrayList<Appliance> foundAppliances = new ArrayList<>();
            NodeList elementList = doc.getElementsByTagName(criteria.getGroupSearchName().toLowerCase());
            for (int i = 0; i < elementList.getLength(); i++) {
                Node p = elementList.item(i);
                if (p.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) p;
                    NodeList nameList = element.getChildNodes();
                    ArrayList<String> applianceInfo = new ArrayList<>();
                    for (int j = 0; j < nameList.getLength(); j++) {
                        Node n = nameList.item(j);
                        if (n.getNodeType() == Node.ELEMENT_NODE) {
                            Element name = (Element) n;
                            applianceInfo.add(name.getTextContent());
                        }
                    }
                    foundAppliances.add(applianceFactory.createInstance(criteria.getGroupSearchName(), applianceInfo));
                }
            }

            return foundAppliances;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new DAOException(e);
        }
    }
}