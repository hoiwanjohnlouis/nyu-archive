// code 6D
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import COM.cloudscape.core.BasicDataSource;
public class BindDataSource{
	public static void main(String[] args){
		try{
		// create a hash table and put parameters to create the context
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
			"com.sun.jndi.fscontext.RefFSContextFactory");
		env.put(Context.PROVIDER_URL,"file:/c:/jndistore");
		
		//create the context
		Context context = new InitialContext(env);

		// create a datasource and put your database name in it.
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDatabaseName("c:/data/VSTORE");
		
		//bind the datasource to a name
		context.rebind("mydatasource",datasource);
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
}