/**
 * 
 */
package com.mall.model;

/**
 * 权限
 * 
 * @author chen
 *
 *         2017年9月16日
 */
public class RoleLimit {
	//权限类别
	private int limit_id;
	//权限描述
	private String limit_description;
	/**
	 * 默认构造方法
	 */
	public RoleLimit() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 带参构造方法
	 * @return
	 */
	public RoleLimit(int limit_id, String limit_description) {
		super();
		this.limit_id = limit_id;
		this.limit_description = limit_description;
	}
	public RoleLimit(String limit_description) {
		super();
		this.limit_description = limit_description;
	}
	public int getLimit_id() {
		return limit_id;
	}

	public void setLimit_id(int limit_id) {
		this.limit_id = limit_id;
	}

	public String getLimit_description() {
		return limit_description;
	}

	public void setLimit_description(String limit_description) {
		this.limit_description = limit_description;
	}

}
