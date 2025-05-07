
package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public Connection databaseLink;

	public Connection getConnection() {
		String dataBaseName = "pokemones";
		String dataBaseUser = "root";
		String dataBasePass = "";
		String url = "jdbc:mysql://localhost:3306/" + dataBaseName;


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url, dataBaseUser, dataBasePass);
			System.out.println("Conexión establecida");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return databaseLink;
	}
}