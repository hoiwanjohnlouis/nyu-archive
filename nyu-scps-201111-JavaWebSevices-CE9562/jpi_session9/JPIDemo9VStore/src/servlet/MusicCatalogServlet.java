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


public class MusicCatalogServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(MusicCatalogServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String caller = "doGet:";

        logger.info(caller + "Sending Response Starts");
        try{
            String category = request.getParameter("category");
            List<Music> musics = null;
            if (null != category) {
                ProductDAOIF dao = new ProductDAO();
                musics = dao.getMusic(category);
            }
            // use jsp instead of servlet
            // RequestDispatcher dispatcher = request.getRequestDispatcher("MusicDisplayServlet");
            request.setAttribute("musicList", musics);
            RequestDispatcher dispatcher = request.getRequestDispatcher("musiccatalog.jsp");
            dispatcher.forward(request, response);
        }
        catch(Exception e){
            throw new ServletException(e.toString());
        }
        finally{
            logger.info(caller + "Sending Response Finallty");
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
