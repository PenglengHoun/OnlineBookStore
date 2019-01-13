package ckcc.OnlineBookStore.Back.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ckcc.OnlineBookStore.Back.Stock.BookInStock;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "edition")
	private int edition;
	
	@Column(name = "volume")
	private int volume;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "year_published")
	private String yearPublished;
	
	@Column(name = "isbn")
	private String ISBN;
	
	@Column(name = "price")
	private double price;
	
	@OneToOne(mappedBy = "book")
	private BookInStock bis;
	
	public Book() {
		
	}
	
	public Book(String title, String publisher, String yearPublished, String ISBN, double price,
			    String author, int edition, int volume) {
	
		this.author = author;
		this.edition = edition;
		this.volume = volume;
		this.title = title;
		this.publisher = publisher;
		this.yearPublished = yearPublished;
		this.ISBN = ISBN;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public int getEdition() {
		return edition;
	}

	public int getVolume() {
		return volume;
	}
	
	public String getTitle() {
		return title;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getYearPublished() {
		return yearPublished;
	}

	public String getISBN() {
		return ISBN;
	}

	public double getPrice() {
		return price;
	}
	
	public BookInStock getBookInStock() {
		return bis;
	}
	
	public Object[] getInfo() {
		return new Object[] {
			id, title, publisher, yearPublished, ISBN, price, author, edition, volume, bis.getQty()	
		};
	}

}
