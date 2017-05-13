package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

	public static Connection getConnection() {

		try {

			return DriverManager.getConnection(

					"jdbc:mysql://localhost/Planner", "root", "root");

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

	}

}