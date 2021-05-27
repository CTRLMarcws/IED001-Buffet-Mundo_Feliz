package persistence;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.No_Temas;
import model.Tema;

public class TemaDao
{
	public static final Object[][] Percorrer = null;
	private static String msg;
	private No_Temas inicio;

	public TemaDao()
	{
		this.inicio = null;
	}

	public int tamanho() {
		No_Temas aux = this.inicio;
		int cont = 0;
		if (aux != null) {
			while (aux.getProx() != null) {
				aux = aux.getProx();
				cont++;
			}
		}
		return cont;
	}
	
	public Tema getTema(int tema) {
		No_Temas aux = this.inicio;
		for (int i = 0; i < tema; i++) {
			aux = aux.getProx();
		}
		if (aux == null) {
			return null;
		}
		return aux.getTemaDao();
	}

	public String adicionarInicio(Tema tema)
	{
		No_Temas novo = new No_Temas(tema);
		novo.prox = this.inicio;
		this.inicio = novo;
		msg = novo.getTemaDao().getNome() + novo.getTemaDao().getDesc() + novo.getTemaDao().getValor();
		return msg;
	}


	public String AdicionarFinal(Tema tema)
	{
		if(listaVazia())
		{
			msg = adicionarInicio(tema);
		}
		else
		{
			No_Temas auxiliar = this.inicio;

			while(auxiliar.prox != null)
			{
				auxiliar = auxiliar.prox;
			}
			No_Temas novo = new No_Temas (tema);
			auxiliar.prox = novo;
			msg = "Tema adicionado na lista: \nNome: " + novo.getTemaDao().getNome() 
					+ "\nDescrição: " + novo.getTemaDao().getDesc()
					+ "\nValor: " + novo.getTemaDao().getValor()
					+ "\n";
		}
		return msg;
	}


	private boolean listaVazia()
	{
		if(this.inicio == null)
		{
			return true;
		}
		return false;
	}


	public String [] percorrer()
	{
		int pos = 1;
		No_Temas novo = this.inicio;

		int total = percorrer(novo, 0);
		String dados[] = new String [total];

		if (this.inicio == null)
		{
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
		}
		else
		{
			while (novo != null)
			{
				dados[pos - 1] =
						novo.getTemaDao().getNome() + ","
								+ novo.getTemaDao().getDesc() + ","
								+ novo.getTemaDao().getValor() + ","
								+ novo.getTemaDao().getSts() + ";";
				novo = novo.getProx();
				pos++;
			}
		}
		return dados;
	}

	public static int percorrer(No_Temas auxiliar, int i)
	{
		if(auxiliar.getProx() != null)
		{
			i++;
			return percorrer(auxiliar.getProx(), i);
		}
		return i;
	}

}
