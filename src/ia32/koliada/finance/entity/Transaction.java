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

    private String type; // "INCOME" або "EXPENSE"

    public Transaction() {}

    public void setId(Long id) { this.id = id; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setDate(LocalDateTime date) { this.date = date; }
    public void setDescription(String description) { this.description = description; }
    public void setType(String type) { this.type = type; }

    public BigDecimal getAmount() { return amount; }
    public String getDescription() { return description; }
    public String getFormattedDate() {
        return date != null ? date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) : "N/A";
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s грн (%s)", type, description, amount, getFormattedDate());
    }
}