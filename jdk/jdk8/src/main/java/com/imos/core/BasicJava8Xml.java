package com.imos.core;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class BasicJava8Xml {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("/home/p/Tools/apache-maven-3.8.6/conf/toolchains.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList toolchains = doc.getElementsByTagName("toolchain");
            for (int i = 0; i < toolchains.getLength(); i++) {
                Node toolchain = toolchains.item(i);
                if (toolchain.getNodeType() == Node.ELEMENT_NODE) {
                    Element toolchainElement = (Element) toolchain;
                    String type = toolchainElement.getElementsByTagName("type").item(0).getTextContent();
                    if (type.equals("jdk")) {
                        String jdkVersion = toolchainElement.getElementsByTagName("version").item(0).getTextContent();
                        System.out.println("JDK version: " + jdkVersion);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
