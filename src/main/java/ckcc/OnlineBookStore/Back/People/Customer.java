package ckcc.OnlineBookStore.Back.People;

public class Customer {

	private int id;
	private String name;
	private String email;
	private String phone;
	private Address shippingAddress;
	private Address billingAddress;
	
	public Customer(String name, Address shippingAddress, Address billingAddress) {
		this.name = name;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
	}
	
	public void checkOut() {
		
	}
	
//	public void placeOrder(Cart shoppingCart) {
//		this.shoppingCart = shoppingCart;
//	}
//	
//	public Cart cancelOrder() {
//		Cart temp = new Cart(shoppingCart);
//		shippingAddress = null;
//		billingAddress = null;
//		shoppingCart = null;
//		return temp;
//	}

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
	public Address getShippingAddress() {
		return shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}
	
}
