package ckcc.OnlineBookStore.Front.JDialog;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ckcc.OnlineBookStore.Back.Extra.TableTitle;
import ckcc.OnlineBookStore.Back.Order.Cart;
import ckcc.OnlineBookStore.Back.Order.OrderDetail;
import ckcc.OnlineBookStore.Back.People.Address;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Invoice extends JDialog {
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
	
	private DefaultTableModel table;
	private JTable jTable;
	private JTextField tfSAPostalCode;
	
	private JTextField tfSubTotal;
	private JTextField tfDiscount;
	private JTextField tfTotal;
	private JTextField tfDiscountP;
	
	public static void main(String[] args) {
		try {
			Invoice dialog = new Invoice();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Invoice() {
		
	}
	
	public Invoice(Cart cart) {
		getContentPane().setLayout(null);
		setTitle("Invoice");
		setBounds(400, 100, 530, 560);
		
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Customer's Information");
		lblNewLabel.setBounds(0, 0, 529, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(105, 36, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setBounds(105, 71, 46, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Phone :");
		lblNewLabel_1.setBounds(105, 105, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		tfName = new JTextField();
		tfName.setBounds(176, 36, 203, 20);
		getContentPane().add(tfName);
		tfName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(176, 68, 203, 20);
		getContentPane().add(tfEmail);
		
		tfPhone = new JTextField();
		tfPhone.setBounds(176, 102, 203, 20);
		getContentPane().add(tfPhone);
		tfPhone.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Billing Address");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(71, 133, 90, 25);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblShippingAddress = new JLabel("Shipping Address");
		lblShippingAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblShippingAddress.setBounds(337, 133, 109, 25);
		getContentPane().add(lblShippingAddress);
		
		JLabel lblStreet = new JLabel("Street : ");
		lblStreet.setBounds(26, 169, 46, 14);
		getContentPane().add(lblStreet);
		
		JLabel lblCity = new JLabel("City : ");
		lblCity.setBounds(26, 194, 46, 14);
		getContentPane().add(lblCity);
		
		JLabel lblState = new JLabel("State : ");
		lblState.setBounds(26, 219, 46, 14);
		getContentPane().add(lblState);
		
		JLabel lblCountry = new JLabel("Country : ");
		lblCountry.setBounds(26, 244, 77, 14);
		getContentPane().add(lblCountry);
		
		JLabel lblPostalCode = new JLabel("Postal Code : ");
		lblPostalCode.setBounds(26, 269, 77, 14);
		getContentPane().add(lblPostalCode);
		
		tfBAStreet = new JTextField();
		tfBAStreet.setColumns(10);
		tfBAStreet.setBounds(113, 169, 124, 20);
		getContentPane().add(tfBAStreet);
		
		tfBACity = new JTextField();
		tfBACity.setColumns(10);
		tfBACity.setBounds(113, 194, 124, 20);
		getContentPane().add(tfBACity);
		
		tfBAState = new JTextField();
		tfBAState.setColumns(10);
		tfBAState.setBounds(113, 219, 124, 20);
		getContentPane().add(tfBAState);
		
		tfBACountry = new JTextField();
		tfBACountry.setColumns(10);
		tfBACountry.setBounds(113, 244, 124, 20);
		getContentPane().add(tfBACountry);
		
		tfBAPostalCode = new JTextField();
		tfBAPostalCode.setColumns(10);
		tfBAPostalCode.setBounds(113, 269, 124, 20);
		getContentPane().add(tfBAPostalCode);
		
		JLabel label = new JLabel("Street : ");
		label.setBounds(282, 169, 46, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("City : ");
		label_1.setBounds(282, 194, 46, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("State : ");
		label_2.setBounds(282, 219, 46, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Country : ");
		label_3.setBounds(282, 244, 77, 14);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Postal Code : ");
		label_4.setBounds(282, 269, 77, 14);
		getContentPane().add(label_4);
		
		tfSAStreet = new JTextField();
		tfSAStreet.setColumns(10);
		tfSAStreet.setBounds(369, 169, 124, 20);
		getContentPane().add(tfSAStreet);
		
		tfSACity = new JTextField();
		tfSACity.setColumns(10);
		tfSACity.setBounds(369, 194, 124, 20);
		getContentPane().add(tfSACity);
		
		tfSAState = new JTextField();
		tfSAState.setColumns(10);
		tfSAState.setBounds(369, 219, 124, 20);
		getContentPane().add(tfSAState);
		
		tfSACountry = new JTextField();
		tfSACountry.setColumns(10);
		tfSACountry.setBounds(369, 244, 124, 20);
		getContentPane().add(tfSACountry);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		tfSAPostalCode = new JTextField();
		tfSAPostalCode.setColumns(10);
		tfSAPostalCode.setBounds(369, 269, 124, 20);
		getContentPane().add(tfSAPostalCode);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(26, 305, 467, 131);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new DefaultTableModel(null, new Object[] {TableTitle.ID, TableTitle.BOOK_ID, TableTitle.TITLE,
				TableTitle.PRICE, TableTitle.QTY, TableTitle.DISCOUNT, TableTitle.SUB_TOTAL});
		
		jTable = new JTable(table);
		
		JScrollPane scrollPane = new JScrollPane(jTable);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblSubtotal = new JLabel("Sub-Total :");
		lblSubtotal.setBounds(26, 447, 56, 14);
		getContentPane().add(lblSubtotal);
		
		JLabel lblDiscount = new JLabel("Discount :");
		lblDiscount.setBounds(26, 472, 56, 14);
		getContentPane().add(lblDiscount);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setBounds(26, 497, 56, 14);
		getContentPane().add(lblTotal);
		
		tfSubTotal = new JTextField();
		tfSubTotal.setColumns(10);
		tfSubTotal.setBounds(92, 447, 124, 20);
		getContentPane().add(tfSubTotal);
		
		tfDiscount = new JTextField();
		tfDiscount.setColumns(10);
		tfDiscount.setBounds(92, 472, 124, 20);
		getContentPane().add(tfDiscount);
		
		tfTotal = new JTextField();
		tfTotal.setColumns(10);
		tfTotal.setBounds(92, 497, 124, 20);
		getContentPane().add(tfTotal);
		
		
		tfName.setText(cart.getCustomer().getName());
		tfEmail.setText(cart.getCustomer().getEmail());
		tfPhone.setText(cart.getCustomer().getPhone());
		
		List<Address> address = cart.getCustomer().getAddress();
		
		tfBAStreet.setText(address.get(0).getStreet());
		tfBACity.setText(address.get(0).getCity());
		tfBAState.setText(address.get(0).getState());
		tfBACountry.setText(address.get(0).getCountry());
		tfBAPostalCode.setText(address.get(0).getPostalCode());
		
		if(address.size() == 1) {
			tfSAStreet.setText(address.get(0).getStreet());
			tfSACity.setText(address.get(0).getCity());
			tfSAState.setText(address.get(0).getState());
			tfSACountry.setText(address.get(0).getCountry());
			tfSAPostalCode.setText(address.get(0).getPostalCode());
		}
		else {
			tfSAStreet.setText(address.get(1).getStreet());
			tfSACity.setText(address.get(1).getCity());
			tfSAState.setText(address.get(1).getState());
			tfSACountry.setText(address.get(1).getCountry());
			tfSAPostalCode.setText(address.get(1).getPostalCode());
		}
		int count = 0;
		for(OrderDetail temp : cart.getOrderDetail())
			table.addRow(new Object[] {
				++count, temp.getBookId(), temp.getBookTitle(), temp.getPrice(), temp.getQty(), temp.getDiscountP(),
				temp.getSubTotal()
			});
		
		tfSubTotal.setText(""+cart.getTotal());
		tfDiscount.setText(""+cart.getDiscountMoney());
		tfTotal.setText(""+cart.getSubTotal());
		
		tfName.setEditable(false);
		tfEmail.setEditable(false);
		tfPhone.setEditable(false);
		
		tfBAStreet.setEditable(false);
		tfBACity.setEditable(false);
		tfBAState.setEditable(false);
		tfBACountry.setEditable(false);
		tfBAPostalCode.setEditable(false);

		tfSAStreet.setEditable(false);
		tfSACity.setEditable(false);
		tfSAState.setEditable(false);
		tfSACountry.setEditable(false);
		tfSAPostalCode.setEditable(false);
		
		tfTotal.setEditable(false);
		tfDiscount.setEditable(false);
		tfSubTotal.setEditable(false);
		
		JLabel lblDiscount_1 = new JLabel("Discount (%):");
		lblDiscount_1.setBounds(251, 450, 77, 14);
		getContentPane().add(lblDiscount_1);
		
		tfDiscountP = new JTextField();
		tfDiscountP.setText("0.0");
		tfDiscountP.setEditable(false);
		tfDiscountP.setColumns(10);
		tfDiscountP.setBounds(322, 447, 124, 20);
		
		tfDiscountP.setText(cart.getDiscount()+" %");
		
		getContentPane().add(tfDiscountP);
		
		JLabel lblRemark = new JLabel("Remark :");
		lblRemark.setBounds(251, 475, 56, 14);
		getContentPane().add(lblRemark);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(322, 476, 124, 41);
		textArea.setEditable(false);
		
		textArea.setText(cart.getRemark());
		
		getContentPane().add(textArea);
	}
}
