package ia32.koliada.finance.repository;

import ia32.koliada.finance.config.DatabaseConnection;
import ia32.koliada.finance.entity.Account;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AccountRepository implements IRepository<Account> {
    private static Map<Long, Account> fakeDbTable = new HashMap<>();

    public AccountRepository() {
        DatabaseConnection.getInstance();
    }

    @Override
    public void save(Account account) {
        fakeDbTable.put(account.getId(), account);
        System.out.println("SQL >>> UPDATE accounts SET balance = " + account.getBalance() + " WHERE id = " + account.getId());
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.ofNullable(fakeDbTable.get(id));
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(fakeDbTable.values());
    }
}
