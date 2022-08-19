import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import junit.framework.TestCase;


public class PropertiesFileTestCase extends TestCase {

    public void testPropertiesFile(){
        PropertyResourceBundle bundle = null;
        String driver = null;
        String connectionString = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet actorsResultSet = null;
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
            assertNotNull(actorsResultSet);
            while (actorsResultSet.next()){
                System.out.print(actorsResultSet.getInt("Actor_ID") + " - ");
                System.out.println(actorsResultSet.getString("Actor_Name"));
            }
        }
        catch(SQLException e){
            while (e!=null){
                e.printStackTrace();
                e = e.getNextException();
            }
            fail("Database error");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            fail("Class Not Found Exception thrown");
        }
        finally{
            if (connection!=null){
                try{
                    connection.close();
                }
                catch(Exception e2){
                    //do nothing - can't do anything anyway.
                }
            }
        }
    }
}
