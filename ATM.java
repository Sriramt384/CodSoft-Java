import java.util.*;
class BankAccount{
    private double balance;
    public BankAccount(double ini){
        balance=ini;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        balance+=amount;
    }
    public boolean withdraw(double amount){
        if (amount<=balance) {
            balance-=amount;
            return true;
        }
        return false;
    }
}
class ATM{
    private BankAccount account;
    public ATM(BankAccount bankAccount){
        account = bankAccount;
    }
    public void displayMenu(){
        System.out.println("ATM Menu:");
        System.out.println("Enter 1 To Check Balance");
        System.out.println("Enter 2 To Deposit Money");
        System.out.println("Enter 3 To Withdraw");
        System.out.println("Enter 4 To Quit");
    }
    public void run(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Balance: Rs: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Successfully Deposited. New Balance: Rs: " + account.getBalance());
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if(account.withdraw(withdrawAmount)) System.out.println("Withdrawal successful. New balance: Rs: " + account.getBalance()); 
                    else System.out.println("Insufficient balance");
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}
class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
