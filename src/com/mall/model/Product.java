package com.mall.model;

public class Product {
	private String product_id;//商品编号
	private ProCategory proCate;//商品类别
	private String pro_name;//商品名称
	private double product_price;//商品价格
	private int pro_mount;//商品数量
	private RoleInfo role;//商品卖家
	private int pro_state;//商品状态
	private String pro_picture;//商品图片
	
	public static final int NO_CHECK=0;//未审核
	public static final int CHECKING=1;//审核中
	public static final int ON_SALE=2;//已上架
	public static final int OUT_SALE=3;//已下架
	/**
	 * 无参构造函数
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 有参构造函数
	 * @param product_id
	 * @param proCate
	 * @param pro_name
	 * @param product_price
	 * @param pro_mount
	 * @param role
	 * @param pro_state
	 * @param pro_picture
	 */
	public Product(String product_id, ProCategory proCate, String pro_name, double product_price, int pro_mount,
			RoleInfo role, int pro_state, String pro_picture) {
		super();
		this.product_id = product_id;
		this.proCate = proCate;
		this.pro_name = pro_name;
		this.product_price = product_price;
		this.pro_mount = pro_mount;
		this.role = role;
		this.pro_state = pro_state;
		this.pro_picture = pro_picture;
	}
	/**
	 * 部分参数构造函数
	 * @param proCate
	 * @param pro_name
	 * @param product_price
	 * @param pro_mount
	 * @param role
	 * @param pro_picture
	 */
	public Product(ProCategory proCate, String pro_name, double product_price, int pro_mount, RoleInfo role,
			String pro_picture) {
		super();
		this.proCate = proCate;
		this.pro_name = pro_name;
		this.product_price = product_price;
		this.pro_mount = pro_mount;
		this.role = role;
		this.pro_picture = pro_picture;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public ProCategory getProCate() {
		return proCate;
	}
	public void setProCate(ProCategory proCate) {
		this.proCate = proCate;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public int getPro_mount() {
		return pro_mount;
	}
	public void setPro_mount(int pro_mount) {
		this.pro_mount = pro_mount;
	}
	public RoleInfo getRole() {
		return role;
	}
	public void setRole(RoleInfo role) {
		this.role = role;
	}
	public int getPro_state() {
		return pro_state;
	}
	public void setPro_state(int pro_state) {
		this.pro_state = pro_state;
	}
	public String getPro_picture() {
		return pro_picture;
	}
	public void setPro_picture(String pro_picture) {
		this.pro_picture = pro_picture;
	}
}
