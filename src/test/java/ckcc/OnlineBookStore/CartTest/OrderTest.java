package ckcc.OnlineBookStore.CartTest;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ckcc.OnlineBookStore.Back.Cart.Order;
import ckcc.OnlineBookStore.Back.Item.Book;

public class OrderTest {

	static Order itemOrder;
	
	@BeforeClass
	public static void initObj() {
		itemOrder = new Order(new Book("Re:Zero","Toe","2007","1234-1234",199.99,"Sajaki",1,1),30);
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(5999.7,Math.round(itemOrder.getAmount() * 100) / 100.0,0.0);
	}
	
	@AfterClass
	public static void distroyObj() {
		itemOrder = null;
		System.gc();
	}

}
