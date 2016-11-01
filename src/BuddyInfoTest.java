import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BuddyInfoTest {
	BuddyInfo nullBuddy = null;
	BuddyInfo blankBuddy = null;
	BuddyInfo testBuddy = null;
	
	@Before
	public void setUp() {
		blankBuddy = new BuddyInfo();
		testBuddy = new BuddyInfo("Travis", "1234 Fake Street", "(613) 123-4567");
	}
	
	@Test
	public void testCompareInfo(){
		blankBuddy = new BuddyInfo(testBuddy.getName(), testBuddy.getAddress(), testBuddy.getPhoneNumber());
		assertTrue("Should be equal to self.", testBuddy.equals(blankBuddy));
	}
	
	@Test
	public void testName() {
		String name = "John Smith";
		blankBuddy.setName(name);
		assertEquals("Name should be new name.", name, blankBuddy.getName());
	}
	
	@Test
	public void testAddress() {
		String address = "Apt. 789, 4567 Bronson Avenue";
		blankBuddy.setAddress(address);
		assertEquals("Address should be new address.", address, blankBuddy.getAddress());
	}
	
	@Test
	public void testPhoneNumber() {
		String phone = "(416) 098-7654";
		blankBuddy.setPhoneNumber(phone);
		assertEquals("Phone number should be new number.", phone, blankBuddy.getPhoneNumber());
	}
	
	@Test
	public void testCompareToSelf() {
		assertTrue("Should be equal to self.", testBuddy.equals(testBuddy));
	}
	
	@Test
	public void testCompareToNull() {
		assertFalse("Null buddy should be unequal and not get NullPointerException.", testBuddy.equals(nullBuddy));
	}
	
	@Test
	public void testCopyBuddy(){
		blankBuddy = new BuddyInfo(testBuddy);
		assertTrue("Buddies should be equal.", testBuddy.equals(blankBuddy));
	}
	
	@Test
	public void testGreeting() {
		assertEquals("Greeting should match format.", "Hello, " + testBuddy.getName() + "!", testBuddy.greeting());
	}
	
	@Test
	public void testUnder18() {
		testBuddy.setAge(14);
		assertFalse("Should be under 18.", testBuddy.isOver18());
	}
	
	@Test
	public void testOver18() {
		testBuddy.setAge(21);
		assertTrue("Should be over 18.", testBuddy.isOver18());
	}
	
	@Test
	public void testAge18() {
		testBuddy.setAge(18);
		assertTrue("Should be over 18.", testBuddy.isOver18());
	}

}
