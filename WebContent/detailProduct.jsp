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
<link href="css/right.css" rel="stylesheet" type="text/css" />
</head>
<BODY leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
	<%@ include file="top.jsp"%>
	<TABLE height=28 cellSpacing=3 cellPadding=0 width=776 align=center
		background=zjej/btmunu.gif border=0>
		<TBODY>
			<TR vAlign=bottom>
				<TD>&nbsp;&nbsp;<A class=nav href="index.jsp">首页</A><FONT
					class=nav> &gt; </FONT><A class=nav
					href="ProductServlet?method=pro_page">商品展示</A><FONT
					class=nav> &gt; </FONT>商品信息
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
		<TBODY>
			<TR>
				<TD vAlign=top width=195 background=zjej/ny3.gif bgColor=#ffffff
					height=186><%@include file="left.jsp"%></TD>
				<TD vAlign=top width=3 bgColor=#e8e8e8></TD>
				<td valign="top" bgcolor="#ffffff" height="300">
					<table cellspacing="0" cellpadding="0" width="100%" align="center"
						border="0">
						<tbody>
							<tr valign="top">
								<td>
									<table cellspacing="5" cellpadding="3" width="100%"
										bgcolor="#ffffff" border="0">
										<tbody>

											<tr>
												<td valign="top" align="middle" width="150" height="100"><font
													color="#000000"><img
														style="BORDER-LEFT-COLOR: #000000; BORDER-BOTTOM-COLOR: #000000; BORDER-TOP-COLOR: #000000; BORDER-RIGHT-COLOR: #000000"
														height="83" hspace="0"
														src="upload/${detailPro.pro_picture}" width="86"
														align="default" border="0" /></font>
														<a style="float:right" href="javascript:location.href='OrderServlet?method=addorder&pro_id=${detailPro.product_id}'">加入购物车</a></td>
												<td height="100" valign="top">
													<table height="100%" cellspacing="3" cellpadding="0"
														width="100%" border="0">
														<tbody>

															<tr valign="top">
																<td>
																	<table cellspacing="1" cellpadding="3" width="100%"
																		bgcolor="#cccccc" border="0">
																		<tbody>
																			<tr valign="top" bgcolor="#ffffff">
																				<td align="middle" width="90" bgcolor="#f0f0f0">产品编号</td>
																				<td style="PADDING-LEFT: 10px">${detailPro.product_id}</td>
																			</tr>
																			<tr valign="top" bgcolor="#ffffff">
																				<td align="middle" width="90" bgcolor="#f0f0f0">产品名称</td>
																				<td style="PADDING-LEFT: 10px">${detailPro.pro_name}</td>
																			</tr>
																			<tr valign="top" bgcolor="#ffffff">
																				<td align="middle" width="90" bgcolor="#f0f0f0">产品类型</td>
																				<td style="PADDING-LEFT: 10px">${detailPro.proCate.cate_name}</td>
																			</tr>
																			<tr valign="top" bgcolor="#ffffff">
																				<td align="middle" width="90" bgcolor="#f0f0f0">产品价格</td>
																				<td style="PADDING-LEFT: 10px">${detailPro.product_price}</td>
																			</tr>
																			<tr valign="top" bgcolor="#ffffff">
																				<td align="middle" width="90" bgcolor="#f0f0f0">产品库存</td>
																				<td style="PADDING-LEFT: 10px">${detailPro.pro_mount}</td>
																			</tr>
																		</tbody>
																	</table>
																	<table cellspacing="2" cellpadding="0" width="100%"
																		border="0">
																		<tbody>
																			<tr valign="top">
																				<td background="商务信息网站套餐.files/line.gif" height="4"></td>
																			</tr>
																		</tbody>
																	</table>
																</td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
					<table>
						<tr>
							<td><h4>买家有话说</h4>
								<table>
									<tr>
										<td width="200px">zhangsan:</td>
										<td width="100px">5星好评</td>
										<td style="float-right: 20px">2017.10.9 17:00</td>
									</tr>
									<tr>
										<td align="middle" width="200px">lisi回复zhangsan:</td>
										<td width="100px">really?</td>
										<td style="float-right: 20px">2017.10.9 17:04</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</TR>
		</TBODY>
	</TABLE>
	<%@include file="bottom.jsp"%>

</BODY>
</HTML>


