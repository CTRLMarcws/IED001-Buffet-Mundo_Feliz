package model;


public class No_Temas
{
	public Tema tema;
	public No_Temas prox;
	
	public No_Temas(Tema tema)
	{
		this.tema = tema;
		prox = null;
	}

	public Tema getTemaDao()
	{
		return tema;
	}
	
	public void setTema(Tema tema)
	{
		this.tema = tema;
	}
	
	public No_Temas getProx()
	{
		return prox;
	}
	
	public void setProx(No_Temas prox)
	{
		this.prox = prox;
	}
}