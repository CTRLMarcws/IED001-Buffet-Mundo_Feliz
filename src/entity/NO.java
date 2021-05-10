package entity;


public class NO
{
	public Tema tema;
	public NO prox;
	
	public NO(Tema tema)
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
	
	public NO getProx()
	{
		return prox;
	}
	
	public void setProx(NO prox)
	{
		this.prox = prox;
	}
}