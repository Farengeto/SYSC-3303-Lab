import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class AddressBook extends DefaultListModel<BuddyInfo> implements Serializable{
	
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
	
	public String toXML(){
		String s = "<AddressBook>" + System.lineSeparator();
		for(int i = 0; i < getSize(); i++){
			BuddyInfo b = elementAt(i);
			s += "\t<BuddyInfo>"  + System.lineSeparator();
			s += "\t\t<name>" + b.getName() + "</name>" + System.lineSeparator();
			s += "\t\t<address>" + b.getAddress() + "</address>" + System.lineSeparator();
			s += "\t\t<phoneNumber>" + b.getPhoneNumber() + "</phoneNumber>" + System.lineSeparator();
			s += "\t</BuddyInfo>"  + System.lineSeparator();
		}
		s += "</AddressBook>"  + System.lineSeparator();
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
	
	public static AddressBook importBook(String filename){
		AddressBook book = new AddressBook();
		try{
			Scanner reader = new Scanner(new File(filename));
			while(reader.hasNextLine()){
				String s = reader.nextLine();
				if(s.length() > 0){ //skip empty end lines
					BuddyInfo b = importBuddy(s);
					book.addBuddy(b);
				}
			}
			reader.close();
		}catch(IOException e){
			System.err.println("File not found");
		}
		return book;
	}
	
	public void export(String filename){
		try{
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
			String s = toString();
			writer.write(s);
			writer.close();
		}catch(IOException e){
			System.err.println("IO Error, export failed");
		}
	}
	
	public static AddressBook serialImport(String filename){
		AddressBook a = new AddressBook();
		try{
			FileInputStream fos = new FileInputStream(filename);
			ObjectInputStream oos = new ObjectInputStream(fos);
			a = (AddressBook)oos.readObject();
			oos.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return a;
	}
	
	public void serialExport(String filename){
		try{
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void exportToXMLFile(String filename){
		try{
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
			String s = toXML();
			writer.write(s);
			writer.close();
		}catch(IOException e){
			System.err.println("IO Error, export failed");
		}
	}
	
	/*public static void importFromXmlFileSAX(String filename) throws Exception{
		File f = new File(filename);
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser s = spf.newSAXParser();
		
		DefaultHandler dh = new DefaultHandler(){
			public void startElement(String u, String ln, String qName, Attributes a){
				System.out.println("START: " + qName);
			}
			
			public void endElement(String uri, String localName, String qName){
				System.out.println("END: " + qName);
			}
			
			public void characters(char[] ch, int start, int length){
				System.out.println("CHARS: " + new String(ch,start,length));
			}
		};
		s.parse(f, dh);
	}*/
	
	public static AddressBook importFromXmlFileDOM(String filename) throws Exception{
		File f = new File(filename);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder d = factory.newDocumentBuilder();
		Document doc = d.parse(f);
		AddressBook a = new AddressBook();
		System.out.println(doc.getDocumentElement().getNodeName());
		if(doc.getDocumentElement().getNodeName().equals("AddressBook")){ //else not an AddressBook
			NodeList lst = doc.getDocumentElement().getChildNodes(); //get BuddyInfos
			for(int ii=0; ii<lst.getLength(); ii++){
				Node n = lst.item(ii);
				System.out.println("\t" + n.getNodeName());
				if(n.getNodeName().equals("BuddyInfo")){
					BuddyInfo b = new BuddyInfo();
					NodeList lst2 = n.getChildNodes();
					for(int i=0; i<lst2.getLength(); i++){
						Node nb = lst2.item(i);
						System.out.println("\t\t" + nb.getNodeName());
						if(nb.getNodeName().equals("name")){
							b.setName(nb.getTextContent());
						}
						else if(nb.getNodeName().equals("address")){
							b.setAddress(nb.getTextContent());
						}
						else if(nb.getNodeName().equals("phoneNumber")){
							b.setPhoneNumber(nb.getTextContent());
						}
						else if(nb.getNodeName().equals("#text")){} //ignore without raising errors
						else{
							System.err.println("Invalid AddressBook tag: " + n.getNodeName());
						}
					}
					a.addBuddy(b);
					
				}
				else if(n.getNodeName().equals("#text")){} //ignore without raising errors
				else{
					//System.err.println("Invalid AddressBook tag: " + n.getNodeName());
				}
			}
		}
		else{
			System.err.println("Invalid AddressBook tag: " + doc.getDocumentElement().getNodeName());
		}
		return a;
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
