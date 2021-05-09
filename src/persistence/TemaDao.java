package persistence;

import java.util.Scanner;

import entity.Tema;

public class TemaDao
{
	private String msg;
	private Tema inicio;
	
	public TemaDao()
	{
		inicio = null;
	}

	public String adicionarInicio(String nome, String desc, double valor)
	{
		msg = "";
		
		Tema novo = new Tema(nome, desc, valor);
		
		if (listaVazia())
		{
			inicio = novo;
			
			msg = exibirMsg(novo);
		}
		else
		{
			novo.setProximo(inicio);
			
			msg = exibirMsg(novo);
			
			inicio.setAnterior(novo);
		}
		
		return msg;
	}
	
	public String adicionarFinal(String nome, String desc, double valor)
	{
		msg = "";
		
		Tema novo = new Tema(nome, desc, valor);
		
		if(inicio == null)
		{
			adicionarInicio(nome, desc, valor);
		}
		else
		{
			Tema auxiliar = buscarParaAdicionar(inicio);
			
			auxiliar.setProximo(novo);
			novo.setAnterior(auxiliar);
			novo.setProximo(null);
			
			msg = exibirMsg(novo);
		}
		
		return msg;
	}

	private Tema buscarParaAdicionar(Tema aux)
	{
		if(aux.getProximo() != null)
		{
			return buscarParaAdicionar(aux.getProximo());
		}
		return aux;
		
	}
	
	private boolean listaVazia()
	{
		return this.inicio == null;
	}
	
	private String exibirMsg(Tema novo)
	{
		return "Nome: " + novo.getNome()
			 + "Descrição: " + novo.getDesc()
			 + ""
			 + "Valor: " + novo.getValor();
	}
	
	public static void main(String[] args)
	{
		System.out.println("1, 2, 3, testando");
		Scanner sc1 = new Scanner(System.in);
		
		String aaaaa = sc1.nextLine();
		
		System.out.println(aaaaa);
	}
	
}
