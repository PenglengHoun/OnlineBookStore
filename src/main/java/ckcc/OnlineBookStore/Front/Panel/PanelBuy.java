package ckcc.OnlineBookStore.Front.Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ckcc.OnlineBookStore.Back.Extra.Data;
import ckcc.OnlineBookStore.Back.Extra.TableTitle;
import ckcc.OnlineBookStore.Back.Extra.TempOrderDetail;
import ckcc.OnlineBookStore.Back.Item.Book;
import ckcc.OnlineBookStore.Back.Order.Cart;
import ckcc.OnlineBookStore.Back.Order.OrderDetail;
import ckcc.OnlineBookStore.Front.EventClass.EventRemoveFocusTable;
import ckcc.OnlineBookStore.Front.EventClass.SearchButtonHelper;

public class PanelBuy extends JPanel {
	
	private JPanel pnlMain;
	
	private JTextField tfSearch;
	private JComboBox<String> cboSearch;
	private JButton btnSearch;
	
	private DefaultTableModel table;
	private JTable jTable;
	private JScrollPane scrollPane;
	
	private JButton btnDelete;
	private JButton btnUpdateQty;
	private JButton btnCheckOut;
	private JLabel lblTotal;
	
	public PanelBuy() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblMyShoppingCart = new JLabel("My Shopping Cart");
		lblMyShoppingCart.setForeground(new Color(255, 0, 255));
		lblMyShoppingCart.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyShoppingCart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblMyShoppingCart, BorderLayout.NORTH);
		
		pnlMain = new JPanel();
		add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("     ");
		add(label, BorderLayout.EAST);
		
		JLabel label_1 = new JLabel("     ");
		add(label_1, BorderLayout.WEST);
		
		initSearchPanel();
		initTable();
		initDeleteUpdateAndCheckOut();
		
	}
	
	private void initSearchPanel() {
		JPanel pnlSearch = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlSearch.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlMain.add(pnlSearch, BorderLayout.NORTH);
		
		JLabel lblSearchBy = new JLabel("Search by :");
		pnlSearch.add(lblSearchBy);
		
		cboSearch = new JComboBox<String>();
		cboSearch.setBackground(new Color(0, 191, 255));
		cboSearch.setMaximumRowCount(10);
		cboSearch.setModel(new DefaultComboBoxModel<String>(new String[] {TableTitle.ID, TableTitle.BOOK_ID}));
		cboSearch.setSelectedIndex(0);
		
		pnlSearch.add(cboSearch);
		
		tfSearch = new JTextField();
		tfSearch.setPreferredSize(new Dimension(6, 27));
		tfSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnlSearch.add(tfSearch);
		tfSearch.setColumns(15);
		
		btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(0, 191, 255));
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if(tfSearch.getText().equals(""))	return;				
				SearchButtonHelper help = new SearchButtonHelper((String)cboSearch.getSelectedItem());
				
				ArrayList<TempOrderDetail> list;
				
				if(help.isString())
					list = Data.getTempOrderDetail(help.getType(), tfSearch.getText());
				else
					list = Data.getTempOrderDetail(help.getType(), Double.parseDouble(tfSearch.getText()));
				
				if(list.isEmpty()) {
					JOptionPane.showMessageDialog(null, "!!!There is no matched item!!!", "No matched item", JOptionPane.INFORMATION_MESSAGE);
					refreshTable();
					return;
				}
				
				table.getDataVector().removeAllElements();
				for(TempOrderDetail temp : list)
					table.addRow(temp.getInfo());
			}
		});	
		
		pnlSearch.add(btnSearch);
		
		JLabel label_2 = new JLabel("                             ");
		pnlSearch.add(label_2);
		
		lblTotal = new JLabel("Total : 0");
		lblTotal.setForeground(Color.RED);
		pnlSearch.add(lblTotal);
	
	}
	
	private void initTable() {
		
		table = new DefaultTableModel(null, new Object[] {TableTitle.ID, TableTitle.BOOK_ID, TableTitle.TITLE,
				TableTitle.PRICE, TableTitle.QTY, TableTitle.DISCOUNT, TableTitle.SUB_TOTAL});
		
		jTable = new JTable(table);
		jTable.setBackground(Color.WHITE);
		jTable.addMouseListener(new EventRemoveFocusTable(jTable));
		
		jTable.getTableHeader().setReorderingAllowed(false);
		
		refreshTable();
		refreshTotalLabel();
		
		scrollPane = new JScrollPane(jTable);
		pnlMain.add(scrollPane, BorderLayout.CENTER);
	}
	
	private void refreshTotalLabel() {
		double sum = 0;
		for(int i=0; i<table.getRowCount(); i++)
			sum += Double.parseDouble("" + table.getValueAt(i, 6));
		lblTotal.setText("Total : " + sum);
	}
	
	private void refreshTable() {
		ArrayList<TempOrderDetail> list = Data.getTempOrderDetail();
		table.getDataVector().removeAllElements();
		for(TempOrderDetail temp : list)
			table.addRow(temp.getInfo());
	}
	
	private void initDeleteUpdateAndCheckOut() {
		
		JPanel pnlDeleteUpdateAndCheckOut = new JPanel();
		pnlMain.add(pnlDeleteUpdateAndCheckOut, BorderLayout.SOUTH);
		pnlDeleteUpdateAndCheckOut.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel pnlDeleteUpdate = new JPanel();
		pnlDeleteUpdateAndCheckOut.add(pnlDeleteUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(0, 191, 255));
		
		btnDelete.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				if(jTable.getSelectedRowCount() == 0) return;
				
				try {
					int decision = Integer.parseInt("" + JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete", JOptionPane.YES_NO_OPTION));
					if(decision !=0) return;
				}
				finally {
					
				}
				
				int bookId = Integer.parseInt("" + table.getValueAt(jTable.getSelectedRow(), 1));
				Book book = Data.getOneBook(bookId);
				int returnQty = book.getBookInStock().getQty() + Integer.parseInt("" + table.getValueAt(jTable.getSelectedRow(), 4));
				
				Data.updateStock("qty", book.getBookInStock().getId(), returnQty);
				Data.deleteTempOrderDetail(Integer.parseInt("" + table.getValueAt(jTable.getSelectedRow(), 0)));
				table.removeRow(jTable.getSelectedRow());
				
				refreshTotalLabel();
			}
		});
		
		pnlDeleteUpdate.add(btnDelete);
		
		btnUpdateQty = new JButton("Update Amount");
		btnUpdateQty.setBackground(new Color(0, 191, 255));
		
		btnUpdateQty.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				
				if(jTable.getSelectedRowCount() == 0) return;
				try {
					
					String result = JOptionPane.showInputDialog(null, "Input New Quantity :", "Input Amount", JOptionPane.PLAIN_MESSAGE);
					if(result.equals("")) return;
					
					int qty = Integer.parseInt(result);
					if(qty<0) {
						JOptionPane.showMessageDialog(null, "!!!Input Negative Number!!!", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					Book book = Data.getOneBook(Integer.parseInt("" + table.getValueAt(jTable.getSelectedRow(), 1)));
					if(qty > book.getBookInStock().getQty()) {
						JOptionPane.showMessageDialog(null, "!!!Not Enough Item!!!", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					int newQty = book.getBookInStock().getQty() + Integer.parseInt("" + table.getValueAt(jTable.getSelectedRow(), 4)) - qty;
					
					table.setValueAt(qty, jTable.getSelectedRow(), 4);				
					Data.updateStock("qty", book.getBookInStock().getId(), newQty);
					Data.updateTempOrderDetail("qty", Integer.parseInt("" + table.getValueAt(jTable.getSelectedRow(), 0)), qty);
					
					TempOrderDetail temp = new TempOrderDetail(0, qty, Double.parseDouble(""+table.getValueAt(jTable.getSelectedRow(), 3)), Double.parseDouble(""+table.getValueAt(jTable.getSelectedRow(), 5)));			
					Data.updateTempOrderDetail("subTotal", Integer.parseInt("" + table.getValueAt(jTable.getSelectedRow(), 0)), temp.getSubTotal());
					table.setValueAt(temp.getSubTotal(), jTable.getSelectedRow(), 6);	
					refreshTotalLabel();
				}
				catch(NumberFormatException ex) {			
					JOptionPane.showMessageDialog(null, "!!!Please Input Number!!!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception ex) {		
				}
			}
		});
		
		pnlDeleteUpdate.add(btnUpdateQty);
		
		JPanel pnlCheckOut = new JPanel();
		pnlDeleteUpdateAndCheckOut.add(pnlCheckOut);
		
		btnCheckOut = new JButton("Check-Out");
		btnCheckOut.setBackground(new Color(0, 191, 255));
		btnCheckOut.setActionCommand("CheckOut");
		pnlCheckOut.add(btnCheckOut);
	}
	
	public void setSwitchActionListener(ActionListener al) {
		btnCheckOut.addActionListener(al);
	}

}
