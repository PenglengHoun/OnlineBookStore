package ckcc.OnlineBookStore.Back.OrderTest;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ckcc.OnlineBookStore.Back.Order.OrderDetail;

public class OrderDetailTest {

	static OrderDetail orderDetail;
	static double varyLevel;
	
	@BeforeClass
	public static void initObject() {
		varyLevel = 0.01;
		// there will be a problem if the 
		//calculated money and the prediction money differ more than 1 cent
		
		orderDetail = new OrderDetail(1, 100, 99.99, 10);
	}
	
	@Test
	public void getTotalTest() {
		assertEquals(9999 ,orderDetail.getTotal(), varyLevel);
	}
	
	@Test
	public void getDiscountMoneyTest() {
		assertEquals(999.9 ,orderDetail.getDiscountMoney(), varyLevel);
	}
	
	@Test
	public void getSubTotalTest() {
		assertEquals(8999.1 ,orderDetail.getSubTotal(), varyLevel);
	}
	
	@AfterClass
	public static void destroyObject() {
		orderDetail = null;
		System.gc();
	}

}
