package model;

public class Client
{
	private int id;
	private String name, cpf, rg, email, phone, obs;

	public Client(int id, String name, String cpf, String rg, String email, String phone, String obs)
	{
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.phone = phone;
		this.obs = obs;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getRg()
	{
		return rg;
	}

	public void setRg(String rg)
	{
		this.rg = rg;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getObs()
	{
		return obs;
	}

	public void setObs(String obs)
	{
		this.obs = obs;
	}
}