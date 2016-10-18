import java.awt.event.*;

public class addBookListener implements ActionListener{
	private MenuFrame menu;
	
	public addBookListener(MenuFrame m){
		menu = m;
	}
	
	public void actionPerformed(ActionEvent e) {
		menu.addBook();
	}
}
