package com.mall.dao;

import java.util.List;

import com.mall.model.ProCategory;

public interface ProCategoryDao {

	List<ProCategory> showAllProCategory();
	boolean addProCategory(ProCategory proCate);
	boolean deleteProCategory(String cate_id);
	boolean modifyProCategory(ProCategory proCate);
	ProCategory searchProCategory(int cate_id);
}
