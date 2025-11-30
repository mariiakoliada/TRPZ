package ia32.koliada.finance.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CategoryFactory {
    private static final Map<String, CategoryFlyweight> cache = new HashMap<>();

    public static CategoryFlyweight getCategory(String name, String iconName, String colorHex) {
        if (!cache.containsKey(name)) {
            System.out.println(">>> [Factory] Створення нового об'єкта категорії: " + name);
            cache.put(name, new CategoryFlyweight(name, iconName, colorHex));
        } else {

        }
        return cache.get(name);
    }

    public static int getCacheSize() {
        return cache.size();
    }
}