// code 6F
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import COM.cloudscape.core.LocalConnectionPoolDataSource;
public class BindConnectionPoolDataSource{
	public static void main(String[] args){
		try{
		// create a hash table and put parameters to create the context
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.fscontext.RefFSContextFactory");
		env.put(Context.PROVIDER_URL,"file:/C:/jndistore");
		
		//create the context
		Context context = new InitialContext(env);

		// create a datasource and put your database name in it.
		LocalConnectionPoolDataSource datasource = new LocalConnectionPoolDataSource();
		datasource.setDatabaseName("c:/data/VSTORE");
		
		//bind the datasource to a name
		context.rebind("myconnectionpooldatasource",datasource);
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
}