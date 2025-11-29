package ia32.koliada.finance.report;

import ia32.koliada.finance.entity.Transaction;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvReportStrategy implements ReportStrategy {
    @Override
    public void generate(List<Transaction> transactions) {
        String filename = "finance_report.csv"; // Назва файлу

        System.out.println(">>> Розпочато експорт у файл " + filename + "...");

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Date;Description;Amount");

            for (Transaction t : transactions) {
                writer.printf("%s;%s;%s%n",
                        t.getFormattedDate(),
                        t.getDescription(),
                        t.getAmount());
            }

            System.out.println(">>> Звіт успішно збережено у файл: " + filename);
            System.out.println(">>> (Ви можете знайти його в папці проєкту)");

        } catch (IOException e) {
            System.err.println("Помилка при запису файлу: " + e.getMessage());
        }
    }
}