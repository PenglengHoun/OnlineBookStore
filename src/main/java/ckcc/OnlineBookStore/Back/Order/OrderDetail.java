package ckcc.OnlineBookStore.Back.Order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ckcc.OnlineBookStore.Back.Extra.Data;
import ckcc.OnlineBookStore.Back.Extra.TempOrderDetail;
import ckcc.OnlineBookStore.Back.Item.Book;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	public OrderDetail() {
		
	}
	
	public OrderDetail(int bookId, int qty, double price, double discount) {
		this.bookId = bookId;
		this.qty = qty;
		this.price = price;
		this.discount = discount;
		subTotal = getTotal() - getDiscountMoney();
		
	}
	
	public void addOrderDetail(TempOrderDetail t) {
		bookId = t.getBookId();
		qty = t.getQty();
		discount = t.getDiscountP();
		subTotal = t.getSubTotal();
		price = t.getPrice();
	}
	
	
	
	public double getDiscountMoney() {
		return (qty * price) * getDiscount();
	}
	
	public double getTotal() {
		return qty * price;
	}
	
	public Object[] getInfo() {	
		Book book = Data.getOneBook(bookId);	
		return new Object[] {
			id, bookId, book.getTitle() ,price, qty, discount, subTotal
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
