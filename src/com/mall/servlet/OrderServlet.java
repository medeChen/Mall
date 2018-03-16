package com.mall.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mall.dao.OrderRecordDao;
import com.mall.dao.OrdersInfoDao;
import com.mall.dao.ProductDao;
import com.mall.dao.impl.OrderRecordDaoImpl;
import com.mall.dao.impl.OrdersInfoDaoImpl;
import com.mall.dao.impl.ProductDaoImpl;
import com.mall.model.OrderRecord;
import com.mall.model.OrdersInfo;
import com.mall.model.Product;
import com.mall.model.RoleInfo;
import com.mall.util.RandomId;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	OrdersInfoDao orderDao=new OrdersInfoDaoImpl();
	OrderRecordDao recordDao=new OrderRecordDaoImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if("addorder".equals(method)){
			addorder(request,response);
		}
	}
	/**
	 * 商品详情页点击添加数据库执行添加详情页商品到订单表和订单详情表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从页面获得商品编号，实例化商品对象
		String pro_id=request.getParameter("pro_id");
		Product pro=new Product();
		pro.setProduct_id(pro_id);
		ProductDao productDao=new ProductDaoImpl();
		pro=productDao.searchProduct(pro_id);
		//实例化订单对象
		OrdersInfo order=new OrdersInfo();
		order.setOrder_info_id(RandomId.getRandomNumbers());//给订单编号赋一个随机的值
		HttpSession session=request.getSession();
		RoleInfo role=(RoleInfo) session.getAttribute("loginUser");
		order.setRole(role);//将当前的用户赋给订单的买家
		order.setStatus(0);//订单状态为未审核
		orderDao.addOrders(order);
		//实例化订单详情对象
		OrderRecord record=new OrderRecord();
		record.setOrderInfo(order);//连接订单对象和订单详情对象
		record.setProduct(pro);//连接订单详情和商品对象
		record.setProMount(1);//商品数量默认为1
		recordDao.addOrderRecord(record);
		List<OrderRecord> list=recordDao.showAllOrderRecord(role.getRole_id());//查询所有的订单详情
        System.out.println(list.size());
		request.setAttribute("records",list);
		request.getRequestDispatcher("cart/myCart.jsp").forward(request, response);
	}

}
