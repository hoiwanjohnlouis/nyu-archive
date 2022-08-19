import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;


public class CachedRowSetTester {


    /**
    * @param args
    */
    public static void main(String[] args) {

        try {
            CachedRowSet crs = new CachedRowSetImpl();
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
            Connection c = DriverManager.getConnection(connectionString);
            System.out.println(c.getClass().getName());

            String mySelect = "Select * from Musics where Recording_id=?";
            PreparedStatement s = c.prepareStatement(mySelect);
            System.out.println(s.getClass().getName());
            s.setInt(1, 2007);
            ResultSet rs = s.executeQuery();
            crs.populate(rs);
            c.close();

            while(crs.next()){
                int id = crs.getInt("Recording_ID");
                String title = crs.getString("Album_Title");
                System.out.println(id + ": " + title);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
