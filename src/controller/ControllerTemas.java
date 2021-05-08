package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entity.Tema;
import persistence.TemaDao;
import view.FPrincipal;
import view.PConsulta;

public class ControllerTemas implements ActionListener
{
	private TemaDao tDao;
	private JTextField tfNome;
	private JFormattedTextField ftfValor;
	private JTextArea taDesc;
	
	public ControllerTemas(JTextField tfNome, JTextArea taDesc, JFormattedTextField ftfValor)
	{
		this.tfNome = tfNome;
		this.ftfValor = ftfValor;
		this.taDesc = taDesc;
		tDao = new TemaDao();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();

		if (cmd.equals("Pesquisar"))
		{
			
		}
		if (cmd.equals("Salvar"))
		{
			
		}
		if (cmd.equals("Excluir"))
		{
			
		}
		if (cmd.equals("Ver Todos"))
		{
			FPrincipal.atualizarFrame(new PConsulta());			
		}
	}
	
	
}
