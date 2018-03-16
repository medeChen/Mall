package com.mall.dao;

import java.util.List;

import com.mall.model.OrderRecord;

public interface OrderRecordDao {
	//添加购物车，内容为交易记录
	boolean addOrderRecord(OrderRecord record);
	//显示购物车内所有订单详情
	List<OrderRecord> showAllOrderRecord(String role_id);
	
}
