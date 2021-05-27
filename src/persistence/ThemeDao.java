package persistence;

import javax.swing.JOptionPane;

import model.Node_Themes;
import model.Theme;

public class ThemeDao
{
	public static final Object[][] Percorrer = null;
	private static String msg;
	private Node_Themes inicio;

	public ThemeDao()
	{
		this.inicio = null;
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

	public String adicionarInicio(Theme tema)
	{
		Node_Themes novo = new Node_Themes(tema);
		novo.next = this.inicio;
		this.inicio = novo;
		msg = novo.getThemeDao().getNome() + novo.getThemeDao().getDesc() + novo.getThemeDao().getValor();
		return msg;
	}


	public String AdicionarFinal(Theme tema)
	{
		if(emptyList())
		{
			msg = adicionarInicio(tema);
		}
		else
		{
			Node_Themes auxiliar = this.inicio;

			while(auxiliar.next != null)
			{
				auxiliar = auxiliar.next;
			}
			Node_Themes novo = new Node_Themes (tema);
			auxiliar.next = novo;
			msg = "Tema adicionado na lista: \nNome: " + novo.getThemeDao().getNome() 
					+ "\nDescrição: " + novo.getThemeDao().getDesc()
					+ "\nValor: " + novo.getThemeDao().getValor()+ "\n";
		}
		return msg;
	}


	private boolean emptyList()
	{
		if(this.inicio == null)
		{
			return true;
		}
		return false;
	}

	private void removeFirstTheme()
	{
		this.inicio = this.inicio.getNext();
	}


	private void removeLastTheme()
	{
		if (this.inicio.next == null)
		{
			this.inicio = null;
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

			aux2.setNext(null);
		}
	}

	public void removeTheme(int id)
	{
		if (emptyList())
		{
			//erro = não há temas
		}
		else
		{
			if(id == 1)
			{
				removeFirstTheme();
			}
			else if (id == getLenght() + 1)
			{
				removeLastTheme();
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
				aux2.setNext(aux1.getNext());
			}
		}
	}

	//	update theme

	public int getId(int id)
	{
		Node_Themes aux = this.inicio;
		int i = 0;

		//		while(aux != null && id != aux.getThemeDao().getId())
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
}
