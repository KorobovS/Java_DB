import java.sql.*;

public class DatabaseOracle {
    // Пример строки подключения (измените под вашу БД)
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1"; // или SID: @localhost:1521:ORCL
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("✅ Подключение успешно!");

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT SYSDATE FROM DUAL")) {

                if (rs.next()) {
                    System.out.println("Текущая дата в Oracle: " + rs.getTimestamp(1));
                }
            }

        } catch (SQLException e) {
            System.err.println("❌ Ошибка подключения: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
