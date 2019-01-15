package ckcc.OnlineBookStore;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import ckcc.OnlineBookStore.Back.Extra.TableTitle;

public class Main {

	public static void main(String[] args) throws InterruptedException {
	
		Date date = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY / HH:mm:ss");
		
		System.out.println(format.format(date));

		Thread.sleep(5000);
		
		System.out.println(format.format(date));
		
		
	}

}
