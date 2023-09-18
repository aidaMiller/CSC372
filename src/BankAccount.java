
public class BankAccount {
	private String firstName;
	private String lastName;
	private int accountID;
	protected double balance;
	
	public BankAccount(String firstName, String lastName, int accountID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = 0;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public boolean withdrawal(double amount) {
		if (amount > this.balance) {
			return false;
		}
		this.balance -= amount;
		return true;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		 this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		 this.lastName = lastName;
	}
	
	public int getAccountID() {
		return this.accountID;
	}
	
	public void setAccountID(int accountID) {
		 this.accountID = accountID;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void accountSummary() {
		System.out.println("Account Summary" );
		System.out.println("First Name: " + this.firstName);
		System.out.println("Last Name: " + this.lastName);
		System.out.println("Account ID: " + this.accountID);
		System.out.println("Balance: " + this.balance);
	}
}
