package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import service.RandomServiceIF;

public class RandomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		if (context!=null){	
			RandomServiceIF myRandom = (RandomServiceIF) context.getBean("y");
			int random = myRandom.findRandom();

			PrintWriter out = null;

	    	// set the content type of response.
		    response.setContentType("text/html");

			// get a handle on the print writer of response.
		    out=response.getWriter();

			// generate response.
	     	out.println("<HTML>");
	    	out.println("<HEAD>");
	    	out.println("<TITLE>");
	    	out.println("RandomServlet");
	    	out.println("</TITLE>");
	    	out.println("</HEAD>");
	    	out.println("<BODY>");
	    	out.println("<H1>Random Number is: " + random + "</H1>");
	    	out.println("</BODY>");
	    	out.println("</HTML>");

		}
		else{
			throw new IOException("Web Application Context for Spring in null");
		}

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
