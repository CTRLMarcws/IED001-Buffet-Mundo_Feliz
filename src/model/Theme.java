package model;


public class Theme
{

	private String nome, desc;
	private double valor;
	private int id;

	public Theme(int id, String nome, String desc, double valor)
	{
		this.id = id;
		this.nome = nome;
		this.desc = desc;
		this.valor = valor;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public double getValor()
	{
		return valor;
	}

	public void setValor(double valor)
	{
		this.valor = valor;
	}


}