/**
 * 
 */
package com.mall.dao;

import java.util.List;

import com.mall.model.RoleLimit;

/**
 * 权限接口
 * @author chen
 *
 *         2017年9月16日
 */
public interface RoleLimitDao {
	/**
	 * 添加权限
	 */
	boolean addLimit(RoleLimit role_limit);
	/**
	 * 根据权限ID修改权限
	 */
	boolean modifyLimit(RoleLimit role_limit);
	/**
	 * 根据权限ID删除权限
	 */
	boolean deleteLimit(int limit_id);
	/**
	 * 查询数据库所有已存在权限
	 */
	List<RoleLimit> selectAllLimit();
	/**
	 * 根据权限ID查询权限
	 */
	RoleLimit selectLimitByLimitId(int limit_id);
}
