package com.ustglobal.jdbc.dynamicquery;

import java.sql.*;
import com.mysql.jdbc.Driver;
public class SelectQuery {
	public static void main(String[] args) {


		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=ROOT";
			conn=DriverManager.getConnection(url);
			String sql="select * from employee_info where id=?";
			pstmt=conn.prepareStatement(sql);
			String empid=args[0];
			int id=Integer.parseInt(empid);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();

			// step4 
			if(rs.next()) {
				int emp_id=rs.getInt("id");
				String name1=rs.getString("name");
				int emsal=rs.getInt("sal");
				String emgender=rs.getString("gender");
				System.out.println(" Id: "+emp_id);
				System.out.println(" Name : "+name1);
				System.out.println(" Sal: "+emsal);
				System.out.println(" Gender: "+emgender);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(rs!=null) {
					rs.close();

				}
			}catch(SQLException e) {
				e.printStackTrace();
			}

		}

	}


}
