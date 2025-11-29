import java.sql.*;

public class DatabaseConnectionExample {
    private static final String URL = "jdbc:postgresql://localhost:5432/your_db_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("✅ Подключение успешно!");

            // Пример запроса
            String sql = "SELECT version();";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    System.out.println("Версия PostgreSQL: " + rs.getString(1));
                }
            }

        } catch (SQLException e) {
            System.err.println("❌ Ошибка подключения: " + e.getMessage());
            e.printStackTrace();
        }
    }
}