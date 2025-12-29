import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {

    private List<IAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    @Override
    public void OpenAccount(IAccount account) {
        if (account != null) {
            accounts.add(account);
        }
    }

    @Override
    public void CloseAccount(int accountNumber) {
        IAccount toRemove = null;

        for (IAccount account : accounts) {
            if (account.GetAccountNumber() == accountNumber) {
                toRemove = account;
                break;
            }
        }

        if (toRemove == null) {
            return;
        }

        if (toRemove.GetCurrentBalance() >= 0) {
            accounts.remove(toRemove);
        } else {
            System.out.println("Account is not closed due to debt");
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> result = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() < 0) {
                result.add(account);
            }
        }
        return result;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double amount) {
        List<IAccount> result = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() > amount) {
                result.add(account);
            }
        }
        return result;
    }
}
