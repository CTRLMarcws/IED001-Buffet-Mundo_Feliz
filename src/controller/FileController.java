package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import model.Theme;
import persistence.ThemeDao;

@SuppressWarnings("unused")
public class FileController
{
	private final String path = "C:\\TEMP\\ED\\";
	private final String nameThemes = "themes.csv";

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

	//-----------------------CRUD - Themes-----------------------
	private void createTheme(Theme theme) throws IOException
	{
		readDir();
		File file = new File(path + nameThemes);


		String newTheme = theme.getId() + ";" + theme.getName() + ";" + theme.getDesc() + ";" + theme.getValue();

		boolean exists = false;
		if (file.exists()) exists = true;

		FileWriter fileWriter = new FileWriter(file, exists);

		PrintWriter print = new PrintWriter(fileWriter);
		print.write(newTheme);
		print.flush();
		print.close();
		fileWriter.close();			
	}

	private ThemeDao readThemes(ThemeDao tDao) throws IOException
	{
		Theme theme;

		File file = new File(path + nameThemes);

		readDir();
		if (file.exists() && file.isFile())
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
				tDao.addLast(theme);
				line = buffer.readLine();
			}

			buffer.close();
			reader.close();
			stream.close();
		}
		else
		{
			throw new IOException ("Empty database.");
		}
		return tDao;
	}

	private void updateTheme()
	{
		//logica do update
	}

	private void deleteTheme(ThemeDao tDao, int id) throws IOException
	{
		int idTheme = tDao.getId(id);
		if (idTheme == 0)
		{
			//tema não encontrado
		}
		else
		{
			File file = new File(path + nameThemes);
			tDao.removeTheme(id);
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

	private void createClient()
	{

	}

	private void readClients()
	{

	}

	private void updateClient()
	{

	}

	private void deleteClient()
	{

	}


	//-----------------------CRUD - Rental-----------------------

	private void createRental()
	{

	}

	private void readRentals()
	{

	}

	private void updateRental()
	{

	}

	private void deleteRental()
	{

	}
}