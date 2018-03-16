package com.mall.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mall.dao.ProCategoryDao;
import com.mall.dao.ProductDao;
import com.mall.dao.impl.ProCategoryDaoImpl;
import com.mall.dao.impl.ProductDaoImpl;
import com.mall.model.ProCategory;
import com.mall.model.Product;
import com.mall.model.RoleInfo;
import com.mall.util.StateInfo;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProCategoryDao categoryDao=new ProCategoryDaoImpl();
    ProductDao productDao=new ProductDaoImpl();
    Product pro=new Product();
    ProCategory category=new ProCategory();
    RoleInfo role=new RoleInfo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
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
		if("categoryList".equals(method)){
			categoryList(request,response);
		}else if("addProduct".equals(method)){
			addProduct(request,response);
		}else if("productList".equals(method)){
			productList(request,response);
		}else if("editState".equals(method)){
			editState(request,response);
		}else if("pro_page".equals(method)){
			pro_page(request,response);
		}else if("allpro_page".equals(method)){
			allpro_page(request,response);
		}else if("seo_pro".equals(method)){
			seo_pro(request,response);
		}else if("detail".equals(method)){
			detail(request,response);
		}
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pro_id=request.getParameter("pro_id");
		Product p=productDao.detailProduct(pro_id);
		request.setAttribute("detailPro", p);
		request.getRequestDispatcher("detailProduct.jsp").forward(request, response);
	}

	private void seo_pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seoState=Integer.parseInt(request.getParameter("seoState"));
		String seoName=request.getParameter("seoName");
		Product p=new Product();
		p.setPro_state(seoState);
		p.setPro_name(seoName);
		HttpSession session=request.getSession();
		RoleInfo role=(RoleInfo) session.getAttribute("loginUser");
		p.setRole(role);
		List<Product> list=productDao.searchProductSeo(p);
		request.setAttribute("allPros", list);
		request.setAttribute("updown", seoState);
		request.getRequestDispatcher("productList.jsp").forward(request, response);
	}

	private void allpro_page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p=request.getParameter("page");
		List<Integer> Pages =new ArrayList<Integer>();
		int page;
		try {
			//当前页数
			page=Integer.valueOf(p);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			page=1;
		}
		//用户总数
		int Products=productDao.searchAllProductCount();
		//总页数
		int pages=Products%StateInfo.PRO_ROWPAGE==0?Products/StateInfo.PRO_ROWPAGE:Products/StateInfo.PRO_ROWPAGE+1;
		for(int i=1;i<=pages;i++){
			Pages.add(i);
		}
		//本页起始用户序号
		int minNum=(page-1)*StateInfo.PRO_ROWPAGE+1;
		int maxNum=page*StateInfo.PRO_ROWPAGE;
		List<Product> list=productDao.showAllProductPage(maxNum, minNum);
		request.setAttribute("Pages", Pages);
		request.setAttribute("allPros", list);
		request.setAttribute("page", page);
		request.getRequestDispatcher("productList.jsp").forward(request, response);
	}

	private void pro_page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	private void editState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		int state=Integer.parseInt(request.getParameter("state"));
		boolean flag=productDao.editState(id, state);
		request.setAttribute("state", flag);
		productList(request, response);
	}

	private void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products=productDao.showAllProduct();
		request.setAttribute("products", products);
		request.getRequestDispatcher("productList.jsp").forward(request, response);
	}

	@SuppressWarnings("deprecation")
	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = null;
		
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 获取文件需要上传到的路径
		String path = request.getRealPath("/upload");
		System.out.println(path);
		File uploadPath=new File(path);
		if(!uploadPath.exists()){
			uploadPath.mkdirs();
		}

		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(path));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);

		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			// 可以上传多个文件
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);

			for (FileItem item : list) {
				// 获取表单的属性名字
				String name = item.getFieldName();// title

				// 如果获取的 表单信息是普通的 文本 信息
				if (item.isFormField()) {
					// 获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的
					String value = item.getString();// title content
					request.setAttribute(name, value);
				}
				// 对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些
				else {
					/**
					 * 以下三步，主要获取 上传文件的名字
					 * 名字采用随机的方式设置的
					 */
					// 获取路径名
					String value = item.getName();
					String suffix = value.substring(value.lastIndexOf("."));
					filename = "pro"+String.valueOf(((new Date()).getTime())%10000000)+suffix;
					request.setAttribute(name, filename);

					// 真正写到磁盘上
					// 它抛出的异常 用exception 捕捉

					// item.write( new File(path,filename) );//第三方提供的

					// 手动写的
					OutputStream out = new FileOutputStream(new File(path,
							filename));

					InputStream in = item.getInputStream();

					int length = 0;
					byte[] buf = new byte[1024];

					//System.out.println("获取上传文件的总共的容量：" + item.getSize());

					// in.read(buf) 每次读到的数据存放在 buf 数组中
					while ((length = in.read(buf)) != -1) {
						// 在 buf 数组中 取出数据 写到 （输出流）磁盘上
						out.write(buf, 0, length);

					}

					in.close();
					out.close();
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 从request 取出 name,value (form upload)

		String role_id=new String(String.valueOf(request.getAttribute("role_id")).getBytes("iso-8859-1"),"UTF-8");
	 	String pro_name= new String(String.valueOf(request.getAttribute("pro_name")).getBytes("iso-8859-1"),"UTF-8");
	 	double pro_price=Double.parseDouble(request.getAttribute("pro_price").toString());
	 	int pro_mount=Integer.parseInt(request.getAttribute("pro_mount").toString());
	 	int cate_id=Integer.parseInt(request.getAttribute("cate_id").toString());
	 	String pro_picture= new String(String.valueOf(request.getAttribute("pro_picture")).getBytes("iso-8859-1"),"UTF-8");
	 	//1获取页面数据
	 	/*String role_id=request.getParameter("role_id");
		String pro_name=request.getParameter("pro_name");
		Double pro_price=Double.parseDouble(request.getParameter("pro_price"));
		int pro_mount=Integer.parseInt(request.getParameter("pro_mount"));
		int cate_id=Integer.parseInt(request.getParameter("cate_id"));*/
		category.setCate_id(cate_id);
		role.setRole_id(role_id);
		pro=new Product(category, pro_name, pro_price, pro_mount, role,pro_picture);
		if(productDao.addProduct(pro)){
			request.setAttribute("flag", 1);
		}else{
			request.setAttribute("flag", 0);
		}
		categoryList(request, response);
	}

	private void categoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProCategory> list=categoryDao.showAllProCategory();
		request.setAttribute("categorys", list);
		request.getRequestDispatcher("addProduct.jsp").forward(request, response);
	}

}
