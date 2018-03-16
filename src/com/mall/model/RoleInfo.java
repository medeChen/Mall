/**
 * 
 */
package com.mall.model;

/**
 * 角色信息
 * 
 * @author chen
 *
 *         2017年9月16日
 */
public class RoleInfo {
	// 角色id  	pk
	private String role_id;
	// 角色姓名
	private String role_name;
	// 角色密码
	private String role_pwd;
	// 角色邮箱
	private String role_email;
	// 角色电话
	private String role_phone;
	// 角色权限 	fk
	private RoleLimit role_limit;

	/**
	 * 默认构造方法
	 */
	public RoleInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 带参构造方法
	 * @return
	 */
	public RoleInfo(String role_id, String role_name, String role_pwd, String role_email, String role_phone,
			RoleLimit role_limit) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_pwd = role_pwd;
		this.role_email = role_email;
		this.role_phone = role_phone;
		this.role_limit = role_limit;
	}
	public RoleInfo(String role_name, String role_pwd, String role_email, String role_phone, RoleLimit role_limit) {
		super();
		this.role_name = role_name;
		this.role_pwd = role_pwd;
		this.role_email = role_email;
		this.role_phone = role_phone;
		this.role_limit = role_limit;
	}
	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_pwd() {
		return role_pwd;
	}

	public void setRole_pwd(String role_pwd) {
		this.role_pwd = role_pwd;
	}

	public String getRole_email() {
		return role_email;
	}

	public void setRole_email(String role_email) {
		this.role_email = role_email;
	}

	public String getRole_phone() {
		return role_phone;
	}

	public void setRole_phone(String role_phone) {
		this.role_phone = role_phone;
	}

	public RoleLimit getRole_limit() {
		return role_limit;
	}

	public void setRole_limit(RoleLimit role_limit) {
		this.role_limit = role_limit;
	}
}
