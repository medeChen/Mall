package com.mall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mall.dao.ProductDao;
import com.mall.model.ProCategory;
import com.mall.model.Product;
import com.mall.model.RoleInfo;
import com.mall.util.GetUUID;
import com.mall.util.JDBCUtil;
import com.mall.util.StateInfo;

public class ProductDaoImpl extends JDBCUtil implements ProductDao {
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	@Override
	public List<Product> showAllProduct() {
		List<Product> list= new ArrayList<Product>();
		String sql="select p.product_id,pc.cate_name,p.pro_name,p.product_price,p.pro_mount,p.saler_id,r.role_name,p.pro_state,p.product_picture"
				+ " from product_info p,pro_category pc,role_info r "
				+ "where p.cate_id=pc.cate_id and p.saler_id=r.role_id";
	    conn=super.getConnection();
	    try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Product pro=new Product();
				pro.setProduct_id(rs.getString(1));
				ProCategory proCate=new ProCategory();	
				proCate.setCate_name(rs.getString(2));
				pro.setProCate(proCate);
				pro.setPro_name(rs.getString(3));
				pro.setProduct_price(rs.getDouble(4));
				pro.setPro_mount(rs.getInt(5));
				RoleInfo role=new RoleInfo();
				role.setRole_id(rs.getString(6));
				role.setRole_name(rs.getString(7));
				pro.setRole(role);
				pro.setPro_state(rs.getInt(8));
				pro.setPro_picture(rs.getString(9));
				list.add(pro);
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
	public boolean addProduct(Product pro) {
		boolean flag=false;
		String sql="insert into product_info(product_id,cate_id,pro_name,product_price,pro_mount,saler_id,product_picture) "
				+ "values(?,?,?,?,?,?,?)";
	    conn=super.getConnection();
	    try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, new GetUUID().getUUID());
			pstmt.setInt(2, pro.getProCate().getCate_id());
			pstmt.setString(3, pro.getPro_name());
			pstmt.setDouble(4, pro.getProduct_price());
			pstmt.setInt(5, pro.getPro_mount());
			pstmt.setString(6, pro.getRole().getRole_id());
			pstmt.setString(7, pro.getPro_picture());
//			pstmt.setInt(7, pro.getPro_state());
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
	public boolean deleteProduct(String product_id) {
		boolean flag=false;
		String sql="delete from product_info where product_id=?";
	    conn=super.getConnection();
	    try {
	    	pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, product_id);
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
	public boolean modifyProduct(Product pro) {
		boolean flag=false;
		String sql="update product_info set cate_id=?,pro_name=?,product_price=?,pro_mount=?,saler_id=?,pro_state=? "
				+ "where product_id=?";
		conn=super.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pro.getProCate().getCate_id());
			pstmt.setString(2, pro.getPro_name());
			pstmt.setDouble(3, pro.getProduct_price());
			pstmt.setInt(4, pro.getPro_mount());
			pstmt.setString(5, pro.getRole().getRole_id());
			pstmt.setInt(6, pro.getPro_state());
			pstmt.setString(7, pro.getProduct_id());
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
	public boolean editState(String id,int state) {
		boolean flag=false;
		String sql="update product_info set pro_state=? where product_id=?";
		conn=super.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, state);
			pstmt.setString(2, id);
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
	public Product searchProduct(String product_id) {
		Product pro=new Product();
		String sql="select p.product_id,pc.cate_name,p.pro_name,p.product_price,p.pro_mount,p.saler_id,r.role_name,p.pro_state"
				+ " from product_info p,pro_category pc,role_info r "
				+ "where p.product_id=? and p.cate_id=pc.cate_id and p.saler_id=r.role_id";
		conn=super.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, product_id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				pro.setProduct_id(rs.getString(1));
				ProCategory proCate=new ProCategory();
				proCate.setCate_name(rs.getString(2));
				pro.setProCate(proCate);
				pro.setPro_name(rs.getString(3));
				pro.setProduct_price(rs.getDouble(4));
				pro.setPro_mount(rs.getInt(5));
				RoleInfo role=new RoleInfo();
				role.setRole_id(rs.getString(6));
				role.setRole_name(rs.getString(7));
				pro.setRole(role); 
				pro.setPro_state(rs.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	    	super.closeAll(conn, pstmt, stmt, rs);
	    }
		return pro;
	}

	@Override
	public List<Product> showOnlineProduct() {
		List<Product> list= new ArrayList<Product>();
		String sql="select p.product_id,p.pro_name,p.product_price,p.pro_mount,p.product_picture,pc.cate_name "
				+ "from product_info p,pro_category pc where pro_state=? and p.cate_id=pc.cate_id";
	    conn=super.getConnection();
	    try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,StateInfo.PRO_STATE_UP);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Product pro=new Product();
				pro.setProduct_id(rs.getString(1));
				pro.setPro_name(rs.getString(2));
				pro.setProduct_price(rs.getDouble(3));
				pro.setPro_mount(rs.getInt(4));
				pro.setPro_picture(rs.getString(5));
				ProCategory procate=new ProCategory();
				procate.setCate_name(rs.getString(6));
				pro.setProCate(procate);
				list.add(pro);
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
	public int searchOnlineProductCount() {
		int count=0;
		String sql="select count(1) from product_info where pro_state=?";
	    conn=super.getConnection();
	    try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,StateInfo.PRO_STATE_UP);
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	    	super.closeAll(conn, pstmt, stmt, rs);
	    }
		return count;
	}

	@Override
	public List<Product> showOnlineProductPage(int maxNum,int minNum) {
		List<Product> list= new ArrayList<Product>();
		String sql="select * from (select v.*,rownum rn from "
				+ "(select p.product_id,p.pro_name,p.product_price,p.pro_mount,p.product_picture,pc.cate_name "
				+ "from product_info p,pro_category pc where pro_state=? and p.cate_id=pc.cate_id)v "
				+ "where rownum<=?) where rn>=?";
	    conn=super.getConnection();
	    try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,StateInfo.PRO_STATE_UP);
			pstmt.setInt(2,maxNum);
			pstmt.setInt(3,minNum);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Product pro=new Product();
				pro.setProduct_id(rs.getString(1));
				pro.setPro_name(rs.getString(2));
				pro.setProduct_price(rs.getDouble(3));
				pro.setPro_mount(rs.getInt(4));
				pro.setPro_picture(rs.getString(5));
				ProCategory procate=new ProCategory();
				procate.setCate_name(rs.getString(6));
				pro.setProCate(procate);
				list.add(pro);
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
	public int searchAllProductCount() {
		int count=0;
		String sql="select count(1) from product_info ";
	    conn=super.getConnection();
	    try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	    	super.closeAll(conn, pstmt, stmt, rs);
	    }
		return count;
	}

	@Override
	public List<Product> showAllProductPage(int maxNum, int minNum) {
		List<Product> list= new ArrayList<Product>();
		String sql="select * from (select v.*,rownum rn from "
				+ "(select p.product_id,pc.cate_name,p.pro_name,p.product_price,p.pro_mount,p.saler_id,r.role_name,p.pro_state,p.product_picture"
				+ " from product_info p,pro_category pc,role_info r "
				+ "where p.cate_id=pc.cate_id and p.saler_id=r.role_id)v "
				+ "where rownum<=?) where rn>=?";
	    conn=super.getConnection();
	    try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,maxNum);
			pstmt.setInt(2,minNum);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Product pro=new Product();
				pro.setProduct_id(rs.getString(1));
				ProCategory proCate=new ProCategory();	
				proCate.setCate_name(rs.getString(2));
				pro.setProCate(proCate);
				pro.setPro_name(rs.getString(3));
				pro.setProduct_price(rs.getDouble(4));
				pro.setPro_mount(rs.getInt(5));
				RoleInfo role=new RoleInfo();
				role.setRole_id(rs.getString(6));
				role.setRole_name(rs.getString(7));
				pro.setRole(role);
				pro.setPro_state(rs.getInt(8));
				pro.setPro_picture(rs.getString(9));
				list.add(pro);
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
	public List<Product> searchProductSeo(Product pro) {
		List<Product> list= new ArrayList<Product>();
		String sql="select p.product_id,pc.cate_name,p.pro_name,p.product_price,p.pro_mount,p.saler_id,r.role_name,p.pro_state,p.product_picture"
				+ " from product_info p,pro_category pc,role_info r "
				+ "where p.cate_id=pc.cate_id and p.saler_id=r.role_id and p.saler_id=? and p.pro_state=?";
		if(!"".equals(pro.getPro_name())){
			sql=sql+" and p.pro_name like '%'||?||'%'";
		}
	    conn=super.getConnection();
	    try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pro.getRole().getRole_id());
			pstmt.setInt(2, pro.getPro_state());
			if(!"".equals(pro.getPro_name())){
				pstmt.setString(3, pro.getPro_name());
			}
			rs=pstmt.executeQuery();
			while(rs.next()){
				Product p=new Product();
				p.setProduct_id(rs.getString(1));
				ProCategory proCate=new ProCategory();	
				proCate.setCate_name(rs.getString(2));
				p.setProCate(proCate);
				p.setPro_name(rs.getString(3));
				p.setProduct_price(rs.getDouble(4));
				p.setPro_mount(rs.getInt(5));
				RoleInfo role=new RoleInfo();
				role.setRole_id(rs.getString(6));
				role.setRole_name(rs.getString(7));
				p.setRole(role);
				p.setPro_state(rs.getInt(8));
				p.setPro_picture(rs.getString(9));
				list.add(p);
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
	public Product detailProduct(String product_id) {
		Product pro=new Product();
		String sql="select p.product_id,pc.cate_name,p.pro_name,p.product_price,p.pro_mount,p.saler_id,r.role_name,p.pro_state,p.product_picture"
				+ " from product_info p,pro_category pc,role_info r "
				+ "where p.cate_id=pc.cate_id and p.saler_id=r.role_id and p.product_id='"+product_id+"'";
	    conn=super.getConnection();
	    try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				pro.setProduct_id(rs.getString(1));
				ProCategory proCate=new ProCategory();	
				proCate.setCate_name(rs.getString(2));
				pro.setProCate(proCate);
				pro.setPro_name(rs.getString(3));
				pro.setProduct_price(rs.getDouble(4));
				pro.setPro_mount(rs.getInt(5));
				RoleInfo role=new RoleInfo();
				role.setRole_id(rs.getString(6));
				role.setRole_name(rs.getString(7));
				pro.setRole(role);
				pro.setPro_state(rs.getInt(8));
				pro.setPro_picture(rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	    	super.closeAll(conn, pstmt, stmt, rs);
	    }
		return pro;
	}

}
