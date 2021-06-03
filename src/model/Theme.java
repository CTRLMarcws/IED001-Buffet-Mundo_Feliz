package model;


public class Theme
{
	private String name, desc;
	private double value;
	private int id;

	public Theme(int id, String name, String desc, double value)
	{
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.value = value;
	}


	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
		return name;
	}

}