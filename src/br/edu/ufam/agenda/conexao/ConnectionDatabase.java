package br.edu.ufam.agenda.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDatabase {

	public static Connection getConnection() {
		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "root");
		properties.setProperty("useSSL", "false");
		properties.setProperty("autoReconnect", "true");
		try {

			return DriverManager.getConnection(

					"jdbc:mysql://localhost:3306/Planner?useSSL=false", "root", "root");

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

	}

}