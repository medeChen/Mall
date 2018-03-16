package com.mall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mall.dao.OrdersInfoDao;
import com.mall.model.OrdersInfo;
import com.mall.util.JDBCUtil;

public class OrdersInfoDaoImpl extends JDBCUtil implements OrdersInfoDao {

	OrdersInfo order=null;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	@Override
	public boolean addOrders(OrdersInfo order) {
		boolean flag=false;
		//1.sql
		String sql="insert into orders_info(order_info_id,buyer_id,status) "
				+ "values('"+order.getOrder_info_id()+"','"+order.getRole().getRole_id()+"',"+order.getStatus()+")";
		//2.conn
		conn=super.getConnection();
		try {
			//3.执行sql
			stmt=conn.createStatement();
			//4.param
			//5.rs
			int count=stmt.executeUpdate(sql);
			//6.rows
			if(count>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//close all
			super.closeAll(conn, pstmt, stmt, rs);
		}
		return flag;
	}

}
