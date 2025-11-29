package ia32.koliada.finance.builder;

import ia32.koliada.finance.entity.Transaction;
import java.math.BigDecimal;

public class TransactionDirector {

    public Transaction constructCoffeeTransaction(TransactionBuilder builder, Long accountId) {
        return builder.setAccountId(accountId)
                .setCategory(5L) // ID категорії "Їжа"
                .setAmount(new BigDecimal("-60.00"))
                .setDescription("Ранкова кава")
                .setType("EXPENSE")
                .setCurrentDate()
                .build();
    }

    public Transaction constructSalaryTransaction(TransactionBuilder builder, Long accountId) {
        return builder.setAccountId(accountId)
                .setCategory(1L) // ID категорії "Зарплата"
                .setAmount(new BigDecimal("25000.00"))
                .setDescription("Зарплата за місяць")
                .setType("INCOME")
                .setCurrentDate()
                .build();
    }
}