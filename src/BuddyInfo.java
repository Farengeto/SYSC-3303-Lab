
public class BuddyInfo {
	private String name;
	private String address;
	private String phoneNumber;
	
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
	
}
