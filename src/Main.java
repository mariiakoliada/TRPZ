package ia32.koliada.finance;

import ia32.koliada.finance.entity.Account;
import ia32.koliada.finance.repository.AccountRepository;
import ia32.koliada.finance.service.FinanceService;
import ia32.koliada.finance.ui.MainWindow;

import javax.swing.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        initMockData();

        SwingUtilities.invokeLater(() -> {
            FinanceService service = new FinanceService();
            MainWindow window = new MainWindow(service);
            window.setVisible(true); // Показуємо Форму 1
        });
    }

    private static void initMockData() {
        AccountRepository repo = new AccountRepository();
        repo.save(new Account(1L, 100L, "Monobank (White)", new BigDecimal("5000.00")));
        repo.save(new Account(2L, 100L, "Готівка", new BigDecimal("1200.00")));
        repo.save(new Account(3L, 100L, "Скарбничка", new BigDecimal("10000.00")));
        System.out.println(">>> Тестові дані завантажено.");
    }
}