
package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	public static Connection databaseLink;

		private static String url = "jdbc:mysql://localhost:3306/pokemones";
		private static String login = "root";
		private static String password = "";


		public static Connection getConnection(){
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				databaseLink = DriverManager.getConnection(url, login, password);
				System.out.println("Conexión establecida");
			} catch (ClassNotFoundException e) {
		        System.out.println("Driver MySQL no encontrado.");
		        e.printStackTrace();
		    } catch (SQLException e) {
		        System.out.println("Error al conectar con la base de datos.");
		        e.printStackTrace();
		    }
			return databaseLink;
		}
}