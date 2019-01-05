package ckcc.OnlineBookStore.Back.People;

public class Address {

	private String street;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private double shippingFree;
	
	public Address(String street, String city, String state, String country, String postalCode, double shippingFree) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.shippingFree = shippingFree;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public double getShippingFree() {
		return shippingFree;
	}
	
}
