package model;

import javax.swing.JTextArea;

public class Tema
{

	private String nome, desc;
  	private String valor;
	private int sts;
	private Tema proximo, anterior;

	public Tema(String nome, String desc, String valor)
	{
		this.nome = nome;
		this.desc = desc;
		this.valor = valor;
		sts = 0;
		proximo = null;
		anterior = null;
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
	
	public String getValor()
	{
		return valor;
	}
	
	public void setValor(String valor)
	{
		this.valor = valor;
	}
	
	public int getSts()
	{
		return sts;
	}
	
	public void setSts(int sts)
	{
		this.sts = sts;
	}
	
}