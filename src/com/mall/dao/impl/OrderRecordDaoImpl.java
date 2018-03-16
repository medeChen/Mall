package com.mall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mall.dao.OrderRecordDao;
import com.mall.model.OrderRecord;
import com.mall.model.OrdersInfo;
import com.mall.model.Product;
import com.mall.model.RoleInfo;
import com.mall.util.JDBCUtil;

public class OrderRecordDaoImpl extends JDBCUtil implements OrderRecordDao {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	@Override
	public boolean addOrderRecord(OrderRecord record) {
		boolean flag=false;
		//1.sql
		String sql="insert into order_record(order_record_id,order_info_id,product_id,pro_number) "
				+ "values(record_seq.nextval,'"+record.getOrderInfo().getOrder_info_id()+"','"+record.getProduct().getProduct_id()+"',"+record.getProMount()+")";
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
	@Override
	public List<OrderRecord> showAllOrderRecord(String role_id) {
		List<OrderRecord> list=new ArrayList<OrderRecord>();
		String sql="select r.order_record_id,r.order_info_id,r.product_id,r.pro_number,"
				+ "o.buyer_id,o.order_time,o.status,"
				+ "p.cate_id,pc.cate_name,p.pro_name,p.product_price,p.product_picture,p.saler_id "
				+ "from order_record r,orders_info o,product_info p,pro_category pc "
				+ "where r.order_info_id=o.order_info_id and r.product_id=p.product_id and p.cate_id=pc.cate_id and o.buyer_id=?";
				//取出所有属性
		conn=super.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, role_id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				OrderRecord record=new OrderRecord();
				record.setOrder_record_id(rs.getString(1));//记录编号
				//订单信息中需要包含的数据 String order_info_id, RoleInfo role, int status, Timestamp order_time
				RoleInfo role=new RoleInfo();
				role.setRole_id(rs.getString(5));
				OrdersInfo order=new OrdersInfo(rs.getString(2),role,rs.getInt(7),rs.getTimestamp(6));
				//商品属性
				Product pro=new Product();
				pro.setProduct_id(rs.getString(3));
				pro.setPro_picture(rs.getString(12));
				pro.setProduct_price(rs.getDouble(11));
				pro.setPro_name(rs.getString(10));
				RoleInfo saler=new RoleInfo();
				saler.setRole_id(rs.getString(13));
				pro.setRole(saler);
				record.setOrderInfo(order);//记录中订单（编号,买家，状态，时间）
				record.setProduct(pro);//记录中商品信息（编号，图片，卖家，名称）
				record.setProMount(rs.getInt(4));//记录中商品购买数量
				list.add(record);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(conn, pstmt, stmt, rs);
		}
		return list;
	}

}
