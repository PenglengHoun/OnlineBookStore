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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ckcc.OnlineBookStore.Back.Extra.Data;
import ckcc.OnlineBookStore.Back.Order.Cart;
import ckcc.OnlineBookStore.Back.People.Customer;
import ckcc.OnlineBookStore.Front.JDialog.Invoice;

public class PanelHistory extends JPanel {
	
	private JPanel pnlMain;
	
	private JComboBox<String> cboSearch;
	private JTextField tfSearch;
	private JButton btnSearch;
	
	private DefaultTableModel table;
	private JTable jTable;
	private JScrollPane scrollPane;
	
	private JButton btnView;

	public PanelHistory() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("History");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("     ");
		add(label, BorderLayout.WEST);
		
		JLabel label_1 = new JLabel("     ");
		add(label_1, BorderLayout.EAST);
		
		pnlMain = new JPanel();
		add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(new BorderLayout(0, 0));

		initSearchPanel();
		initTable();
		initViewPanel();
		
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
		cboSearch.setModel(new DefaultComboBoxModel<String>(new String[] {"ID", "Name"}));
		cboSearch.setSelectedIndex(0);
		pnlSearch.add(cboSearch);
		
		tfSearch = new JTextField();
		tfSearch.setPreferredSize(new Dimension(6, 27));
		tfSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnlSearch.add(tfSearch);
		tfSearch.setColumns(15);
		
		btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(0, 191, 255));
		pnlSearch.add(btnSearch);
	}
	
	private void initTable() {
		table = new DefaultTableModel(null, new Object[] {"ID", "Name", "Date"});
		
		refreshTable();
		
		jTable = new JTable(table);
		scrollPane = new JScrollPane(jTable);
		pnlMain.add(scrollPane, BorderLayout.CENTER);
	}

	private void initViewPanel() {
		JPanel pnlView = new JPanel();
		pnlMain.add(pnlView, BorderLayout.SOUTH);
		
		btnView = new JButton("View");
		btnView.setBackground(new Color(0, 191, 255));
		
		btnView.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				
				Cart cart = Data.getOneCart(Integer.parseInt("" + table.getValueAt(jTable.getSelectedRow(), 0)));
				try {
					Invoice dialog = new Invoice(cart);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		pnlView.add(btnView);
	}
	
	private void refreshTable() {
		ArrayList<Cart> list = Data.getCart();
		table.getDataVector().removeAllElements();
		for(Cart temp : list)
			table.addRow(temp.getInfo());
	}
}
