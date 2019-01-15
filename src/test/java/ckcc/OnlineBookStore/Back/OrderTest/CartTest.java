package ckcc.OnlineBookStore.Back.OrderTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ckcc.OnlineBookStore.Back.Order.Cart;
import ckcc.OnlineBookStore.Back.Order.OrderDetail;
import ckcc.OnlineBookStore.Back.People.Address;
import ckcc.OnlineBookStore.Back.People.Customer;

public class CartTest {

	static Cart cart;
	static Customer customer;
	static ArrayList<OrderDetail> orderDetails;
	static Date date;
	static double varyLevel;
	
	@BeforeClass
	public static void initObject() {
		varyLevel = 0.01;
		// there will be a problem if the 
		//calculated money and the prediction money differ more than 1 cent
		
		date = new Date();
		
		orderDetails = new ArrayList<OrderDetail>();
		orderDetails.add(new OrderDetail(1, 10, 99.99, 25));
		orderDetails.add(new OrderDetail(2, 20, 199.99, 50));
		orderDetails.add(new OrderDetail(3, 30, 299.99, 75));
		
		customer = new Customer("Aba Bab", "ababab@gmail.com", "0123456", new Address("123", "Tokyo", "Tokyo", "Japan", "+999"));
		cart = new Cart(customer, orderDetails, date, 50, "Good");
	}
	
	@Test
	public void getTotalTest() {
		assertEquals(4999.75, Math.round(cart.getTotal() * 100.0) / 100.0, varyLevel);
	}
	
	@Test
	public void getDiscountMoneyTest() {
		assertEquals(2499.875, Math.round(cart.getDiscountMoney() * 100.0) / 100.0, varyLevel);
	}
	
	@Test
	public void getSubTotalTest() {
		assertEquals(2499.875, Math.round(cart.getSubTotal() * 100.0) / 100.0, varyLevel);
	}
	
	@AfterClass
	public static void destroyObject() {
		orderDetails = null;
		customer = null;
		cart = null;
		System.gc();
	}

}
