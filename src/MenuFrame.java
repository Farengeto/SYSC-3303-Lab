import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

public class MenuFrame extends JFrame{
	private AddressBook book;
	private JTextArea list;
	private JMenuItem create;
	private JMenuItem save;
	private JMenuItem display;
	private JMenuItem addBuddies;
	
	public MenuFrame(){
		super("Address Book");
		/*name = new JTextField("");
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
		bookMenu.add(saveBook);*/
		
		JScrollPane listMenu = new JScrollPane();
		listMenu.setSize(200, 500);
		list = new JTextArea();
		//list.append("Address Book:\n");
		listMenu.add(list);
		list.setEditable(false);
		
		/*JPanel buddyMenu = new JPanel();
		buddyMenu.setLayout(new GridLayout(3,3));
		buddyMenu.add(new JLabel("Name"));
		buddyMenu.add(new JLabel("Address"));
		buddyMenu.add(new JLabel("Phone Number"));
		buddyMenu.add(name);
		buddyMenu.add(address);
		buddyMenu.add(phoneNumber);
		buddyMenu.add(addBuddy);*/
		
		setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();
		JMenu addressMenu = new JMenu("Address Book");
		create = new JMenuItem("Create");
		create.addActionListener(new addBookListener(this));
		save = new JMenuItem("Save");
		save.setEnabled(false);
		save.addActionListener(new saveBookListener(this));
		display = new JMenuItem("Display");
		display.setEnabled(false);
		display.addActionListener(new displayListener(this));
		addressMenu.add(create);
		addressMenu.add(save);
		addressMenu.add(display);
		menuBar.add(addressMenu);
		JMenu buddiesMenu = new JMenu("Buddies");
		addBuddies = new JMenuItem("Add");
		addBuddies.setEnabled(false);
		addBuddies.addActionListener(new addBuddyListener(this));
		buddiesMenu.add(addBuddies);
		menuBar.add(buddiesMenu);
		add(menuBar,BorderLayout.NORTH);
		//add(bookMenu,BorderLayout.NORTH);
		//add(listMenu,BorderLayout.CENTER);
		add(new JScrollPane(list),BorderLayout.CENTER);
		//add(buddyMenu,BorderLayout.SOUTH);
		pack();
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		MenuFrame m = new MenuFrame();
	}
	
	public void display(){
		addText(book.toString());
	}
	
	public void addText(String s){
		list.append(s + "\n");
		pack();
	}
	
	public void addBook(){
		book = new AddressBook();
		addBuddies.setEnabled(true);
		save.setEnabled(true);
		display.setEnabled(true);
		addText("Address Book Created\n");
	}
	
	public void addBuddy(){
		//BuddyInfo b = new BuddyInfo(name.getText(),address.getText(),phoneNumber.getText());
		//String n = (String)(JOptionPane.showInputDialog(this,"Input Buddy name:"));
		String n = (String)(JOptionPane.showInputDialog(this,"Input Buddy name:","Add Buddy",JOptionPane.PLAIN_MESSAGE));
		String a = (String)(JOptionPane.showInputDialog(this,"Input Buddy address:","Add Buddy",JOptionPane.PLAIN_MESSAGE));
		String p = (String)(JOptionPane.showInputDialog(this,"Input Buddy phone number:","Add Buddy",JOptionPane.PLAIN_MESSAGE));
		BuddyInfo b = new BuddyInfo(n,a,p);
		book.addBuddy(b);
		addText(b.toString() + "\n");
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
