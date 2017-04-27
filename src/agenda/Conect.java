package agenda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;


public class Conect {
	
	private final static String ADRESS = "jdbc:mysql://127.0.0.1:3306/";
	private final static String BD = "Agenda";
	private final static String USER = "root";
	private static final String PASSWORD = "root";
	
	
	//jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
	
	public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
            		ADRESS+BD, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }	
	
	public static void close(Connection connection){
		Conect.close(connection, null);
	}
	
	public static void close(Connection connection, Statement statement){
		try {
			if (statement != null){
				statement.close();
			}
			if (connection != null){
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}