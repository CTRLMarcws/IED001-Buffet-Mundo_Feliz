package persistence;

import controller.FileController;
import model.Client;
import model.ClientsNode;
import model.ThemesNode;

public class ClientsDao
{
	private String msg;
	private ClientsNode inicio;
	FileController file;
	
	public ClientsDao()
	{
		this.inicio = null;
	}
	
	public boolean emptyList()
	{
		if(this.inicio == null)
		{
			return true;
		}
		return false;
	}

	public int getLenght()
	{
		ClientsNode aux = this.inicio;
		int i = 0;
		if (aux != null)
		{
			while (aux.getNext() != null)
			{
				aux = aux.getNext();
				i++;
			}
		}
		return i;
	}
	
	public int getId(int id)
	{
		ClientsNode aux = this.inicio;
		int i = 0;

		while(aux != null)
		{
			if (id == aux.getClient().getId())
			{
				return i;
			}
			i++;
			aux = aux.getNext();
		}
		return 0;
	}

	public Client getClient(int rowIndex)
	{
		ClientsNode aux = this.inicio;
		for (int i = 0; i < rowIndex; i++)
		{
			aux = aux.getNext();
		}
		if (aux == null)
		{
			return null;
		}
		return aux.getClient();
	}
	
	public Client findClientByName(String name)
	{
		ClientsNode aux = this.inicio;

		while(aux != null)
		{
			if (name.equalsIgnoreCase(aux.getClient().getNome()))
			{
				return aux.client;
			}
			aux = aux.getNext();
		}
		return null;
	}
	
	/*
	 * addFirst
	 * addLast
	 * RemoveFirst
	 * removeLast
	 * removeClient
	 * updateClient
	 */
	
	
}
