package persistence;

import java.io.IOException;

import controller.FileController;
import model.ThemesNode;
import model.Theme;

public class ThemesDao
{
	private String msg;
	private ThemesNode inicio;
	private FileController file;

	public ThemesDao()
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
		ThemesNode aux = this.inicio;
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
		ThemesNode aux = this.inicio;
		int i = 0;

		while(aux != null)
		{
			if (id == aux.getTheme().getId())
			{
				return i;
			}
			i++;
			aux = aux.getNext();
		}
		return 0;
	}

	public Theme getTheme(int rowIndex)
	{
		ThemesNode aux = this.inicio;
		for (int i = 0; i < rowIndex; i++)
		{
			aux = aux.getNext();
		}
		if (aux == null)
		{
			return null;
		}
		return aux.getTheme();
	}

	public Theme findTheme(String name)
	{
		ThemesNode aux = this.inicio;

		while(aux != null)
		{
			if (name.equalsIgnoreCase(aux.getTheme().getName()))
			{
				return aux.theme;
			}
			aux = aux.getNext();
		}
		return null;
	}

	public Theme getLastTheme()
	{
		ThemesNode aux = this.inicio;

		while(aux.getNext() != null)
		{
			aux = aux.getNext();
		}
		return aux.getTheme();
	}

	private String addFirst(Theme theme)
	{
		ThemesNode newTheme = new ThemesNode(theme);
		newTheme.next = this.inicio;
		this.inicio = newTheme;
		msg = msgMod(newTheme, 1);
		return msg;
	}

	public String addLast(Theme theme, int write) throws IOException
	{
		if(emptyList())
		{
			msg = addFirst(theme);
		}
		else
		{
			ThemesNode aux = this.inicio;

			while(aux.next != null)
			{
				aux = aux.next;
			}
			ThemesNode newTheme = new ThemesNode(theme);
			aux.next = newTheme;
			msg = msgMod(newTheme, 1);
		}
		if (write == 1)
		{
			file = new FileController();
			file.createTheme(theme);
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
			ThemesNode aux1 = this.inicio;
			ThemesNode aux2 = this.inicio;

			while (aux1.getNext() != null)
			{
				aux2 = aux1;
				aux1 = aux1.getNext();
			}
			msg = msgMod(aux1, 0);
			aux2.setNext(null);
		}
		return msg;
	}

	public String removeById(int id) throws IOException
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
				ThemesNode aux1 = this.inicio;
				ThemesNode aux2 = this.inicio;
				
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

	//	update theme

	private String msgMod (ThemesNode aux, int add)
	{
		if (add == 1)
		{
			msg = "Tema adicionado na lista: \n";
		}
		else
		{
			msg = "Tema removido da lista: \n";
		}
		msg += "ID: " + aux.getTheme().getId()
				+ "\nNome: " + aux.getTheme().getName() 
				+ "\nDescrição: " + aux.getTheme().getDesc()
				+ "\nValor: " + aux.getTheme().getValue()+ "\n";
		return msg;
	}

}
