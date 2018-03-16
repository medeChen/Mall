package com.mall.dao;

import java.util.List;

import com.mall.model.Product;

public interface ProductDao {
	//显示所有商品，不分页
	public abstract List<Product> showAllProduct();
	//添加商品
	public abstract boolean addProduct(Product pro);
	//通过商品id删除商品
	public abstract boolean deleteProduct(String product_id);
	//修改商品信息
	public abstract boolean modifyProduct(Product pro);
	//通过商品id查询商品信息
	public abstract Product searchProduct(String product_id);
	//修改商品的上下架状态
	boolean editState(String id, int state);
	//买家登录界面显示上架商品
	public abstract List<Product> showOnlineProduct();
	//买家登录界面，分页用，上架商品的总数
	int searchOnlineProductCount();
	//卖家和管理员登录界面，分页用，所有商品总数
	int searchAllProductCount();
	///买家登录界面分页显示上架商品
	public abstract List<Product> showOnlineProductPage(int maxNum,int minNum);
	//卖家、管理员登录商品列表分页显示所有商品
	public abstract List<Product> showAllProductPage(int maxNum,int minNum);
	//卖家、管理员登录根据条件动态搜索商品
	public abstract List<Product> searchProductSeo(Product pro);
	//买家查看商品详细信息
	Product detailProduct(String product_id);
}
