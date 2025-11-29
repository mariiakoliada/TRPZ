package ia32.koliada.finance.service;

import ia32.koliada.finance.entity.Transaction;
import ia32.koliada.finance.report.ReportStrategy;
import java.util.List;

public class ReportService {
    private ReportStrategy strategy;

    public ReportService(ReportStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ReportStrategy strategy) {
        this.strategy = strategy;
    }

    public void createReport(List<Transaction> transactions) {
        strategy.generate(transactions);
    }
}