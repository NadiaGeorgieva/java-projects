import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

@SuppressWarnings("serial")
public class MyPopUpMenu extends JPopupMenu {
	private JMenuItem editItem = new JMenuItem("Редактиране");
	private JMenuItem delItem = new JMenuItem("Изтриване");
	
	private int id;
	
	public MyPopUpMenu(int id) {
		this.add(delItem);		
		delItem.addActionListener(new DeleteAction());
		this.add(editItem);
		editItem.addActionListener(new EditAction());
		this.id = id;
	}
	
	class EditAction implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
			DBConnector.updateRow(" ", id);
		
		}
		
	}
	class DeleteAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			DBConnector.deleteRow(" ", id);			
		}
		
	}

}

