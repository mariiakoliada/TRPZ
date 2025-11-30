package ia32.koliada.finance.decorator;

import ia32.koliada.finance.entity.Transaction;

public class SimpleTransactionPrinter implements TransactionPrinter {
    @Override
    public String print(Transaction transaction) {
        // Базовий вивід: "Опис: сума"
        return transaction.getDescription() + ": " + transaction.getAmount() + " грн";
    }
}