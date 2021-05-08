package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import view.FPrincipal;
import view.PCadTemas;
import view.PConsulta;

public class ControllerPrincipal implements ActionListener
{
	private JComboBox listaOpcoes;
	private JButton btnCadastro, btnConsulta;

	public ControllerPrincipal(JComboBox listaOpcoes, JButton btnCadastro, JButton btnConsulta)
	{
		this.btnCadastro = btnCadastro;
		this.btnConsulta = btnConsulta;
		this.listaOpcoes = listaOpcoes;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		String opc = String.valueOf(listaOpcoes.getSelectedItem());

		if (cmd.equals("Cadastrar"))
		{
			switch(opc)
			{
			case "Temas":
				FPrincipal.atualizarFrame(new PCadTemas());
				break;
			case "Clientes":
				//FPrincipal.atualizarFrame(new PCadClientes());
				break;
			case "Alugueis":
				//FPrincipal.atualizarFrame(new PCadAlugueis());
				break;
			}

		}

		if (cmd.equals("Consultar"))
		{
			FPrincipal.atualizarFrame(new PConsulta());
			
			switch(opc)
			{
			case "Temas":
				consultaTipo(0);
				break;
				
			case "Clientes":
				consultaTipo(1);
				break;
				
			case "Alugueis":
				consultaTipo(2);
				break;
			}
		}
	}
	
	private void consultaTipo(int tipo)
	{
		//criar lista
		//mensagem de carregando dados
		switch(tipo)
		{
		case 0:
			//executar query do tipo temas
			break;
		case 1:
			//executar query do tipo clientes
			break;
		case 2:
			//executar query do tipo alugueis
			break;
		}
	}
}
