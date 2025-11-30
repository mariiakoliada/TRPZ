package ia32.koliada.finance.flyweight;

import java.math.BigDecimal;

public class TransactionContext {
    private BigDecimal amount;
    private String description;

    private CategoryFlyweight category;

    public TransactionContext(BigDecimal amount, String description, String catName, String icon, String color) {
        this.amount = amount;
        this.description = description;
        this.category = CategoryFactory.getCategory(catName, icon, color);
    }

    public void showDetails() {
        category.display(description, amount);
    }
}