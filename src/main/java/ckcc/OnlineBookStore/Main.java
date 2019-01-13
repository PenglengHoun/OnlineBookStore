package ckcc.OnlineBookStore;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import ckcc.OnlineBookStore.Back.Extra.TableTitle;

public class Main {

	public static void main(String[] args) {
	
		Date date = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY / HH:mm");
		
		System.out.println(format.format(date));
		String title = String.format("%45s%s%46s", " ", "Invoice", " ");
		String l2 = "+----------+----------+------------------------------+----------+----------+----------+----------+";
		String l3 = String.format("|%-10s|%-10s|%-30s|%-10s|%-10s|%-10s|%-10s|", 
				TableTitle.ID, TableTitle.BOOK_ID, TableTitle.TITLE, TableTitle.PRICE, TableTitle.QTY,
				TableTitle.DISCOUNT, TableTitle.SUB_TOTAL);
		
		System.out.println(title + "\n" + l2 + "\n" + l3);
		
	}

}
