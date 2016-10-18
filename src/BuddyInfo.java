
public class BuddyInfo {
	private String name;
	private String address;
	private String phoneNumber;
	
	public BuddyInfo(){
		this(null,null,null);
	}
	
	public BuddyInfo(String name, String address, String phoneNumber){
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public static void main(String[] args) {
		System.out.println("Buddy Info:");
		BuddyInfo b = new BuddyInfo();
		b.setName("Homer");
		System.out.println("Hello, " + b.getName() + "!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String toString(){
		return name + ": " + address + ", " + phoneNumber;
	}
	
	public boolean equals(BuddyInfo b){
		return (name.equals(b.getName()) && address.equals(b.getAddress()) && phoneNumber.equals(b.getPhoneNumber()));
	}
	
}
