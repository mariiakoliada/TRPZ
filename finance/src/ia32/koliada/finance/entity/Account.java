package ia32.koliada.finance.entity;

import java.math.BigDecimal;

public class Account {
    private Long id;
    private Long userId;
    private String name;
    private BigDecimal balance;

    public Account(Long id, Long userId, String name, BigDecimal balance) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.balance = balance;
    }

    public Long getId() { return id; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " (" + balance + " грн)"; // Це буде видно в ComboBox
    }
}
