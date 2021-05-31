package model;

import javax.swing.table.AbstractTableModel;

import persistence.RentsDao;

public class MainMenuTableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private String[] columns = {"Cliente", "Tema", "Data", "Horario"};
	private RentsDao rDao;

	public MainMenuTableModel(RentsDao rDao)
	{
		this.rDao = rDao; 
	}

	@Override
	public String getColumnName(int column)
	{
		return columns[column];
	}

	@Override
	public int getColumnCount()
	{
		return this.columns.length;
	}

	@Override
	public int getRowCount()
	{
		if (rDao != null)
		{
			return rDao.getLenght() + 1;
		}
		return 0;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		switch(columnIndex)
		{
		//"Cliente", "Tema", "Data", "Hora-Inicio", "Hora-Fim"
		case 0: return rDao.getRent(rowIndex).getClient();

		case 1: return rDao.getRent(rowIndex).getTheme();

		case 2: return rDao.getRent(rowIndex).getDate();

		case 3: return rDao.getRent(rowIndex).getStartTime() + " - " + rDao.getRent(rowIndex).getEndTime();
		}
		return null;
	}

	public void refreshTable()
	{
		this.fireTableDataChanged();
	}

}
