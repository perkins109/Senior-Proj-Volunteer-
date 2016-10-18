package test.test;

import java.io.Serializable;

public class MyMessage implements Serializable
{
	String message;

	public MyMessage(String message) 
	{
		super();
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message) 
	{
		this.message = message;
	}
}
