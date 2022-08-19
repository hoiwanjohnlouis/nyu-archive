import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;


public class MetadataTestCase extends TestCase {

    public void testDatabaseMetaData(){
        Connection connection = null;
        DatabaseMetaData metadata = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver"); // type 4 HSQL
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
            connection = DriverManager.getConnection(connectionString);
            assertNotNull(connection);
            // get the database metadata
            metadata = connection.getMetaData();
            assertNotNull(metadata);
            System.out.println("Database Info:");
            // get features of the database
            System.out.print("Database Name: ");
            System.out.println(metadata.getDatabaseProductName());
            System.out.print("Database version: ");
            System.out.println(metadata.getDatabaseProductVersion());
            System.out.print("Driver Name: ");
            System.out.println(metadata.getDriverName());
            System.out.print("Driver Verison: ");
            System.out.println(metadata.getDriverVersion());
            System.out.print("Supports Forward only Resultset: ");
            System.out.println(metadata.supportsResultSetType(
                ResultSet.TYPE_FORWARD_ONLY));
            System.out.print("Supports scroll sensitive Resultset: ");
            System.out.println(metadata.supportsResultSetType(
                ResultSet.TYPE_SCROLL_SENSITIVE));
            System.out.print("Supports scroll insensitive Resultset");
            System.out.println(metadata.supportsResultSetType(
                ResultSet.TYPE_SCROLL_INSENSITIVE));
            System.out.print("Supports updatable Resultset: ");
            System.out.println(metadata.supportsResultSetConcurrency(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE));

            String[] types = {"TABLE"};
            ResultSet tables = metadata.getTables(null,null,null,types);
            assertNotNull(tables);

            System.out.println("Here are the tables: ");

            //loop through all the items.
            while (tables.next()){
                System.out.println(tables.getString("TABLE_NAME"));
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

    public void testResultSetMetadata(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet actorsResultSet = null;
        ResultSetMetaData metadata = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver"); // type 4 HSQL
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
            connection = DriverManager.getConnection(connectionString);
            assertNotNull(connection);

            //a select statement that returns no row but metadata is returned anyway
            String sql = "SELECT * from ACTORS where 2+2=5";
            statement = connection.prepareStatement(sql);
            assertNotNull(statement);
            actorsResultSet = statement.executeQuery();
            assertNotNull(actorsResultSet);
            // get the resultset metadata
            metadata = actorsResultSet.getMetaData();
            assertNotNull(metadata);

            System.out.println("Here is the structure of MUSICS Table");

            //loop through all the items.
            for (int i=1; i<= metadata.getColumnCount();i++){
                System.out.print(metadata.getColumnName(i) + " - ");
                System.out.print(metadata.getColumnTypeName(i) + " - ");
                System.out.print(metadata.getColumnDisplaySize(i));
                System.out.println();
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
