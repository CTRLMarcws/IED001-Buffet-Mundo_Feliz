package model;

public class ClientsNode
{
	public Client client;
	public ClientsNode next;

	public ClientsNode(Client client)
	{
		this.client = client;
		next = null;
	}

	public Client getClient()
	{
		return client;
	}

	public void setClient(Client client)
	{
		this.client = client;
	}

	public ClientsNode getNext()
	{
		return next;
	}

	public void setNext(ClientsNode next)
	{
		this.next = next;
	}
}
