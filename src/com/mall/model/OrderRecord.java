package com.mall.model;

/**
 * 交易记录类
 * @author Alley
 *
 */
public class OrderRecord {

	//交易记录表的编号 
	private String order_record_id; 
	//订单信息
	private OrdersInfo orderInfo;
	//商品信息
	private Product product;
	//商品的数量
	private int proMount;
	
	public String getOrder_record_id() {
		return order_record_id;
	}
	public void setOrder_record_id(String order_record_id) {
		this.order_record_id = order_record_id;
	}
	public OrdersInfo getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(OrdersInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProMount() {
		return proMount;
	}
	public void setProMount(int proMount) {
		this.proMount = proMount;
	}
	/**
	 * 无参构造方法
	 */
	public OrderRecord() {
		super();
	}
	/**
	 * 带有所有参数的构造方法
	 * @param order_record_id
	 * @param orderInfo
	 * @param product
	 * @param proMount
	 */
	public OrderRecord(String order_record_id, OrdersInfo orderInfo, Product product, int proMount) {
		super();
		this.order_record_id = order_record_id;
		this.orderInfo = orderInfo;
		this.product = product;
		this.proMount = proMount;
	}
}
