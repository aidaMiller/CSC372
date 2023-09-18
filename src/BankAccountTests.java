import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class BankAccountTests {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private final PrintStream originalOut = System.out;
	
	@BeforeEach
	void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}
	
	@AfterEach
	void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	void testBankAccountDefaults() {
		BankAccount testAccount = new BankAccount("John", "Smith", 1234);
		assertEquals(testAccount.getFirstName(), "John");
		assertEquals(testAccount.getLastName(), "Smith");
		assertEquals(testAccount.getAccountID(), 1234);
		assertEquals(testAccount.getBalance(), 0);
	}
	
	@Test
	void testBankAccountDepositsCorrectly() {
		BankAccount testAccount = new BankAccount("John", "Smith", 1234);
		assertEquals(testAccount.getBalance(), 0);
		
		testAccount.deposit(35);
		assertEquals(testAccount.getBalance(), 35);
		
		testAccount.deposit(200);
		assertEquals(testAccount.getBalance(), 235);
	}
	
	@Test
	void testBankAccountWithdrawalsCorrectly() {
		BankAccount testAccount = new BankAccount("John", "Smith", 1234);
		assertEquals(testAccount.getBalance(), 0);
		
		testAccount.deposit(35);
		assertEquals(testAccount.getBalance(), 35);
		
		assertTrue(testAccount.withdrawal(20));
		assertEquals(testAccount.getBalance(), 15);
		
		assertFalse(testAccount.withdrawal(20));
		assertEquals(testAccount.getBalance(), 15);
	}
	
	@Test
	void testSetFisrtName() {
		BankAccount testAccount = new BankAccount("John", "Smith", 1234);
		testAccount.setFirstName("Mia");
		assertEquals(testAccount.getFirstName(), "Mia");
	
	}
	
	@Test
	void testSetLastName() {
		BankAccount testAccount = new BankAccount("John", "Smith", 1234);
		testAccount.setLastName("Miller");
		assertEquals(testAccount.getLastName(), "Miller");
	
	}
	
	@Test
	void testAccountID() {
		BankAccount testAccount = new BankAccount("John", "Smith", 1234);
		testAccount.setAccountID(567);
		assertEquals(testAccount.getAccountID(), 567);
	
	}
	
	@Test
	void testAccountSummary() { 
		BankAccount testAccount = new BankAccount("John", "Smith", 1234);
		testAccount.accountSummary();
		assertEquals(outContent.toString().trim(), "Account Summary\nFirst Name: John\nLast Name: Smith\nAccount ID: 1234\nBalance: 0.0");
		
		
	}

}
