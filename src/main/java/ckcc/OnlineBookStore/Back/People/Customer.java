package ckcc.OnlineBookStore.Back.People;

import ckcc.OnlineBookStore.Back.Cart.Cart;

public class Customer {

	private String id;
	private String name;
	private Address shippingAddress;
	private Address billingAddress;
	private Cart shoppingCart;
	
	public Customer(String id, String name, Address shippingAddress, Address billingAddress) {
		this.id = id;
		this.name = name;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
	}
	
	public void checkOut() {
		
	}
	
	public void placeOrder(Cart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	public Cart cancelOrder() {
		Cart temp = new Cart(shoppingCart);
		shippingAddress = null;
		billingAddress = null;
		shoppingCart = null;
		return temp;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public Cart getShoppingCart() {
		return shoppingCart;
	}
	
}
