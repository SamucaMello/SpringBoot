package br.gerenciamentoderedes.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;


public class Database {
	static private Connection connection;
	
	static private String CONNECTION_URL = "jdbc:sqlite:db.sql";
	
	private Database() throws SQLException {
		if (Objects.isNull(connection)) {
			System.out.println("Obtendo conexão");
			connection = DriverManager.getConnection(CONNECTION_URL);
		}
	}
	
	static public Connection getConnection() throws SQLException {
		return new Database().connection;
	}
	
	public static void main(String...args) throws SQLException {
		Connection con = Database.getConnection();
		System.out.println(con);
	}
}
