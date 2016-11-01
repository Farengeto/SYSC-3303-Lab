import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class AddressBook extends DefaultListModel<BuddyInfo>{
	
	public AddressBook(){
		super();
	}
	
	public static void main(String[] args){
		BuddyInfo buddy = new BuddyInfo("Homer","Carleton","613-123-4567");
		AddressBook book = new AddressBook();
		book.addBuddy(buddy);
		System.out.println("Address Book");
	}
	
	public void addBuddy(MenuFrame m){
		String n = (String)(JOptionPane.showInputDialog(m,"Input Buddy name:","Add Buddy",JOptionPane.PLAIN_MESSAGE));
		String a = (String)(JOptionPane.showInputDialog(m,"Input Buddy address:","Add Buddy",JOptionPane.PLAIN_MESSAGE));
		String p = (String)(JOptionPane.showInputDialog(m,"Input Buddy phone number:","Add Buddy",JOptionPane.PLAIN_MESSAGE));
		BuddyInfo b = new BuddyInfo(n,a,p);
		addElement(b);
	}
	
	public void addBuddy(BuddyInfo buddy){
		addElement(buddy);
	}
	
	public void editBuddy(MenuFrame m, int i){
		if(i != -1 && get(i) != null){
			String n = (String)(JOptionPane.showInputDialog(m,"Input Buddy name:","Add Buddy",JOptionPane.PLAIN_MESSAGE,null,null,get(i).getName()));
			String a = (String)(JOptionPane.showInputDialog(m,"Input Buddy address:","Add Buddy",JOptionPane.PLAIN_MESSAGE,null,null,get(i).getAddress()));
			String p = (String)(JOptionPane.showInputDialog(m,"Input Buddy phone number:","Add Buddy",JOptionPane.PLAIN_MESSAGE,null,null,get(i).getPhoneNumber()));
			BuddyInfo b = new BuddyInfo(n,a,p);
			set(i,b);
		}
	}
	
	public void removeBuddy(BuddyInfo buddy){
		//buddies.remove(buddy);
		removeElement(buddy);
	}
}
