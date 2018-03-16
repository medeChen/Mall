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

import com.mall.dao.RoleInfoDao;
import com.mall.model.RoleInfo;
import com.mall.model.RoleLimit;
import com.mall.util.GetUUID;
import com.mall.util.JDBCUtil;

/**
 * @author chen
 *
 *         2017年9月16日
 */
public class RoleInfoDaoImpl extends JDBCUtil implements RoleInfoDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	/**
	 * 添加角色
	 */
	@Override
	public boolean addRole(RoleInfo role_info) {
		conn = super.getConnection();
		boolean flag = false;
		String sql = "INSERT INTO " 
				+ "role_info(role_id,role_name,role_pwd,role_email,role_phone,limit_id) "
				+ "VALUES(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, new GetUUID().getUUID());
			pstmt.setString(2, role_info.getRole_name());
			pstmt.setString(3, role_info.getRole_pwd());
			pstmt.setString(4, role_info.getRole_email());
			pstmt.setString(5, role_info.getRole_phone());
			pstmt.setInt(6, role_info.getRole_limit().getLimit_id());
			int count=pstmt.executeUpdate();
			if(count>0){
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
	 * 根据角色ID修改角色
	 */
	@Override
	public boolean modifyRole(RoleInfo role_info) {
		boolean flag=false;
		String sql="UPDATE role_info SET role_name=?,role_pwd=?,role_email=?,role_phone=?,limit_id=? WHERE role_id=?";
		conn=super.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, role_info.getRole_name());
			pstmt.setString(2, role_info.getRole_pwd());
			pstmt.setString(3, role_info.getRole_email());
			pstmt.setString(4, role_info.getRole_phone());
			pstmt.setInt(5, role_info.getRole_limit().getLimit_id());
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
	 * 根据角色ID删除角色
	 */
	@Override
	public boolean deleteRole(String role_id) {
		boolean flag=false;
		String sql="DELETE FROM role_info WHERE role_id=?";
		conn=super.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, role_id);
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
	 * 查询数据库所有已存在角色
	 */
	@Override
	public List<RoleInfo> selectAllRole() {
		List<RoleInfo> result=new ArrayList<RoleInfo>();
		String sql="SELECT i.role_id,i.role_name,i.role_pwd,i.role_email,i.role_phone,l.limit_id,l.limit_description "
				+ "FROM role_info i,role_limit l "
				+ "where i.limit_id=l.limit_id";
		conn=super.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				RoleLimit roleLimit= new RoleLimit();
				roleLimit.setLimit_id(rs.getInt(6));
				roleLimit.setLimit_description(rs.getString(7));
				RoleInfo roleInfo=new RoleInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),roleLimit);
				result.add(roleInfo);
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
	 * 根据角色ID查询角色
	 */
	@Override
	public RoleInfo selectRoleByRoleId(String role_id) {
		RoleInfo result=new RoleInfo();
		String sql="SELECT i.role_id,i.role_name,i.role_pwd,i.role_email,i.role_phone,l.limit_id,l.limit_description "
				+ "FROM role_info i,role_limit l "
				+ "WHERE role_id=? and i.limit_id=l.limit_id";
		conn=super.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, role_id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				RoleLimit roleLimit= new RoleLimit();
				roleLimit.setLimit_id(rs.getInt(6));
				roleLimit.setLimit_description(rs.getString(7));
				result=new RoleInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),roleLimit);
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
	 * 根据角色权限ID查询角色
	 */
	@Override
	public RoleInfo selectRoleByLimitId(int limit_id) {
		RoleInfo result=new RoleInfo();
		String sql="SELECT role_id,role_name,role_pwd,role_email,role_phone,limit_id FROM role_info WHERE limit_id=?";
		conn=super.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, limit_id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				RoleLimit roleLimit= new RoleLimit();
				roleLimit.setLimit_id(rs.getInt(6));
				result=new RoleInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),roleLimit);
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
