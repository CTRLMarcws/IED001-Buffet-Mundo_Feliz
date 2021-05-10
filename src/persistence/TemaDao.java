package persistence;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import entity.Tema;
import entity.NO;

public class TemaDao
{
	public static final Object[][] Percorrer = null;
	private String msg;
	private static NO inicio;
	
	public TemaDao()
	{
		inicio = null;
	}

	public static void adicionarInicio(Tema tema)
	{
		NO novo = new NO(tema);
		novo.prox = inicio;
		inicio = novo;
		
		JOptionPane.showMessageDialog(null,"Tema adicionado na lista: \nNome: " + novo.getTemaDao().getNome() 
				+ "\nDescrição: " + novo.getTemaDao().getDesc()
				+ "\nValor: " + novo.getTemaDao().getValor()
				+ "\n");
		
	}
	
			
	public static void AdicionarFinal(Tema tema) {
			
			if(listaVazia())
			{
				adicionarInicio(tema);
			}
			else
			{
				NO auxiliar = inicio;
				
				while(auxiliar.prox != null)
				{
					auxiliar = auxiliar.prox;
				}
				NO novo = new NO (tema);
				auxiliar.prox = novo;
				
				JOptionPane.showMessageDialog(null,"Tema adicionado na lista: \nNome: " + novo.getTemaDao().getNome() 
						+ "\nDescrição: " + novo.getTemaDao().getDesc()
						+ "\nValor: " + novo.getTemaDao().getValor()
						+ "\n");
			}
		}
		
	
	public static boolean listaVazia()
	{
		if(inicio == null)
		{
			return true;
		}
		return false;
	}
	

	public static void percorrer()
	{
		int pos = 1;
		
		if (inicio == null) {
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
		} else {
			NO novo = inicio;
			System.out.println("\n\n\n\n************ Lista de Temas: \n");
			while (novo != null) {

				System.out.println("Posição: #" + pos + " - Nome: " + novo.getTemaDao().getNome()
						+ "\nDescrição: " + novo.getTemaDao().getDesc()
						+ "\nValor: " + novo.getTemaDao().getValor()
						+ "\n");
				novo = novo.getProx();
				pos ++;
				
			}
		}
	}
	
}