package model;


public class Node_Themes
{
	public Theme theme;
	public Node_Themes next;
	
	public Node_Themes(Theme theme)
	{
		this.theme = theme;
		next = null;
	}

	public Theme getThemeDao()
	{
		return theme;
	}
	
	public void setTheme(Theme theme)
	{
		this.theme = theme;
	}
	
	public Node_Themes getNext()
	{
		return next;
	}
	
	public void setNext(Node_Themes next)
	{
		this.next = next;
	}
}