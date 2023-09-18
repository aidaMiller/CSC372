
public class CheckingAccount extends BankAccount {
	
	double interestRate = 0.001;
	double overdraftFee = 30.0;

	public CheckingAccount(String firstName, String lastName, int accountID) {
		super(firstName, lastName, accountID);		
	}
	
	@Override
	public boolean withdrawal(double amount) {
		this.balance -= amount;
		if (this.balance < 0) {
			this.balance -= this.overdraftFee;
			System.out.print("Insufficient Funds, a " + overdraftFee + " dollar fee was added, new balance is: " + this.balance + " dollars.");
		}		
		return true;
	}
	
	@Override
	public void accountSummary() {
		super.accountSummary();
		System.out.print("Interest Rate: " + this.interestRate);
	}
	
}
