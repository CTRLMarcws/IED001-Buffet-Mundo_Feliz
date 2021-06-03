package model;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import persistence.ThemesDao;

public class ThemesComboBoxModel extends AbstractListModel<Object> implements ComboBoxModel<Object>
{
	private static final long serialVersionUID = 1L;
	private ThemesDao tDao;
	private Theme theme;

	public ThemesComboBoxModel(ThemesDao tDao)
	{
		this.tDao = tDao;
	}

	@Override
	public int getSize()
	{
		return tDao.getLenght() + 1;
	}


	@Override
	public Object getElementAt(int index)
	{
		return this.tDao.getTheme(index);
	}

	@Override
	public void setSelectedItem(Object anItem)
	{  
		if (anItem instanceof Theme)
		{
			this.theme = (Theme) anItem;
			fireContentsChanged(this.tDao, 0, this.tDao.getLenght() + 1);
		}
	}

	@Override
	public Object getSelectedItem()
	{
		return this.theme;
	}
}
