import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveListener implements ActionListener{
	private MenuFrame menu;
	
	public RemoveListener(MenuFrame m){
		menu = m;
	}
	
	public void actionPerformed(ActionEvent e) {
		BuddyInfo b = menu.getList().getSelectedValue();
		if(b != null){
			menu.getBook().removeBuddy(b);
			menu.setText("Buddy Removed");
		}
	}
}
