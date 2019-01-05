package ckcc.OnlineBookStore.Front.Panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ckcc.OnlineBookStore.Back.Extra.TableTitle;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelMyShoppingCart extends JPanel {
	
	private JPanel pnlMain;
	
	private JTextField tfSearch;
	private JComboBox<String> cboSearch;
	private JButton btnSearch;
	private JRadioButton rdbtnExact;
	private JRadioButton rdbtnBelow;
	private JRadioButton rdbtnAbove;
	private ButtonGroup bg;
	
	private DefaultTableModel table;
	private JTable jTable;
	private JScrollPane scrollPane;
	
	private JButton btnDelete;
	private JButton btnUpdateAmount;
	private JButton btnCheckout;

	public PanelMyShoppingCart() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblMyShoppingCart = new JLabel("My Shopping Cart");
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
		cboSearch.setMaximumRowCount(10);
		cboSearch.setModel(new DefaultComboBoxModel<String>(new String[] {"ID", "Title", "Publisher", "Year Published", "ISBN", "Price", "Author", "Edition", "Volume"}));
		cboSearch.setSelectedIndex(0);
		pnlSearch.add(cboSearch);
		
		tfSearch = new JTextField();
		tfSearch.setPreferredSize(new Dimension(6, 27));
		tfSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnlSearch.add(tfSearch);
		tfSearch.setColumns(15);
		
		btnSearch = new JButton("Search");
		pnlSearch.add(btnSearch);
		
		rdbtnExact = new JRadioButton("Exact",true);
		pnlSearch.add(rdbtnExact);
		
		rdbtnBelow = new JRadioButton("Below",false);
		pnlSearch.add(rdbtnBelow);
		
		rdbtnAbove = new JRadioButton("Above",false);
		pnlSearch.add(rdbtnAbove);
		
		bg = new ButtonGroup();
		bg.add(rdbtnAbove);
		bg.add(rdbtnBelow);
		bg.add(rdbtnExact);
	
	}
	
	private void initTable() {
		
		table = new DefaultTableModel(null, new Object[] {TableTitle.ID,TableTitle.TITLE,
				TableTitle.PUBLISHER,TableTitle.YEAR_PUBLISHED, TableTitle.ISBN, TableTitle.PRICE, 
				TableTitle.AUTHOR, TableTitle.EDITION, TableTitle.VOLUME});
		
		jTable = new JTable(table);
		
		scrollPane = new JScrollPane(jTable);
		pnlMain.add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initDeleteUpdateAndCheckOut() {
		
		JPanel pnlDeleteUpdateAndCheckOut = new JPanel();
		pnlMain.add(pnlDeleteUpdateAndCheckOut, BorderLayout.SOUTH);
		pnlDeleteUpdateAndCheckOut.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel pnlDeleteUpdate = new JPanel();
		pnlDeleteUpdateAndCheckOut.add(pnlDeleteUpdate);
		
		btnDelete = new JButton("Delete");
		pnlDeleteUpdate.add(btnDelete);
		
		btnUpdateAmount = new JButton("Update Amount");
		pnlDeleteUpdate.add(btnUpdateAmount);
		
		JPanel pnlCheckOut = new JPanel();
		pnlDeleteUpdateAndCheckOut.add(pnlCheckOut);
		
		btnCheckout = new JButton("Check-Out");
		pnlCheckOut.add(btnCheckout);
	}

}
