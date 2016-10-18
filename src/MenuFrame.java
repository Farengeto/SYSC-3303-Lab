import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

public class MenuFrame extends JFrame{
	private AddressBook book;
	private JButton addBook;
	private JButton saveBook;
	private JButton addBuddy;
	private JTextField name;
	private JTextField address;
	private JTextField phoneNumber;
	private JTextArea list;
	
	public MenuFrame(){
		super("Address Book");
		name = new JTextField("");
		address = new JTextField("");
		phoneNumber = new JTextField("");
		addBook = new JButton("Create Address Book");
		addBook.addActionListener(new addBookListener(this));
		saveBook = new JButton("Save Address Book");
		saveBook.addActionListener(new saveBookListener(this));
		saveBook.setEnabled(false);
		addBuddy = new JButton("Add Buddy");
		addBuddy.addActionListener(new addBuddyListener(this));
		addBuddy.setEnabled(false);
		
		JPanel bookMenu = new JPanel();
		bookMenu.setLayout(new GridLayout(1,2));
		bookMenu.add(addBook);
		bookMenu.add(saveBook);
		
		JScrollPane listMenu = new JScrollPane();
		listMenu.setSize(200, 500);
		list = new JTextArea();
		//list.append("Address Book:\n");
		listMenu.add(list);
		list.setEditable(false);
		
		JPanel buddyMenu = new JPanel();
		buddyMenu.setLayout(new GridLayout(3,3));
		buddyMenu.add(new JLabel("Name"));
		buddyMenu.add(new JLabel("Address"));
		buddyMenu.add(new JLabel("Phone Number"));
		buddyMenu.add(name);
		buddyMenu.add(address);
		buddyMenu.add(phoneNumber);
		buddyMenu.add(addBuddy);
		
		setLayout(new BorderLayout());
		add(bookMenu,BorderLayout.NORTH);
		//add(listMenu,BorderLayout.CENTER);
		add(list,BorderLayout.CENTER);
		add(buddyMenu,BorderLayout.SOUTH);
		pack();
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		MenuFrame m = new MenuFrame();
	}
	
	public void addText(String s){
		list.append(s + "\n");
		pack();
	}
	
	public void addBook(){
		book = new AddressBook();
		addBook.setEnabled(false);
		addBuddy.setEnabled(true);
		saveBook.setEnabled(true);
		addText("Address Book:");
	}
	
	public void addBuddy(){
		BuddyInfo b = new BuddyInfo(name.getText(),address.getText(),phoneNumber.getText());
		book.addBuddy(b);
		addText(b.toString());
	}
	
	public void save(){
		try{
			if(book != null){
				PrintWriter writer = new PrintWriter("AddressBook.txt", "UTF-8");
				writer.print(book.toString());
				writer.close();
			}
		}catch(IOException e){}
	}
}
