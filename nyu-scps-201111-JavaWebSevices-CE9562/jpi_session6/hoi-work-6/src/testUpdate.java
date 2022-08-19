/**
 * 
 */
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author computerlab
 *
 */
public class testUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		    String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
		    Connection c = DriverManager.getConnection(connectionString);
		    System.out.println(c.getClass().getName());
		    Statement s = c.createStatement();
		    System.out.println(s.getClass().getName());
		    String mySQL = "INSERT INTO ACTORS (ACTOR_ID, ACTOR_NAME) VALUES (400, 'myself');";
		    int impacted = s.executeUpdate(mySQL);
		    System.out.println(impacted);
		    	    
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

