package com.ustglobal.jdbc.staticquery;
import java.sql.*;
import com.mysql.jdbc.Driver;
public class DeleteQuery {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);

			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=ROOT";
			conn=DriverManager.getConnection(url);

			String sql="delete from employee_info where id=6";
			stmt=conn.createStatement();
			int delete=stmt.executeUpdate(sql);
			System.out.println(delete + "delete one row(s)");

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}


	}
}
