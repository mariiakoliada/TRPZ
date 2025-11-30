package ia32.koliada.finance.decorator;

import ia32.koliada.finance.entity.Transaction;

public abstract class PrinterDecorator implements TransactionPrinter {
    protected TransactionPrinter wrappee;

    public PrinterDecorator(TransactionPrinter wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public String print(Transaction transaction) {
        return wrappee.print(transaction);
    }
}