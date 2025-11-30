package ia32.koliada.finance;

import ia32.koliada.finance.bridge.*;
import ia32.koliada.finance.entity.Transaction;
import ia32.koliada.finance.service.FinanceService;
import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FinanceService service = new FinanceService();
        service.addTransaction(1L, 1L, new BigDecimal("-120.00"), "Обід");
        service.addTransaction(1L, 2L, new BigDecimal("-50.00"), "Проїзд");
        List<Transaction> data = service.getAllTransactions();

        System.out.println("\n=== BRIDGE ===");

        Report textReport = new MonthlyReport(new TextFormat(), data);
        textReport.buildReport();

        System.out.println("\n-----------------------------------\n");

        Report pdfReport = new MonthlyReport(new PdfFormat(), data);
        pdfReport.buildReport();

        System.out.println("=====================================\n");
    }
}