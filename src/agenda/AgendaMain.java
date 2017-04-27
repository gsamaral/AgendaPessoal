package agenda;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AgendaMain {
	
	

	public static void main(String[] args) {
		Connection con = Conect.getConnection(); 
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate("CREATE TABLE TAREFA(idTarefa INT NOT NULL) ENGINE = InnoDB;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
