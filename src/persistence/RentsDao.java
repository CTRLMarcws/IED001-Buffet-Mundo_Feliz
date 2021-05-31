package persistence;

import java.io.IOException;
import java.time.LocalDate;

import controller.FileController;
import model.Rent;
import model.RentsNode;

public class RentsDao
{
	private String msg;
	private RentsNode start;
	FileController file;

	public RentsDao()
	{
		this.start = null;
	}

	public boolean emptyList()
	{
		if(this.start == null)
		{
			return true;
		}
		return false;
	}

	public int getLenght()
	{
		RentsNode aux = this.start;
		int i = 0;
		if(aux != null)
		{
			while(aux.getNext() != null)
			{
				aux = aux.getNext();
				i++;
			}
		}
		return i;
	}

	public int getId(int id)
	{
		RentsNode aux = this.start;
		int i = 0;

		while(aux != null)
		{
			if(id == aux.getRent().getId())
			{
				return i;
			}
			i++;
			aux = aux.getNext();
		}
		return 0;
	}

	public Rent getRent(int rowIndex)
	{
		RentsNode aux = this.start;
		for(int i = 0; i < rowIndex; i++)
		{
			aux = aux.getNext();
		}
		if(aux == null)
		{
			return null;
		}
		return aux.getRent();
	}

	public RentsNode getRentsNode(int rowIndex)
	{
		RentsNode aux = this.start;
		for(int i = 0; i < rowIndex; i++)
		{
			aux = aux.getNext();
		}
		return aux;
	}

	public Rent getLastRent()
	{
		RentsNode aux = this.start;

		while(aux.getNext() != null)
		{
			aux = aux.getNext();
		}
		return aux.getRent();
	}

	private String addFirst(Rent rent)
	{
		RentsNode newRent = new RentsNode(rent);
		newRent.next = this.start;
		this.start = newRent;
		msg = msgMod(newRent, 1);
		return msg;
	}

	public String addLast(Rent rent, int write) throws IOException
	{
		if (emptyList())
		{
			msg = addFirst(rent);
		}
		else
		{
			RentsNode aux = this.start;
			while(aux.next != null)
			{
				aux = aux.next;
			}

			RentsNode newRent = new RentsNode(rent);
			aux.setNext(newRent);
			newRent.setPrev(aux);
			msg = msgMod(newRent, 1);
		}
		if (write == 1)
		{
			file = new FileController();
			file.createRent(rent);
		}
		return msg;
	}

	private String removeFirst()
	{
		msg = msgMod(this.start, 0);
		this.start = this.start.getNext();
		return msg;
	}

	private String removeLast()
	{
		if(this.start.next == null)
		{
			this.start = null;
		}
		else
		{
			RentsNode aux = this.start;

			while(aux.getNext() != null)
			{
				aux = aux.getNext();
			}
			msg = msgMod(aux, 0);
			aux = aux.getPrev();
			aux.setRent(null);
		}
		return msg;
	}

	public String removeById(int id)
	{
		if (emptyList())
		{
			msg = "A lista está vazia";
		}
		else
		{
			if (id == 1)
			{
				msg = removeFirst();
			}
			else if (id == getLenght() + 1)
			{
				msg = removeLast();
			}
			else if (id <= getLenght() && id > 0)
			{
				RentsNode aux1 = this.start;
				RentsNode aux2 = this.start;

				while(id > 1)
				{
					aux1 = aux1.getNext();
				}
				msg = msgMod(aux1, 0);

				aux2 = aux1.getPrev();
				aux1 = aux1.getNext();
				aux2.setNext(aux1);
				aux1.setPrev(aux2);
			}
		}
		return msg;
	}

	public void updateById()
	{

	}

	private String msgMod(RentsNode aux, int add)
	{
		if (add == 1)
		{
			msg = "Agendamento confirmado! \n";
		}
		else
		{
			msg = "Agendamento cancelado. \n";			
		}
		msg += "ID: " + aux.getRent().getId()
				+ "\nCliente: " + aux.getRent().getClient()
				+ "\nTema: " + aux.getRent().getTheme()
				+ "\nData: " + aux.getRent().getDate()
				+ "\nDas: " + aux.getRent().getStartTime()
				+ " as " + aux.getRent().getEndTime()
				+ "\nTotal: " + aux.getRent().getValue() + "\n";
		return msg;
	}

	public void sort()
	{
		quickSort(0, getLenght());
	}

	private void quickSort(int low, int high)
	{
		if(low < high)
		{
			int pivot = partition(low, high);
			quickSort(low, pivot - 1);
			quickSort(pivot + 1, high);
		}
	}

	private int partition(int high, int low)
	{
		int i = high;

		for(int j = high; j < low; j++)
		{
			LocalDate dateJ = getRent(j).formatDate(getRent(j).getDate());
			LocalDate dateLow = getRent(low).formatDate(getRent(low).getDate());

			if(dateJ.isBefore(dateLow))
			{
				swap(i++, j);
			}
		}
		swap(i, low);
		return i;
	}

	private void swap(int high, int low)
	{
		RentsNode nodeHigh = getRentsNode(high);
		Rent rentHigh = nodeHigh.getRent();

		RentsNode nodeLow = getRentsNode(low);
		Rent rentLow = nodeLow.getRent();

		nodeLow.setRent(rentHigh);
		nodeHigh.setRent(rentLow);
	}

}
