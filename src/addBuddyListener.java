import java.awt.event.*;

public class addBuddyListener implements ActionListener{
	private MenuFrame menu;
	
	public addBuddyListener(MenuFrame m){
		menu = m;
	}
	
	public void actionPerformed(ActionEvent e) {
		menu.getBook().addBuddy(menu);
		menu.setText("Buddy Added");
	}
}
