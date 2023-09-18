
public class Main {

	public static void main(String[] args) {
		BankAccount bills = new BankAccount("Wes", "Miller", 2635);
		bills.accountSummary();
		bills.deposit(65);
		bills.accountSummary();

	}

}
