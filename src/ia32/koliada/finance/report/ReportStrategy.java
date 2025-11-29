package ia32.koliada.finance.report;

import ia32.koliada.finance.entity.Transaction;
import java.util.List;

public interface ReportStrategy {
    void generate(List<Transaction> transactions);
}
