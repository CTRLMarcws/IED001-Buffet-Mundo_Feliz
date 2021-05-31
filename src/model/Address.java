package model;

public class Address
{
	private String street, district, city, addrCompl, state, streetNum, postalCode;

	public Address(String street, String streetNum, String district, String city, String state, String addrCompl,
			String postalCode)
	{
		this.street = street;
		this.streetNum = streetNum;
		this.district = district;
		this.city = city;
		this.state = state;
		this.addrCompl = addrCompl;
		this.postalCode = postalCode;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getDistrict()
	{
		return district;
	}

	public void setDistrict(String district)
	{
		this.district = district;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getAddrCompl()
	{
		return addrCompl;
	}

	public void setAddrCompl(String addrCompl)
	{
		this.addrCompl = addrCompl;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getStreetNum()
	{
		return streetNum;
	}

	public void setStreetNum(String streetNum)
	{
		this.streetNum = streetNum;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	//	public String[] ufList(int pos)
	//	{
	//		String[][] estados = {{"Acre","AC"},{"Alagoas","AL"},{"Amapá","AP"},{"Amazonas","AM"},
	//				{"Bahia","BA"},{"Ceará","CE"},{"Distrito Federal","DF"},{"Espírito Santo","ES"},
	//				{"Goiás","GO"},{"Maranhão","MA"},{"Mato Grosso","MT"},{"Mato Grosso do Sul","MS"},
	//				{"Minas Gerais","MG"},{"Pará","PA"},{"Paraíba","PB"},{"Paraná","PR"},
	//				{"Pernambuco","PE"},{"Piauí","PI"},{"Rio de Janeiro","RJ"},{"Rio Grande do Norte","RN"},
	//				{"Rio Grande do Sul","RS"},{"Rondônia","RO"},{"Roraima","RR"},{"Santa Catarina","SC"},
	//				{"São Paulo","SP"},{"Sergipe","SE"},{"Tocantins","TO"}};
	//
	//		String [] vet = {estados[pos][0], estados[pos][1]};
	//		return vet;
	//	}

	public String formatToFile()
	{
		return getStreet() + ";" + getStreetNum() + ";" + getDistrict() + ";"
				+ getCity() + ";" + getState() + ";" + getAddrCompl() + ";" + getPostalCode();
	}

	public String formatToTableModel()
	{
		return getStreet() + ", " + getStreetNum() + " - " + getDistrict() + ", "
				+ getCity() + "/" + getState() + " - " + getAddrCompl() + " - " + getPostalCode();
	}
}
