package ia32.koliada.finance.builder;

import ia32.koliada.finance.entity.Transaction;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SimpleTransactionBuilder implements TransactionBuilder {
    private Transaction transaction;

    public SimpleTransactionBuilder() {
        this.transaction = new Transaction();
    }

    @Override
    public TransactionBuilder setAccountId(Long accountId) {
        transaction.setAccountId(accountId);
        return this;
    }

    @Override
    public TransactionBuilder setCategory(Long categoryId) {
        transaction.setCategoryId(categoryId);
        return this;
    }

    @Override
    public TransactionBuilder setAmount(BigDecimal amount) {
        transaction.setAmount(amount);
        return this;
    }

    @Override
    public TransactionBuilder setDescription(String description) {
        transaction.setDescription(description);
        return this;
    }

    @Override
    public TransactionBuilder setType(String type) {
        transaction.setType(type);
        return this;
    }

    @Override
    public TransactionBuilder setCurrentDate() {
        transaction.setDate(LocalDateTime.now());
        return this;
    }

    @Override
    public Transaction build() {
        if (transaction.getAmount() == null) {
            throw new IllegalStateException("Сума транзакції не може бути пустою!");
        }
        return transaction;
    }
}
