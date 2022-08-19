package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Music;

import org.apache.log4j.Logger;

import dao.ProductDAO;
import dao.ProductDAOIF;

public class MusicDisplayServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static final Logger logger = Logger.getLogger(MusicDisplayServlet.class);

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String caller = "doGet:";

    PrintWriter out = null;
    logger.info(caller + "Sending Response Starts");

    try{
      List<Music> musics = (List<Music>) request.getAttribute("musics");

      // set the content type of response
      response.setContentType("text/html");

      // get a handle on the print writer of response.
      out=response.getWriter();

      // generate response.
      out.println("<BODY>");
      out.println("<TABLE BORDER=1>");
      out.println("<TR>");
      out.println("<TD>Artist</TD>");
      out.println("<TD>Title</TD>");
      out.println("<TD>Price</TD>");
      out.println("<TD>ShoppingCart</TD>");
      out.println("</TR>");

      // get the iterator from the collection.
      Iterator<Music> iterator = musics.iterator();

      //loop through all the items.
      while (iterator.hasNext())
      {
        // get the next item
        Music music = (Music) iterator.next();

        out.println("<TR>");
        out.println("<TD>" + music.getArtist().getName() + "</TD>");
        out.println("<TD>" + music.getTitle() + "</TD>");
        out.println("<TD>" + music.getPrice() + "</TD>");
        out.println("<TD>" + "<A HREF=" + "AddToShoppingCartServlet?" +
                                          "id=" + music.getId() + 
                                          "&type=" + music.getCategory().getType() + 
                                          "&price=" + music.getPrice()+ ">" + "Buy" + "</A></TD>");
        out.println("</TR>");
      }
      out.println("</TABLE>");
      out.println("</BODY>");

    }
    catch(Exception e){
      throw new ServletException(e.toString());
    }

    logger.info(caller + "Sending Response Ends");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String caller = "doPost:";
    logger.info(caller + "Sending Response Starts");
    doGet(request,response);
    logger.info(caller + "Sending Response Ends");
  }

}
