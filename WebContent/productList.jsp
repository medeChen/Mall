<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html class="no-js">
<head>
<meta charset="utf-8">
<base href="<%=basePath%>" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/app.js"></script>
<script src="js/productList.js"></script>

</head>
<body>
	<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->
</head>

<body>
	<div class="am-popup am-popup-inner" id="my-popups"  style="height:360px">
		<div class="am-popup-hd">
			<h4 class="am-popup-title">确认操作</h4>
			<span data-am-modal-close class="am-close">&times;</span>
		</div>
		<div class="am-popup-bd" align="center">
			<span class="you" id="mesfield"></span>
			<form name="sure" class="am-form tjlanmu">
			    <input type="hidden" id="forId">
			    <input type="hidden" id="forState">
				<button id="mesbtn1" onclick="javascript:set(1)"
					class="am-btn am-btn-success am-radius">确定</button>
				<button id="mesbtn0" onclick="javascript:set(0)"
					class="am-btn am-btn-success am-radius">取消</button>
			</form>
		</div>
	</div>
	<header class="am-topbar admin-header">
	<div class="am-topbar-brand">
		<img src="assets/i/logo.png">
	</div>

	<div class="am-collapse am-topbar-collapse" id="topbar-collapse">
		<ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">

			<li class="am-dropdown tognzhi" data-am-dropdown>
				<button
					class="am-btn am-btn-primary am-dropdown-toggle am-btn-xs am-radius am-icon-bell-o"
					data-am-dropdown-toggle>
					消息管理<span class="am-badge am-badge-danger am-round">6</span>
				</button>
				<ul class="am-dropdown-content">



					<li class="am-dropdown-header">所有消息都在这里</li>



					<li><a href="#">未激活会员 <span
							class="am-badge am-badge-danger am-round">556</span></a></li>
					<li><a href="#">未激活代理 <span
							class="am-badge am-badge-danger am-round">69</span></a></a></li>
					<li><a href="#">未处理汇款</a></li>
					<li><a href="#">未发放提现</a></li>
					<li><a href="#">未发货订单</a></li>
					<li><a href="#">低库存产品</a></li>
					<li><a href="#">信息反馈</a></li>



				</ul>
			</li>

			<li class="kuanjie"><a href="#">会员管理</a> <a href="#">奖金管理</a> <a
				href="#">订单管理</a> <a href="#">产品管理</a> <a href="#">个人中心</a> <a
				href="#">系统设置</a></li>

			<li class="soso">

				<p>

					<select
						data-am-selected="{btnWidth: 70, btnSize: 'sm', btnStyle: 'default'}">
						<option value="b">全部</option>
						<option value="o">产品</option>
						<option value="o">会员</option>

					</select>

				</p>

				<p class="ycfg">
					<input type="text" class="am-form-field am-input-sm"
						placeholder="圆角表单域" />
				</p>
				<p>
					<button class="am-btn am-btn-xs am-btn-default am-xiao">
						<i class="am-icon-search"></i>
					</button>
				</p>
			</li>




			<li class="am-hide-sm-only" style="float: right;"><a
				href="javascript:;" id="admin-fullscreen"><span
					class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
		</ul>
	</div>
	</header>

	<div class="am-cf admin-main">

		<div class="nav-navicon admin-main admin-sidebar">


			<div class="sideMenu am-icon-dashboard"
				style="color: #aeb2b7; margin: 10px 0 0 0;">欢迎${sessionScope.loginUser.role_limit.limit_description}：${sessionScope.loginUser.role_name}</div>
			<div>
				<a href="LoginServlet?method=logout">安全退出</a>
			</div>
			<div class="sideMenu">
				<h3 class="am-icon-flag">
					<em></em> <a href="#">商品管理</a>
				</h3>
				<ul>
					<li><a href="ProductServlet?method=allpro_page&page=1">商品列表</a></li>
					<li class="func" dataType='html' dataLink='msn.htm'
						iconImg='images/msn.gif'><a
						href="ProductServlet?method=categoryList">添加新商品</a></li>
					<li><a href="">商品分类</a></li>
					<li><a href="">用户评论</a></li>
					<li>商品回收站</li>
					<li><a href="">库存管理</a></li>
				</ul>
				<h3 class="am-icon-cart-plus">
					<em></em> <a href="#"> 订单管理</a>
				</h3>
				<ul>
					<li><a href="">订单列表</a></li>
					<li>合并订单</li>
					<li>订单打印</li>
					<li>添加订单</li>
					<li>发货单列表</li>
					<li>换货单列表</li>
				</ul>
				<h3 class="am-icon-users">
					<em></em> <a href="#">会员管理</a>
				</h3>
				<ul>
					<li><a href="">会员列表</a></li>
					<li>未激活会员</li>
					<li>团队系谱图</li>
					<li>会员推荐图</li>
					<li>推荐列表</li>
				</ul>
				<h3 class="am-icon-volume-up">
					<em></em> <a href="">信息通知</a>
				</h3>
				<ul>
					<li>站内消息 /留言</li>
					<li>短信</li>
					<li>邮件</li>
					<li>微信</li>
					<li>客服</li>
				</ul>
				<h3 class="am-icon-gears">
					<em></em> <a href="">系统设置</a>
				</h3>
				<ul>
					<li>数据备份</li>
					<li>邮件/短信管理</li>
					<li>上传/下载</li>
					<li>权限</li>
					<li>网站设置</li>
					<li>第三方支付</li>
					<li>提现 /转账 出入账汇率</li>
					<li>平台设置</li>
					<li>声音文件</li>
				</ul>
			</div>
			<!-- sideMenu End -->

			<script type="text/javascript">
				jQuery(".sideMenu").slide({
					titCell : "h3", //鼠标触发对象
					targetCell : "ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
					effect : "slideDown", //targetCell下拉效果
					delayTime : 300, //效果时间
					triggerTime : 150, //鼠标延迟触发时间（默认150）
					defaultPlay : true,//默认是否执行效果（默认true）
					returnDefault : true
				//鼠标从.sideMen移走后返回默认状态（默认false）
				});
			</script>
		</div>

		<div class=" admin-content">

			<div class="daohang">
				<ul>
					<li><button type="button"
							class="am-btn am-btn-default am-radius am-btn-xs">首页</button></li>
					<li><button type="button"
							class="am-btn am-btn-default am-radius am-btn-xs">
							帮助中心<a href="javascript: void(0)" class="am-close am-close-spin"
								data-am-modal-close="">×</a>
						</button></li>
					<li><button type="button"
							class="am-btn am-btn-default am-radius am-btn-xs">
							奖金管理<a href="javascript: void(0)" class="am-close am-close-spin"
								data-am-modal-close="">×</a>
						</button></li>
					<li><button type="button"
							class="am-btn am-btn-default am-radius am-btn-xs">
							产品管理<a href="javascript: void(0)" class="am-close am-close-spin"
								data-am-modal-close="">×</a>
						</button></li>


				</ul>




			</div>

			<div class="admin-biaogelist">

				<div class="listbiaoti am-cf">
					<ul class="am-icon-flag on">栏目名称
					</ul>

					<dl class="am-icon-home" style="float: right;">
						当前位置： 首页 >
						<a href="#">商品列表</a>
					</dl>

					<dl>
						<button type="button"
							class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus">
							添加产品</button>
					</dl>


				</div>

				<form name="seoFRM" action="ProductServlet?method=seo_pro" method="post">
					<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
						<ul>
							<li>
								<div class="am-btn-group am-btn-group-xs">
									<select name="seoState" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
										<c:choose>
											<c:when test="${updown==0}">
												<option value="1">上架</option>
												<option value="0" selected>下架</option>
											</c:when>
											<c:when test="${updown==1}">
												<option value="1" selected>上架</option>
												<option value="0">下架</option>
											</c:when>
											<c:otherwise>
												<option value="1" selected>上架</option>
												<option value="0">下架</option>
											</c:otherwise>
											</c:choose>
									</select>
								</div>
							</li>
							<li><input type="text" name="seoName" class="am-form-field am-input-sm am-input-xm" placeholder="关键词搜索" /></li>
							<li>
							<button type="submit" class="am-btn am-radius am-btn-xs am-btn-success"
									style="margin-top: -1px;">搜索</button></li>
						</ul>
					</div>
				</form>

				<form class="am-form am-g">
					<table width="100%"
						class="am-table am-table-bordered am-table-radius am-table-striped">
						<thead>
							<tr class="am-success">
								<th class="table-check"><input type="checkbox" /></th>
								<th class="table-id">序号</th>
								<th class="table-title">商品名称</th>
								<th class="table-type">商品类别</th>
								<th class="table-author am-hide-sm-only">上架<i
									class="am-icon-check am-text-warning"></i>/下架 <i
									class="am-icon-close am-text-primary"></i></th>
								<th class="table-date am-hide-sm-only">图片描述</th>
								<th class="table-id">单价</th>
								<th width="163px" class="table-set">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allPros}" var="p">
								<tr class="am-success">
									<td class="table-check"><input type="checkbox" /></td>
									<td class="table-id">${p.product_id}</td>
									<td class="table-title">${p.pro_name}</td>
									<td class="table-type">${p.proCate.cate_name}</td>
									<td class="table-autdor am-hide-sm-only"><c:if
											test="${p.pro_state==1}">
											<i class="am-icon-check am-text-warning"></i>
										</c:if> <c:if test="${p.pro_state==0}">
											<i class="am-icon-close am-text-primary"></i>
										</c:if></td>
									<td class="table-date am-hide-sm-only"><c:if
											test="${empty  p.pro_picture}">
											<img src="assets/img/logo.png" width="100px" height="40px" />
										</c:if> <c:if test="${not empty  p.pro_picture}">
											<img src="upload/${p.pro_picture}" width="100px"
												height="40px" onerror="this.src='assets/img/a5.png'" />
										</c:if></td>
									<td class="table-id">${p.product_price}</td>
									<td width="200px" class="table-set">
										<button
											class="am-btn am-btn-default am-btn-xs am-text-success am-round">
											<span class="am-icon-search"></span>
										</button> <a
										href="javascript:editState('${p.product_id}',${p.pro_state})"
										data-am-modal="{target: '#my-popups'}"
										class="am-btn am-btn-default am-btn-xs"><span
											class="am-icon-pencil-square-o"></span></a>
										<button
											class="am-btn am-btn-default am-btn-xs am-text-warning  am-round">
											<span class="am-icon-copy"></span>
										</button>
										<button
											class="am-btn am-btn-default am-btn-xs am-text-danger am-round">
											<span class="am-icon-trash-o"></span>
										</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<div class="am-btn-group am-btn-group-xs">
						<button type="button" class="am-btn am-btn-default">
							<span class="am-icon-plus"></span> 删除
						</button>
						<button type="button" class="am-btn am-btn-default">
							<span class="am-icon-save"></span> 上架
						</button>
						<button type="button" class="am-btn am-btn-default">
							<span class="am-icon-save"></span> 下架
						</button>
						<button type="button" class="am-btn am-btn-default">
							<span class="am-icon-save"></span> 移动
						</button>
						<button type="button" class="am-btn am-btn-default">
							<span class="am-icon-plus"></span> 新增
						</button>
						<button type="button" class="am-btn am-btn-default">
							<span class="am-icon-save"></span> 保存
						</button>
						<button type="button" class="am-btn am-btn-default">
							<span class="am-icon-archive"></span> 移动
						</button>
						<button type="button" class="am-btn am-btn-default">
							<span class="am-icon-trash-o"></span> 删除
						</button>
					</div>

					<ul class="am-pagination am-fr">
						<c:if test="${page>1}">
							<li ><a href="ProductServlet?method=allpro_page&page=${page-1}">«</a></li>
						</c:if>
						<c:if test="${page==1}">
							<li><a href="ProductServlet?method=allpro_page&page=${page}">«</a></li>
						</c:if>
						<c:forEach items="${Pages}" var="p">
							<c:if test="${p==page}">
								<li class="am-active"><a href="ProductServlet?method=allpro_page&page=${p}">${p}</a></li>
							</c:if>
							<c:if test="${p!=page}">
								<li><a href="ProductServlet?method=allpro_page&page=${p}">${p}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${page<Pages.size()}">
							<li ><a href="ProductServlet?method=allpro_page&page=${page+1}">»</a></li>
						</c:if>
						<c:if test="${page==Pages.size()}">
							<li><a href="ProductServlet?method=allpro_page&page=${page}">»</a></li>
						</c:if>
					</ul>

					<hr />
					<p>注：.....</p>
				</form>

				<div class="foods">
					<ul>
						版权所有@2015. 模板收集自
						<a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
						- More Templates
						<a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
					</ul>
					<dl>
						<a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a>
					</dl>
				</div>




			</div>

		</div>

	</div>

	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="assets/js/amazeui.min.js"></script>
	<!--<![endif]-->



</body>
</html>