package ckcc.OnlineBookStore.Front.EventClass;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class EventRemoveFocusTable extends MouseAdapter{
	
	private JTable jTable;
	
	public EventRemoveFocusTable(JTable jTable) {
		this.jTable = jTable;
	}

	public void mousePressed(MouseEvent e) {
		if(jTable.isEditing()) {
			JOptionPane.showMessageDialog(null, "!!!You can't edit this table!!!", "Warning", JOptionPane.WARNING_MESSAGE);
			jTable.removeEditor();
		}
	}
	
}
