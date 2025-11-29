package ia32.koliada.finance;

import ia32.koliada.finance.builder.SimpleTransactionBuilder;
import ia32.koliada.finance.builder.TransactionBuilder;
import ia32.koliada.finance.builder.TransactionDirector;
import ia32.koliada.finance.entity.Account;
import ia32.koliada.finance.entity.Transaction;
import ia32.koliada.finance.repository.AccountRepository;
import ia32.koliada.finance.repository.TransactionRepository;
import ia32.koliada.finance.service.FinanceService;
import ia32.koliada.finance.ui.MainWindow;

import javax.swing.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        initMockData();

        System.out.println("\n===BUILDER==");

        TransactionBuilder builder = new SimpleTransactionBuilder();
        Transaction t1 = builder.setAccountId(1L)
                .setAmount(new BigDecimal("-500"))
                .setDescription("Супермаркет")
                .setType("EXPENSE")
                .setCurrentDate()
                .build();

        System.out.println("Створено вручну: " + t1);

        TransactionDirector director = new TransactionDirector();
        Transaction coffee = director.constructCoffeeTransaction(new SimpleTransactionBuilder(), 1L);

        System.out.println("Створено Директором: " + coffee);

        TransactionRepository txRepo = new TransactionRepository();
        txRepo.save(t1);
        txRepo.save(coffee);

        System.out.println("=====================================\n");

        SwingUtilities.invokeLater(() -> {
            FinanceService service = new FinanceService();
            MainWindow window = new MainWindow(service);
            window.setVisible(true);
        });
    }

    private static void initMockData() {
        AccountRepository repo = new AccountRepository();
        repo.save(new Account(1L, 100L, "Monobank", new BigDecimal("5000.00")));
    }
}