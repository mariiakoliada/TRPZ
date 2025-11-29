package ia32.koliada.finance.report;

import ia32.koliada.finance.entity.Transaction;
import java.util.List;

public class ConsoleReportStrategy implements ReportStrategy {
    @Override
    public void generate(List<Transaction> transactions) {
        System.out.println("\n----- ФІНАНСОВИЙ ЗВІТ (Перегляд) -----");
        if (transactions.isEmpty()) {
            System.out.println("Транзакцій не знайдено.");
        } else {
            for (Transaction t : transactions) {
                System.out.printf("Дата: %s | Опис: %-15s | Сума: %s грн%n",
                        t.getFormattedDate(),
                        t.getDescription(),
                        t.getAmount());
            }
        }
        System.out.println("--------------------------------------\n");
    }
}