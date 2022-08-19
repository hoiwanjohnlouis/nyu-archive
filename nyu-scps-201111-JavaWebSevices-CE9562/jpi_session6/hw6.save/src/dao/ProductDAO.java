package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;


import model.Music;
import model.Video;


/**
 * @author root
 *
 */
public class ProductDAO implements ProductDAOIF {

	public ProductDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param categoryName - The music category name like 'Jazz'
	 * @return a List of Music that matches the categoryName - exact match
	 */
	public List<Music> getMusic(String categoryName) throws SQLException, ClassNotFoundException {
		List<Music> myList       = null;
	    Connection  myConnection = null;
	    ResultSet   myResultSet  = null;
	    String      mySql        = "SELECT Actor_ID, Actor_Name from ACTORS ORDER BY Actor_Name";
	    
	    myConnection = getConnection();
	    if (null != myConnection) {
	    	myResultSet = getResultSet(myConnection, mySql);
	    }
	    
		return myList;
	};

	/**
	 * @param title - Partial video title like 'star' or 'the'
	 * @return a List of Video that matches the title 
	 *         - NOT case sensitive and SQL like match
	 */
	public List<Video> getVideo(String title) throws SQLException, ClassNotFoundException {
		List<Video> myList       = null;
	    Connection  myConnection = null;
	    ResultSet   myResultSet  = null;
	    String      mySql        = "SELECT Actor_ID, Actor_Name from ACTORS ORDER BY Actor_Name";
	    
	    myConnection = getConnection();
	    if (null != myConnection) {
	    	myResultSet = getResultSet(myConnection, mySql);
	    }
	    
		return myList;
	};


	/**
	 * @param - none 
	 * @return a connection object 
	 */
	public Connection getConnection() {

	    PropertyResourceBundle bundle = null;
	    String driver                 = null;
	    String connectionString       = null;
	    Connection connection         = null;

	    try{
	        // load Database.properties file
	        bundle = (PropertyResourceBundle) ResourceBundle.getBundle("Database");

	        // get the JDBC driver class name from the bundle
	        driver = bundle.getString("database.JDBCDriver");

	        // load the driver class.
	        Class.forName(driver);

	        // get the url from the bundle.
	        connectionString = bundle.getString("database.connectionString");

	        // get a db connection for caller
	        connection = DriverManager.getConnection(connectionString);
	    }
        catch(SQLException e){
            while (null != e){
                e.printStackTrace();
                e = e.getNextException();
            }
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }

		return connection;
	}

	/**
	 * @param - connection to database
	 * @param - sql string 
	 * @return a connection object 
	 */
	public CachedRowSet getResultSet(Connection pConnection, String pSql) {
		CachedRowSet      crs = null;     
		PreparedStatement ps  = null;
	    ResultSet         rs  = null;
	    
	    try {
	    	// prepare and execute the statement
	    	ps = pConnection.prepareStatement(pSql);
	        rs = ps.executeQuery();
	    }
        catch(SQLException e){
            while (null != e){
                e.printStackTrace();
                e = e.getNextException();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
	    
	    return crs;
	}
}

/*
  


while (actorsResultSet.next()){
    System.out.print(actorsResultSet.getInt("Actor_ID") + " - ");
    System.out.println(actorsResultSet.getString("Actor_Name"));
}

        catch(SQLException e){
            while (e!=null){
                e.printStackTrace();
                e = e.getNextException();
            }
        }
        finally{
            if (connection!=null){
                try{
                    connection.close();
                }
                catch(Exception e2){
                    //do nothing - can't do anything anyway.
                    e2.printStackTrace();
                }
            }
        }

*/