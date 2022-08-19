import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

public class SerializableCustomer implements Serializable,Cloneable{
	
	public static final long serialVersionUID = 1;

	// private fields to hold customer information.
	private SerializableName name;
	private SerializableAddress address;
	
	/** Customer constructor that takes name as input.
	*/
	public SerializableCustomer(SerializableName anyName){
		name = anyName;
	}
	
	/** Customer constructor that takes name and address as input.
	*/
	public SerializableCustomer(SerializableName anyName, SerializableAddress anyAddress){
		name = anyName;
		address = anyAddress;
	}

	public SerializableAddress getAddress() {
		return address;
	}

	public void setAddress(SerializableAddress address) {
		this.address = address;
	}

	public SerializableName getName() {
		return name;
	}

	public void setName(SerializableName name) {
		this.name = name;
	}
	public Object clone(){

		SerializableCustomer copy = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		ByteArrayInputStream byteArrayInputStream = null;
		ObjectInputStream objectInputStream = null;
		try{
			// temp output stream
			byteArrayOutputStream = new ByteArrayOutputStream();
			// attach ObjectOutputStream
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			// write the object out 
			objectOutputStream.writeObject(this);
			//flush the stream.
			objectOutputStream.flush();
	
			// temp input stream.
			byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			// attach ObjectInputStream.
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
			// read in the object
			copy = (SerializableCustomer) objectInputStream.readObject();
		}
		catch(StreamCorruptedException e){
			e.printStackTrace();
		}
		catch(OptionalDataException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				byteArrayOutputStream.close();
				objectOutputStream.close();
				byteArrayInputStream.close();
				objectInputStream.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return copy;
	}
}
