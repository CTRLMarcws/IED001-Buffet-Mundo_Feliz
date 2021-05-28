package controller;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import persistence.ClientsDao;



@SuppressWarnings("unused")
public class ClientsController implements ActionListener
{
	private JTextField tfName, tfEmail, tfStreet, tfDistrict, tfCity, tfAddrCompl,  tfStreetNum;
	private JFormattedTextField ftfId, ftfCpf, ftfRg, ftfPhone, ftfPostalCode;
	private JTextArea taObs;
	private ClientsDao cDao;	

	public ClientsController(JTextField tfName, JTextField tfEmail, JTextField tfStreet,
			JTextField tfDistrict, JTextField tfCity, JTextField tfAddrCompl, JTextField tfStreetNum,
			JFormattedTextField ftfId, JFormattedTextField ftfCpf, JFormattedTextField ftfRg,
			JFormattedTextField ftfPhone, JFormattedTextField ftfPostalCode, JTextArea taObs)
	{
		this.tfName = tfName;
		this.tfEmail = tfEmail;
		this.tfStreet = tfStreet;
		this.tfDistrict = tfDistrict;
		this.tfCity = tfCity;
		this.tfAddrCompl = tfAddrCompl;
		this.tfStreetNum = tfStreetNum;
		this.ftfId = ftfId;
		this.ftfCpf = ftfCpf;
		this.ftfRg = ftfRg;
		this.ftfPhone = ftfPhone;
		this.ftfPostalCode = ftfPostalCode;
		this.taObs = taObs;
		cDao = new ClientsDao();
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