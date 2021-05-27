package controller;

import javax.swing.JTable;

import model.Tema;
import persistence.TemaDao;

public class ControllerConsulta
{
	private Tema inicio;

	private JTable table;

	private static int tamanhoLista = 0;


	public ControllerConsulta()
	{
		this.inicio = null;
	}

	public static void setTipo(int tipo)
	{

		int i = 0;

		switch(tipo)
		{
		case 0:

			//executar query do tipo temas
			break;
		case 1:
			String colClientes[] = {"", ""};
			//executar query do tipo clientes
			break;
		case 2:
			String colAlugueis[] = {"", ""};
			//executar query do tipo alugueis
			break;
		}	
	}
}
