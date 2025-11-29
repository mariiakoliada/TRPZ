package ia32.koliada.finance.builder;

import ia32.koliada.finance.entity.Transaction;
import java.math.BigDecimal;

public interface TransactionBuilder {
    TransactionBuilder setAccountId(Long accountId);
    TransactionBuilder setCategory(Long categoryId);
    TransactionBuilder setAmount(BigDecimal amount);
    TransactionBuilder setDescription(String description);
    TransactionBuilder setType(String type);
    TransactionBuilder setCurrentDate(); // Автоматичне встановлення дати

    Transaction build();
}