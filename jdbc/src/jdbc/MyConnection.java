package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String uname="root";
	private static String pass="123456789";
	private static String url="jdbc:mysql://localhost:3306/practical";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,uname,pass);
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  con;
	}
	public static void main(String[] args) {
		System.out.println("dfgsdf");
		getConnection();
	}
}
