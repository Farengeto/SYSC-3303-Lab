import javax.swing.event.*;

public class SelectionListener implements ListSelectionListener {
	private MenuFrame menu;
	
	public SelectionListener(MenuFrame m){
		menu = m;
	}
	
	public void valueChanged(ListSelectionEvent e) {
        menu.select(menu.getList().getSelectedIndex());
    }
}
