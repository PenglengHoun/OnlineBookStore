package ckcc.OnlineBookStore.Front.Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelHome extends JPanel {

	public PanelHome() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblOnlineBookShop = new JLabel("Online Book Shop");
		lblOnlineBookShop.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblOnlineBookShop.setSize(new Dimension(50, 100));
		lblOnlineBookShop.setPreferredSize(new Dimension(50, 100));
		lblOnlineBookShop.setVisible(true);
		lblOnlineBookShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineBookShop.setVerticalAlignment(SwingConstants.CENTER);
		add(lblOnlineBookShop, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblByHoun = new JLabel("By : Houn Pengleng");
		lblByHoun.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblByHoun.setHorizontalAlignment(SwingConstants.CENTER);
		lblByHoun.setHorizontalTextPosition(SwingConstants.CENTER);
		lblByHoun.setForeground(Color.BLUE);
		panel.add(lblByHoun);
		
		JLabel lblLecturerThay = new JLabel("Lecturer : Thay Setha");
		lblLecturerThay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLecturerThay.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLecturerThay.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecturerThay.setForeground(Color.BLUE);
		panel.add(lblLecturerThay);

	}

}
