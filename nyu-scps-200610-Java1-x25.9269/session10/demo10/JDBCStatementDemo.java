
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JDBCStatementDemo
{
	
	public static void main(String[] args)
	{
		String url;
		Connection connection;
		Statement selectStatement;	
		ResultSet resultSet;
		Statement updateStatement;
		try
		{

			// load the driver JDBC-ODBC class.
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			url = "jdbc:odbc:DSStudent";

			// for oracle
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			// String url2="jdbc:oracle:thin:@localhost:1521:ORCL";
			// connect to oracle.
			//connection = DriverManager.getConnection(url2);

			// connect to the database using JDBC-ODBC Bridge.
			connection = DriverManager.getConnection(url);

			// create a statement.
			selectStatement = connection.createStatement();

			// execute a query using the statement.
			// this will return a resultset.
			resultSet = selectStatement.executeQuery("select * from student");

			// print starting string.
			System.out.println("Before Update:");

			// loop through all the records and print them.
			while (resultSet.next())
			{
				System.out.println(resultSet.getInt("Student_Id")
					+ "\t" + resultSet.getString(2)
					+ "\t" + resultSet.getString(3));

			}

			// print finish string.
			System.out.println("Received all rows");


			// print a blank line.
			System.out.println();

			// create another statement object for update.
			updateStatement = connection.createStatement();

			// execute three updates on the database.
			int rows = updateStatement.executeUpdate(
				"Update Student set First_Name='X' where Last_Name='Smith'");
			System.out.println("Rows Impacted: " + rows);	
			rows = updateStatement.executeUpdate(
				"Update Student set First_Name='Y' where Last_Name='White'");
			System.out.println("Rows Impacted: " + rows);	
			rows = updateStatement.executeUpdate(
				"Update Student set First_Name='Z' where Last_Name='Fisher'");
			System.out.println("Rows Impacted: " + rows);	


			// retrieve all the records again to verify the updates.
			resultSet = selectStatement.executeQuery("select * from Student");
			System.out.println("After Update:");
			while (resultSet.next())
			{
				System.out.println(resultSet.getInt(1) 
					+ "\t" + resultSet.getString(2) 
					+ "\t" + resultSet.getString(3));
			}
			System.out.println("Received all rows");
			System.out.println();
				}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
