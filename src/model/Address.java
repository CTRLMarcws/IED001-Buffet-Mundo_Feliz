package model;

public class Address
{
	private String street, district, city, addrCompl, state, streetNum, postalCode;

	public Address(String street, String district, String city, String addrCompl, String state, String streetNum,
			String postalCode)
	{
		this.street = street;
		this.district = district;
		this.city = city;
		this.addrCompl = addrCompl;
		this.state = state;
		this.streetNum = streetNum;
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddrCompl() {
		return addrCompl;
	}

	public void setAddrCompl(String addrCompl) {
		this.addrCompl = addrCompl;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(String streetNum) {
		this.streetNum = streetNum;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
