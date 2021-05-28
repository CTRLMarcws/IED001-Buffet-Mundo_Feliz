package model;

import javax.swing.table.AbstractTableModel;

import persistence.ThemesDao;

public class ThemesTableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private String[] columns = {"ID", "Nome", "Descrição", "Valor"};
	private ThemesDao tDao;


	public ThemesTableModel(ThemesDao tDao)
	{
		this.tDao = tDao;
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
		if (tDao != null)
		{
			return tDao.getLenght() + 1;
		}
		return 0;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		switch(columnIndex)
		{
		case 0: return tDao.getTheme(rowIndex).getId();
		
		case 1: return tDao.getTheme(rowIndex).getName();

		case 2: return tDao.getTheme(rowIndex).getDesc();

		case 3: return tDao.getTheme(rowIndex).getValue();
		}
		return null;
	}
	
	public void refreshTable()
	{
		this.fireTableDataChanged();
	}

}
