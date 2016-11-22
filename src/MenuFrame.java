import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

public class MenuFrame extends JFrame{
	private AddressBook book;
	//private JTextArea list;
	private JList<BuddyInfo> list;
	private JMenuItem create;
	private JMenuItem save;
	private JMenuItem load;
	//private JMenuItem display;
	private JMenuItem addBuddies;
	private JMenuItem edit;
	private JMenuItem remove;
	private JLabel label;
	private int selected;
	
	public MenuFrame(){
		super("Address Book");
		selected = -1;
		list = new JList<>();
		list.addListSelectionListener(new SelectionListener(this));
		
		setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();
		JMenu addressMenu = new JMenu("Address Book");
		create = new JMenuItem("Create");
		create.addActionListener(new addBookListener(this));
		save = new JMenuItem("Save");
		save.setEnabled(false);
		save.addActionListener(new saveBookListener(this));
		load = new JMenuItem("Import");
		load.addActionListener(new importBookListener(this));
		/*display = new JMenuItem("Display");
		display.setEnabled(false);
		display.addActionListener(new displayListener(this));*/
		addressMenu.add(create);
		addressMenu.add(save);
		addressMenu.add(load);
		//addressMenu.add(display);
		menuBar.add(addressMenu);
		JMenu buddiesMenu = new JMenu("Buddies");
		addBuddies = new JMenuItem("Add");
		addBuddies.setEnabled(false);
		addBuddies.addActionListener(new addBuddyListener(this));
		edit = new JMenuItem("Edit");
		edit.setEnabled(false);
		edit.addActionListener(new EditListener(this));
		remove = new JMenuItem("Remove");
		remove.setEnabled(false);
		remove.addActionListener(new RemoveListener(this));
		buddiesMenu.add(addBuddies);
		buddiesMenu.add(edit);
		buddiesMenu.add(remove);
		menuBar.add(buddiesMenu);
		label = new JLabel("Create an Address Book to begin");
		add(menuBar,BorderLayout.NORTH);
		add(new JScrollPane(list),BorderLayout.CENTER);
		add(label,BorderLayout.SOUTH);
		pack();
		setSize(250,500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		BuddyInfo b = AddressBook.importBuddy("Travis/555 Fake Street/(555) 123-4567");
		System.out.println(b);
		MenuFrame m = new MenuFrame();
	}
	
	/*public void display(){
		addText(book.toString());
	}
	
	public void addText(String s){
		list.append(s + "\n");
		pack();
	}*/
	
	public void setText(String s){
		label.setText(s);
	}
	
	public AddressBook getBook(){
		return book;
	}
	
	public JList<BuddyInfo> getList(){
		return list;
	}
	
	public int getSelected(){
		return selected;
	}
	
	public void addBook(){
		addBook(new AddressBook());
	}
	
	public void addBook(AddressBook a){
		book = a;
		list.setModel(book);
		addBuddies.setEnabled(true);
		save.setEnabled(true);
		label.setText("Address Book created.");
		//display.setEnabled(true);
		//addText("Address Book Created\n");
	}
	
	public void select(int i){
		if(i != -1 && book.get(i) != null){
			selected = i;
			edit.setEnabled(true);
			remove.setEnabled(true);
		}
		else{
			selected = -1;
			edit.setEnabled(false);
			remove.setEnabled(false);
		}
	}
	
	/*public static BuddyInfo importBuddy(String s){
		Scanner sc = new Scanner(s);
		sc.useDelimiter("/");
		String b = sc.next();
		String a = sc.next();
		String n = sc.next();
		sc.close();
		return new BuddyInfo(b,a,n);
	}*/
	
	public void importBook(){
		System.out.println("Importing");
		AddressBook a = new AddressBook();
		a.importBook();
		addBook(a);
		label.setText("Imported!");
		/*try{
			Scanner reader = new Scanner(new File("AddressBook.txt", "UTF-8"));
			AddressBook book = new AddressBook();
			while(reader.hasNextLine()){
				BuddyInfo b = importBuddy(reader.nextLine());
				book.addBuddy(b);
			}
			reader.close();
		}catch(IOException e){}*/
	}
	
	public void export(){
		if(book != null){
			/*PrintWriter writer = new PrintWriter("AddressBook.txt", "UTF-8");
			//PrintWriter writer = new PrintWriter(new FileWriter("AddressBook.txt"));
			String s = book.toString();
			System.out.print(s);
			//writer.print(s);
			writer.write(s);
			writer.close();*/
			book.export();
			label.setText("Saved!");
		}
	}
}
