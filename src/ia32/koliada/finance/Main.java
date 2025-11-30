package ia32.koliada.finance;

import ia32.koliada.finance.decorator.*;
import ia32.koliada.finance.entity.Transaction;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Transaction tx = new Transaction(1L, 1L, 1L, new BigDecimal("-500.00"), "Подарунок");

        System.out.println("\n===DECORATOR===");

        TransactionPrinter simple = new SimpleTransactionPrinter();
        System.out.println("Simple: " + simple.print(tx));

        TransactionPrinter html = new HtmlPrinter(simple);
        System.out.println("HTML:   " + html.print(tx));

        TransactionPrinter secureHtml = new SecurePrinter(new HtmlPrinter(new SimpleTransactionPrinter()));
        System.out.println("Combo:  " + secureHtml.print(tx));

        System.out.println("====================================\n");
    }
}