package persistence;

import java.io.IOException;

import controller.FileController;
import model.Client;
import model.ClientsNode;

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
			if (name.equalsIgnoreCase(aux.getClient().getName()))
			{
				return aux.client;
			}
			aux = aux.getNext();
		}
		return null;
	}

	public Client findClientByCPF(String cpf)
	{
		ClientsNode aux = this.inicio;

		while(aux != null)
		{
			if (cpf.equalsIgnoreCase(aux.getClient().getCpf()))
			{
				return aux.client;
			}
			aux = aux.getNext();
		}
		return null;
	}

	public Client getLastClient()
	{
		ClientsNode aux = this.inicio;

		while(aux.getNext() != null)
		{
			aux = aux.getNext();
		}
		return aux.getClient();
	}

	private String addFirst(Client client)
	{
		ClientsNode newClient = new ClientsNode(client);
		newClient.next = this.inicio;
		this.inicio = newClient;
		msg = msgMod(newClient, 1);
		return msg;
	}

	public String addLast(Client client, int write) throws IOException
	{
		if(emptyList())
		{
			msg = addFirst(client);
		}
		else
		{
			ClientsNode aux = this.inicio;

			while(aux.next != null)
			{
				aux = aux.next;
			}

			ClientsNode newClient = new ClientsNode(client);
			aux.next = newClient;

			msg = msgMod(newClient, 1);
		}
		if (write == 1)
		{
			file = new FileController();
			file.createClient(client);
		}
		return msg;
	}

	private String removeFirst()
	{
		msg = msgMod(this.inicio, 0);
		this.inicio = this.inicio.getNext();
		return msg;
	}

	private String removeLast()
	{
		if (this.inicio.next == null)
		{
			this.inicio = null;
		}
		else
		{
			ClientsNode aux1 = this.inicio;
			ClientsNode aux2 = this.inicio;

			while (aux1.getNext() != null)
			{
				aux2 = aux1;
				aux1 = aux1.getNext();
			}
			msg = msgMod(aux1, 0);
			aux2.setClient(null);
		}
		return msg;
	}

	public String removeById(int id)
	{
		if (emptyList())
		{
			msg = "A Lista está vazia.";
		}
		else
		{
			if(id == 1)
			{
				msg = removeFirst();
			}
			else if (id == getLenght() + 1)
			{
				msg = removeLast();
			}
			else if (id <= getLenght() && id > 0)
			{
				ClientsNode aux1 = this.inicio;
				ClientsNode aux2 = this.inicio;

				while (id > 1)
				{
					aux2 = aux1;
					aux1 = aux1.getNext();
					id --;
				}
				msg = msgMod(aux1, 0);
				aux2.setNext(aux1.getNext());

			}
		}
		return msg;
	}
	
	//update client

	private String msgMod (ClientsNode aux, int add)
	{
		if (add == 1)
		{
			msg = "Cliente adicionado na lista: \n";
		}
		else
		{
			msg = "Cliente removido na lista: \n";			
		}
		msg += "ID:\t\t\t" + aux.getClient().getId()
				+ "\nNome:\t\t\t" + aux.getClient().getName()
				+ "\nCPF:\t\t\t" + aux.getClient().getCpf()
				+ "\nRG:\t\t\t\t" + aux.getClient().getRg()
				+ "\nE-mail:\t\t\t" + aux.getClient().getEmail()
				+ "\nNúmero:\t\t" + aux.getClient().getPhone()
				+ "\nObservação:\t" + aux.getClient().getObs() + "\n";
		return msg;
	}
}
