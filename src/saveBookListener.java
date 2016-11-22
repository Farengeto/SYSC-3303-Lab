import java.awt.event.*;

public class saveBookListener implements ActionListener{
	private MenuFrame menu;
	
	public saveBookListener(MenuFrame m){
		menu = m;
	}
	
	public void actionPerformed(ActionEvent e) {
		menu.export();
	}
}
