/**
 * This class tests the BankAccount class.
 * You will need to add to it incrementally as you implement
 * the methods of the BankAccount class.
 * 
 */
public class TestBankAccount {

    public static void main(String[] args) {
        // instantiate 3 BankAccount objects
        BankAccount myCurrentAccount = new BankAccount(BankAccount.AccountType.CURRENT, "003456CURRENT");
        BankAccount mySavingsAccount = new BankAccount(BankAccount.AccountType.SAVINGS, "003456SAVINGS");
        BankAccount yourCurrentAccount = new BankAccount(BankAccount.AccountType.CURRENT, "003457CURRENT", 1000.00);
        BankAccount lowBudgetAccount = new BankAccount(BankAccount.AccountType.SAVINGS, "001222SAVINGS", 0);

        // deposit amount in accounts
        myCurrentAccount.deposit(5000);
        mySavingsAccount.deposit(500);

        // Perform monthly maintenance
        System.out.println("Getting Bank Account Maintenance Updates...\n");

        System.out.printf("ID: %s\n", myCurrentAccount.getAccountID());
        myCurrentAccount.performMonthlyMaintenance();

        System.out.printf("ID: %s\n", mySavingsAccount.getAccountID());
        mySavingsAccount.performMonthlyMaintenance();

        System.out.printf("ID: %s\n", yourCurrentAccount.getAccountID());
        yourCurrentAccount.performMonthlyMaintenance();

        // perform bank transfer
        myCurrentAccount.transfer(true, mySavingsAccount, 100);
        System.out.println();
        yourCurrentAccount.transfer(false, myCurrentAccount, 60);

        // display new account balance
        System.out.println("\nGetting Account Balance Updates...\n");
        System.out.printf("ID: %s\n", myCurrentAccount.getAccountID());
        System.out.printf("Balance: %s\n\n", myCurrentAccount.getBalance());

        System.out.printf("ID: %s\n", mySavingsAccount.getAccountID());
        System.out.printf("Balance: %s\n\n", mySavingsAccount.getBalance());

        System.out.printf("ID: %s\n", yourCurrentAccount.getAccountID());
        System.out.printf("Balance: %s\n\n", yourCurrentAccount.getBalance());

        /* 
        * test failed withdrawal cases
        *
        */
        
        System.out.println("Testing failed withdrawal cases...\n");
        
        // test insufficient balance
        myCurrentAccount.withdraw(5000);

        // test withdrawal limit
        mySavingsAccount.withdraw(50);
        mySavingsAccount.withdraw(50);
        mySavingsAccount.withdraw(50);

        // test in the red
        lowBudgetAccount.withdraw(100);

    }
}
