package persistence;

import model.Node_Themes;

public class ClienteDao
{
	private String msg;
	private Node_Themes next, previous;
	
	public ClienteDao(Node_Themes next, Node_Themes previous)
	{
		this.next = next;
		this.previous = previous;
	}
	
	
}
