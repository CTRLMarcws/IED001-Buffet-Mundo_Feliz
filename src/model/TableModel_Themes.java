package model;

import javax.swing.table.AbstractTableModel;

import persistence.ThemeDao;

public class TableModel_Themes extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private String[] columns = {"Nome", "Descrição", "Valor"};
	private ThemeDao tDao;


	public TableModel_Themes(ThemeDao tDao)
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
		case 0: return tDao.getTheme(rowIndex).getName();

		case 1: return tDao.getTheme(rowIndex).getDesc();

		case 2: return tDao.getTheme(rowIndex).getValue();
		}
		return null;
	}
	
	public void refreshTable()
	{
		this.fireTableDataChanged();
	}

}
