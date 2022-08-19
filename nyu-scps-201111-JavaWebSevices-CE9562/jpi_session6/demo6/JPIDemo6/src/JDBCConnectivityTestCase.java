import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import junit.framework.TestCase;


public class JDBCConnectivityTestCase extends TestCase{

    public void testConnection(){
        Connection connection = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver"); // type 4 HSQL
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
            connection = DriverManager.getConnection(connectionString);
            assertNotNull(connection);
        }
        catch(Exception e){
            e.printStackTrace();
            fail("Could not connect to the database");
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

    public void testStatement(){
        Connection connection = null;
        Statement statement = null;
        ResultSet actorsResultSet = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver"); // type 4 HSQL
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
            connection = DriverManager.getConnection(connectionString);
            assertNotNull(connection);
            String sql = "SELECT Actor_ID, Actor_Name from ACTORS ORDER BY Actor_Name";
            statement = connection.createStatement();
            assertNotNull(statement);
            actorsResultSet = statement.executeQuery(sql);
            assertNotNull(actorsResultSet);
        }
        catch(Exception e){
            e.printStackTrace();
            fail("Database error");
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

    public void testResultSet(){
        Connection connection = null;
        Statement statement = null;
        ResultSet actorsResultSet = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver"); // type 4 HSQL
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
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
        catch(Exception e){
            e.printStackTrace();
            fail("Database error");
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

    public void testException(){
        Connection connection = null;
        Statement statement = null;
        ResultSet actorsResultSet = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver"); // type 4 HSQL
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
            connection = DriverManager.getConnection(connectionString);
            assertNotNull(connection);
            String sql = "SELECT Actor_ID, Actor_Name from NOTABLE ORDER BY Actor_Name";
            statement = connection.createStatement();
            assertNotNull(statement);
            actorsResultSet = statement.executeQuery(sql);
            fail("'NOTABLE' is invalid table name, Exception should have been thrown");
        }
        catch(SQLException e){
            while (e!=null){
                e.printStackTrace();
                e = e.getNextException();
            }
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

    public void testBackwardScrolling(){
        Connection connection = null;
        Statement statement = null;
        ResultSet actorsResultSet = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver"); // type 4 HSQL
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
            connection = DriverManager.getConnection(connectionString);
            assertNotNull(connection);
            String sql = "SELECT Actor_ID, Actor_Name from ACTORS ORDER BY Actor_Name";
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            assertNotNull(statement);
            actorsResultSet = statement.executeQuery(sql);
            assertNotNull(actorsResultSet);
            // if can't scroll backward - let user know.
            if (!(actorsResultSet.getType()==ResultSet.TYPE_SCROLL_INSENSITIVE)){
                System.out.println("Driver does not support backward-scroll.");
                fail("Database does not support backward scrolling");
                return;
            }
            actorsResultSet.afterLast();
            System.out.println("Scrolling Backwards...");
            while (actorsResultSet.previous()){
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

    public void testUpdatableResultSet(){
        Connection connection = null;
        Statement statement = null;
        ResultSet actorsResultSet = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver"); // type 4 HSQL
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
            connection = DriverManager.getConnection(connectionString);
            assertNotNull(connection);
            String sql = "SELECT Actor_ID, Actor_Name from ACTORS ORDER BY Actor_Name";
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            assertNotNull(statement);
            actorsResultSet = statement.executeQuery(sql);
            assertNotNull(actorsResultSet);
            // if not updatable - let user know.
            if (!(actorsResultSet.getConcurrency()==ResultSet.CONCUR_UPDATABLE)){
                System.out.println("Driver does not support updatable resultset.");
                return;
            }

            System.out.println("Updating...");
            int actorId;
            while (actorsResultSet.next()){
                actorId = 1000 + actorsResultSet.getInt("Actor_ID");
                actorsResultSet.updateInt("Actor_ID",actorId);
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

    public void testPreparedStatement(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet musicResultSet = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver"); // type 4 HSQL
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
            connection = DriverManager.getConnection(connectionString);
            assertNotNull(connection);
            String sql = "SELECT Recording_ID,Album_Title,Price from MUSICS where Price=?";
            statement = connection.prepareStatement(sql);
            assertNotNull(statement);
            //get everything priced at 10.99
            statement.setDouble(1, 10.99);
            System.out.println("Music at 10.99");
            musicResultSet = statement.executeQuery();
            assertNotNull(musicResultSet);
            while (musicResultSet.next()){
                System.out.print(musicResultSet.getInt("Recording_ID") + " - ");
                System.out.print(musicResultSet.getString("Album_Title") + " - ");
                System.out.println(musicResultSet.getDouble("Price"));
            }

            //get everything priced at 12.99
            statement.setDouble(1, 12.99);
            musicResultSet = statement.executeQuery();
            assertNotNull(musicResultSet);
            System.out.println("Music at 12.99");
            while (musicResultSet.next()){
                System.out.print(musicResultSet.getInt("Recording_ID") + " - ");
                System.out.print(musicResultSet.getString("Album_Title") + " - ");
                System.out.println(musicResultSet.getDouble("Price"));
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

    public void testRollBack(){
        Connection connection = null;
        ResultSet resultSet = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver"); // type 4 HSQL
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
            String sqlDropTable = "Drop TABLE TEST";
            String sqlCreateTable = "CREATE TABLE TEST (NAME VARCHAR(20),VALUE VARCHAR(50))";
            String sqlInsertRow = "INSERT INTO TEST (NAME,VALUE) VALUES(?,?)";
            String sqlCountRow = "SELECT COUNT(NAME) AS ROWCOUNT FROM TEST";
            connection = DriverManager.getConnection(connectionString);
            connection.setAutoCommit(false);
            assertNotNull(connection);
            PreparedStatement dropTable = connection.prepareStatement(sqlDropTable);
            assertNotNull(dropTable);
            System.out.println("Dropping test table..");
            try{
                dropTable.execute();
            }
            catch(SQLException e){
                /*do nothing. If drop table failed
                 * It is probably because the table does not exist.
                */
            }
            PreparedStatement createTable = connection.prepareStatement(sqlCreateTable);
            assertNotNull(createTable);
            System.out.println("Creating test table..");
            createTable.execute();
            PreparedStatement insertRow = connection.prepareStatement(sqlInsertRow);
            insertRow.setString(1, "Key1");
            insertRow.setString(2, "Value1");
            insertRow.execute();
            insertRow.setString(1, "Key2");
            insertRow.setString(2, "Value2");
            insertRow.execute();
            PreparedStatement countRow = connection.prepareStatement(sqlCountRow);
            resultSet = countRow.executeQuery();
            int rowCount =0;
            if (resultSet.next()){
                rowCount = resultSet.getInt("ROWCOUNT");
            }
            assertEquals(2,rowCount);
            connection.rollback();

            //table creation (DDL) is atomic - it does not rollback.
            resultSet = countRow.executeQuery();
            if (resultSet.next()){
                rowCount = resultSet.getInt("ROWCOUNT");
            }
            //zero since we rolled back
            assertEquals(0,rowCount);
        }
        catch(SQLException e){
            while (e!=null){
                e.printStackTrace();
                e = e.getNextException();
            }
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

    public void testCommit(){
        Connection connection = null;
        ResultSet resultSet = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver"); // type 4 HSQL
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
            String sqlDropTable = "Drop TABLE TEST";
            String sqlCreateTable = "CREATE TABLE TEST (NAME VARCHAR(20),VALUE VARCHAR(50))";
            String sqlInsertRow = "INSERT INTO TEST (NAME,VALUE) VALUES(?,?)";
            String sqlCountRow = "SELECT COUNT(NAME) AS ROWCOUNT FROM TEST";
            connection = DriverManager.getConnection(connectionString);
            connection.setAutoCommit(false);
            assertNotNull(connection);

            PreparedStatement dropTable = connection.prepareStatement(sqlDropTable);
            assertNotNull(dropTable);
            System.out.println("Dropping test table..");
            try{
                dropTable.execute();
            }
            catch(SQLException e){
                /*do nothing. If drop table failed
                 * It is probably because the table does not exist.
                */
            }

            PreparedStatement createTable = connection.prepareStatement(sqlCreateTable);
            assertNotNull(createTable);
            System.out.println("Creating test table..");
            createTable.execute();
            PreparedStatement insertRow = connection.prepareStatement(sqlInsertRow);
            insertRow.setString(1, "Key1");
            insertRow.setString(2, "Value1");
            insertRow.execute();
            insertRow.setString(1, "Key2");
            insertRow.setString(2, "Value2");
            insertRow.execute();
            PreparedStatement countRow = connection.prepareStatement(sqlCountRow);
            resultSet = countRow.executeQuery();
            int rowCount =0;
            if (resultSet.next()){
                rowCount = resultSet.getInt("ROWCOUNT");
            }
            assertEquals(2,rowCount);
            connection.commit();
            resultSet = countRow.executeQuery();
            if (resultSet.next()){
                rowCount = resultSet.getInt("ROWCOUNT");
            }
            assertEquals(2,rowCount);
        }
        catch(SQLException e){
            while (e!=null){
                e.printStackTrace();
                e = e.getNextException();
            }
            try{
                connection.rollback();
            }
            catch(SQLException e2){
                //nothing we could do.
            }
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
