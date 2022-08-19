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
import model.Video;

import org.apache.log4j.Logger;

import dao.ProductDAO;
import dao.ProductDAOIF;

public class VideoCatalogServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static final Logger logger = Logger.getLogger(VideoCatalogServlet.class);

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String caller = "doGet:";

    logger.info(caller + "Processing Request Starts");
    try{
      String title = request.getParameter("title");
      ProductDAOIF dao = new ProductDAO();
      List<Video> videos = dao.getVideo(title);
      request.setAttribute("videos", videos);
      RequestDispatcher dispatcher = request.getRequestDispatcher("VideoDisplayServlet");
      dispatcher.forward(request, response);
    }
    catch(Exception e){
      throw new ServletException(e.toString());
    }
    logger.info(caller + "Processing Request Ends");

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String caller = "doPost:";
    logger.info(caller + "Processing Request Starts");
    doGet(request,response);
    logger.info(caller + "Processing Request Ends");
  }

}
