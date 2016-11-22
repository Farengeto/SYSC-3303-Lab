import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	public String toString(){
		String s = "";
		for(int i = 0; i < getSize(); i++){
			s += elementAt(i).toString() + System.lineSeparator();
		}
		return s;
	}
	
	public static BuddyInfo importBuddy(String s){
		Scanner sc = new Scanner(s);
		sc.useDelimiter("/");
		String b = sc.next();
		String a = sc.next();
		String n = sc.next();
		sc.close();
		return new BuddyInfo(b,a,n);
	}
	
	public void importBook(){
		try{
			Scanner reader = new Scanner(new File("AddressBook.txt"));
			while(reader.hasNextLine()){
				String s = reader.nextLine();
				if(s.length() > 0){ //skip empty end lines
					BuddyInfo b = importBuddy(s);
					addBuddy(b);
				}
			}
			reader.close();
		}catch(IOException e){
			System.err.println("File not found");
		}
	}
	
	public void export(){
		try{
			PrintWriter writer = new PrintWriter("AddressBook.txt", "UTF-8");
			String s = toString();
			writer.write(s);
			writer.close();
		}catch(IOException e){}
	}
	
	public boolean equals(AddressBook b){
		if(getSize() != b.getSize()){
			return false;
		}
		for(int i = 0; i < getSize(); i++){
			if(!elementAt(i).equals(b.elementAt(i))){
				return false;
			}
		}
		return true;
	}
}
