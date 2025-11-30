package ia32.koliada.finance;

import ia32.koliada.finance.flyweight.CategoryFactory;
import ia32.koliada.finance.flyweight.TransactionContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n=== FLYWEIGHT ===");

        List<TransactionContext> transactions = new ArrayList<>();

        transactions.add(new TransactionContext(new BigDecimal("-150"), "Суші", "Їжа", "food.png", "Red"));
        transactions.add(new TransactionContext(new BigDecimal("-60"), "Кава", "Їжа", "food.png", "Red"));
        transactions.add(new TransactionContext(new BigDecimal("-200"), "Піца", "Їжа", "food.png", "Red"));

        transactions.add(new TransactionContext(new BigDecimal("-8"), "Метро", "Транспорт", "bus.png", "Blue"));
        transactions.add(new TransactionContext(new BigDecimal("-150"), "Таксі", "Транспорт", "bus.png", "Blue"));

        System.out.println("\n--- Вивід списку транзакцій ---");
        for (TransactionContext tx : transactions) {
            tx.showDetails();
        }

        System.out.println("\n-------------------------------------");
        System.out.println("Всього транзакцій створено: " + transactions.size());
        System.out.println("Кількість об'єктів категорій у пам'яті: " + CategoryFactory.getCacheSize());
        System.out.println("=====================================\n");
    }
}