package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Address;
import model.Client;
import persistence.ClientsDao;
import view.FMain;
import view.PQuery;

public class ClientsController implements ActionListener
{
	private JTextField tfName, tfEmail;
	private JFormattedTextField ftfId, ftfCpf, ftfRg, ftfPhone;
	private JTextArea taObs;
	private ClientsDao cDao;
	private Address address;
	private Client client;
	private JTextField tfStreet, tfDistrict, tfCity, tfAddrCompl,  tfStreetNum;
	private JFormattedTextField ftfPostalCode;
	private JComboBox<String> cbStates;

	public ClientsController(JFormattedTextField ftfId, JTextField tfName, JFormattedTextField ftfCpf,
			JFormattedTextField ftfRg, JTextField tfEmail, JFormattedTextField ftfPhone, JTextArea taObs,
			JTextField tfStreet, JTextField tfDistrict, JTextField tfCity, JTextField tfAddrCompl,
			JTextField tfStreetNum, JFormattedTextField ftfPostalCode, JComboBox<String> cbStates)
	{
		this.ftfId = ftfId;
		this.tfName = tfName;
		this.ftfCpf = ftfCpf;
		this.ftfRg = ftfRg;
		this.tfEmail = tfEmail;
		this.ftfPhone = ftfPhone;
		this.taObs = taObs;
		this.tfStreet = tfStreet;
		this.tfStreetNum = tfStreetNum;
		this.tfDistrict = tfDistrict;
		this.tfCity = tfCity;
		this.tfAddrCompl = tfAddrCompl;
		this.ftfPostalCode = ftfPostalCode;
		this.cbStates = cbStates;

		cDao = new ClientsDao();
		FileController file = new FileController();
		try
		{
			if(file.readFile("clients.csv"))
			{
				cDao = file.readClients(cDao);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();

		if (cmd.equals("Salvar"))
		{
			try {
				register();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Consultar"))
		{
			search();
		}
		if (cmd.equals("VerTodos"))
		{
			FMain.refreshFrame(new PQuery("Clientes"));
		}
		if (cmd.equals("Excluir"))
		{
			remove();
		}
		if (cmd.equals("Limpar"))
		{
			clearFields();
		}
	}

	private void search()
	{
		String searchInput, returnMsg;
		client = null;

		if(!cDao.emptyList())
		{
			if(ftfCpf.getText().isEmpty() && tfName.getText().isEmpty())
			{
				returnMsg = "Os campos 'Nome' ou 'CPF' são obrigatórios para esta operação";
				notification(returnMsg, "erro");									
			}
			else
			{
				if (!ftfCpf.getText().isEmpty())
				{
					searchInput = ftfCpf.getText();
					client = cDao.findClientByCPF(searchInput);

				}
				if (!tfName.getText().isEmpty())
				{
					searchInput = tfName.getText();
					client = cDao.findClientByName(searchInput);
				}				
			}

			if(client != null)
			{
				ftfId.setValue(client.getId());
				tfName.setText(client.getName());
				ftfCpf.setText(client.getCpf());
				ftfRg.setText(client.getRg());
				tfEmail.setText(client.getEmail());
				ftfPhone.setText(client.getPhone());
				taObs.setText(client.getObs());

				tfStreet.setText(client.getAddress().getStreet());
				tfStreetNum.setText(client.getAddress().getStreetNum());
				tfDistrict.setText(client.getAddress().getDistrict());
				tfCity.setText(client.getAddress().getCity());
				tfAddrCompl.setText(client.getAddress().getAddrCompl());
				ftfPostalCode.setText(client.getAddress().getPostalCode());
//				cbStates.setSelectedIndex(address.getIndex(client.getAddress().getState()));
			}
			else
			{
				returnMsg = "Cliente não encontrado.";
				notification(returnMsg, "erro");
			}
		}
		else
		{
			returnMsg = "A lista está vazia.";
			notification(returnMsg, "erro");
		}
	}

	private void register() throws IOException
	{
		int id = 1;
		if(validateFields())
		{
			if(!cDao.emptyList())
			{
				id = cDao.getLastClient().getId() + 1;
			}

			address = new Address(tfStreet.getText(),tfStreetNum.getText(),tfDistrict.getText(),tfCity.getText(),
					cbStates.getSelectedItem().toString(),tfAddrCompl.getText(),ftfPostalCode.getText());

			client = new Client(id, tfName.getText(), ftfCpf.getText(), ftfRg.getText(),
					tfEmail.getText(), ftfPhone.getText(), taObs.getText(), address);
			String returnMsg = cDao.addLast(client, 1);

			notification(returnMsg, "adicionado");
			clearFields();
		}
	}

	private void remove()
	{
		String searchInput, returnMsg;
		client = null;

		if(!cDao.emptyList())
		{
			if (!ftfCpf.getText().isEmpty())
			{
				searchInput = ftfCpf.getText();
				client = cDao.findClientByCPF(searchInput);
			}
			else if (!tfName.getText().isEmpty())
			{
				searchInput = tfName.getText();
				client = cDao.findClientByName(searchInput);
			}
			else
			{
				returnMsg = "Os campos 'Nome' ou 'CPF' são obrigatórios para esta operação";
				notification(returnMsg, "erro");
			}

			if(client != null)
			{
				returnMsg = cDao.removeById(client.getId());
				clearFields();
			}
			else
			{
				returnMsg = "Cliente não encontrado.";
				notification(returnMsg, "erro");
			}
		}
		else
		{
			returnMsg = "A lista está vazia.";
			notification(returnMsg, "erro");
		}
	}

	private void clearFields()
	{
		ftfId.setText(null);
		tfName.setText(null);
		ftfCpf.setText(null);
		ftfRg.setText(null);
		tfEmail.setText(null);
		ftfPhone.setText(null);
		taObs.setText(null);
		tfStreet.setText(null);
		tfDistrict.setText(null);
		tfCity.setText(null);
		tfAddrCompl.setText(null);
		tfStreetNum.setText(null);
		ftfPostalCode.setText(null);
	}

	private boolean validateFields()
	{
		if(!tfName.getText().isEmpty())
		{
			if(!ftfCpf.getText().isEmpty())
			{
				if(!ftfPhone.getText().isEmpty())
				{
					if(!tfEmail.getText().isEmpty())
					{
						if(!ftfPostalCode.getText().isEmpty())
						{
							if(!tfStreetNum.getText().isEmpty())
							{
								return true;								
							}
						}
					}
				}
			}
		}
		String returnMsg = "Exitem campos vazios";
		notification(returnMsg, "erro");
		return false;
	}

	private void notification(String returnMsg, String contains)
	{
		if (returnMsg.contains(contains))
		{
			JOptionPane.showMessageDialog(null, returnMsg, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, returnMsg, "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}