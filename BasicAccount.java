public class BasicAccount implements IAccount {

    private int accountNumber;
    private double balance;
    private double withdrawLimit;

    public BasicAccount(int accountNumber, double withdrawLimit) {
        this.accountNumber = accountNumber;
        this.withdrawLimit = withdrawLimit;
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

        // Apply withdrawal limit
        double allowed = Math.min(amount, withdrawLimit);

        // No credit limit (cannot go below 0)
        allowed = Math.min(allowed, balance);

        balance -= allowed;
        return allowed;
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
