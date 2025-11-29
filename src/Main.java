package ia32.koliada.finance;

import ia32.koliada.finance.entity.Account;
import ia32.koliada.finance.entity.Transaction;
import ia32.koliada.finance.report.ConsoleReportStrategy;
import ia32.koliada.finance.report.CsvReportStrategy;
import ia32.koliada.finance.repository.AccountRepository;
import ia32.koliada.finance.service.FinanceService;
import ia32.koliada.finance.service.ReportService;
import ia32.koliada.finance.ui.MainWindow;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        initMockData();

        FinanceService financeService = new FinanceService();

        financeService.addTransaction(1L, 1L, new BigDecimal("-250.00"), "Спортзал");

        List<Transaction> myTransactions = financeService.getAllTransactions();

        System.out.println("\n=== ПОЧАТОК ТЕСТУВАННЯ ПАТЕРНУ STRATEGY ===");

        ReportService reportService = new ReportService(new ConsoleReportStrategy());
        reportService.createReport(myTransactions);

        System.out.println("...Користувач змінює налаштування експорту...");

        reportService.setStrategy(new CsvReportStrategy());
        reportService.createReport(myTransactions);

        System.out.println("=== КІНЕЦЬ ТЕСТУВАННЯ ===");

        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(financeService);
            window.setVisible(true);
        });
    }

    private static void initMockData() {
        AccountRepository repo = new AccountRepository();
        repo.save(new Account(1L, 100L, "Monobank (White)", new BigDecimal("5000.00")));
        repo.save(new Account(2L, 100L, "Готівка", new BigDecimal("1200.00")));

        FinanceService fs = new FinanceService();
        fs.addTransaction(1L, 1L, new BigDecimal("-60.00"), "Кава");
    }
}