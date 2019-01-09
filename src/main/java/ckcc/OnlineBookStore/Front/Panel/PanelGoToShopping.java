package ckcc.OnlineBookStore.Front.Panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ckcc.OnlineBookStore.Back.Extra.TableTitle;
import ckcc.OnlineBookStore.Back.Item.Book;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.Color;

public class PanelGoToShopping extends JPanel {
	
	private JPanel pnlMain;
	
	private JTextField tfSearch;
	private JComboBox<String> cboSearch;
	private JButton btnSearch;
	
	private DefaultTableModel table;
	private JTable jTable;	
	private JScrollPane scrollPane;
	
	private JButton btnAddToCart;
	
	private JRadioButton rdbtnExact;
	private JRadioButton rdbtnBelow;
	private JRadioButton rdbtnAbove;
	private ButtonGroup bg;

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
		setRadioButtonVisible(false);
		initTable();
		initBuyPanel();

	}
	
	private void setRadioButtonVisible(boolean condition) {
			rdbtnExact.setVisible(condition);
			rdbtnAbove.setVisible(condition);
			rdbtnBelow.setVisible(condition);		
			rdbtnExact.setSelected(true);		
	}
	
	private void initBuyPanel() {
		JPanel pnlBuy = new JPanel();
		pnlMain.add(pnlBuy, BorderLayout.SOUTH);
		
		btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.setBackground(new Color(0, 191, 255));
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
		cboSearch.setModel(new DefaultComboBoxModel<String>(new String[] {"ID", "Title", "Publisher", "Year Published", "ISBN", "Price", "Author", "Editon", "Volume"}));
		cboSearch.setSelectedIndex(0);
		
		cboSearch.addItemListener(new ItemListener() {		
			public void itemStateChanged(ItemEvent e) {
				String result = (String) cboSearch.getSelectedItem();
				if(result.equals("Price"))
					setRadioButtonVisible(true);
				else
					setRadioButtonVisible(false);
			}
		});
		
		pnlSearch.add(cboSearch);
		
		tfSearch = new JTextField();
		tfSearch.setPreferredSize(new Dimension(6, 27));
		tfSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnlSearch.add(tfSearch);
		tfSearch.setColumns(15);
		
		btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(0, 191, 255));
		pnlSearch.add(btnSearch);
		
		rdbtnExact = new JRadioButton("Exact",true);
		pnlSearch.add(rdbtnExact);
		
		rdbtnBelow = new JRadioButton("Below",false);
		pnlSearch.add(rdbtnBelow);
		
		rdbtnAbove = new JRadioButton("Above",false);
		pnlSearch.add(rdbtnAbove);
		
		bg = new ButtonGroup();
		
		bg.add(rdbtnExact);
		bg.add(rdbtnBelow);
		bg.add(rdbtnAbove);
	}
	
	private void initTable() {
		
		table = new DefaultTableModel(null, new Object[] {TableTitle.ID,TableTitle.TITLE,
				TableTitle.PUBLISHER,TableTitle.YEAR_PUBLISHED, TableTitle.ISBN, TableTitle.PRICE, 
				TableTitle.AUTHOR, TableTitle.EDITION, TableTitle.VOLUME});
		
		jTable = new JTable(table);
		
		scrollPane = new JScrollPane(jTable);
		pnlMain.add(scrollPane, BorderLayout.CENTER);
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			//List<Book> bookList = session.get
		}
		finally {
			
		}
		
	}

}
