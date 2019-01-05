package ckcc.OnlineBookStore.Back.Cart;

import java.util.ArrayList;

public class Cart {

	private ArrayList<Order> purchasedItem;
	private double discount;
	
	public Cart(Cart cart) {
		purchasedItem = cart.purchasedItem;
	}
	
	public Cart(double discount) {
		purchasedItem = new ArrayList<Order>();
		this.discount = discount;
	}
	
	public void addItem(Order itemOrder) {
		purchasedItem.add(itemOrder);
	}
	
	public void removeItem(Order itemOrder) {
		purchasedItem.remove(itemOrder);
	}
	
	public double getDiscount() {
		return discount / 100;
	}
	
	public double calculateSubTotal() {
		double subTotal = 0;
		for(Order temp : purchasedItem)
			subTotal += temp.getAmount();
		return subTotal;
	}
	
	public double calculateDiscountMoney() {
		return calculateSubTotal() * getDiscount();
	}
	
	public double calculateTotal() {
		double total = calculateSubTotal();
		return total - total * getDiscount();
	}
	
}
