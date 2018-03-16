package com.mall.test;

import java.util.List;

import com.mall.dao.ProCategoryDao;
import com.mall.dao.RoleInfoDao;
import com.mall.dao.RoleLimitDao;
import com.mall.dao.impl.ProCategoryDaoImpl;
import com.mall.dao.impl.RoleInfoDaoImpl;
import com.mall.dao.impl.RoleLimitDaoImpl;
import com.mall.model.ProCategory;
import com.mall.model.RoleInfo;
import com.mall.model.RoleLimit;

public class test {
	public static void main(String[] args) {
		/*
		 * 检索权限
		 */
//		RoleLimitDao limitDao=new RoleLimitDaoImpl();
//		List<RoleLimit> result=limitDao.selectAllLimit();
//		for(RoleLimit res:result){
//			System.out.println(res.getLimit_id()+" "+res.getLimit_description());
//		}
		/*
		 * 检索用户信息
		 */
//		RoleInfoDao infoDao=new RoleInfoDaoImpl();
//		List<RoleInfo> list=infoDao.selectAllRole();
//		for(RoleInfo r:list){
//			System.out.println(r.getRole_id()+" "+r.getRole_name()+" "+r.getRole_email()+" "+r.getRole_phone()+" "+r.getRole_limit().getLimit_description());
//		}
		/*
		 * 添加用户信息
		 */
//		RoleInfo role=new RoleInfo(); 
//		role.setRole_name("王五");
//		role.setRole_pwd("333333");
//		role.setRole_phone("22222222222");
//		role.setRole_email("163@163.com");
//		RoleLimit limit=new RoleLimit();
//		limit.setLimit_id(3);
//		role.setRole_limit(limit);
//		RoleInfoDao roleDao=new RoleInfoDaoImpl();
//		roleDao.addRole(role);
//		RoleInfoDao infoDao=new RoleInfoDaoImpl();
//		List<RoleInfo> list=infoDao.selectAllRole();
//		for(RoleInfo r:list){
//			System.out.println(r.getRole_id()+" "+r.getRole_name()+" "+r.getRole_email()+" "+r.getRole_phone()+" "+r.getRole_limit().getLimit_description());
//		}
		/*
		 * 检索商品类别
		 */
//		ProCategoryDao categoryDao=new ProCategoryDaoImpl();
//		List<ProCategory> categorys=categoryDao.showAllProCategory();
//		for(ProCategory c:categorys){
//			System.out.println(c.getCate_id()+" "+c.getCate_name());
//		}
	}
}
