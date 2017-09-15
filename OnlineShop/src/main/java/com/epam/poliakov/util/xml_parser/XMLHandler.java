package com.epam.poliakov.util.xml_parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {

    private static final String URL = "url";
    private static final String ROLE = "role";
    private static final String CONSTRAINT = "constraint";

    private List<Security> securityList = null;
    private Security security = null;

    private boolean xmlURL = false;
    private boolean xmlRole = false;

    public List<Security> getSecurityList() {
        return Collections.unmodifiableList(securityList);
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        if (name.equalsIgnoreCase(CONSTRAINT)) {
            String url = attributes.getValue(URL);
            security = new Security();
            security.setUrl(url);
            if (securityList == null) {
                securityList = new ArrayList<>();
            }
        } else if (name.equalsIgnoreCase(URL)) {
            xmlURL = true;
        } else if (name.equalsIgnoreCase(ROLE)) {
            xmlRole = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        if (name.equalsIgnoreCase(CONSTRAINT)) {
            securityList.add(security);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (xmlURL) {
            security.setUrl(new String(ch, start, length));
            xmlURL = false;
        } else if (xmlRole) {
            security.setRole(new String(ch, start, length));
            xmlRole = false;
        }
    }
}
