package ckcc.OnlineBookStore.Front.Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import ckcc.OnlineBookStore.Front.EventClass.EventRemoveFocusTable;
import ckcc.OnlineBookStore.Front.EventClass.SearchButtonHelper;

public class PanelGoToShopping extends JPanel {
	
	private JPanel pnlMain;
	
	private JTextField tfSearch;
	private JComboBox<String> cboSearch;
	private JButton btnSearch;
	
	private DefaultTableModel table;
	private JTable jTable;	
	private JScrollPane scrollPane;
	
	private JButton btnAddToCart;

	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}
	
	public PanelGoToShopping() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblShopping = new JLabel("Shopping");
		lblShopping.setForeground(new Color(255, 0, 255));
		lblShopping.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblShopping.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblShopping, BorderLayout.NORTH);
		
		pnlMain = new JPanel();
		add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(new BorderLayout(0, 0));		
		
		JLabel lblNewLabel = new JLabel("     ");
		add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("     ");
		add(lblNewLabel_1, BorderLayout.EAST);
		
		initSearchPanel();
		initTable();
		initBuyPanel();
		
		cart = new Cart();

	}
	
	private void initBuyPanel() {
		JPanel pnlBuy = new JPanel();
		pnlMain.add(pnlBuy, BorderLayout.SOUTH);
		
		btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.setBackground(new Color(0, 191, 255));
		
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(jTable.getSelectedRowCount() == 0) return;
				
				int qtyColumn;
				int id;
				double price;
				double discount = 0;
				try {
					// INPUT QTY
					qtyColumn = Integer.parseInt("" + table.getValueAt(jTable.getSelectedRow(), 9));				
					id = Integer.parseInt("" + table.getValueAt(jTable.getSelectedRow(), 0));
					price = Double.parseDouble("" + table.getValueAt(jTable.getSelectedRow(), 5));
					
					String result = JOptionPane.showInputDialog(null, "Input Quantity :", "Input Quantity", JOptionPane.PLAIN_MESSAGE);
					if(result.equals("")) return;
					
					int qty = Integer.parseInt(result);
					if(qty > qtyColumn) {
						JOptionPane.showMessageDialog(null, "!!!Not Enough Item!!!", "Error", JOptionPane.WARNING_MESSAGE);
						return;
					}
					if(qty < 0) {
						JOptionPane.showMessageDialog(null, "!!!Please input positive Number!!!", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					table.setValueAt(qtyColumn - qty, jTable.getSelectedRow(), 9);
					
					// INPUT DISCOUNT
					String result1 = JOptionPane.showInputDialog(null, "Input New Discount :", "Input New Discount", JOptionPane.PLAIN_MESSAGE);
					if(result1.equals("")) {}
					
					discount = Double.parseDouble(result1);
					if(discount < 0 || discount > 100) {
						JOptionPane.showMessageDialog(null, "!!!Please input between 0-100!!!", "Error", JOptionPane.ERROR_MESSAGE);
					}				
					
					TempOrderDetail tempOrderDetail = new TempOrderDetail(id, qty, price, discount);					
					Data.addTempOrderDetailIntoData(tempOrderDetail);
					Data.updateStock("discount", jTable.getSelectedRow() + 1, discount);
					Data.updateStock("qty", jTable.getSelectedRow() + 1, qtyColumn - qty);
					
				}
				catch(NumberFormatException ex) {			
					JOptionPane.showMessageDialog(null, "!!!Please Input Number!!!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception ex) {		
				}	
				
			}
		});

		pnlBuy.add(btnAddToCart);
		
	}
	
	private void initSearchPanel() {
		JPanel pnlSearch = new JPanel();
		FlowLayout fl_pnlSearch = (FlowLayout) pnlSearch.getLayout();
		fl_pnlSearch.setAlignment(FlowLayout.LEFT);
		pnlMain.add(pnlSearch, BorderLayout.NORTH);
		
		JLabel lblSearchBy = new JLabel("Search by :");
		pnlSearch.add(lblSearchBy);
		
		cboSearch = new JComboBox<String>();
		cboSearch.setBackground(new Color(0, 191, 255));
		cboSearch.setMaximumRowCount(10);
		cboSearch.setModel(new DefaultComboBoxModel<String>(
				new String[] {
						TableTitle.ID, TableTitle.TITLE, TableTitle.PUBLISHER, TableTitle.YEAR_PUBLISHED,
						TableTitle.ISBN, TableTitle.PRICE, TableTitle.AUTHOR, TableTitle.EDITION, TableTitle.VOLUME,
						     }
														   )
						  );
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
				
				ArrayList<Book> bookList;
				
				if(help.isString())
					bookList = Data.getBook(help.getType(), tfSearch.getText());
				else
					bookList = Data.getBook(help.getType(), Double.parseDouble(tfSearch.getText()));
				
				if(bookList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "!!!There is no matched item!!!", "No matched item", JOptionPane.INFORMATION_MESSAGE);
					refreshTable();
					return;
				}
				
				table.getDataVector().removeAllElements();
				for(Book temp : bookList)
					table.addRow(temp.getInfo());
			}
		});		
		pnlSearch.add(btnSearch);
	}
	
	private void initTable() {
		
		table = new DefaultTableModel(null, new Object[] {TableTitle.ID,TableTitle.TITLE,
				TableTitle.PUBLISHER,TableTitle.YEAR_PUBLISHED, TableTitle.ISBN, TableTitle.PRICE, 
				TableTitle.AUTHOR, TableTitle.EDITION, TableTitle.VOLUME, TableTitle.QTY});
		
		jTable = new JTable(table);
		jTable.setAutoCreateRowSorter(true);
		jTable.getTableHeader().setReorderingAllowed(false);
		
		jTable.addMouseListener(new EventRemoveFocusTable(jTable));

		scrollPane = new JScrollPane(jTable);
		pnlMain.add(scrollPane, BorderLayout.CENTER);

		refreshTable();

	}
	
	private void refreshTable() {
		ArrayList<Book> bookList = Data.getBook();
		table.getDataVector().removeAllElements();
		for(Book temp : bookList)
			table.addRow(temp.getInfo());
	}

}
