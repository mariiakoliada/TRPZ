package ia32.koliada.finance.decorator;

import ia32.koliada.finance.entity.Transaction;

public class HtmlPrinter extends PrinterDecorator {

    public HtmlPrinter(TransactionPrinter wrappee) {
        super(wrappee);
    }

    @Override
    public String print(Transaction transaction) {
        return "<tr><td>" + super.print(transaction) + "</td></tr>";
    }
}