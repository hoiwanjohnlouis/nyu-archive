package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Actor;
import model.Video;

import org.apache.log4j.Logger;

import dao.ProductDAO;
import dao.ProductDAOIF;

public class VideoDisplayServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger logger = Logger.getLogger(VideoDisplayServlet.class);

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String caller = "doGet:";

    PrintWriter out = null;
    logger.info(caller + "Sending Response Starts");
    try{
      List<Video> videos = (List<Video>) request.getAttribute("videos");

      // set the content type of response
      response.setContentType("text/html");

      // get a handle on the print writer of response.
      out=response.getWriter();

      // generate response.
      out.println("<BODY>");
      out.println("<TABLE BORDER=1>");
      out.println("<TR>");
      out.println("<TD>Id</TD>");
      out.println("<TD>Title</TD>");
      out.println("<TD>Price</TD>");
      out.println("<TD>Stock Quantity</TD>");
      out.println("<TD>Rating</TD>");
      out.println("<TD>Director</TD>");
      out.println("<TD>Actors</TD>");
      out.println("<TD>ShoppingCart</TD>");
      out.println("</TR>");

      // get the iterator from the collection.
      Iterator<Video> iterator = videos.iterator();

      //loop through all the items.
      while (iterator.hasNext())
      {
        // get the next item
        Video video = (Video) iterator.next();

        out.println("<TR>");
        out.println("<TD>" + video.getId() + "</TD>");
        out.println("<TD>" + video.getTitle() + "</TD>");
        out.println("<TD>" + video.getPrice() + "</TD>");
        out.println("<TD>" + video.getStockCount() + "</TD>");
        out.println("<TD>" + video.getRating() + "</TD>");
        out.println("<TD>" + video.getDirector().getName() + "</TD>");

        // video.actors is a list, process acccordingly
        out.print("<td>");
        List<Actor> actors = new ArrayList<Actor>();
        actors = video.getActors();
        Iterator<Actor> iteratorActors = actors.iterator();
        while (iteratorActors.hasNext()) {
      	  Actor oneActor = iteratorActors.next();
      	  out.print(oneActor.getName() + " ");
        }
        out.println("</td>");
        
        out.println("<TD>" + "<A HREF=" + "AddToShoppingCartServlet?" +
                                          "id=" + video.getId() + 
                                          "&type=" + video.getCategory().getType() + 
                                          "&price=" + video.getPrice()+ ">" + "Buy" + "</A></TD>");
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

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String caller = "doPost:";
    logger.info(caller + "Sending Response Starts");
    doGet(request,response);
    logger.info(caller + "Sending Response Ends");
  }

}
