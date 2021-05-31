package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import model.Address;
import model.Client;
import model.Theme;
import persistence.ClientsDao;
import persistence.ThemesDao;

@SuppressWarnings("unused")
public class FileController
{
	private final String path = "C:\\TEMP\\ED\\";
	private final String nameThemes = "themes.csv";
	private final String nameClients = "clients.csv";
	private final String nameRents = "rents.csv";

	public FileController()
	{
		super();
	}

	public void readDir() throws IOException
	{
		File dir = new File(path);
		if (!dir.exists() || !dir.isDirectory())
		{
			if (dir.mkdir())
			{
				System.out.println("Repositório criado.\n" + path); //alterar?
			}
			else
			{
				throw new IOException ("Invalid Directory.");
			}
		}
	}
	public boolean readFile(String name)
	{
		File file = new File(path + name);
		if (!file.exists() || !file.isFile())
		{
			return false;			
		}
		return true;
	}

	//-----------------------CRUD - Themes-----------------------
	public void createTheme(Theme theme) throws IOException
	{
		readDir();
		File file = new File(path + nameThemes);
		String newTheme;
		boolean exists = false;

		if(readFile(nameThemes))
		{
			newTheme = theme.getId() + ";" + theme.getName() + ";" + theme.getDesc() + ";" + theme.getValue() + "\n";
			exists = true;
		}
		else
		{
			newTheme = "Id;Nome;Descricao;Valor\n";
			newTheme += theme.getId() + ";" + theme.getName() + ";" + theme.getDesc() + ";" + theme.getValue() + "\n";
		}

		FileWriter fileWriter = new FileWriter(file, exists);

		PrintWriter print = new PrintWriter(fileWriter);
		print.write(newTheme);
		print.flush();
		print.close();
		fileWriter.close();			
	}

	public ThemesDao readThemes(ThemesDao tDao) throws IOException
	{
		Theme theme;
		File file = new File(path + nameThemes);
		readDir();
		if (readFile(nameThemes))
		{
			FileInputStream stream = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);

			String line = buffer.readLine();
			line = buffer.readLine();

			while (line != null)
			{
				String lineTheme[] = line.split(";");
				theme = new Theme(Integer.parseInt(lineTheme[0]), lineTheme[1], lineTheme[2], Double.parseDouble(lineTheme[3]));
				tDao.addLast(theme, 0);
				line = buffer.readLine();
			}
			buffer.close();
			reader.close();
			stream.close();
		}
		else
		{
			throw new IOException ("Empty themes database.");
		}
		return tDao;
	}

	public void updateTheme()
	{
		//logica do update
	}

	public void deleteTheme(ThemesDao tDao, int id) throws IOException
	{
		int idTheme = tDao.getId(id);
		if (idTheme == 0)
		{
			//tema não encontrado
		}
		else
		{
			File file = new File(path + nameThemes);
			tDao.removeById(id);
			if (tDao.getTheme(0) == null)
			{
				file.delete();
			}
			else
			{
				StringBuffer buffer = new StringBuffer();

				int i = 0;
				Theme theme = tDao.getTheme(i);

				while (theme != null)
				{
					buffer.append(theme.getId() + ";" + theme.getName() + ";" + theme.getDesc() + ";" + theme.getValue());
					buffer.append("\n");
					i++;
					theme = tDao.getTheme(i);
				}
				String data = "Id;Nome;Descrição;Valor\n";
				data += buffer.toString();

				FileWriter fileWriter = new FileWriter(file);

				PrintWriter print = new PrintWriter(fileWriter);
				print.write(data);
				print.flush();
				print.close();
				fileWriter.close();			
			}
		}
	}

	//-----------------------CRUD - Clients-----------------------

	public void createClient(Client client) throws IOException
	{
		readDir();
		File file = new File(path + nameClients);
		String newClient;
		boolean exists = false;

		Address address = new Address(client.getAddress().getStreet(), client.getAddress().getStreetNum(),
				client.getAddress().getDistrict(),client.getAddress().getCity(),client.getAddress().getState(),
				client.getAddress().getAddrCompl(), client.getAddress().getPostalCode());
		
		if(readFile(nameClients))
		{
			
			newClient = client.getId() + ";" + client.getName()+ ";" + client.getCpf() + ";"
					+ client.getRg() + ";" + client.getEmail()+ ";" + client.getPhone() + ";"
					+ client.getObs() + ";" + address.formatToFile() + "\n";
			exists = true;
		}
		else
		{
			newClient = "ID;Nome;CPF;RG;E-Mail;Telefone;Observação;Endereço;Número;Bairro;Cidade;UF;Complemento;CEP\n";
			newClient += client.getId() + ";" + client.getName()+ ";" + client.getCpf() + ";"
					+ client.getRg() + ";" + client.getEmail()+ ";" + client.getPhone() + ";"
					+ client.getObs() + ";" + address.formatToFile() + "\n";
		}
		FileWriter fileWriter = new FileWriter(file, exists);

		PrintWriter print = new PrintWriter(fileWriter);
		print.write(newClient);
		print.flush();
		print.close();
		fileWriter.close();
	}

	public ClientsDao readClients(ClientsDao cDao) throws IOException
	{
		Client client;
		File file = new File(path + nameClients);
		readDir();
		if (readFile(nameClients))
		{
			FileInputStream stream = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);

			String line = buffer.readLine();
			line = buffer.readLine();

			while (line != null)
			{
				String lineClient[] = line.split(";");
				Address address = new Address(lineClient[7], lineClient[8], lineClient[9],
						lineClient[10], lineClient[11], lineClient[12], lineClient[13]);
				
				client = new Client(Integer.parseInt(lineClient[0]), lineClient[1], lineClient[2],
						lineClient[3], lineClient[4], lineClient[5], lineClient[6], address);
				
				cDao.addLast(client, 0);
				line = buffer.readLine();
			}
			buffer.close();
			reader.close();
			stream.close();
		}
		else
		{
			throw new IOException ("Empty clients database.");
		}
		return cDao;
	}

	public void updateClient()
	{

	}

	public void deleteClient(ClientsDao cDao, int id) throws IOException
	{
		int idClient = cDao.getId(id);
		if(idClient == 0)
		{
			//cliente não encontrado
		}
		else
		{
			File file = new File(path + nameClients);
			cDao.removeById(id);
			if(cDao.getClient(0) == null)
			{
				file.delete();
			}
			else
			{
				StringBuffer buffer = new StringBuffer();
				int i = 0;
				Client client = cDao.getClient(i);

				while (client != null)
				{
					buffer.append(client.getId() + ";" + client.getName()+ ";" + client.getCpf() + ";"
							+ client.getRg() + ";" + client.getEmail()+ ";" + client.getPhone() + ";"
							+ client.getObs() + client.getAddress().formatToFile() + "\n");
					i++;
					client = cDao.getClient(i);
				}
				String data = "ID;Nome;CPF;RG;E-Mail;Telefone;Observação;Endereço;Número;Bairro;Cidade;UF;Complemento;CEP\n";
				data += buffer.toString();

				FileWriter fileWriter = new FileWriter(file);

				PrintWriter print = new PrintWriter(fileWriter);
				print.write(data);
				print.flush();
				print.close();
				fileWriter.close();
			}
		}
	}

	//-----------------------CRUD - Rental-----------------------

	public void createRental()
	{

	}

	public void readRentals()
	{

	}

	public void updateRental()
	{

	}

	public void deleteRental()
	{

	}
}