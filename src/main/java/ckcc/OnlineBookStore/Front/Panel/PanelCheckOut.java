package ckcc.OnlineBookStore.Front.Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ckcc.OnlineBookStore.Back.Extra.Data;
import ckcc.OnlineBookStore.Back.Extra.TempOrderDetail;
import ckcc.OnlineBookStore.Back.Order.Cart;
import ckcc.OnlineBookStore.Back.Order.OrderDetail;
import ckcc.OnlineBookStore.Back.People.Address;
import ckcc.OnlineBookStore.Back.People.Customer;
import ckcc.OnlineBookStore.Front.JDialog.Invoice;

public class PanelCheckOut extends JPanel implements ActionListener{
	
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfPhone;
	
	private JTextField tfBAStreet;
	private JTextField tfBACity;
	private JTextField tfBAState;
	private JTextField tfBACountry;
	private JTextField tfBAPostalCode;
	
	private JTextField tfSAStreet;
	private JTextField tfSACity;
	private JTextField tfSAState;
	private JTextField tfSACountry;
	private JTextField tfSAPostalCode;
	
	private JRadioButton rdbtnYes;
	private JRadioButton rdbtnNo;
	private ButtonGroup bg;
	
	private JButton btnBack;
	private JButton btnCheckOut;
	
	private JPanel pnlMain;
	private JPanel pnlAddress;

	public PanelCheckOut() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblCheckout = new JLabel("Check-Out");
		lblCheckout.setForeground(Color.MAGENTA);
		lblCheckout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckout.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCheckout, BorderLayout.NORTH);
		
		JPanel pnlContainMain = new JPanel();
		add(pnlContainMain, BorderLayout.CENTER);
		
		pnlMain = new JPanel();
		pnlContainMain.add(pnlMain);
		pnlMain.setLayout(new GridLayout(2, 1, 0, 0));
		
		initCustomerInfoPanel();
		initAddressPanel();
		initButtonPanel();
		initRadioButtonEvent();
		
	}
	
	private void initCustomerInfoPanel() {
		JPanel pnlCustomerInfo = new JPanel();
		pnlMain.add(pnlCustomerInfo);
		pnlCustomerInfo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCustomersInformation = new JLabel("Customer's Information");
		lblCustomersInformation.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCustomersInformation.setBorder(new EmptyBorder(0, 0, 20, 0));
		lblCustomersInformation.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCustomerInfo.add(lblCustomersInformation, BorderLayout.NORTH);
		
		JPanel pnlCustomerInfoDetail = new JPanel();
		pnlCustomerInfo.add(pnlCustomerInfoDetail, BorderLayout.CENTER);
		pnlCustomerInfoDetail.setLayout(new GridLayout(4, 2, 0, 5));
		
		JLabel lblName = new JLabel("Name :");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCustomerInfoDetail.add(lblName);
		
		tfName = new JTextField();
		pnlCustomerInfoDetail.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCustomerInfoDetail.add(lblEmail);
		
		tfEmail = new JTextField();
		pnlCustomerInfoDetail.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone : ");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCustomerInfoDetail.add(lblPhone);
		
		tfPhone = new JTextField();
		pnlCustomerInfoDetail.add(tfPhone);
		tfPhone.setColumns(10);
		
		JPanel pnlQuestion = new JPanel();
		pnlQuestion.setBorder(new EmptyBorder(0, 0, 20, 0));
		pnlCustomerInfo.add(pnlQuestion, BorderLayout.SOUTH);
		
		JLabel lblAreShippingAddress = new JLabel("Are shipping address and billing address the same?");
		lblAreShippingAddress.setForeground(new Color(255, 0, 0));
		pnlQuestion.add(lblAreShippingAddress);
		
		rdbtnYes = new JRadioButton("Yes");
		pnlQuestion.add(rdbtnYes);
		
		rdbtnNo = new JRadioButton("No");		
		pnlQuestion.add(rdbtnNo);
	}
	
	private void initAddressPanel() {
		pnlAddress = new JPanel();
		pnlMain.add(pnlAddress);
		pnlAddress.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlAddressDetail = new JPanel();
		pnlAddress.add(pnlAddressDetail, BorderLayout.CENTER);
		pnlAddressDetail.setLayout(new GridLayout(1, 2, 20, 0));
		
		JPanel pnlBillingAddress = new JPanel();
		pnlAddressDetail.add(pnlBillingAddress);
		pnlBillingAddress.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBillingAddresss = new JLabel("Billing Addresss");
		lblBillingAddresss.setBorder(new EmptyBorder(0, 0, 10, 0));
		lblBillingAddresss.setHorizontalAlignment(SwingConstants.CENTER);
		pnlBillingAddress.add(lblBillingAddresss, BorderLayout.NORTH);
		
		JPanel pnlBillingAddressDetail = new JPanel();
		pnlBillingAddress.add(pnlBillingAddressDetail, BorderLayout.CENTER);
		pnlBillingAddressDetail.setLayout(new GridLayout(5, 2, 0, 5));
		
		JLabel lblStreet = new JLabel("Street :");
		pnlBillingAddressDetail.add(lblStreet);
		
		tfBAStreet = new JTextField();
		pnlBillingAddressDetail.add(tfBAStreet);
		tfBAStreet.setColumns(10);
		
		JLabel lblCity = new JLabel("City :");
		pnlBillingAddressDetail.add(lblCity);
		
		tfBACity = new JTextField();
		pnlBillingAddressDetail.add(tfBACity);
		tfBACity.setColumns(10);
		
		JLabel lblState = new JLabel("State :");
		pnlBillingAddressDetail.add(lblState);
		
		tfBAState = new JTextField();
		pnlBillingAddressDetail.add(tfBAState);
		tfBAState.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country :");
		pnlBillingAddressDetail.add(lblCountry);
		
		tfBACountry = new JTextField();
		pnlBillingAddressDetail.add(tfBACountry);
		tfBACountry.setColumns(10);
		
		JLabel lblPostalCode = new JLabel("Postal Code :");
		pnlBillingAddressDetail.add(lblPostalCode);
		
		tfBAPostalCode = new JTextField();
		pnlBillingAddressDetail.add(tfBAPostalCode);
		tfBAPostalCode.setColumns(10);
		
		JPanel pnlShippingAddress = new JPanel();
		pnlAddressDetail.add(pnlShippingAddress);
		pnlShippingAddress.setLayout(new BorderLayout(0, 0));
		
		JLabel lblShippingAddress = new JLabel("Shipping Address");
		lblShippingAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblShippingAddress.setBorder(new EmptyBorder(0, 0, 10, 0));
		pnlShippingAddress.add(lblShippingAddress, BorderLayout.NORTH);
		
		JPanel pnlShippingAddressDetail = new JPanel();
		pnlShippingAddress.add(pnlShippingAddressDetail, BorderLayout.CENTER);
		pnlShippingAddressDetail.setLayout(new GridLayout(5, 2, 0, 5));
		
		JLabel lblStreet_1 = new JLabel("Street :");
		pnlShippingAddressDetail.add(lblStreet_1);
		
		tfSAStreet = new JTextField();
		pnlShippingAddressDetail.add(tfSAStreet);
		tfSAStreet.setColumns(10);
		
		JLabel lblCity_1 = new JLabel("City :");
		pnlShippingAddressDetail.add(lblCity_1);
		
		tfSACity = new JTextField();
		pnlShippingAddressDetail.add(tfSACity);
		tfSACity.setColumns(10);
		
		JLabel lblState_1 = new JLabel("State :");
		pnlShippingAddressDetail.add(lblState_1);
		
		tfSAState = new JTextField();
		tfSAState.setBackground(Color.WHITE);
		pnlShippingAddressDetail.add(tfSAState);
		tfSAState.setColumns(10);
		
		JLabel lblCountry_1 = new JLabel("Country : ");
		pnlShippingAddressDetail.add(lblCountry_1);
		
		tfSACountry = new JTextField();
		tfSACountry.setBackground(Color.WHITE);
		pnlShippingAddressDetail.add(tfSACountry);
		tfSACountry.setColumns(10);
		
		JLabel lblPostalCode_1 = new JLabel("Postal Code :");
		pnlShippingAddressDetail.add(lblPostalCode_1);
		
		tfSAPostalCode = new JTextField();
		tfSAPostalCode.setBackground(Color.WHITE);
		pnlShippingAddressDetail.add(tfSAPostalCode);
		tfSAPostalCode.setColumns(10);
	}
	
	private void initButtonPanel() {
		JPanel pnlButton = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlButton.getLayout();
		flowLayout.setHgap(50);
		pnlButton.setBorder(new EmptyBorder(20, 0, 0, 0));
		pnlAddress.add(pnlButton, BorderLayout.SOUTH);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(0, 191, 255));
		pnlButton.add(btnBack);
		
		btnCheckOut = new JButton("Check Out");
		btnCheckOut.setBackground(new Color(0, 191, 255));
		btnCheckOut.addActionListener(this);
		pnlButton.add(btnCheckOut);
	}
	
	public void setSwitchActionListener(ActionListener al) {
		btnBack.addActionListener(al);
	}
	
	private void initRadioButtonEvent() {		
		bg = new ButtonGroup();
		bg.add(rdbtnNo);
		bg.add(rdbtnYes);
		
		rdbtnYes.setSelected(true);	
		tfSAStreet.setEnabled(false);
		tfSACity.setEnabled(false);
		tfSAState.setEnabled(false);
		tfSACountry.setEnabled(false);
		tfSAPostalCode.setEnabled(false);
		
		rdbtnYes.addItemListener(new ItemListener() {			
			public void itemStateChanged(ItemEvent e) {				
				tfSAStreet.setEnabled(false);
				tfSACity.setEnabled(false);
				tfSAState.setEnabled(false);
				tfSACountry.setEnabled(false);
				tfSAPostalCode.setEnabled(false);	
			}
		});
		
		rdbtnNo.addItemListener(new ItemListener() {			
			public void itemStateChanged(ItemEvent e) {
				tfSAStreet.setEnabled(true);
				tfSACity.setEnabled(true);
				tfSAState.setEnabled(true);
				tfSACountry.setEnabled(true);
				tfSAPostalCode.setEnabled(true);		
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		Address billingAddress;
		Address shippingAddress;
		Customer customer;
		
		String BAStreet = tfBAStreet.getText();
		String BACity = tfBACity.getText();
		String BAState = tfBAState.getText();
		String BACountry = tfBACountry.getText();
		String BAPostalCode = tfBAPostalCode.getText();
		String name = tfName.getText();
		String email = tfEmail.getText();
		String phone = tfPhone.getText();
		
		billingAddress = new Address(BAStreet,BACity,BAState,BACountry,BAPostalCode);
		
		if(!rdbtnYes.isSelected()) {
			String SAStreet = tfSAStreet.getText();
			String SACity = tfSACity.getText();
			String SAState = tfSAState.getText();
			String SACountry = tfSACountry.getText();
			String SAPostalCode = tfSAPostalCode.getText();
			
			shippingAddress = new Address(SAStreet, SACity, SAState, SACountry, SAPostalCode);
			customer = new Customer(name, email, phone, billingAddress, shippingAddress);
		}
		else {
			customer = new Customer(name, email, phone, billingAddress);
		}
		
		List<TempOrderDetail> tempOrderDetails = Data.getTempOrderDetail();
		
		ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();			
		for(TempOrderDetail temp : tempOrderDetails) {
			OrderDetail od = new OrderDetail();
			od.addOrderDetail(temp);
			orderDetails.add(od);
		}
		
		Date date = new Date();
		
		double discount = 0;
		while(true){
			try {
				discount = Double.parseDouble(
						JOptionPane.showInputDialog(null, "Input Discount : ", "Must Input", JOptionPane.PLAIN_MESSAGE)
						);			
				if(!(discount < 0 || discount > 100))
					break;
			}
			catch(Exception ex){
			}
		}
		
		String remark = JOptionPane.showInputDialog(null, "Input your thought : ", "Feedback", JOptionPane.PLAIN_MESSAGE);
		
		Cart cart = new Cart(customer, orderDetails, date, discount, remark);
		Data.addCartIntoData(cart);
		
		try {
			Invoice dialog = new Invoice(cart);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		Data.emptyTempOrderDetail();
		TempOrderDetail.reset();
		this.setVisible(false);
	}

}
