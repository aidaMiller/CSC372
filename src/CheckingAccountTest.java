import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckingAccountTest {
	
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
	void testCheckingAccountDefaults() {
		CheckingAccount testAccount = new CheckingAccount("John", "Smith", 1234);
		assertEquals(testAccount.getFirstName(), "John");
		assertEquals(testAccount.getLastName(), "Smith");
		assertEquals(testAccount.getAccountID(), 1234);
		assertEquals(testAccount.getBalance(), 0);
	}
	
	@Test
	void testBankAccountWithdrawalsCorrectly() {
		CheckingAccount testAccount = new CheckingAccount("John", "Smith", 1234);
		assertEquals(testAccount.getBalance(), 0);
		
		testAccount.deposit(35);
		assertEquals(testAccount.getBalance(), 35);
		
		assertTrue(testAccount.withdrawal(20));
		assertEquals(testAccount.getBalance(), 15);
	}
	
	@Test
	void testWithdrawalNegativeDisplaysFee() {
		CheckingAccount testAccount = new CheckingAccount("John", "Smith", 1234);
		assertTrue(testAccount.withdrawal(2));
		assertEquals(testAccount.getBalance(), -32);
		assertEquals(outContent.toString().trim(), "Insufficient Funds, a 30.0 dollar fee was added, new balance is: -32.0 dollars.");
	}
	
	@Test
	void testAccountSummary() { 
		CheckingAccount testAccount = new CheckingAccount("John", "Smith", 1234);
		testAccount.accountSummary();
		assertEquals(outContent.toString().trim(), "Account Summary\nFirst Name: John\nLast Name: Smith\nAccount ID: 1234\nBalance: 0.0\nInterest Rate: 0.001");
		
		
	}

}

