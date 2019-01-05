package ckcc.OnlineBookStore.Back.Cart;

import ckcc.OnlineBookStore.Back.Item.Book;

public class Order {
	
	private Book book;
	private int qty;
	
	public Order(Book book, int qty) {
		this.book = book;
		this.qty = qty;
	}
	
	public Book getBook() {
		return book;
	}
	
	public int getQty() {
		return qty;
	}
	
	public double getAmount() {
		return qty * book.getPrice();
	}
	
}
