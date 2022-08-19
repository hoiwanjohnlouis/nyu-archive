// Code 2A
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.log4j.Logger;
public class Servlet1 implements Servlet
{
	private static final Logger logger = Logger.getLogger(Servlet1.class);

	public void init(ServletConfig servletconfig) throws ServletException
  	{
    		logger.debug("init() starts");
    		logger.debug("ServletConfig Class: " + servletconfig.getClass().getName());
    		logger.debug("init() ends");
  	}

  	public ServletConfig getServletConfig()
  	{
    		logger.debug("getServletConfig()");
    		return null;
  	}

  	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
  	{
    		logger.debug("service() starts");
    		logger.debug("ServletRequest Class: " + request.getClass().getName());
    		logger.debug("ServletResponse Class: " + response.getClass().getName());
    		logger.debug("service() ends");
	}
  	public String getServletInfo()
  	{
    		logger.debug("getServletInfo()");
    		return null;
  	}
  	public void destroy()
  	{
    		logger.debug("destroy()");
  	}
}
