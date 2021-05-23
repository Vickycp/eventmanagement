package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databasecon {

	private static String dbUrl = "jdbc:mysql://localhost:3306/userdb";
	private  static String dbUname = "root";
	private static String dbPassword ="";
	private static String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public static void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		Connection con = null;
		try {
			loadDriver(dbDriver);
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	
}
