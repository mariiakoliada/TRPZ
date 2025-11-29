package ia32.koliada.finance.config;

import java.sql.Connection;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        System.out.println(">>> [DB] Підключення до бази даних встановлено");
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        System.out.println(">>> [DB] Відключення від бази даних");
    }
}
