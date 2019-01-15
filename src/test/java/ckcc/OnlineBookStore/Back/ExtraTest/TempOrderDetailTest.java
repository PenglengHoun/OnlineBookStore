package ckcc.OnlineBookStore.Back.ExtraTest;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ckcc.OnlineBookStore.Back.Extra.TempOrderDetail;

public class TempOrderDetailTest {

	static TempOrderDetail tempOrderDetail;
	static double varyLevel;
	
	@BeforeClass
	public static void initObject() {
		varyLevel = 0.01;	
		// there will be a problem if the 
		//calculated money and the prediction money differ more than 1 cent
		
		tempOrderDetail = new TempOrderDetail(1, 100, 199.99, 25);
	}
	
	@Test
	public void getDiscountMoneyTest() {
		assertEquals(4999.75, Math.round(tempOrderDetail.getDiscountMoney() * 100.0) / 100.0, varyLevel);
	}
	
	@Test
	public void getTotalTest() {
		assertEquals(19999, Math.round(tempOrderDetail.getTotal() * 100.0) / 100.0, varyLevel);
	}
	
	@Test 
	public void getSubTotalTest() {
		assertEquals(14999.25, Math.round(tempOrderDetail.getSubTotal() * 100.0) / 100.0, varyLevel);
	}
	
	/*
	 * I give '1' as a bookId to this variable by default,
	 * so it should return 'One Piece', which is the book that has '1' as an id
	 */
	@Test
	public void getBookTitleTest() {
		assertEquals("One Piece", tempOrderDetail.getBookTitle());
	}

	@AfterClass
	public static void destroyObject() {
		tempOrderDetail = null;
		System.gc();
	}
	
}
