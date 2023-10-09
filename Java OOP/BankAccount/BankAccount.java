public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts = 0;
    private static double totalAmountStored = 0;

    // Constructor to initialize the account with a random account number
    public BankAccount() {
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        numberOfAccounts++; // Increment the account count
    }

    // Getter method for checking balance
    public double getCheckingBalance() {
        return checkingBalance;
    }

    // Getter method for savings balance
    public double getSavingsBalance() {
        return savingsBalance;
    }

    // Method to deposit money into the specified account type
    public void deposit(String accountType, double amount) {
        if ("checking".equalsIgnoreCase(accountType)) {
            checkingBalance += amount;
        } else if ("savings".equalsIgnoreCase(accountType)) {
            savingsBalance += amount;
        }
        totalAmountStored += amount;
    }

    // Method to withdraw money from the specified account type
    public void withdraw(String accountType, double amount) {
        if (("checking".equalsIgnoreCase(accountType) && checkingBalance >= amount) ||
                ("savings".equalsIgnoreCase(accountType) && savingsBalance >= amount)) {
            if ("checking".equalsIgnoreCase(accountType)) {
                checkingBalance -= amount;
            } else {
                savingsBalance -= amount;
            }
            totalAmountStored -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    // Method to display the total money from checking and savings
    public void displayTotalBalance() {
        double totalBalance = checkingBalance + savingsBalance;
        System.out.println("Total money in checking and savings accounts: $" + totalBalance);
    }

    // Static method to get the number of accounts created so far
    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    // Static method to get the total amount of money stored in all accounts
    public static double getTotalAmountStored() {
        return totalAmountStored;
    }
}
