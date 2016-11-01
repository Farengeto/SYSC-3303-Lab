import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//whole class depreceated due to GUI changes
public class displayListener implements ActionListener{
	private MenuFrame menu;
	
	public displayListener(MenuFrame m){
		menu = m;
	}
	
	public void actionPerformed(ActionEvent e) {
		//menu.display();
	}
}
