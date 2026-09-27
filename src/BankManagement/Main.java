package BankManagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        System.out.println("=================================");
        System.out.println("       Welcome To InBank");
        System.out.println("=================================");

        while (true) {

            System.out.println("\n========== BANK MENU ==========");
            System.out.println("1. Create Account");
            System.out.println("2. Login Account");
            System.out.println("3. Exit");
            System.out.println("===============================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\n===== CREATE ACCOUNT =====");

                    System.out.print("Enter Your Full Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Account Number: ");
                    int accountNumber = sc.nextInt();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    bank.createAccount(name, accountNumber, balance);

                    break;

                case 2:

                    System.out.println("\n===== LOGIN ACCOUNT =====");

                    System.out.print("Enter Your Full Name: ");
                    String loginName = sc.nextLine();

                    System.out.print("Enter Account Number: ");
                    int loginAccountNumber = sc.nextInt();

                    boolean login = bank.loginAccount(
                            loginName,
                            loginAccountNumber
                    );

                    if (login) {

                        System.out.println("\nLogin Successful!");
                        System.out.println("Welcome, " + loginName);

                        // Logged-in menu
                        while (true) {

                            System.out.println("\n====== ACCOUNT MENU ======");
                            System.out.println("1. Check Balance");
                            System.out.println("2. Deposit Money");
                            System.out.println("3. Withdraw Money");
                            System.out.println("4. Account Details");
                            System.out.println("5. Logout");
                            System.out.println("==========================");

                            System.out.print("Enter your choice: ");
                            int accountChoice = sc.nextInt();

                            switch (accountChoice) {

                                case 1:

                                    System.out.println(
                                            "Current Balance: ₹"
                                                    + bank.getAccount().checkBalance()
                                    );

                                    break;

                                case 2:

                                    System.out.print("Enter amount to deposit: ");
                                    double depositAmount = sc.nextDouble();

                                    bank.getAccount().deposit(depositAmount);

                                    break;

                                case 3:

                                    System.out.print("Enter amount to withdraw: ");
                                    double withdrawAmount = sc.nextDouble();

                                    bank.getAccount().withdraw(withdrawAmount);

                                    break;

                                case 4:

                                    bank.getAccount().accountDetails();

                                    break;

                                case 5:

                                    System.out.println("Logged out successfully.");
                                    break;

                                default:

                                    System.out.println("Invalid choice.");
                            }

                            if (accountChoice == 5) {
                                break;
                            }
                        }

                    } else {

                        System.out.println("\nInvalid Name or Account Number!");
                    }

                    break;

                case 3:

                    System.out.println("\nThank you for using InBank!");
                    sc.close();
                    return;

                default:

                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}