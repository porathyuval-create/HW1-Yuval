public class StandardAccount implements IAccount {

    private int accountNumber;
    private double balance;
    private double creditLimit; // must be negative or zero

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        // If positive credit limit is sent, treat it as zero
        if (creditLimit > 0) {
            this.creditLimit = 0;
        } else {
            this.creditLimit = creditLimit;
        }
        this.balance = 0;
    }

    @Override
    public void Deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public double Withdraw(double amount) {
        if (amount <= 0) {
            return 0;
        }

        // Maximum amount we can withdraw without exceeding credit limit
        // Example: balance=100, creditLimit=-100 -> maxWithdraw=200
        double maxWithdraw = balance - creditLimit;

        if (maxWithdraw <= 0) {
            return 0;
        }

        double actual = Math.min(amount, maxWithdraw);
        balance -= actual;
        return actual;
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }
}
