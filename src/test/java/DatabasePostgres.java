import java.sql.*;

public class DatabasePostgres {
    private static final String URL = "jdbc:postgresql://localhost:5432/my_app_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "qaz123";

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

            ResultSet result = conn.createStatement().executeQuery("select * from users;");
            while (result.next()) {
                System.out.println(result.getString("id") + " "
                        + result.getString("username") + " "
                        + result.getString("email") + " "
                        + result.getString("created_at") + " ");
            }

        } catch (SQLException e) {
            System.err.println("❌ Ошибка подключения: " + e.getMessage());
            e.printStackTrace();
        }
    }
}