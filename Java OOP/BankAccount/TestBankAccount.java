public class TestBankAccount {
    public static void main(String[] args) {
        // Creating a bank account
        BankAccount account = new BankAccount();

        // Depositing money into checking and savings accounts
        account.deposit("checking", 1000);
        account.deposit("savings", 500);

        // Displaying account information
        System.out.println("Account Information:");
        System.out.println("Checking Balance: $" + account.getCheckingBalance());
        System.out.println("Savings Balance: $" + account.getSavingsBalance());

        // Withdrawing money from accounts
        account.withdraw("checking", 200);
        account.withdraw("savings", 700); // This should display an insufficient funds message

        // Displaying updated account information
        System.out.println("\nAfter Withdrawal:");
        System.out.println("Checking Balance: $" + account.getCheckingBalance());
        System.out.println("Savings Balance: $" + account.getSavingsBalance());

        // Displaying the total number of accounts created and total amount stored
        System.out.println("\nNumber of accounts created: " + BankAccount.getNumberOfAccounts());
        System.out.println("Total amount stored in all accounts: $" + BankAccount.getTotalAmountStored());
    }
}
