// code 6E
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
public class DataSourceClient{
	public static void main(String[] args){
		try{

		// create a hash table and put parameters to create the context
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
			"com.sun.jndi.fscontext.RefFSContextFactory");
		env.put(Context.PROVIDER_URL,"file:/C:/jndistore");
		
		//create the context
		Context context = new InitialContext(env);

		// find the datasource
		DataSource datasource = (DataSource) context.lookup("mydatasource");
		System.out.println(datasource.getClass().getName());

		// get a connection
		Connection connection = datasource.getConnection();

		// create a statement
		Statement statement = connection.createStatement();

		// execute a query using the statement.
		// this will return a resultset.
		ResultSet categories = statement.executeQuery("select * from categories");

		//loop through all the items.
		while (categories.next()){
			System.out.println(categories.getString("category_name"));
		}

		
		}

		catch(Exception e){
			System.out.println(e);
		}
		
	}
}