package model;

import java.time.LocalDate;

public class Rent
{
	private int id;
	private String date, startTime, endTime, client, theme, address;
	private double discount, value;

	public Rent(int id, String client, String theme, String date, String startTime, String endTime, String address, double value)
	{
		this.id = id;
		this.client = client;
		this.theme = theme;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.address = address;
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

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getStartTime()
	{
		return startTime;
	}

	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}

	public String getClient()
	{
		return client;
	}

	public void setClient(String client)
	{
		this.client = client;
	}

	public String getTheme()
	{
		return theme;
	}

	public void setTheme(String theme)
	{
		this.theme = theme;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}

	public double getDiscount()
	{
		return discount;
	}

	public void setDiscount(double discount)
	{
		this.discount = discount;
	}

	public LocalDate formatDate(String date)
	{
		String line[] = date.split("/");
		return LocalDate.of(Integer.parseInt(line[2]), Integer.parseInt(line[1]), Integer.parseInt(line[0]));
	}
	
	public Address getSplitAddress(String addressLine)
	{
		String line[] = addressLine.split(",");
		String lineAux[] = line[1].split("-");
		String lineAux2[] = line[2].split("-");
		String lineAux3[] = lineAux2[0].split("/");

		Address address = new Address(line[0], lineAux[0], lineAux[1], lineAux3[0], lineAux2[3], lineAux2[2], lineAux3[1] + "-" + lineAux2[1]);
		return address;
		
	}
}
