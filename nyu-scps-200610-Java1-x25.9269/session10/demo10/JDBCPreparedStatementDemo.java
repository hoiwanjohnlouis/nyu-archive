// Code 10O

/** A class that uses JDBC prepared selectStatement to access data from database.*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class JDBCPreparedStatementDemo
{
	
	public static void main(String[] args)
	{
		String url;
		Connection connection;
		PreparedStatement selectStatement;	
		ResultSet resultSet;
		PreparedStatement updateStatement;
		PreparedStatement preparedStatement;
		int rows = 0;
		try
		{
			// load driver.
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			// prepare url string.
			url = "jdbc:odbc:DSStudent";

			// get the connection using JDBC-ODBC Bridge.
			connection = DriverManager.getConnection(url);

			// create a selectStatement.
			selectStatement = connection.prepareStatement("select * from Student");

			// execute a query using selectStatement.
			// it returns resultset.
			resultSet = selectStatement.executeQuery();
		
			// print begin string.
			System.out.println("Before Update:");

			// loop though the resultset and print data.
			while (resultSet.next())
			{
				System.out.println(resultSet.getInt(1) 
					+ "\t" + resultSet.getString(2) 
					+ "\t" + resultSet.getString(3));

			}

			// print end string.
			System.out.println("Received all rows");
			System.out.println();

			// create another selectStatement for update.
			updateStatement = connection.prepareStatement("Update Student set First_Name=? where Last_Name=?");
			updateStatement.setString(2,"Smith");
			updateStatement.setString(1,"A");
			rows = updateStatement.executeUpdate();
			System.out.println("Rows Impacted: " + rows);	
			
			updateStatement.setString(2,"White");
			updateStatement.setString(1,"B");
			rows = updateStatement.executeUpdate();
			System.out.println("Rows Impacted: " + rows);	
			
			updateStatement.setString(2,"Fisher");
			updateStatement.setString(1,"C");
			rows = updateStatement.executeUpdate();
			System.out.println("Rows Impacted: " + rows);	

			// let's start printing the data after update.
			System.out.println("After Update:");

			// create a prepared selectStatement.
			// leave the last name undefined.
			preparedStatement = connection.prepareStatement(
				"select * from Student where Last_Name=?");

			// set the last name now to 'Smith'.
			preparedStatement.setString(1,"Smith");

			// execute the query with last name 'Smith'.
			// this will return a resultset.
			resultSet=preparedStatement.executeQuery();

			// loop though the result set and print.
			while (resultSet.next())
			{
				System.out.println(resultSet.getInt(1) 
					+ "\t" + resultSet.getString(2) 
					+ "\t" + resultSet.getString(3));
			}

			// print end string.
			System.out.println("Received all rows");
			System.out.println();

			
			// set the last name now to 'White'.
			preparedStatement.setString(1,"White");

			// execute the query with last name 'White'.
			// this will return a resultset.
			resultSet=preparedStatement.executeQuery();

			// loop though the result set and print.
			while (resultSet.next())
			{
				System.out.println(resultSet.getInt(1) 
					+ "\t" + resultSet.getString(2) 
					+ "\t" + resultSet.getString(3));
			}

			// print end string.
			System.out.println("Received all rows");
			System.out.println();

			// set the last name now to 'Fisher'.
			preparedStatement.setString(1,"Fisher");

			// execute the query with last name 'Fisher'.
			// this will return a resultset.
			resultSet=preparedStatement.executeQuery();

			// loop though the result set and print.
			while (resultSet.next())
			{
				System.out.println(resultSet.getInt(1) 
					+ "\t" + resultSet.getString(2) 
					+ "\t" + resultSet.getString(3));
			}

			// print end string.
			System.out.println("Received all rows");
			System.out.println();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
