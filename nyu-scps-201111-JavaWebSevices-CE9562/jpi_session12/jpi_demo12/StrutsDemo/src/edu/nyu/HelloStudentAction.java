package edu.nyu;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HelloStudentAction extends ActionSupport{

   	private String message = null;
    
	public String execute() throws Exception {
    	
    	String[] names = (String[]) ServletActionContext.getContext().getParameters().get("name");
    	

    	if (names ==null){
    		message= "Hello JPI Class!!!!!!";
    	}
    	else{
    		message= "Hello: " + names[0];
    	}

    	// we only need to set the attribute if we are usin hello.jsp
    	// we don't need it if we are using hellostruts.jsp
    	ServletActionContext.getRequest().setAttribute("myMessage", message);
        
    	return "SUCCESS";
        
    }
    
    public void setMyMessage(String anyMessage){
    	message = anyMessage;
    }
    
    public String getMyMessage(){
    	return message;
    }


 }
