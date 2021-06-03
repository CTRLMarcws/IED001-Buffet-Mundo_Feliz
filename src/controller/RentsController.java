package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Address;
import model.Client;
import model.Rent;
import persistence.ClientsDao;
import persistence.RentsDao;
import persistence.ThemesDao;
import view.FMain;
import view.PQuery;

@SuppressWarnings("unused")
public class RentsController implements ActionListener
{
	private JTextField  tfId, tfClientName, tfStreet, tfDistrict, tfCity, tfAddrCompl, tfStreetNum;

	private JFormattedTextField ftfDate, ftfStartTime, ftfEndTime, ftfValue, ftfDiscount, ftfTotal, ftfPostalCode;
	private JTextArea taObs;
	private ThemesDao tDao;
	private ClientsDao cDao;
	private RentsDao rDao;
	private Address address;
	private Client client;
	private Rent rent;

	private JRadioButton rbAddressYes, rbAddressNo;

	private JComboBox<String> cbStates;
	private JComboBox<Object> cbThemes;

	public RentsController(JTextField tfId, JTextField tfClientName, JTextField tfStreet, JTextField tfDistrict,
			JTextField tfCity, JTextField tfAddrCompl, JTextField tfStreetNum, JFormattedTextField ftfDate,
			JFormattedTextField ftfStartTime, JFormattedTextField ftfEndTime, JFormattedTextField ftfPostalCode,
			JFormattedTextField ftfValue, JFormattedTextField ftfDiscount, JFormattedTextField ftfTotal, JTextArea taObs,
			JRadioButton rbAddressYes, JRadioButton rbAddressNo, JComboBox<String> cbStates, JComboBox<Object> cbThemes)
	{
		this.tfId = tfId;
		this.tfClientName = tfClientName;
		this.tfStreet = tfStreet;
		this.tfDistrict = tfDistrict;
		this.tfCity = tfCity;
		this.tfAddrCompl = tfAddrCompl;
		this.tfStreetNum = tfStreetNum;
		this.ftfDate = ftfDate;
		this.ftfStartTime = ftfStartTime;
		this.ftfEndTime = ftfEndTime;
		this.ftfPostalCode = ftfPostalCode;
		this.ftfValue = ftfValue;
		this.ftfDiscount = ftfDiscount;
		this.ftfTotal = ftfTotal;
		this.taObs = taObs;
		this.rbAddressYes = rbAddressYes;
		this.rbAddressNo = rbAddressNo;
		this.cbStates = cbStates;
		this.cbThemes = cbThemes;

		FileController file = new FileController();
		tDao = new ThemesDao();
		cDao = new ClientsDao();
		rDao = new RentsDao();
		try
		{
			if(file.readFile("themes.csv"))
			{
				tDao = file.readThemes(tDao);
			}
			if(file.readFile("clients.csv"))
			{
				cDao = file.readClients(cDao);
			}
			if(file.readFile("rents.csv"))
			{
				rDao = file.readRents(rDao);
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
		if(cmd.equals("Pesquisar"))
		{
			searchClient();
		}
		if(cmd.equals("Salvar"))
		{
			try
			{
				register();
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		if(cmd.equals("Consultar"))
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ID para pesquisar."));
			searchRent(id);
		}
		if(cmd.equals("Ver todos"))
		{
			FMain.refreshFrame(new PQuery("Alugueis"));
		}
		if(cmd.equals("Excluir"))
		{
			remove();
		}
		if(cmd.equals("Limpar"))
		{
			clearFields();
		}
		if(rbAddressYes.isSelected())
		{
			textFieldsEnable(false);
		}
		if(rbAddressNo.isSelected())
		{
			textFieldsEnable(true);			
		}
	}

	private void searchClient()
	{
		String searchInput, returnMsg;
		client = null;

		if(!cDao.emptyList())
		{
			if(tfClientName.getText().isEmpty())
			{
				returnMsg = "Preencha o nome do cliente para pesquisar.";
			}
			else
			{
				searchInput = tfClientName.getText();
				client = cDao.findClientByName(searchInput);
			}


			if(client != null)
			{
				tfClientName.setText(client.getName());
				tfStreet.setText(client.getAddress().getStreet());
				tfStreetNum.setText(client.getAddress().getStreetNum());
				tfDistrict.setText(client.getAddress().getDistrict());
				tfCity.setText(client.getAddress().getCity());
				tfAddrCompl.setText(client.getAddress().getAddrCompl());
				ftfPostalCode.setText(client.getAddress().getPostalCode());
				rbAddressYes.setSelected(true);
				cbStates.setSelectedItem(client.getAddress().getState());
			}
			else
			{
				returnMsg = "Cliente não encontrado.";
				notify(returnMsg, "erro");
			}
		}
		else
		{
			returnMsg = "A lista está vazia.";
			notify(returnMsg, "erro");
		}
	}

	private void searchRent(int id)
	{
		String searchInput, returnMsg;

		if(!rDao.emptyList())
		{
			System.out.println(id);
			rent = rDao.getLastRent();

			if(rent != null)
			{
				tfClientName.setText(rent.getClient());
				address = rent.getSplitAddress(rent.getAddress());
				tfStreet.setText(address.getStreet());
				tfStreetNum.setText(address.getStreetNum());
				tfDistrict.setText(address.getDistrict());
				tfCity.setText(address.getCity());
				cbStates.setSelectedItem(address.getState().toString());
				tfAddrCompl.setText(address.getAddrCompl());
				ftfPostalCode.setText(address.getPostalCode());
				rbAddressYes.setSelected(true);
				
				cbThemes.setSelectedItem(rent.getTheme().toString());
				ftfDate.setText(rent.getDate());
				ftfStartTime.setText(rent.getStartTime());
				ftfEndTime.setText(rent.getEndTime());
				tfId.setText(Integer.toString(rent.getId()));
				String auxValue = "R$ " +  Double.toString(rent.getValue());
				ftfTotal.setText(auxValue.replace(".", ","));
			}
			else
			{
				returnMsg = "Aluguel não encontrado.";
				notify(returnMsg, "erro");
			}
		}
		else
		{
			returnMsg = "A lista está vazia.";
			notify(returnMsg, "erro");
		}
	}

	private void register() throws IOException
	{
		int id = 1;
		if(validateFields())
		{
			if(!rDao.emptyList())
			{
				id = rDao.getLastRent().getId() + 1;
			}

			address = new Address(tfStreet.getText(), tfStreetNum.getText(), tfDistrict.getText(), tfCity.getText(), ftfPostalCode.getText(),
					tfAddrCompl.getText(), cbStates.getSelectedItem().toString());

			String aux = ftfTotal.getText().substring(3).replace(',', '.');
			double totalValue = Double.parseDouble(aux);

			rent = new Rent(id, tfClientName.getText(), cbThemes.getSelectedItem().toString(), ftfDate.getText(),
					ftfStartTime.getText(), ftfEndTime.getText(), address.formatToTableModel(), totalValue);

			String returnMsg = rDao.addLast(rent, 1);

			notify(returnMsg, "confirmado");
			clearFields();
		}
	}

	private void remove()
	{
		String searchInput, returnMsg;
		rent = null;

		if(!rDao.emptyList())
		{
			if(!tfId.getText().isEmpty())
			{
				rent = rDao.getRent(Integer.parseInt(tfId.getText()));
			}
			else
			{
				returnMsg = "O campo ID é obrigatório para esta operação";
				notify(returnMsg, "erro");
			}

			if(rent != null)
			{
				try
				{
					returnMsg = rDao.removeById(Integer.parseInt(tfId.getText()));
				}
				catch (NumberFormatException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				clearFields();
			}
			else
			{
				returnMsg = "Erro ao processar esta operação.";
				notify(returnMsg, "erro");
			}
		}
		else
		{
			returnMsg = "A lista está vazia.";
			notify(returnMsg, "erro");
		}
	}

	private void clearFields()
	{
		tfId.setText(null);
		tfClientName.setText(null);
		tfStreet.setText(null);
		tfDistrict.setText(null);
		tfCity.setText(null);
		tfAddrCompl.setText(null);
		tfStreetNum.setText(null);
		ftfDate.setText(null);
		ftfStartTime.setText(null);
		ftfEndTime.setText(null);
		ftfValue.setText(null);
		ftfDiscount.setText(null);
		ftfTotal.setText(null);
		taObs.setText(null);
	}

	private boolean validateFields()
	{
		if (!tfClientName.getText().isEmpty() && !cbThemes.getSelectedItem().toString().isEmpty())
		{
			if (!ftfPostalCode.getText().isEmpty() && !tfStreetNum.getText().isEmpty())
			{
				if (!ftfDate.getText().equals("  /  /   "))
				{
					String[] date = ftfDate.getText().split("/");
					if(Integer.parseInt(date[0]) < 1 || Integer.parseInt(date[0]) > 31 || Integer.parseInt(date[1]) < 1
							|| Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[2]) < 1900 || Integer.parseInt(date[2]) > 2100)
					{
						String returnMsg = "O campo data esta incorreto.";
						notify(returnMsg, "erro");
						return false;
					}
					if(!ftfStartTime.getText().equals("  :  ") && !ftfEndTime.getText().equals("  :  "))
					{
						String[] initHour = ftfStartTime.getText().split(":");
						String[] endHour = ftfEndTime.getText().split(":");
						if (Integer.parseInt(initHour[0]) < 0 || Integer.parseInt(initHour[0]) > 23 ||
								Integer.parseInt(initHour[1]) < 0 || Integer.parseInt(initHour[1]) > 59 ||
								Integer.parseInt(endHour[0]) < 0 || Integer.parseInt(endHour[0]) > 23 ||
								Integer.parseInt(endHour[1]) < 0 || Integer.parseInt(endHour[1]) > 59)
						{
							String returnMsg = "Os campos 'Hora inicial' e/ou 'Hora final' estão incorretos.";
							notify(returnMsg, "erro");
							return false;
						}
						if (!ftfTotal.getText().isEmpty())
						{
							return true;
						}
					}

				}
			}
		}
		String returnMsg = "Exitem campos obrigatórios vazios.";
		notify(returnMsg, "erro");
		return false;
	}

	private void notify(String returnMsg, String contains)
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

	private void textFieldsEnable(boolean active)
	{
		tfStreet.setEnabled(active);
		tfStreetNum.setEnabled(active);
		tfDistrict.setEnabled(active);
		tfCity.setEnabled(active);
		tfAddrCompl.setEnabled(active);
		ftfPostalCode.setEnabled(active);
		cbStates.setEnabled(active);

		tfStreet.setEditable(active);
		tfStreetNum.setEditable(active);
		tfDistrict.setEditable(active);
		tfCity.setEditable(active);
		tfAddrCompl.setEditable(active);
		ftfPostalCode.setEditable(active);
		cbStates.setEditable(active);
	}
}

