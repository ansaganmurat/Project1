package config;
import config.interfaces.IDB;
import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() {
        // Убедись, что имя базы 'oop_assignment' и пароль '0000' верны
        String connectionUrl = "jdbc:postgresql://localhost:5432/oop_assignment";
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(connectionUrl, "postgres", "0000");
        } catch (Exception e) {
            System.out.println("failed to connect to postgres: " + e.getMessage());
            return null;
        }
    }
}
