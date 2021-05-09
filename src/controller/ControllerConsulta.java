package controller;

import javax.swing.JTable;

import entity.Tema;

public class ControllerConsulta
{
	private Tema inicio;
	
	private JTable table;
	
	private static int tamanhoLista = 0;
	
	
	public ControllerConsulta()
	{
		this.inicio = null;
	}

	public static String[] getColunas()
	{
		String colunas[] = {"Nome", "Descrição"};
		
		return colunas;
	}

	public static String[][] getDados(int tipo)
	{
		return null;
		//Tema tema = inicio;
		//String dado[][] = {{tema.getNome(), tema.getDesc(),
		//	Double.toString(tema.getValor()), Integer.toString(tema.getSts())}};
		
		private String mat[][] = {{"Batman","Festa DC"},{"Iron Main", "Marvel do Ceara"}};
		
	}
	
	/*
	 * public int getColumnCount() {
        return this.columns.length;
    }
	 
	
	public static void adicionar(JTable table)
	{
		Tema tema;
		table.setValueAt(tema, table.columns.lenght , );
		table.getColumnCount();
	}*/
	
	public static void setTipo(int tipo)
	{
		int i = 0;
		
		switch(tipo)
		{
		case 0:
			String colTemas[] = {"Nome", "Descrição", "Valor", "Status"};
			for(int i = 0; i < lenght; i++)
			{
				String dado[0][i] = tema.getNome();
				dado[1][i] = tema.getDesc();
				dado[2][i] = Double.toString(tema.getValor());
				dado[3][i] = Integer.toString(tema.getSts());
			}
			//executar query do tipo temas
			break;
		case 1:
			String colClientes[] = {""};
			//executar query do tipo clientes
			break;
		case 2:
			String colAlugueis[] = {" "};
			//executar query do tipo alugueis
			break;
		}	
	}
	
	
	
	public Tema percorrer(Tema auxiliar)
	{
		if(auxiliar.getProximo() != null)
		{
			i++;
			return percorrer(auxiliar.getProximo());
		}
		return i;
	}
}
