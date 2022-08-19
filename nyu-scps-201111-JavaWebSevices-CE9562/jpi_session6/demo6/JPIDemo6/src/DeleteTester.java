import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteTester {

    /**
    * @param args
    */
    public static void main(String[] args) {

        Connection c = null;

        try {
            String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
            c = DriverManager.getConnection(connectionString);
            c.setAutoCommit(false);
            String mySql = "delete from Actors where actor_id=?";
            PreparedStatement s = c.prepareStatement(mySql);

            s.setInt(1, 405);
            int impacted = s.executeUpdate();
            System.out.println(impacted);

            s.setInt(1, 409);
            int impacted2 = s.executeUpdate();

            if (impacted2==0){
                throw new SQLException("testing");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
