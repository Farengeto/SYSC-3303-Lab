import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class displayListener implements ActionListener{
	private MenuFrame menu;
	
	public displayListener(MenuFrame m){
		menu = m;
	}
	
	public void actionPerformed(ActionEvent e) {
		menu.display();
	}
}
