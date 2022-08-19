// Code 2C
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class RequestExaminerServlet extends HttpServlet {

	private static final Logger logger = Logger.getLogger(RequestExaminerServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
		logger.debug("In doGet");

    	Enumeration e;

    	// get the writer and set output content type
    	PrintWriter out = response.getWriter();
    	response.setContentType("text/plain");

		logger.debug("Calling APIs on request");

    	// print request source info.
    	out.println("Protocol: " + request.getProtocol());
    	out.println("Scheme: " + request.getScheme());
    	out.println("Server Name: " + request.getServerName());
    	out.println("Server Port: " + request.getServerPort());
    	out.println("Remote Addr: " + request.getRemoteAddr());
    	out.println("Remote Host: " + request.getRemoteHost());
    	out.println("Content Length: " + request.getContentLength());
    	out.println("Content Type: "+ request.getContentType());
    	out.println("Locale: "+ request.getLocale());
    	out.println("Default Response Buffer: "+ response.getBufferSize());
    	out.println("HTTP Method: " + request.getMethod());
    	out.println("Request URI: " + request.getRequestURI());
    	out.println("Context Path: " + request.getContextPath());
    	out.println("Servlet Path: " + request.getServletPath());
    	out.println("Request Is Secure: " + request.isSecure());
    	out.println("Query String: " + request.getQueryString());
    	out.println();

		logger.debug("Reading request headers");

    	// print request header
    	out.println("Headers in this request:");
    	e = request.getHeaderNames();
    	while (e.hasMoreElements()) {
    		String key = (String)e.nextElement();
    		Enumeration values = request.getHeaders(key);
    		out.print("   " + key + " = ");
        	while (values.hasMoreElements()) {
        		String value = (String) values.nextElement();
        		out.print(value + "\t");
        	}
        	out.println();

    	}
    	out.println();

		logger.debug("Reading request parameters");

		// print request parameter
    	out.println("Parameter names in this request:");
    	e = request.getParameterNames();
    	while (e.hasMoreElements()) {
    		String key = (String)e.nextElement();
    		String[] values = request.getParameterValues(key);
    		out.print("   " + key + " = ");
    		for(int i = 0; i < values.length; i++) {
    			out.print(values[i] + "\t");
    		}
    		out.println();
    	}
    	out.println();
		logger.debug("Finished doGet");
    }
}

