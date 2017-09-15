package com.epam.poliakov.controller.filter;

import com.epam.poliakov.util.xml_parser.Security;
import com.epam.poliakov.util.xml_parser.XMLHandler;
import org.xml.sax.SAXException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.poliakov.controller.SessionAttributeCons.*;

@WebFilter("/*")
public class SequrityFilter implements Filter {

    private static final String SECURITY_XML = "xml/security.xml";
    private Map<String, String> urlMap;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        urlMap = new HashMap();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLHandler xmlHandler = new XMLHandler();
            saxParser.parse(new File(SECURITY_XML), xmlHandler);
            List<Security> securityList = xmlHandler.getSecurityList();
            for (Security security : securityList) {
                urlMap.put(security.getUrl(), security.getRole());
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String requestURI = req.getRequestURI();
        String relativeURL = requestURI.split("/OnlineShop")[1];

        if (!urlMap.containsKey(requestURI)) {
            chain.doFilter(request, response);
        } else {
            if ((req.getSession().getAttribute(SESSION_LOGIN) != null)) {
                if (urlMap.get(requestURI).contains(((String) req.getSession().getAttribute(SESSION_ROLE)))) {
                    chain.doFilter(request, response);
                } else {
                    resp.sendRedirect("access_denied.jsp");
                }
            } else {
                resp.sendRedirect("account.jsp");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
