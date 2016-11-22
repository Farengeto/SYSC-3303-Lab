import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class importBookListener implements ActionListener{
	private MenuFrame menu;
	
	public importBookListener(MenuFrame m){
		menu = m;
	}
	
	public void actionPerformed(ActionEvent e) {
		menu.importBook();
	}
}