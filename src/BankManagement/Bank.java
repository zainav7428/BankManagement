package BankManagement;

public class Bank {

    private BankAccount account;

    // Create Account
    public void createAccount(String name, int accountNumber, double balance) {

        account = new BankAccount(name, accountNumber, balance);

        System.out.println("Account Created Successfully!");
    }

    // Login Account
    public boolean loginAccount(String name, int accountNumber) {

        if (account == null) {
            return false;
        }

        return account.getAccountHolder().equals(name)
                && account.getAccountNumber() == accountNumber;
    }

    // Get account
    public BankAccount getAccount() {
        return account;
    }
}