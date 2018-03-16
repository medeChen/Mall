<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head><base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>淘宝购物车页面</title>
<link href="cart/css/myCart.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="cart/js/myCart.js"></script>
</head>

<body>
<div id="nav">您的位置：<a href="#">首页</a> > <a href="#">我的淘宝</a> > 我的购物车</div>
<div id="navlist">
  <ul>
    <li class="navlist_red_left"></li> 
    <li class="navlist_red">1. 查看购物车</li> 
    <li class="navlist_red_arrow"></li>
    <li class="navlist_gray">2. 确认订单信息</li> 
    <li class="navlist_gray_arrow"></li> 
     <li class="navlist_gray">3. 付款到支付宝</li> 
    <li class="navlist_gray_arrow"></li>   
     <li class="navlist_gray">4. 确认收货</li> 
    <li class="navlist_gray_arrow"></li> 
    <li class="navlist_gray">5. 评价</li> 
    <li class="navlist_gray_right"></li>   
  </ul>
</div>

<div id="content">
 <table width="100%" border="0" cellspacing="0" cellpadding="0" id="shopping">
 <form action="" method="post" name="myform">
  <tr>
    <td class="title_1"><input id="allCheckBox" type="checkbox" value="" onclick="selectAll()" />全选</td>
    <td class="title_2" colspan="2">店铺宝贝</td>
    <td class="title_3">获积分</td>
    <td class="title_4">单价（元）</td>
    <td class="title_5">数量</td>
    <td class="title_6">小计（元）</td>
    <td class="title_7">操作</td>
  </tr>
  <tr>
    <td colspan="8" class="line"></td>
  </tr>
  
  <c:forEach items="${records}" var="record">
  	  <tr>
	    <td colspan="8" class="shopInfo"> 卖家：<a href="#">${record.product.role.role_name}</a> <img src="cart/images/taobao_relation.jpg" alt="relation" /></td>
	  </tr>
	  <tr id="product2">
	    <td class="cart_td_1"><input name="cartCheckBox" type="checkbox" value="product2" onclick="selectSingle()" /></td>
	    <td class="cart_td_2"><img src="upload/${record.product.pro_picture}" alt="shopping"/></td>
	    <td class="cart_td_3"><a href="#">${record.product.pro_name}</a><br />
	        保障：<img src="cart/images/taobao_icon_01.jpg" alt="icon" /> <img src="cart/images/taobao_icon_02.jpg" alt="icon" /></td>
	    <td class="cart_td_4">12</td>
	    <td class="cart_td_5">${record.product.product_price}</td>
	    <td class="cart_td_6"><img src="cart/images/taobao_minus.jpg" alt="minus" onclick="changeNum('num_2','minus')" class="hand"/> <input id="num_2" type="text"  value="1" class="num_input" readonly="readonly"/> <img src="cart/images/taobao_adding.jpg" alt="add" onclick="changeNum('num_2','add')"  class="hand"/></td>
	    <td class="cart_td_7"></td>
	    <td class="cart_td_8"><a href="javascript:deleteRow('product2');">删除</a></td>
	 </tr>
  </c:forEach>
  
   <tr>
   <td  colspan="3"><a href="javascript:deleteSelectRow()"><img src="cart/images/taobao_del.jpg" alt="delete"/></a></td>
    <td colspan="5" class="shopend">商品总价（不含运费）：<label id="total" class="yellow"></label> 元<br />
    可获积分 <label class="yellow" id="integral"></label> 点<br />
    <input name=" " type="image" src="cart/images/taobao_subtn.jpg" /></td>
  </tr>
  </form>
</table>
<div style="text-align:center;">
 
</div>
</div>
</body>
</html>
