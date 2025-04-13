import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3310/stock_management"; // Port corrigé
    private static final String USER = "root";  // Remplacez par votre utilisateur MySQL
    private static final String PASSWORD = "K@yden2021";  // Remplacez par votre mot de passe MySQL

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
