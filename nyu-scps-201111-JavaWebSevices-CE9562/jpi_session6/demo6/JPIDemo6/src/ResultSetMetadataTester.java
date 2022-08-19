import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


public class ResultSetMetadataTester {

    /**
    * @param args
    */
    public static void main(String[] args) {

        try {

            String connectionString = null;
            PropertyResourceBundle bundle = (PropertyResourceBundle) ResourceBundle.getBundle("database");
            connectionString = bundle.getString("connectionString");
            Connection c = DriverManager.getConnection(connectionString);
            String mySelect = "Select * from Musics where Recording_id=?";
            PreparedStatement s = c.prepareStatement(mySelect);
            s.setInt(1, 5000);
            ResultSet rs = s.executeQuery();
            ResultSetMetaData rmd = rs.getMetaData();

            //loop through all the items.
            for (int i=1; i<= rmd.getColumnCount();i++){

                System.out.print(rmd.getColumnName(i) + " - ");
                System.out.print(rmd.getColumnTypeName(i) + " - ");
                System.out.print(rmd.getColumnDisplaySize(i));
                System.out.println();

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
