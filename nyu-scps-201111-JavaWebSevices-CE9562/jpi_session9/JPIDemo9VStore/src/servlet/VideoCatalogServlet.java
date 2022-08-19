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
            List<Video> videos = null;
            if (null != title) {
                ProductDAOIF dao = new ProductDAO();
                videos = dao.getVideo(title);
            }

            // use jsp instead of servlet
            // RequestDispatcher dispatcher = request.getRequestDispatcher("VideoDisplayServlet");
            request.setAttribute("videoList", videos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("videocatalog.jsp");
            dispatcher.forward(request, response);
        }
        catch(Exception e){
            throw new ServletException(e.toString());
        }
        finally{
            logger.info(caller + "Processing Request Finally");
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
