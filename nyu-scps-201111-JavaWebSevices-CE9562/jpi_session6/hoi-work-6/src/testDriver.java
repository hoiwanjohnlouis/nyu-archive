import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class testDriver { 
	
	public static void main (String[] args) {
		
		try {
		    String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
		    Connection c = DriverManager.getConnection(connectionString);
		    System.out.println(c.getClass().getName());
		    Statement s = c.createStatement();
		    System.out.println(s.getClass().getName());
		    String mySelect = "Select * from MUSICS";
		    ResultSet rs = s.executeQuery(mySelect);
		    System.out.println(rs.getClass().getName());
		    
		    while(rs.next()) {
		    	int id = rs.getInt("Recording_ID");
		    	String title = rs.getString("Album_TITLE");
		    	System.out.println(id + ": " + title);
		    }
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    }
	
}