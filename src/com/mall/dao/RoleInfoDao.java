/**
 * 
 */
package com.mall.dao;

import java.util.List;

import com.mall.model.RoleInfo;

/**
 * 角色接口
 * @author chen
 *
 * 2017年9月16日
 */
public interface RoleInfoDao {
	/**
	 * 添加角色
	 */
	boolean addRole(RoleInfo role_info);
	/**
	 * 根据角色ID修改角色
	 */
	boolean modifyRole(RoleInfo role_info);
	/**
	 * 根据角色ID删除角色
	 */
	boolean deleteRole(String role_id);
	/**
	 * 查询数据库所有已存在角色
	 */
	List<RoleInfo> selectAllRole();
	/**
	 * 根据角色ID查询角色
	 */
	RoleInfo selectRoleByRoleId(String role_id);
	/**
	 * 根据角色权限ID查询角色
	 */
	RoleInfo selectRoleByLimitId(int limit_id);
	
}
