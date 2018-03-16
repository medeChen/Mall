/**
 * 
 */
package com.mall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mall.dao.RoleLimitDao;
import com.mall.model.RoleLimit;
import com.mall.util.JDBCUtil;

/**
 * @author chen
 *
 *         2017年9月18日
 */
public class RoleLimitDaoImpl extends JDBCUtil implements RoleLimitDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	/**
	 * 添加权限
	 */
	@Override
	public boolean addLimit(RoleLimit role_limit) {
		conn = super.getConnection();
		boolean flag = false;
		String sql = "INSERT INTO role_limit(limit_id ,limit_description ) VALUES(limit_id_seq.nextval,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, role_limit.getLimit_description());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, stmt, rs);
		}
		return flag;
	}

	/**
	 * 根据权限ID修改权限
	 */
	@Override
	public boolean modifyLimit(RoleLimit role_limit) {
		boolean flag = false;
		String sql = "UPDATE role_limit SET limit_description=?  WHERE limit_id =?";
		conn = super.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,role_limit.getLimit_description() );
			pstmt.setInt(2, role_limit.getLimit_id());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, stmt, rs);
		}
		return flag;
	}

	/**
	 * 根据权限ID删除权限
	 */
	@Override
	public boolean deleteLimit(int limit_id) {
		boolean flag=false;
		String sql="DELETE FROM role_limit WHERE limit_id=?";
		conn=super.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, limit_id);
			int count=pstmt.executeUpdate();
			if (count>0) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(conn, pstmt, stmt, rs);
		}
		return flag;
	}

	/**
	 * 查询数据库所有已存在权限
	 */
	@Override
	public List<RoleLimit> selectAllLimit() {
		List<RoleLimit> result=new ArrayList<RoleLimit>();
		String sql="SELECT limit_id,limit_description FROM role_limit";
		conn=super.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				RoleLimit roleLimit= new RoleLimit(rs.getInt(1),rs.getString(2));
				result.add(roleLimit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(conn, pstmt, stmt, rs);
		}
		return result;
	}

	/**
	 * 根据权限ID查询权限
	 */
	@Override
	public RoleLimit selectLimitByLimitId(int limit_id) {
		RoleLimit result=null;
		String sql="SELECT limit_id,limit_description FROM role_limit WHERE limit_id=?";
		conn=super.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, limit_id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				result=new RoleLimit(rs.getInt(1),rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(conn, pstmt, stmt, rs);
		}
		return result;
	}

}
