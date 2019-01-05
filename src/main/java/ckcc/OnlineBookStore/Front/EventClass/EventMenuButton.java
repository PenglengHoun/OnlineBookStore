package ckcc.OnlineBookStore.Front.EventClass;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class EventMenuButton implements ActionListener{

	private JPanel jPanel;
	private CardLayout cardLayout;
	
	public EventMenuButton(JPanel jPanel, CardLayout cardLayout) {
		this.jPanel = jPanel;
		this.cardLayout = cardLayout;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if(command.equals("Home"))
			cardLayout.show(jPanel, "Home");
		else if(command.equals("Add New Item"))
			cardLayout.show(jPanel, "AddNewItem");
		else if(command.equals("Go To Shopping"))
			cardLayout.show(jPanel, "GoToShopping");
		else if(command.equals("My Shopping Cart"))
			cardLayout.show(jPanel, "MyShoppingCart");
		else
			cardLayout.show(jPanel, "History");
		
	}

}
