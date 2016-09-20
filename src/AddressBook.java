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
}
