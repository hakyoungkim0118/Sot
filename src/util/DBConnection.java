package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection conn;
	public final static DBConnection instance; 
	static {
		instance = new DBConnection();
	}
	
	public static DBConnection getInstance() {
		return instance;
	}
	
	public static Connection getConnection() {
		return conn;
	}

	private DBConnection() {
		System.out.println("DBConnection");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:admin", 
					user="bankadmin", 
					password="1234";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("立加 己傍");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException ex){
				System.out.println("connecion error");
			}
		} finally {
			System.out.println("积己磊 辆丰");
		}
	}
	
	public DBConnection(String msg) {
		System.out.println("DBConnection(String msg)");
	}
}
