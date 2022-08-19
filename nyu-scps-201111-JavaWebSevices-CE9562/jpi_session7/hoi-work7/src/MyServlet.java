import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// super.doGet(req, resp);
		System.out.println("In doGet");
		String user_name = req.getParameter("user_name");
		String host = req.getParameter("accept");
		PrintWriter pw = resp.getWriter();
		if (null == user_name) {
			pw.println("Hello there!");
		}
		else {
			pw.println("<html>"
					   + "<title>my servlet response</title>"
					   + "<body>"
					   + "Hello " + user_name.toString() + " " 
					   + "</body>"
					   + "</html>");
		}
		
	}

}
