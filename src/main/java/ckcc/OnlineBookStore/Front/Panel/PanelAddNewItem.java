package ckcc.OnlineBookStore.Front.Panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ckcc.OnlineBookStore.Back.Extra.Data;
import ckcc.OnlineBookStore.Back.Item.Book;
import ckcc.OnlineBookStore.Back.Stock.BookInStock;

import java.awt.Color;

public class PanelAddNewItem extends JPanel {
	
	private JTextField tfISBN;
	private JTextField tfTitle;
	private JTextField tfPublisher;
	private JTextField tfYearPublished;
	private JTextField tfAuthor;
	private JTextField tfEdition;
	private JTextField tfVolume;
	private JTextField tfPrice;
	private JPanel pnlButton;
	private JButton btnAdd;
	private JButton btnClear;
	private JTextField tfQty;

	public PanelAddNewItem() {
		setLayout(new BorderLayout(0, 0));
		
		initObj();
		
		btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(0, 191, 255));
		btnAdd.setForeground(new Color(0, 0, 0));
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					String title = tfTitle.getText();
					String publisher = tfPublisher.getText();
					String yearPublished = tfYearPublished.getText();
					String ISBN = tfISBN.getText();
					String author = tfAuthor.getText();
					int edition = Integer.parseInt(tfEdition.getText());
					int volume = Integer.parseInt(tfVolume.getText());
					double price = Double.parseDouble(tfPrice.getText());
					int qty = Integer.parseInt(tfQty.getText());
					
					Book book = new Book(title,publisher,yearPublished,ISBN,price,author,edition,volume);
					BookInStock bis = new BookInStock(book, qty);
					
					Data.addBookInStockIntoData(bis);
				
				tfTitle.requestFocus();
				tfTitle.select(0, tfTitle.getText().length());
			}
		});
		
		
		
		pnlButton.add(btnAdd);
		
		btnClear = new JButton("Clear");
		btnClear.setBackground(new Color(0, 191, 255));
		btnClear.setForeground(new Color(0, 0, 0));
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfISBN.setText("");
				tfTitle.setText("");
				tfPublisher.setText("");
				tfYearPublished.setText("");
				tfAuthor.setText("");
				tfEdition.setText("");
				tfVolume.setText("");
				tfPrice.setText("");
				tfQty.setText("");
				tfTitle.requestFocus();
			}
		});
		
		pnlButton.add(btnClear);

	}
	
	private void initObj() {
		
		JLabel lblNewLabel = new JLabel("Add New Book");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setPreferredSize(new Dimension(69, 41));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pnlOut = new JPanel();
		panel.add(pnlOut);
		pnlOut.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlControl = new JPanel();
		pnlOut.add(pnlControl);
		pnlControl.setLayout(new GridLayout(10, 2, 0, 20));
		
		JLabel lblTitle = new JLabel("Title :");
		pnlControl.add(lblTitle);
		
		tfTitle = new JTextField();
		pnlControl.add(tfTitle);
		tfTitle.setColumns(20);
		
		JLabel lblPublisher = new JLabel("Publisher :");
		pnlControl.add(lblPublisher);
		
		tfPublisher = new JTextField();
		pnlControl.add(tfPublisher);
		tfPublisher.setColumns(20);
		
		JLabel lblYearPublished = new JLabel("Year Published :");
		pnlControl.add(lblYearPublished);
		
		tfYearPublished = new JTextField();
		pnlControl.add(tfYearPublished);
		tfYearPublished.setColumns(20);
		
		JLabel lblIsbn = new JLabel("ISBN :");
		pnlControl.add(lblIsbn);
		
		tfISBN = new JTextField();
		pnlControl.add(tfISBN);
		tfISBN.setColumns(20);
		
		JLabel lblAuthor = new JLabel("Author :");
		pnlControl.add(lblAuthor);
		
		tfAuthor = new JTextField();
		pnlControl.add(tfAuthor);
		tfAuthor.setColumns(20);
		
		JLabel lblEdition = new JLabel("Edition :");
		pnlControl.add(lblEdition);
		
		tfEdition = new JTextField();
		pnlControl.add(tfEdition);
		tfEdition.setColumns(20);
		
		JLabel lblVolumn = new JLabel("Volume :");
		pnlControl.add(lblVolumn);
		
		tfVolume = new JTextField();
		pnlControl.add(tfVolume);
		tfVolume.setColumns(20);
		
		JLabel lblPrice = new JLabel("Price :");
		pnlControl.add(lblPrice);
		
		tfPrice = new JTextField();
		pnlControl.add(tfPrice);
		tfPrice.setColumns(20);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		pnlControl.add(lblQuantity);
		
		tfQty = new JTextField();
		pnlControl.add(tfQty);
		tfQty.setColumns(10);
		
		pnlButton = new JPanel();
		pnlButton.setBorder(new EmptyBorder(20, 0, 0, 0));
		pnlButton.setBounds(new Rectangle(10, 0, 0, 0));
		FlowLayout flowLayout = (FlowLayout) pnlButton.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(25);
		pnlOut.add(pnlButton, BorderLayout.SOUTH);
		
	}

}
