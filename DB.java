import java.sql.*;

public class DB {
    // Database credentials
    static final String URL = "jdbc:mysql://localhost:3306/event_system3";
    static final String USER = "root";
    static final String PASSWORD = "Rivya@29";

    // Load the JDBC driver once (static block)
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ MySQL JDBC Driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Failed to load MySQL JDBC Driver!");
            e.printStackTrace();
        }
    }

    // Method to get a database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Main method to test the connection
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = getConnection();
            if (conn != null) {
                System.out.println("✅ Database connected successfully!");
            } else {
                System.out.println("❌ Failed to connect to the database!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Connection error: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
                System.out.println("🔒 Connection closed.");
            } catch (SQLException e) {
                System.out.println("⚠️ Error closing connection: " + e.getMessage());
            }
        }
    }
}
