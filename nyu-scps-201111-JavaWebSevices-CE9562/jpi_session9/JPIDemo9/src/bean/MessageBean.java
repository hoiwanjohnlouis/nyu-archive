package bean;
public class MessageBean implements java.io.Serializable 
{
	private static final long serialVersionUID = 1L;

	private String message;
	public String getMessage(){
		return message;
	}

	public void setMessage(String newmessage){
		message = newmessage;
	}
	
	public String generateDefaultMessage(){
		return "Beans are cool, EJBs are pain in the neck";
	}

}
