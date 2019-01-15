package ckcc.OnlineBookStore.Back.Stock;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ckcc.OnlineBookStore.Back.Item.Book;

@Entity
@Table(name = "stock")
public class BookInStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private Book book;
	
	@Column(name = "qty")
	private int qty;
	
	@Column(name = "discount")
	private double discount;
	
	public BookInStock() {
		
	}
	
	public BookInStock(Book book, int qty) {
		this.book = book;
		this.qty = qty;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public int getId() {
		return id;
	}
	
	public Book getBook() {
		return book;
	}
	
	public int getQty() {
		return qty;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public Object[] getInfo() {
		return new Object[] {
			book.getId(), book.getTitle(), book.getPrice(), book.getYearPublished(), book.getISBN(),
			book.getPrice(), book.getAuthor(), book.getEdition(), book.getVolume(), qty, discount
		};
	}
}
