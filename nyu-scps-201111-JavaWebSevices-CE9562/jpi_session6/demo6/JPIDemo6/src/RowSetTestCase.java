import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.WebRowSet;

import junit.framework.TestCase;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.WebRowSetImpl;


public class RowSetTestCase extends TestCase {

    public void testCachedRowSet(){
        PropertyResourceBundle bundle = null;
        String driver = null;
        String connectionString = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet actorsResultSet = null;
        CachedRowSet actorsRowSet = null;
        try{
            // load Database.properties file
            bundle = (PropertyResourceBundle) ResourceBundle.getBundle("Database");

            // get the JDBC driver class name from the bundle
            driver = bundle.getString("database.JDBCDriver");

            // load the driver class.
            Class.forName(driver);

            // get the url from the bundle.
            connectionString = bundle.getString("database.connectionString");

            connection = DriverManager.getConnection(connectionString);
            assertNotNull(connection);
            String sql = "SELECT Actor_ID, Actor_Name from ACTORS ORDER BY Actor_Name";
            statement = connection.createStatement();
            assertNotNull(statement);
            actorsResultSet = statement.executeQuery(sql);
            actorsRowSet = new CachedRowSetImpl();
            actorsRowSet.populate(actorsResultSet);
            //you can close the connection now.
            connection.close();
            while (actorsRowSet.next()){
                System.out.print(actorsRowSet.getInt("Actor_ID") + " - ");
                System.out.println(actorsRowSet.getString("Actor_Name"));
            }
        }
        catch(SQLException e){
            while (e!=null){
                e.printStackTrace();
                e = e.getNextException();
            }
            fail("SQL Exception thrown");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            fail("Class Not Found Exception thrown");
        }
    }

    public void testWebRowSet(){
        PropertyResourceBundle bundle = null;
        String driver = null;
        String connectionString = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet actorsResultSet = null;
        WebRowSet actorsRowSet = null;
        try{
            // load Database.properties file
            bundle = (PropertyResourceBundle) ResourceBundle.getBundle("Database");

            // get the JDBC driver class name from the bundle
            driver = bundle.getString("database.JDBCDriver");

            // load the driver class.
            Class.forName(driver);

            // get the url from the bundle.
            connectionString = bundle.getString("database.connectionString");

            connection = DriverManager.getConnection(connectionString);
            assertNotNull(connection);
            String sql = "SELECT Actor_ID, Actor_Name from ACTORS ORDER BY Actor_Name";
            statement = connection.createStatement();
            assertNotNull(statement);
            actorsResultSet = statement.executeQuery(sql);
            actorsRowSet = new WebRowSetImpl();
            actorsRowSet.populate(actorsResultSet);
            //you can close the connection now.
            connection.close();
            while (actorsRowSet.next()){
                System.out.print(actorsRowSet.getInt("Actor_ID") + " - ");
                System.out.println(actorsRowSet.getString("Actor_Name"));
            }
            actorsRowSet.writeXml(System.out);
        }
        catch(SQLException e){
            while (e!=null){
                e.printStackTrace();
                e = e.getNextException();
            }
            fail("SQL Exception thrown");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            fail("Class Not Found Exception thrown");
        }
        catch(IOException e){
            e.printStackTrace();
            fail("I/O Exception thrown");
        }

    }

}
