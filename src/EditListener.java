import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditListener implements ActionListener{
	private MenuFrame menu;
	
	public EditListener(MenuFrame m){
		menu = m;
	}
	
	public void actionPerformed(ActionEvent e) {
		int s = menu.getSelected();
		if(s != -1){
			menu.getBook().editBuddy(menu,s);
			menu.setText("Buddy Edited");
		}
	}
}
