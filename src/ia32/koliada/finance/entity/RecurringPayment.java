package ia32.koliada.finance.entity;

import java.math.BigDecimal;

public class RecurringPayment implements Cloneable {
    private Long accountId;
    private Long categoryId;
    private BigDecimal amount;
    private String frequency;

    public RecurringPayment(Long accountId, Long categoryId, BigDecimal amount, String frequency) {
        this.accountId = accountId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.frequency = frequency;
    }

    public Transaction createTransaction() {
        return new Transaction(
                null,
                this.accountId,
                this.categoryId,
                this.amount,
                "Auto-payment: " + this.frequency
        );
    }

    @Override
    public RecurringPayment clone() {
        try {
            return (RecurringPayment) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}