package ru.demi.app.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.demi.app.resourceServer.ResourceServer;
import ru.demi.app.resources.TestResource;
import ru.demi.app.sax.ReadXMLFileSAX;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author demi
 * @date 21.02.16
 */
public class ResourceServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(ResourceServlet.class);
    public static final String PAGE_URL = "/resources";
    private final ResourceServer resourceServer;

    public ResourceServlet(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        String path = request.getParameter("path");
        if (path == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        TestResource testResource = (TestResource) ReadXMLFileSAX.readXML(path);
        resourceServer.setTestResource(testResource);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
