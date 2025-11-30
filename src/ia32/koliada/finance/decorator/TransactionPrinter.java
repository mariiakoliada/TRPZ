package ia32.koliada.finance.decorator;

import ia32.koliada.finance.entity.Transaction;

public interface TransactionPrinter {
    String print(Transaction transaction);
}