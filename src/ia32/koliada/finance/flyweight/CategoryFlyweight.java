package ia32.koliada.finance.flyweight;

import java.math.BigDecimal;

public class CategoryFlyweight {
    private String name;
    private String iconName;
    private String colorHex;

    public CategoryFlyweight(String name, String iconName, String colorHex) {
        this.name = name;
        this.iconName = iconName;
        this.colorHex = colorHex;
    }

    public void display(String description, BigDecimal amount) {
        System.out.printf("Відображення: [Категорія: %s | Іконка: %s] -> Транзакція: '%s' (%s грн)%n",
                name, iconName, description, amount);
    }

    @Override
    public String toString() {
        return name;
    }
}