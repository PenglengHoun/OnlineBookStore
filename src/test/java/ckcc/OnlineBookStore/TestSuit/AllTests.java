package ckcc.OnlineBookStore.TestSuit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ckcc.OnlineBookStore.Back.ExtraTest.TempOrderDetailTest;
import ckcc.OnlineBookStore.Back.OrderTest.CartTest;
import ckcc.OnlineBookStore.Back.OrderTest.OrderDetailTest;

@RunWith(Suite.class)
@SuiteClasses({TempOrderDetailTest.class, CartTest.class, OrderDetailTest.class})
public class AllTests {

}
