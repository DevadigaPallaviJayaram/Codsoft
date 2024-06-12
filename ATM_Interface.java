
//********************   ATM_INTERFACE   ***************************


import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialAmount) {
        this.balance = initialAmount;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + " Rs was successful.");
        } else {
            System.out.println("Invalid entry! Please choose a number above 0.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " Rs was successful.");
        } else {
            System.out.println("Invalid entry! Insufficient balance or negative value entered.");
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Select Options:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Leave");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            displayMenu();
            System.out.print("Pick an option: ");
            while (!sc.hasNextInt()) {
                System.out.print("Invalid entry! Please enter a number: ");
                sc.next();
            }
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Invalid entry! Please enter a number: ");
                        sc.next();
                    }
                    int depositAmount = sc.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Invalid entry! Please enter a number: ");
                        sc.next();
                    }
                    int withdrawAmount = sc.nextInt();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance() + " Rs");
                    break;
                case 4:
                    System.out.println("Thanks for using DPJ Bank.");
                    break;
                default:
                    System.out.println("Invalid entry! Enter only the given options.");
            }
        } while (option != 4);
        sc.close();
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(30000);
        ATM atm = new ATM(userAccount);
        System.out.print("Enter Your PIN: ");
        String pin = sc.nextLine();
        if (pin.equals("1234")) {
            atm.run();
        } else {
            System.out.println("Wrong PIN.");
        }
        sc.close();
    }
}


