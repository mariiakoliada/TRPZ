package ia32.koliada.finance.bridge;

import ia32.koliada.finance.entity.Transaction;
import java.util.List;

public class MonthlyReport extends Report {
    private List<Transaction> transactions;

    public MonthlyReport(ReportFormat format, List<Transaction> transactions) {
        super(format);
        this.transactions = transactions;
    }

    @Override
    public void buildReport() {
        format.generateHeader("Місячний звіт");

        StringBuilder body = new StringBuilder();
        for (Transaction t : transactions) {
            body.append("\n - ").append(t.getDescription())
                    .append(": ").append(t.getAmount()).append(" грн");
        }

        format.generateBody(body.toString());
        format.generateFooter();
    }
}