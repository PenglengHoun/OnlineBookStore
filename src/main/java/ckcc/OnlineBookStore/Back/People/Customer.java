package ckcc.OnlineBookStore.Back.People;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ckcc.OnlineBookStore.Back.Order.Cart;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<Address> address;
	
	@OneToOne(mappedBy = "customer")
	private Cart cart;
	
	public Customer() {
		
	}
	
	public Customer(String name, String email, String phone, Address billingAddress) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		address = new ArrayList<Address>();
		address.add(billingAddress);
	}
	
	public Customer(String name, String email, String phone, Address billingAddress, Address shippingAddress) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		address = new ArrayList<Address>();
		address.add(billingAddress);
		address.add(shippingAddress);
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public List<Address> getAddress() {
		return address;
	}

	public Cart getCart() {
		return cart;
	}

}
