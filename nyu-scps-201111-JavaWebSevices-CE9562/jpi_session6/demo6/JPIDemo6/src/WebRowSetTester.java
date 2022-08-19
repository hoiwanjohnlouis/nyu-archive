import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.WebRowSet;


import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.WebRowSetImpl;


public class WebRowSetTester {


    /**
    * @param args
    */
    public static void main(String[] args) {

        try {

            WebRowSet crs = new WebRowSetImpl();
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


        // write out metadata of WebRowSet
        crs.writeXml(System.out);


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

    }

}
