package user.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

	/**
	 * db connect properties에 설정한 key 값을 호출하여 사용
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection con = null; 
		Properties pr = new Properties();  
		try {
			pr.load(new FileInputStream("/resources/db_info.properties"));
			String driver = pr.getProperty("driver");
			String url = pr.getProperty("url");
			String user = pr.getProperty("user");
			String password = pr.getProperty("pwd"); 

			// driver를 메모리에 올려야 함
			// 1. driver로딩
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	/**
	 * 자원 반납하는 메서드
	 * 
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void close(ResultSet rs, PreparedStatement stmt,
			Connection con) {

		// 반납하기 전에 null 체크를 하지 않으면 nullPointException 에러가 발생할 수 있기 떄문에 체크가 필요
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
