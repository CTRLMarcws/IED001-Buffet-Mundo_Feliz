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

public class FileController
{

	public FileController()
	{
	}

	//Validação:
	//		Diretório
	//		Arquivo
	//Leitura
	//Escrita

	public boolean readDir(File dir) throws IOException
	{
		if (!dir.exists() || !dir.isDirectory())
		{
			throw new IOException ("Invalid Directory.");
		}
		else
		{
			return true;			
		}
	}

	public void readFile(String path, String name) throws IOException
	{
		File file = new File(path, name);

		if (file.exists() && file.isFile())
		{
			//logica de leitura
		}
	}

	public void writeFile(String path, String name) throws IOException
	{
		File file = new File(path, name);

		if (file.exists() && file.isFile())
		{
			//Logica de escrita
		}
	}

	//CRUD - Theme

	private void createTheme(Theme theme) throws IOException
	{
		String path = "C:\\";
		String name = "excel.csv";

		File dir = new File(path);
		File file = new File(path + name);

		if (readDir(dir))
		{
			String newTheme = theme.getId() + ";" + theme.getNome() + ";" + theme.getDesc() + ";" + theme.getValor();

			boolean exists = false;
			if (file.exists()) exists = true;

			FileWriter fileWriter = new FileWriter(file, exists);

			PrintWriter print = new PrintWriter(fileWriter);
			print.write(newTheme);
			print.flush();
			print.close();
			fileWriter.close();			
		}

	}
	private ThemeDao readThemes(ThemeDao tDao) throws IOException
	{
		String path = "C:\\";
		String name = "excel.csv";

		Theme theme;

		File dir = new File(path);
		File file = new File(path + name);

		if (readDir(dir))
		{
			if (file.exists() && file.isFile()) //alterar logica
			{
				FileInputStream stream = new FileInputStream(file);
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);

				String line = buffer.readLine();
				line = buffer.readLine();

				while (line != null)
				{
					String newTheme[] = line.split(";");// alterar nome
					theme = new Theme(Integer.parseInt(newTheme[0]), newTheme[1], newTheme[2], Double.parseDouble(newTheme[3]));
					tDao.AdicionarFinal(theme);
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
		String path = "C:\\";
		if (idTheme == 0)
		{
			//tema não encontrado
		}
		else
		{
			File file = new File(path);
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
					buffer.append(theme.getId() + ";" + theme.getNome() + ";" + theme.getDesc() + ";" + theme.getValor());
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

}