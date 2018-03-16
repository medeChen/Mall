package com.mall.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	//1数据库连接驱动 string
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	//2 数据库连接地址   string
	private static final String URL="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	//3 数据库实例用户名   string   
	private static final String USER="txy";
	//4 数据库连接密码  string
	private static final String PWD="a123";
	/**
	 * 获取数据库连接方法
	 * return  
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭数据连接类
	 */
	public void closeAll(Connection conn,PreparedStatement pstmt,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
				if(stmt!=null){
					stmt.close();
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
