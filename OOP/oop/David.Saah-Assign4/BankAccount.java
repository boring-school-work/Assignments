/**
 * This class represents a bank account.
 * 
 * The account may be a current account or a savings account.
 * Current accounts must maintain a minimum balance of GHC 6.00,
 * while savings accounts must maintain a minimum balance of 30.00.
 * Current accounts have a monthly maintenance fee of GHC 2.00,
 * whereas savings accounts have no monthly maintenance fee.
 * Savings accounts have an interest rate of 6%,
 * but current accounts have no interest.
 * Lastly, withdrawals from savings accounts may only be be made 2 times a
 * month, whereas there is no limit on withdrawals from current accounts.
 *
 * @author David Saah
 * @version 1.0
 * @since 2023-03-24
 * 
 */
public class BankAccount {

    // Defined enumeration specifying the valid types of accounts
    public enum AccountType {
        CURRENT,
        SAVINGS,
    }

    private AccountType acctType; // type of account (CURRENT or SAVINGS)
    private String acctID; // account's identifier
    private double balance; // current balance
    private int numWithdrawals; // number of withdrawals made in the current month
    private boolean inTheRed; // whether the balance is less than the minimum required balance
    private double minBalance; // minimum balance requirement
    private double interestRate; // annual interest rate
    private double maintenanceFee; // maintenance fee
    private int withdrawalLimit; // maximum number of withdrawals per month.

    // Defined constants
    public static final int MONTHS_PER_YEAR = 12;
    public static final double SAVINGS_ACCT_MIN_BALANCE = 30.0;
    public static final double CURRENT_ACCT_MIN_BALANCE = 6.00;
    public static final double SAVINGS_ACCT_INTEREST_RATE = 0.06;
    public static final double CURRENT_ACCT_MAINTENANCE_FEE = 2.00;
    public static final int SAVINGS_WITHDRAWAL_LIMIT = 2;

    /**
     * Default constructor for Bank Account
     * Sets the default values for a bank account based on the account type
     * 
     * @param type account type, whether SAVINGS or CURRENT
     * @param id   account ID
     */
    public BankAccount(AccountType type, String id) {
        acctType = type;
        acctID = id;
        balance = 0;
        numWithdrawals = 0;

        if (acctType == AccountType.CURRENT) {
            minBalance = CURRENT_ACCT_MIN_BALANCE;
            interestRate = 0;
            maintenanceFee = CURRENT_ACCT_MAINTENANCE_FEE;
            withdrawalLimit = -1;
        }

        if (acctType == AccountType.SAVINGS) {
            minBalance = SAVINGS_ACCT_MIN_BALANCE;
            interestRate = SAVINGS_ACCT_INTEREST_RATE;
            maintenanceFee = 0;
            withdrawalLimit = SAVINGS_WITHDRAWAL_LIMIT;
        }

        inTheRed = (balance < minBalance);
    }

    /**
     * A constructor that sets account type, id and opening balance
     * 
     * @param type           account type, whether SAVINGS or CURRENT
     * @param id             account ID
     * @param openingBalance money to start your account with
     */
    public BankAccount(AccountType type, String id, double openingBalance) {
        acctType = type;
        acctID = id;
        balance = openingBalance;
        numWithdrawals = 0;

        if (acctType == AccountType.CURRENT) {
            minBalance = CURRENT_ACCT_MIN_BALANCE;
            interestRate = 0;
            maintenanceFee = CURRENT_ACCT_MAINTENANCE_FEE;
            withdrawalLimit = -1;
        }

        if (acctType == AccountType.SAVINGS) {
            minBalance = SAVINGS_ACCT_MIN_BALANCE;
            interestRate = SAVINGS_ACCT_INTEREST_RATE;
            maintenanceFee = 0;
            withdrawalLimit = SAVINGS_WITHDRAWAL_LIMIT;
        }

        inTheRed = (balance < minBalance);
    }

    /**
     * Gets the current balance
     * 
     * @return the current bank balance
     * 
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the bank account type
     * 
     * @return the type of account type
     * 
     */
    public AccountType getAccountType() {
        return acctType;
    }

    /**
     * Gets the account ID
     * 
     * @return the account ID
     * 
     */
    public String getAccountID() {
        return acctID;
    }

    /**
     * Gets the minimum balance requirement for a bank account type
     * 
     * @return the minimum balance requirement
     * 
     */
    public double getMinBalance() {
        return minBalance;
    }

    /**
     * Withdraws an amount from a Bank Account
     * Displays an error message if withdrawal failed
     * 
     * @param amount the amount to be withdrawn
     * @return whether or not thewithdrawal transaction was successful
     * 
     */
    public boolean withdraw(double amount) {
        double newBalance = getBalance() - amount;

        // check if withdrawal limit is exceeded
        // Account for the exception (when limit == -1)
        // The exception indicates unlimited withdrawals
        if ((numWithdrawals >= withdrawalLimit) && (withdrawalLimit != -1)) {
            System.out.println("Transaction unsuccessful: Withdrawal limit exceeded!");
        }

        // check if bank account is "in the red"
        else if (inTheRed) {
            System.out.println("Transaction unsuccessful: Account balance in the red!");
        }

        // check if new balance as a result of withdrawal
        // is lower than the minimum balance requirement
        else if (newBalance < getMinBalance()) {
            System.out.println("Transaction unsuccessful: Insufficient balance!");
        }

        // when checks have passed, perform withdrawal transaction
        else {
            balance = newBalance;

            // increase the number of withdrawsals
            numWithdrawals++;
            System.out.printf("Transaction successful: Withdrawal from %s complete!\n", getAccountID());
            return true;
        }

        return false;
    }

    /**
     * Deposits an amount into a Bank Account
     * 
     * @param amount the amount of money to be deposited
     * 
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Performs a monthly maintenance on Bank Account.
     * It checks and updates the balance with interest earned.
     * It resets the withdrawal limit and checks if account is in the red.
     * It finally displays Bank Account details after maintenance.
     * 
     */
    public void performMonthlyMaintenance() {
        // calculate the interest per month
        double interest = (getBalance() * interestRate) / MONTHS_PER_YEAR;

        // perform updates
        balance += interest;
        balance -= maintenanceFee;
        inTheRed = getBalance() < getMinBalance();
        numWithdrawals = 0;

        // display bank account info after maintenance
        System.out.printf("Earned interest: %.2f\nMaintenance fee: %.2f\nUpdated balance: %.2f\n\n",
                interest, maintenanceFee, getBalance());

        // check if account is in the red and display a warning message
        if (inTheRed) {
            System.out.println("WARNING: This account is in the red!");
        }

    }

    /**
     * Performs a bank transfer from one account to another
     * 
     * @param transferTo   specifies whether the transfer is from the current bank
     *                     account or otherAccount
     * @param otherAccount another bank account
     * @param amount       the amount to be transferred
     * @return whether or not the transfer transaction was successful
     * 
     */
    public boolean transfer(boolean transferTo, BankAccount otherAccount, double amount) {
        if (transferTo) {
            if (this.withdraw(amount)) {
                otherAccount.deposit(amount);
            System.out.printf("Transaction successful: Transfer to %s complete!\n", otherAccount.getAccountID());
                return true;
            }
        } else {
            if (otherAccount.withdraw(amount)) {
                this.deposit(amount);
                System.out.printf("Transaction successful: Transfer to %s complete!\n", this.getAccountID());
                return true;
            }
        }

        System.out.println("Transaction unsuccessful!");
        return false;
    }
}
