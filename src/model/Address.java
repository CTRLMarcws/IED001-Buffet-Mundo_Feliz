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
//		String[][] estados = {{"Acre","AC"},{"Alagoas","AL"},{"Amap�","AP"},{"Amazonas","AM"},
//				{"Bahia","BA"},{"Cear�","CE"},{"Distrito Federal","DF"},{"Esp�rito Santo","ES"},
//				{"Goi�s","GO"},{"Maranh�o","MA"},{"Mato Grosso","MT"},{"Mato Grosso do Sul","MS"},
//				{"Minas Gerais","MG"},{"Par�","PA"},{"Para�ba","PB"},{"Paran�","PR"},
//				{"Pernambuco","PE"},{"Piau�","PI"},{"Rio de Janeiro","RJ"},{"Rio Grande do Norte","RN"},
//				{"Rio Grande do Sul","RS"},{"Rond�nia","RO"},{"Roraima","RR"},{"Santa Catarina","SC"},
//				{"S�o Paulo","SP"},{"Sergipe","SE"},{"Tocantins","TO"}};
//
//		String [] vet = {estados[pos][0], estados[pos][1]};
//		return vet;
//	}
}
