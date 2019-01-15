package ckcc.OnlineBookStore.Back.Extra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import ckcc.OnlineBookStore.Back.Item.Book;

@Entity
@Table(name = "temp")
public class TempOrderDetail {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "book_id")
	private int bookId;
	
	@Column(name = "qty")
	private int qty;
	
	@Column(name = "discount")
	private double discount;
	
	@Column(name = "sub_total")
	private double subTotal;
	
	@Column(name = "price")
	private double price;
	
	public TempOrderDetail() {
		
	}
	
	private static int count;
	
	public TempOrderDetail(int bookId, int qty, double price ,double discount) {
		id = ++count;
		this.bookId = bookId;
		this.qty = qty;
		this.discount = discount;
		this.price = price;	
		this.subTotal = getTotal() - getDiscountMoney();			
	}
	
	public static void reset() {
		count = 0;
	}
	
	public double getDiscountMoney() {
		return (qty * price) * getDiscount();
	}
	
	public double getTotal() {
		return qty * price;
	}
	
	public Object[] getInfo() {		
		return new Object[] {
			id, bookId, getBookTitle() ,price, qty, discount, subTotal
		};
	}
	
	public String getBookTitle() {
		Book book = Data.getOneBook(bookId);
		return book.getTitle();
	}
	
	public double getDiscountP() {
		return discount;
	}
	
	public double getDiscount() {
		return discount / 100;
	}
	
	public int getBookId() {
		return bookId;
	}

	public int getId() {
		return id;
	}

	public int getQty() {
		return qty;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public double getPrice() {
		return price;
	}
	
}
