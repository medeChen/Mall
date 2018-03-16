package com.mall.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mall.dao.ProductDao;
import com.mall.dao.RoleInfoDao;
import com.mall.dao.impl.ProductDaoImpl;
import com.mall.dao.impl.RoleInfoDaoImpl;
import com.mall.model.Product;
import com.mall.model.RoleInfo;
import com.mall.util.StateInfo;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
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
		String methods=request.getParameter("method");
		if("login".equals(methods)){
			login(request, response);
		}else if("logout".equals(methods)){
			logout(request, response);
		}
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.removeAttribute("loginUser");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		if(uname==""||upwd==""){
			request.setAttribute("fail", 0);//用户名称或密码为空
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			RoleInfoDao infoDao=new RoleInfoDaoImpl();
			RoleInfo role=infoDao.selectRoleByRoleId(uname);
			if(role.getRole_name()==null){
				request.setAttribute("fail", 1);//用户名不存在
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else if(!upwd.equals(role.getRole_pwd())){
				request.setAttribute("fail", 2);//用户密码错误
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				HttpSession session=request.getSession();
				session.setAttribute("loginUser", role);
				//在线人数统计
				ServletContext app=request.getServletContext();
				int countapp=0;
				if(app.getAttribute("countapp")!=null){
					countapp=Integer.parseInt(app.getAttribute("countapp").toString());
				}
				if(countapp==0){
					app.setAttribute("countapp",1);
				}else{
					countapp=countapp+1;
					app.setAttribute("countapp",countapp);
				}
				if(role.getRole_limit().getLimit_id()==1||role.getRole_limit().getLimit_id()==1){
					request.getRequestDispatcher("index.jsp").forward(request, response);		
				}else{
					ProductDao productDao=new ProductDaoImpl();
					int goPage=1;
					String goPageStr=request.getParameter("gopage");
					if(goPageStr!=null){
						goPage=Integer.parseInt(goPageStr);
					}
					int count=productDao.searchOnlineProductCount();
					int pageNum=0;
					if(count%StateInfo.PRO_ROWPAGE==0){
						pageNum=count/StateInfo.PRO_ROWPAGE;
					}else{
						pageNum=count/StateInfo.PRO_ROWPAGE+1;
					}
					int maxNum=0;
					int minNum=0;
					maxNum=goPage*StateInfo.PRO_ROWPAGE;
					minNum=(goPage-1)*StateInfo.PRO_ROWPAGE+1;
					List<Product> list=productDao.showOnlineProductPage(maxNum,minNum);
					request.setAttribute("pageNum", pageNum);
					request.setAttribute("onlinePros", list);
					request.setAttribute("gopage", goPage);
					request.getRequestDispatcher("onlineProduct.jsp").forward(request, response);
				}
				
			}
		}
	}
}
