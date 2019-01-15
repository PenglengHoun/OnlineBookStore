package ckcc.OnlineBookStore.Front.Panel;

import java.awt.CardLayout;

import javax.swing.JPanel;

import ckcc.OnlineBookStore.Back.Order.Cart;
import ckcc.OnlineBookStore.Front.EventClass.EventMyShoppingCartSwitchButton;

public class PanelMyShoppingCart extends JPanel {

	private CardLayout cardLayout;
	private PanelBuy panelBuy;
	private PanelCheckOut panelCheckOut;
	
	public PanelMyShoppingCart() {
		cardLayout = new CardLayout();
		panelBuy = new PanelBuy();
		panelCheckOut = new PanelCheckOut();
		
		setLayout(cardLayout);
		
		add("Buy", panelBuy);
		add("CheckOut", panelCheckOut);
		
		cardLayout.show(this, "Buy");
		
		EventMyShoppingCartSwitchButton event = new EventMyShoppingCartSwitchButton(this, cardLayout);
		
		panelBuy.setSwitchActionListener(event);
		panelCheckOut.setSwitchActionListener(event);
		
	}

}
