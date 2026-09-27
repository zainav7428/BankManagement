package BankManagement;

public class BankAccount {

    private String accountHolder;
    private int accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter for account holder
    public String getAccountHolder() {
        return accountHolder;
    }

    // Getter for account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Check balance
    public double checkBalance() {
        return balance;
    }

    // Deposit money
    public void deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;
            System.out.println("₹" + amount + " deposited successfully.");
            System.out.println("Current Balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        }
        else if (amount > balance) {
            System.out.println("Insufficient Balance.");
        }
        else {
            balance = balance - amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
            System.out.println("Current Balance: ₹" + balance);
        }
    }

    // Account details
    public void accountDetails() {

        System.out.println("\n===== ACCOUNT DETAILS =====");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance        : ₹" + balance);
    }
}