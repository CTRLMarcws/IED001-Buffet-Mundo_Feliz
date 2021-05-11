package controller;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import persistence.ClienteDao;



public class ControllerClientes implements ActionListener
{

	private ClienteDao cDao;
	private JTextField tfNome, tfEndereco, tfBairro, tfCidade, tfComp, tfEmail, tfEndNum;
	private JFormattedTextField ftfId, ftfCpf, ftfRg, ftfFone, ftfCep;
	private JTextArea taObs;


	public ControllerClientes(JTextField tfNome, JTextField tfEndereco, JTextField tfBairro, JTextField tfCidade,
			JTextField tfComp, JTextField tfEmail, JTextField tfEndNum, JFormattedTextField ftfId,
			JFormattedTextField ftfCpf, JFormattedTextField ftfRg, JFormattedTextField ftfFone,
			JFormattedTextField ftfCep, JTextArea taObs)
	{
		this.tfNome = tfNome;
		this.tfEndereco = tfEndereco;
		this.tfBairro = tfBairro;
		this.tfCidade = tfCidade;
		this.tfComp = tfComp;
		this.tfEmail = tfEmail;
		this.tfEndNum = tfEndNum;
		this.ftfId = ftfId;
		this.ftfCpf = ftfCpf;
		this.ftfRg = ftfRg;
		this.ftfFone = ftfFone;
		this.ftfCep = ftfCep;
		this.taObs = taObs;
		cDao = new ClienteDao();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		
		if (cmd.equals("Salvar"))
		{
			
		}
		if (cmd.equals("Consultar"))
		{
			
		}
		if (cmd.equals("VerTodos"))
		{
			
		}
		if (cmd.equals("Historico"))
		{
			
		}
		if (cmd.contains("Financeira"))
		{
			
		}
	}



}