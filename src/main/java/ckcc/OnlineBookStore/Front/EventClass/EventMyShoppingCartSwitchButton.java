package ckcc.OnlineBookStore.Front.EventClass;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class EventMyShoppingCartSwitchButton implements ActionListener{

	JPanel panel;
	CardLayout cardLayout;
	
	public EventMyShoppingCartSwitchButton(JPanel panel, CardLayout cardLayout) {
		this.panel = panel;
		this.cardLayout = cardLayout;
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("CheckOut")) {
			cardLayout.show(panel, "CheckOut");
		}
		else
			cardLayout.show(panel, "Buy");
	}
	
}
