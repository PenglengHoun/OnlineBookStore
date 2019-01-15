package ckcc.OnlineBookStore.Back.Extra;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ckcc.OnlineBookStore.Back.Item.Book;
import ckcc.OnlineBookStore.Back.Order.Cart;
import ckcc.OnlineBookStore.Back.Order.OrderDetail;
import ckcc.OnlineBookStore.Back.People.Customer;
import ckcc.OnlineBookStore.Back.Stock.BookInStock;

public class Data {
	
	public static void addCartIntoData(Cart cart) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cart.class).buildSessionFactory();
		Session session = factory.getCurrentSession();	
		try {		
			session.beginTransaction();
			session.save(cart);
			session.getTransaction().commit();
			session.close();
		}
		finally {
			factory.close();
		}
	}
	
	public static ArrayList<Cart> getCart() {
		ArrayList<Cart> temp;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cart.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();			
			temp = (ArrayList<Cart>) session.createQuery("from Cart").getResultList();	
			session.close();
		}
		finally {
			factory.close();
		}
		return temp;
	}
	
	public static Cart getOneCart(int id) {
		Cart cart;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cart.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			cart = session.get(Cart.class, id);
			session.close();
		}
		finally{
			factory.close();
		}
		return cart;
	}
	
	public static void emptyTempOrderDetail() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TempOrderDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();	
		try {		
			session.beginTransaction();
			session.createQuery("delete from TempOrderDetail").executeUpdate();
			session.getTransaction().commit();
			session.close();
		}
		finally {
			factory.close();
		}
	}
	
	public static void deleteTempOrderDetail(int id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TempOrderDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();	
		try {		
			session.beginTransaction();
			session.createQuery("delete from TempOrderDetail where id = " + id).executeUpdate();
			session.getTransaction().commit();
			session.close();
		}
		finally {
			factory.close();
		}
	}
	
	public static void updateTempOrderDetail(String field, int id, double item) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TempOrderDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();	
		try {		
			session.beginTransaction();
			session.createQuery("update TempOrderDetail b set b." + field + " = " + item + " where b.id = " + id).executeUpdate();
			session.getTransaction().commit();
			session.close();
		}
		finally {
			factory.close();
		}
	}
	
	public static ArrayList<TempOrderDetail> getTempOrderDetail(String field, String item){
		ArrayList<TempOrderDetail> temp;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TempOrderDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();			
			temp = (ArrayList<TempOrderDetail>) session.createQuery("from TempOrderDetail b where b." + field + " = " + "\'" + item + "\'").getResultList();		
			session.close();
		}
		finally {
			factory.close();
		}
		return temp;
	}
	
	public static ArrayList<TempOrderDetail> getTempOrderDetail(String field, double item){
		ArrayList<TempOrderDetail> temp;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TempOrderDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();			
			temp = (ArrayList<TempOrderDetail>) session.createQuery("from TempOrderDetail b where b." + field + " = " + item ).getResultList();		
			session.close();
		}
		finally {
			factory.close();
		}
		return temp;
	}
	
	public static ArrayList<TempOrderDetail> getTempOrderDetail() {
		ArrayList<TempOrderDetail> temp;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TempOrderDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();			
			temp = (ArrayList<TempOrderDetail>) session.createQuery("from TempOrderDetail").getResultList();	
			session.close();
		}
		finally {
			factory.close();
		}
		return temp;
	}
	
	public static void addTempOrderDetailIntoData(TempOrderDetail t) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TempOrderDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();	
		try {		
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
			session.close();
		}
		finally {
			factory.close();
		}
	}
	
	public static void addOrderDetailIntoData(OrderDetail t) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(OrderDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();	
		try {		
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
			session.close();
		}
		finally {
			factory.close();
		}
	}
	
	public static ArrayList<OrderDetail> getOrderDetail() {
		ArrayList<OrderDetail> temp;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(OrderDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();			
			temp = (ArrayList<OrderDetail>) session.createQuery("from OrderDetail").getResultList();	
			session.close();
		}
		finally {
			factory.close();
		}
		return temp;
	}
	
	public static void updateStock(String field, int id, double item) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BookInStock.class).buildSessionFactory();
		Session session = factory.getCurrentSession();	
		try {		
			session.beginTransaction();
			session.createQuery("update BookInStock b set b." + field + " = " + item + " where b.id = " + id).executeUpdate();
			session.getTransaction().commit();
			session.close();
		}
		finally {
			factory.close();
		}
	}
	
	public static void addBookInStockIntoData(BookInStock bis) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BookInStock.class).buildSessionFactory();
		Session session = factory.getCurrentSession();	
		try {		
			session.beginTransaction();
			session.save(bis);
			session.getTransaction().commit();
			session.close();
		}
		finally {
			factory.close();
		}
	}
	
	public static ArrayList<Book> getBook(){
		ArrayList<Book> temp;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BookInStock.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();			
			temp = (ArrayList<Book>) session.createQuery("from Book").getResultList();	
			session.close();
		}
		finally {
			factory.close();
		}
		return temp;
	}
	
	public static ArrayList<Book> getBook(String field, String item){
		ArrayList<Book> temp;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BookInStock.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();			
			temp = (ArrayList<Book>) session.createQuery("from Book b where b." + field + " = " + "\'" + item + "\'").getResultList();		
			session.close();
		}
		finally {
			factory.close();
		}
		return temp;
	}
	
	public static Book getOneBook(int id) {
		Book temp;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();			
			temp = session.get(Book.class, id);
			session.close();
		}
		finally {
			factory.close();
		}
		return temp;
	}
	
	public static ArrayList<Book> getBook(String field, double item){
		ArrayList<Book> temp;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BookInStock.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();			
			temp = (ArrayList<Book>) session.createQuery("from Book b where b." + field + " = " + item).getResultList();		
			session.close();
		}
		finally {
			factory.close();
		}
		return temp;
	}
}
