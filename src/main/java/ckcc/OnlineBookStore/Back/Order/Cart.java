package ckcc.OnlineBookStore.Back.Order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ckcc.OnlineBookStore.Back.Extra.TableTitle;
import ckcc.OnlineBookStore.Back.People.Address;
import ckcc.OnlineBookStore.Back.People.Customer;

@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<OrderDetail> orderDetail;
	
	@Column(name = "order_date")
	private Date date;
	
	@Column(name = "discount")
	private double discount;
	
	@Column(name = "total")
	private double total;
	
	@Column(name = "remark")
	private String remark;
	
	public Cart(Customer customer, ArrayList<OrderDetail> orderDetail, Date date, double discount, String remark) {
		this.customer = customer;
		this.orderDetail = orderDetail;
		this.date = date;
		this.discount = discount;
		this.remark = remark;

		total = getSubTotal() - getDiscountMoney();
		
	}
	
	public Cart() {

	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	
	public double getDiscount() {
		return discount;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public double getTotal() {
		return total;
	}
	
	public double getDiscountMoney() {
		return getSubTotal() * discount / 100;
	}
	
	public double getSubTotal() {
		double t = 0;
		for(OrderDetail temp : orderDetail)
			t += temp.getSubTotal();
		return t;
	}
	
	public Object[] getInfo() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy / HH:mm");
		
		return new Object[] {
			id, customer.getName(), sdf.format(date)	
		};
	}
	
}
