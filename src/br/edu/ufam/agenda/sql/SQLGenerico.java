package br.edu.ufam.agenda.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class SQLGenerico {
	private Connection connection;

	protected SQLGenerico() {
		this.connection = ConnectionDatabase.getConnection();
	}

	protected Connection getConnection() {
		return connection;
	}

	protected void save(String insertSql, Object... parametros) throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(insertSql);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}

		pstmt.execute();
		pstmt.close();
	}

	protected void update(String updateSql, Object id, Object... parametros) throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(updateSql);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}
		pstmt.setObject(parametros.length + 1, id);
		pstmt.execute();
		pstmt.close();
	}

	protected void delete(String deleteSql, Object... parametros) throws SQLException {
        PreparedStatement pstmt = 
			getConnection().prepareStatement(deleteSql);
			
        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i+1, parametros[i]);
        }

        pstmt.execute();
        pstmt.close();
    }
	
	protected void saveCat(String insertSql, Object... parametros) throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(insertSql);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}

		pstmt.execute();
		pstmt.close();
	}
	
	protected void updateCat(String updateSql, Object id, Object... parametros) throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(updateSql);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}
		pstmt.setObject(parametros.length + 1, id);
		pstmt.execute();
		pstmt.close();
	}

	protected void deleteCat(String deleteSql, Object... parametros) throws SQLException {
        PreparedStatement pstmt = 
			getConnection().prepareStatement(deleteSql);
			
        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i+1, parametros[i]);
        }

        pstmt.execute();
        pstmt.close();
    }
	
	protected void SemCat(String update, Object... parametros) throws SQLException {
		PreparedStatement pstmt = getConnection().prepareStatement(update);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}
		
		pstmt.execute();
		pstmt.close();
    }

	
	
}
