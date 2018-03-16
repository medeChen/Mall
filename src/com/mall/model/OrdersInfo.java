package com.mall.model;

import java.sql.Date;

import com.sun.jmx.snmp.Timestamp;

/**
 * 订单类
 * @author Alley
 *
 */
public class OrdersInfo {
	
	private String order_info_id;//订单id
	private RoleInfo role;//下单用户
	private int status;//订单状态
	private java.sql.Timestamp order_time;//订单生成时间
	/**
	 * 无参构造函数
	 */
	public OrdersInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 带参数构造函数
	 * @param order_info_id
	 * @param role
	 * @param status
	 * @param timestamp
	 */
	public OrdersInfo(String order_info_id, RoleInfo role, int status, java.sql.Timestamp timestamp) {
		super();
		this.order_info_id = order_info_id;
		this.role = role;
		this.status = status;
		this.order_time = timestamp;
	}
	public String getOrder_info_id() {
		return order_info_id;
	}
	public void setOrder_info_id(String order_info_id) {
		this.order_info_id = order_info_id;
	}
	public RoleInfo getRole() {
		return role;
	}
	public void setRole(RoleInfo role) {
		this.role = role;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public java.sql.Timestamp getOrder_time() {
		return order_time;
	}
	public void setOrder_time(java.sql.Timestamp order_time) {
		this.order_time = order_time;
	}
}
