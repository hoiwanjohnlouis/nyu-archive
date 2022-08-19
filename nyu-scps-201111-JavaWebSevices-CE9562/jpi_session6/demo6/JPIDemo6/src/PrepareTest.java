import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PrepareTest

{
    public static void main(String[] args) {

        Connection c = null;

        try {
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
            c = DriverManager.getConnection(connectionString);

            String mySql = "select * from Artists where artist_id=?";
            PreparedStatement s = c.prepareStatement(mySql);
            s.setInt(1, 5);

            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
            }

        } catch(SQLException e) {

            System.out.println("\n--- SQLException caught ---\n");

            while (e != null) {
                System.out.println("Message:                " + e.getMessage());
                System.out.println("SQLState:               " + e.getSQLState());
                System.out.println("Vendor ErrorCode: " + e.getErrorCode());
                e = e.getNextException();
                System.out.println();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
