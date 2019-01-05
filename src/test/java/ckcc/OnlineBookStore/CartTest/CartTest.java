package ckcc.OnlineBookStore.CartTest;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ckcc.OnlineBookStore.Back.Cart.Cart;
import ckcc.OnlineBookStore.Back.Cart.Order;
import ckcc.OnlineBookStore.Back.Item.Book;

public class CartTest {

	static Cart cart;
	
	@BeforeClass
	public static void initObj() {
		cart = new Cart(10);
		cart.addItem(new Order(new Book("Re:Zero","Toe","2007","1234-1234",199.99,"Sajaki",1,1),10));
		cart.addItem(new Order(new Book("Re:Zero 2","Toe","2007","1234-1234",99.99,"Sajaki",1,1),20));
		cart.addItem(new Order(new Book("Re:Zero 3","Toe","2007","1234-1234",399.99,"Sajaki",1,1),30));
	}
	
	@Test
	public void testGetDiscount() {
		assertEquals(0.1,cart.getDiscount(),0.0);
	}
	
	@Test
	public void testCalculateSubTotal() {
		assertEquals(15999.4,Math.round(cart.calculateSubTotal() * 100) / 100.0,0.0);
	}
	
	@Test
	public void testCalcuateDiscountMoney() {
		assertEquals(1599.94,Math.round(cart.calculateDiscountMoney() * 100) / 100.0,0.0);
	}
	
	@Test
	public void testCalculateTotal() {
		assertEquals(14399.46,Math.round(cart.calculateTotal() * 100) / 100.0,0.0);
	}
	
	@AfterClass
	public static void distroyObj() {
		cart = null;
		System.gc();
	}
	
}
