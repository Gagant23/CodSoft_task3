import java.util.Scanner;

public class Task_3 {

    public static class BankAcc {
        double Balance;

        BankAcc(double Amount) {
            this.Balance = Amount;
        }

        public void deposit(double amount) {
            Balance += amount;
            System.out.println("Amount deposited successfully");
        }

        public double withdraw(double amount) {
            if (amount > Balance) {
                System.out.println("Insufficient Balance!");
            } else {
                Balance -= amount;
                System.out.println("Amount withdrawn successfully!");
            }
            return Balance;
        }

        public double getBalance() {
            if (Balance == 0) {
                System.out.println("Account is empty!");
            } else {
                System.out.println("Your Balance = " + Balance);
            }
            return Balance;
        }
    }

    public static class ATM {
        BankAcc account;
        Scanner sc;

        ATM(BankAcc account) {
            this.account = account;
            sc = new Scanner(System.in);
        }

        public void displayOption() {
            System.out.println();
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice : ");
            
        }

        public void start() {
            boolean exit = false;
            while (!exit) {
                displayOption();
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter the amount to withdraw : ");
                        double withdrawAmount = sc.nextDouble();
                        if (account.withdraw(withdrawAmount) != 0) {
                            System.out.println("Withdrawal successful!");
                        }
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit : ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 3:
                        account.getBalance();
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Thank you for using our ATM!");
                        break;
                    default:
                        System.out.println("Invalid input. Please try again!");
                }
            }
        }
    }

    public static void main(String[] args) {
        BankAcc account = new BankAcc(10000);
        ATM atm = new ATM(account);
        atm.start();
    }
}
