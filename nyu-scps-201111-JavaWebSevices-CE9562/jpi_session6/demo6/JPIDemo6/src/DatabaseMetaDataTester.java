import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseMetaDataTester {

    /**
    * @param args
    */
    public static void main(String[] args) {

        try {

            String[] myArry={"TABLE"};
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
            Connection c = DriverManager.getConnection(connectionString);
            DatabaseMetaData dmd = c.getMetaData();

            System.out.println(dmd.getDatabaseProductName());
            System.out.println(dmd.getDatabaseMajorVersion());

            ResultSet rs = dmd.getTables(null, null, null, myArry);

            //loop through all the items.
            while (rs.next()){
                System.out.println(rs.getString("TABLE_NAME"));
            }

/*
            System.out.println(c.getClass().getName());
            String mySelect = "Select * from Musics where Recording_id=?";
            PreparedStatement s = c.prepareStatement(mySelect);
            System.out.println(s.getClass().getName());

            s.setInt(1, 2007);
            ResultSet rs = s.executeQuery();
            while(rs.next()){
                        int id = rs.getInt("Recording_ID");
                        String title = rs.getString("Album_Title");
                        System.out.println(id + ": " + title);
            }

            s.setInt(1, 2009);
            ResultSet rs2 = s.executeQuery();
            while(rs2.next()){
                        int id = rs2.getInt("Recording_ID");
                        String title = rs2.getString("Album_Title");
                        System.out.println(id + ": " + title);
            }

            System.out.println(rs.getClass().getName());
*/

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
