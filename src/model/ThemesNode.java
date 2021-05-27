package model;

public class ThemesNode
{
	public Theme theme;
	public ThemesNode next;

	public ThemesNode(Theme theme)
	{
		this.theme = theme;
		next = null;
	}

	public Theme getTheme()
	{
		return theme;
	}

	public void setTheme(Theme theme)
	{
		this.theme = theme;
	}

	public ThemesNode getNext()
	{
		return next;
	}

	public void setNext(ThemesNode next)
	{
		this.next = next;
	}
}