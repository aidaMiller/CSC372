import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.border.Border;


public class BankGUI {
	
	JPanel depositPanel;
	JButton depositButton;
	JButton withdrawButton;
	JTextField depositField;
	JFrame frame;
	JLabel accountBalance;
	JTextField withdrawField;
	JPanel withdrawPanel;
	
	public static void main(String[] args) {
		BankGUI bank = new BankGUI();
	}
	
	public BankGUI() {
		BankAccount peppasChecking = new CheckingAccount("Peppa", "Pig", 1);
		this.setupGUI(peppasChecking);
	}
	
	private void setupGUI(BankAccount bankAccount) {
		
	    frame = new JFrame();
		frame.setTitle("Bank of Piggy"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Lets us close the application 
		frame.setResizable(false); 		
		frame.setVisible(true); //Make the frame visible
		frame.setLayout(new GridLayout(3, 1));
		Border padding = BorderFactory.createEmptyBorder(10,10,10,10);
		
		
//		frame.getContentPane().setBackground(new Color(100,105,150)); 
		
		JPanel accountsPanel = new JPanel(new GridLayout(1, 4));
		frame.add(accountsPanel);
		accountsPanel.setBorder(padding);
		
		JLabel accountName = new JLabel(bankAccount.getFirstName() + "'s checking");
		accountsPanel.add(accountName);
				
		String balance = this.balanceToDollars(bankAccount.getBalance());
	    accountBalance = new JLabel(balance);
		accountsPanel.add(accountBalance);
		
		depositButton = new JButton("Deposit");
		depositButton.addActionListener(e -> this.startDeposit());
		accountsPanel.add(depositButton);
		
		
		withdrawButton = new JButton("Withdraw");
		withdrawButton.addActionListener(e -> this.startWithdraw());
		accountsPanel.add(withdrawButton);
	
	    depositPanel = new JPanel(new GridLayout(1, 3));
		depositPanel.setBorder(padding);
		depositPanel.setVisible(false);
		frame.add(depositPanel);
		
		JLabel depositLabel = new JLabel("Deposit");
		depositPanel.add(depositLabel);
				
		depositField = new JTextField();
		depositPanel.add(depositField);

		JButton depositAmountButton = new JButton("Deposit");
		depositAmountButton.addActionListener(e -> this.finishDeposit(bankAccount));
		depositPanel.add(depositAmountButton);
		
		//WithdrawPanel
		withdrawPanel = new JPanel(new GridLayout(1, 3));
		withdrawPanel.setBorder(padding);
		withdrawPanel.setVisible(false);
		frame.add(withdrawPanel);
			
		JLabel withdrawLabel = new JLabel("Withdraw");
		withdrawPanel.add(withdrawLabel);
					
		withdrawField = new JTextField();
		withdrawPanel.add(withdrawField);

		JButton withdrawAmountButton = new JButton("Withdraw");
		withdrawAmountButton.addActionListener(e -> this.finishWithdraw(bankAccount));
		withdrawPanel.add(withdrawAmountButton);
		
		frame.pack(); //Sets the size
	}
	private void startDeposit() {
		depositPanel.setVisible(true);
		depositButton.setEnabled(false);
		withdrawButton.setEnabled(false);
	}
	
	private void finishDeposit(BankAccount bankAccount) {
		double amount = Double.parseDouble(depositField.getText());
		bankAccount.deposit(amount);
		depositPanel.setVisible(false);
		depositButton.setEnabled(true);
		withdrawButton.setEnabled(true);
		String balance = this.balanceToDollars(bankAccount.getBalance());
		accountBalance.setText(balance);
	}
	
	private void startWithdraw() {
		withdrawPanel.setVisible(true);
		depositButton.setEnabled(false);
		withdrawButton.setEnabled(false);
	}
	
	private void finishWithdraw(BankAccount bankAccount) {
		double amount = Double.parseDouble(withdrawField.getText());
		bankAccount.withdrawal(amount);
		withdrawPanel.setVisible(false);
		depositButton.setEnabled(true);
		withdrawButton.setEnabled(true);
		String balance = this.balanceToDollars(bankAccount.getBalance());
		accountBalance.setText(balance);
	}
	
	private String balanceToDollars(double amount) {
		NumberFormat formater = NumberFormat.getCurrencyInstance();
		return formater.format(amount);
		
	}
	
	

}
