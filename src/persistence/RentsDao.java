package persistence;

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
	
	public Rent getLastRent()
	{
		RentsNode aux = this.start;
		
		while(aux.getNext() != null)
		{
			aux = aux.getNext();
		}
		return aux.getRent();
	}
	
	/*
	 * addFirst
	 * addLast
	 * removeFirs
	 * removeLast
	 * removeById
	 * updateS
	 * msgMod
	 */
}
