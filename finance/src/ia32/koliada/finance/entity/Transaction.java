package ia32.koliada.finance.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private Long id;
    private Long accountId;
    private Long categoryId;
    private BigDecimal amount;
    private LocalDateTime date;
    private String description;

    public Transaction(Long id, Long accountId, Long categoryId, BigDecimal amount, String description) {
        this.id = id;
        this.accountId = accountId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.description = description;
    }

    public BigDecimal getAmount() { return amount; }
    public String getDescription() { return description; }

    public String getFormattedDate() {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}