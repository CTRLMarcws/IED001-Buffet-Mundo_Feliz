package persistence;

import model.Node_Themes;
import model.Theme;

public class ThemeDao
{
	private String msg;
	private Node_Themes inicio;

	public ThemeDao()
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
		Node_Themes aux = this.inicio;
		int cont = 0;
		if (aux != null)
		{
			while (aux.getNext() != null)
			{
				aux = aux.getNext();
				cont++;
			}
		}
		return cont;
	}
	public int getId(int id)
	{
		Node_Themes aux = this.inicio;
		int i = 0;

		while(aux != null)
		{
			if (id == aux.getThemeDao().getId())
			{
				return i;
			}
			i++;
			aux = aux.getNext();
		}
		return 0;
	}

	public Theme getTheme(int theme)
	{
		Node_Themes aux = this.inicio;
		for (int i = 0; i < theme; i++)
		{
			aux = aux.getNext();
		}
		if (aux == null)
		{
			return null;
		}
		return aux.getThemeDao();
	}

	public Theme findTheme(String name)
	{
		Node_Themes aux = this.inicio;

		while(aux != null)
		{
			if (name.equalsIgnoreCase(aux.getThemeDao().getName()))
			{
				return aux.theme;
			}
			aux = aux.getNext();
		}
		return null;
	}

	public Theme getLastTheme()
	{
		Node_Themes aux = this.inicio;

		while(aux.getNext() != null)
		{
			aux = aux.getNext();
		}
		return aux.getThemeDao();
	}

	public String addFirst(Theme theme)
	{
		Node_Themes newTheme = new Node_Themes(theme);
		newTheme.next = this.inicio;
		this.inicio = newTheme;
		msg = "Tema adicionado na lista: \n"
				+ "ID: " + newTheme.getThemeDao().getId()
				+ "\nNome: " + newTheme.getThemeDao().getName() 
				+ "\nDescrição: " + newTheme.getThemeDao().getDesc()
				+ "\nValor: " + newTheme.getThemeDao().getValue()+ "\n";
		return msg;
	}


	public String addLast(Theme theme)
	{
		if(emptyList())
		{
			msg = addFirst(theme);
		}
		else
		{
			Node_Themes auxiliar = this.inicio;

			while(auxiliar.next != null)
			{
				auxiliar = auxiliar.next;
			}
			Node_Themes newTheme = new Node_Themes (theme);
			auxiliar.next = newTheme;
			msg = "Tema adicionado na lista: \n"
					+ "ID: " + newTheme.getThemeDao().getId()
					+ "\nNome: " + newTheme.getThemeDao().getName() 
					+ "\nDescrição: " + newTheme.getThemeDao().getDesc()
					+ "\nValor: " + newTheme.getThemeDao().getValue()+ "\n";
		}
		return msg;
	}



	private String removeFirstTheme()
	{
		msg = "Tema removido da lista: \n"
				+ "ID: " + this.inicio.getThemeDao().getId()
				+ "\nNome: " + this.inicio.getThemeDao().getName() 
				+ "\nDescrição: " + this.inicio.getThemeDao().getDesc()
				+ "\nValor: " + this.inicio.getThemeDao().getValue()+ "\n";
		this.inicio = this.inicio.getNext();
		return msg;
	}


	private String removeLastTheme()
	{
		if (this.inicio.next == null)
		{
			this.inicio = null; //mantém?
		}
		else
		{
			Node_Themes aux1 = this.inicio;
			Node_Themes aux2 = this.inicio;

			while (aux1.getNext() != null)
			{
				aux2 = aux1;
				aux1 = aux1.getNext();
			}
			msg = "Tema removido da lista: \n"
					+ "ID: " + aux1.getThemeDao().getId()
					+ "\nNome: " + aux1.getThemeDao().getName() 
					+ "\nDescrição: " + aux1.getThemeDao().getDesc()
					+ "\nValor: " + aux1.getThemeDao().getValue()+ "\n";
			aux2.setNext(null);
		}
		return msg;
	}

	public String removeTheme(int id)
	{
		if (emptyList())
		{
			msg = "A Lista está vazia.";
		}
		else
		{
			if(id == 1)
			{
				msg = removeFirstTheme();
			}
			else if (id == getLenght() + 1)
			{
				msg = removeLastTheme();
			}
			else if (id <= getLenght() && id > 0)
			{
				Node_Themes aux1 = this.inicio;
				Node_Themes aux2 = this.inicio;

				while (id > 1)
				{
					aux2 = aux1;
					aux1 = aux1.getNext();
					id --;
				}
				msg = "Tema removido da lista: \n"
						+ "ID: " + aux1.getThemeDao().getId()
						+ "\nNome: " + aux1.getThemeDao().getName() 
						+ "\nDescrição: " + aux1.getThemeDao().getDesc()
						+ "\nValor: " + aux1.getThemeDao().getValue()+ "\n";
				aux2.setNext(aux1.getNext());
			}
		}
		return msg;
	}

	//	update theme


}
