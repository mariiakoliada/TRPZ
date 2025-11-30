package ia32.koliada.finance.decorator;

import ia32.koliada.finance.entity.Transaction;

public class SecurePrinter extends PrinterDecorator {

    public SecurePrinter(TransactionPrinter wrappee) {
        super(wrappee);
    }

    @Override
    public String print(Transaction transaction) {
        String original = super.print(transaction);
        return "[SECURE] " + original.replaceAll("\\d", "*");
    }
}