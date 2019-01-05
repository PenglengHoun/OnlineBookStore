package ckcc.OnlineBookStore;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ckcc.OnlineBookStore.Front.EventClass.EventMenuButton;
import ckcc.OnlineBookStore.Front.Panel.PanelAddNewItem;
import ckcc.OnlineBookStore.Front.Panel.PanelGoToShopping;
import ckcc.OnlineBookStore.Front.Panel.PanelHistory;
import ckcc.OnlineBookStore.Front.Panel.PanelHome;
import ckcc.OnlineBookStore.Front.Panel.PanelMyShoppingCart;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	// BUTTON
	private JButton btnHome;
	private JButton btnAddNewItem;
	private JButton btnGoToShopping;
	private JButton btnMyShoppingCart;
	// END BUTTON
	
	// MAIN
	private JPanel pnlMain;
	private CardLayout cardLayout;
	private JButton btnHistory;
	// END MAIN

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		setTitle("Online Book Shop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setAlignmentY(0.0f);
		contentPane.setAlignmentX(0.0f);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		initMainPanel();
		initButtonPanel();
		
	}
	
	private void initMainPanel() {
		pnlMain = new JPanel();
		contentPane.add(pnlMain, BorderLayout.CENTER);
		
		cardLayout = new CardLayout();
		
		pnlMain.setLayout(cardLayout);	
		pnlMain.add("Home",new PanelHome());
		pnlMain.add("AddNewItem", new PanelAddNewItem());
		pnlMain.add("GoToShopping", new PanelGoToShopping());
		pnlMain.add("MyShoppingCart", new PanelMyShoppingCart());
		pnlMain.add("History", new PanelHistory());
		
		cardLayout.show(pnlMain, "Home");
	}
	
	private void initButtonPanel() {
		JPanel pnlButton = new JPanel();
		pnlButton.setBackground(Color.WHITE);
		contentPane.add(pnlButton, BorderLayout.WEST);
		pnlButton.setLayout(new GridLayout(5, 1, 0, 0));
		
		EventMenuButton event = new EventMenuButton(pnlMain,cardLayout);
		
		btnHome = new JButton("Home");
		btnHome.setBackground(new Color(0, 191, 255));
		btnHome.setActionCommand("Home");
		btnHome.addActionListener(event);
		pnlButton.add(btnHome);
		
		btnAddNewItem = new JButton("Add New Book");
		btnAddNewItem.setBackground(new Color(0, 191, 255));
		btnAddNewItem.setActionCommand("Add New Item");
		btnAddNewItem.addActionListener(event);
		pnlButton.add(btnAddNewItem);
		
		btnGoToShopping = new JButton("Go to Shopping");
		btnGoToShopping.setBackground(new Color(0, 191, 255));
		btnGoToShopping.setActionCommand("Go To Shopping");
		btnGoToShopping.addActionListener(event);
		pnlButton.add(btnGoToShopping);
		
		btnMyShoppingCart = new JButton("My Shopping Cart");
		btnMyShoppingCart.setBackground(new Color(0, 191, 255));
		btnMyShoppingCart.setActionCommand("My Shopping Cart");
		btnMyShoppingCart.addActionListener(event);
		pnlButton.add(btnMyShoppingCart);
		
		btnHistory = new JButton("History");
		btnHistory.setBackground(new Color(0, 191, 255));
		btnHistory.setActionCommand("History");
		btnHistory.addActionListener(event);
		pnlButton.add(btnHistory);
		
	}

}
