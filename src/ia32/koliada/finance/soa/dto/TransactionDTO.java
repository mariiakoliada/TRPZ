package ia32.koliada.finance.soa.dto;

import java.math.BigDecimal;

public class TransactionDTO {
    public BigDecimal amount;
    public String description;
    public String category;

    public TransactionDTO() {}
    public TransactionDTO(BigDecimal amount, String description, String category) {
        this.amount = amount;
        this.description = description;
        this.category = category;
    }
}