package ckcc.OnlineBookStore.Back.People;

public class Address {

	private int id;
	private String street;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	
	public Address(String street, String city, String state, String country, String postalCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}
	
	public int getId() {
		return id;
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
	
}
