import java.util.ArrayList;
public class AddressBook {
	ArrayList<BuddyInfo> buddies;
	
	public AddressBook(){
		buddies = new ArrayList<>();
	}
	
	public static void main(String[] args){
		BuddyInfo buddy = new BuddyInfo("Homer","Carleton","613-123-4567");
		AddressBook book = new AddressBook();
		book.addBuddy(buddy);
		System.out.println("Address Book");
	}
	
	public void addBuddy(BuddyInfo buddy){
		buddies.add(buddy);
	}
	
	public void removeBuddy(BuddyInfo buddy){
		buddies.remove(buddy);
	}
	
	public ArrayList<BuddyInfo> getBuddies(){
		return buddies;
	}
	
	public void helloWorld(){
		System.out.println("Hello World!");
	}
	
	public String toString(){
		String s = "";
		for(BuddyInfo b : buddies){
			s += b.toString() + '\n';
		}
		return s;
	}
}
