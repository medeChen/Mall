package com.mall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mall.dao.ProCategoryDao;
import com.mall.model.ProCategory;
import com.mall.model.Product;
import com.mall.util.JDBCUtil;

public class ProCategoryDaoImpl extends JDBCUtil implements ProCategoryDao {

	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	@Override
	public List<ProCategory> showAllProCategory() {
		List<ProCategory> list= new ArrayList<ProCategory>();
		String sql="select cate_id,cate_name from pro_category";
	    conn=super.getConnection();
	    try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ProCategory proCate=new ProCategory();
				proCate.setCate_id(rs.getInt(1));
				proCate.setCate_name(rs.getString(2));
				list.add(proCate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	    	super.closeAll(conn, pstmt, stmt, rs);
	    }
		return list;
	}

	@Override
	public boolean addProCategory(ProCategory proCate) {
		boolean flag=false;
		String sql="insert into pro_category(cate_id,cate_name) "
				+ "values(seq_proCategory.nextval,?)";
	    conn=super.getConnection();
	    try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, proCate.getCate_name());
			int count=pstmt.executeUpdate();
			if(count>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	    	super.closeAll(conn, pstmt, stmt, rs);
	    }
		return flag;
	}

	@Override
	public boolean deleteProCategory(String cate_id) {
		boolean flag=false;
		String sql="delete from pro_category where cate_id=?";
	    conn=super.getConnection();
	    try {
	    	pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cate_id);
			int count=pstmt.executeUpdate();
			if(count>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	    	super.closeAll(conn, pstmt, stmt, rs);
	    }
		return flag;
	}

	@Override
	public boolean modifyProCategory(ProCategory proCate) {
		boolean flag=false;
		String sql="update pro_category set cate_name=? where cate_id=?";
		conn=super.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, proCate.getCate_name());
			pstmt.setInt(2, proCate.getCate_id());
			int count=pstmt.executeUpdate();
			if(count>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	    	super.closeAll(conn, pstmt, stmt, rs);
	    }
		return flag;
	}

	@Override
	public ProCategory searchProCategory(int cate_id) {
		ProCategory proCate=new ProCategory();
		String sql="select cate_id,cate_name where cate_id=?";
		conn=super.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cate_id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				proCate.setCate_id(cate_id);
				proCate.setCate_id(rs.getInt(2)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	    	super.closeAll(conn, pstmt, stmt, rs);
	    }
		return proCate;
	}

}
