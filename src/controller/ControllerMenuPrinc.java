package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import view.FMain;
import view.PRegThemes;
import view.PQuery;

public class ControllerMenuPrinc implements ActionListener
{
	private JComboBox listaOpcoes;
	private JButton btnCadastro, btnConsulta;

	public ControllerMenuPrinc(JComboBox listaOpcoes, JButton btnCadastro, JButton btnConsulta)
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
				FMain.refreshFrame(new PRegThemes());
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
			switch(opc)
			{
			case "Temas":
				ControllerConsulta.setTipo(0);
				break;
				
			case "Clientes":
				//consultaTipo(1);
				break;
				
			case "Alugueis":
				//consultaTipo(2);
				break;
			}
			
			FMain.refreshFrame(new PQuery());
		}
	}
	
	
}
