package ia32.koliada.finance.repository;

import ia32.koliada.finance.entity.Transaction;
import ia32.koliada.finance.config.DatabaseConnection;
import java.util.Optional;

public class TransactionRepository implements IRepository<Transaction> {

    public TransactionRepository() {
        DatabaseConnection.getInstance();
    }

    @Override
    public void save(Transaction transaction) {
        System.out.println("SQL >>> Вставка транзакції в БД: " + transaction);
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {}
}