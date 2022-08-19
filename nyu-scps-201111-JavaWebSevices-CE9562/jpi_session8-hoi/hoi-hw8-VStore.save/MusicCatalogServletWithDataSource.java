package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Music;

import org.apache.log4j.Logger;

import dao.ProductDAO;
import dao.ProductDAODataSource;
import dao.ProductDAOIF;

public class MusicCatalogServletWithDataSource extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(MusicCatalogServletWithDataSource.class);
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	PrintWriter out = null;
		try{
	    	// set the content type of response.
		    response.setContentType("text/html");

			// get a handle on the print writer of response.
		    out=response.getWriter();

			logger.debug("Sending Response");

			// generate response.
	     	out.println("<HTML>");
	    	out.println("<HEAD>");
	    	out.println("<TITLE>");
	    	out.println("MusicCatalogServlet");
	    	out.println("</TITLE>");
	    	out.println("</HEAD>");
	    	out.println("<BODY>");
			String category = request.getParameter("category");
			
			if (category== null){
		    	out.println("No category to search for");
		    	return;
			}
			else{
				ProductDAOIF dao = new ProductDAODataSource();
				List<Music> musics = dao.getMusic(category);
				if (musics==null){
			    	out.println("No music matched category: " + category);
			    	return;
				}
				else{
					Iterator<Music> iteratorMusics = musics.iterator();
					out.println("<table border='1'>");
					out.println("<tr>");
					out.println("<th>Id</th>");
					out.println("<th>Title</th>");
					out.println("<th>Price</th>");
					out.println("<th>Stock Quantity</th>");
					out.println("<th># of Tracks</th>");
					out.println("<th>Artist</th>");
					out.println("<th>  </th>");
					out.println("</tr>");
					while(iteratorMusics.hasNext()){
						Music music = iteratorMusics.next();
						out.println("<tr>");
						out.println("<td>" + music.getId() + "</td>");
						out.println("<td>" + music.getTitle() + "</td>");
						out.println("<td>" + music.getPrice() + "</td>");
						out.println("<td>" + music.getStockCount() + "</td>");
						out.println("<td>" + music.getNumberOfTracks() + "</td>");
						out.println("<td>" + music.getArtist().getName() + "</td>");
						out.println("<td><A HREF='./AddToShoppingCartServlet?price="+music.getPrice()+"&type=music&id=" + music.getId() + "'>Buy</A></td>");
						out.println("</tr>");
					}
					out.println("</table>");
				}
			}
		}
		catch(Exception e){
			throw new ServletException(e.toString());
		}
		finally{
	    	out.println("</BODY>");
	    	out.println("</HTML>");
	    	logger.info("Finished doGet");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
