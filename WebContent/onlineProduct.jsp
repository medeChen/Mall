<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%@include file="top.jsp"%>
<link href="css/right.css" rel="stylesheet" type="text/css" />
<BODY leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
	<h6 align="center">在线人数：${countapp}</h6>
	<!-- top首页 开始 -->
	<TABLE height=28 cellSpacing=3 cellPadding=0 width=776 align=center
		background="zzjz/btmunu.gif" border=0>
		<TBODY>
			<TR vAlign=bottom>
				<TD>&nbsp;&nbsp;<A class=nav href="index.jsp">首页</A><FONT
					class=nav> &gt; </FONT><A class=nav
					href="ProductServlet?method=pro_page">商品展示</A></TD>
			</TR>
		</TBODY>
	</TABLE>
	<!-- top首页 结束 -->
	<TABLE height=1 cellSpacing=0 cellPadding=0 width=776 align=center
		bgColor=#cccccc border=0>
		<TBODY>
			<TR>
				<TD></TD>
			</TR>
		</TBODY>
	</TABLE>
	<!-- 下面大边框 开始 -->
	<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
		<TBODY>
			<TR>
				<TD vAlign=top width=195 background="zzjz/ny3.gif" bgColor=#ffffff
					height=186><%@include file="left.jsp"%></TD>
				<TD vAlign=top width=3 bgColor=#e8e8e8></TD>
				<TD vAlign=top bgColor=#ffffff height=300>
					<!-- 产品大框 开始 -->
					<table cellspacing="0" cellpadding="4" width="100%" align="center"
						border="0">
						<tbody>

							<tr>
								<td valign="top" width="100%">
									<!-- 产品 开始 -->  

										<table cellspacing="2" cellpadding="0" width="100%"
											bgcolor="#ffffff" border="0">
											<tbody>
											
			<c:forEach items="${onlinePros}" var ="p" >
												<tr valign="top">
													<td align="middle" width="106" height="93">
													<a href="javascript:location.href='ProductServlet?method=detail&pro_id=${p.product_id}'"><font
															color="#000000"> 
																
																<c:if test="${empty  p.pro_picture}">
                <img src="assets/img/logo.png"  onclick="detailProduct.jsp" style="BORDER-LEFT-COLOR: #000000; BORDER-BOTTOM-COLOR: #000000; BORDER-TOP-COLOR: #000000; BORDER-RIGHT-COLOR: #000000"
																height="65" hspace="0" width="70" align="center" border="0"/>
               </c:if>
                <c:if test="${not empty  p.pro_picture}">
                <img src="upload/${p.pro_picture}" style="BORDER-LEFT-COLOR: #000000; BORDER-BOTTOM-COLOR: #000000; BORDER-TOP-COLOR: #000000; BORDER-RIGHT-COLOR: #000000"
																height="65" hspace="0" width="70" align="center" border="0" onerror="this.src='assets/img/a5.png'"/>
               </c:if>
																
																</font></a></td>
													<td height="93">
														<table cellspacing="1" cellpadding="4" width="100%"
															bgcolor="#cccccc" border="0">
															<tbody>
																<tr valign="top" align="right" bgcolor="#ffffff">
																	<td height="30">
																		<table height="28" cellspacing="1" cellpadding="4"
																			width="100%" bgcolor="#cccccc" border="0">
																			<tbody>
																				<tr bgcolor="#99ccff">
																					<td align="center" width="25%" bgcolor="#f0f0f0">产品名称</td>
																					<td width="25%" bgcolor="#ffffff"><font
																							color="#000000">${p.pro_name}</font></td>
																					<td align="center" width="25%" bgcolor="#f0f0f0">产品数量</td>
																					<td  width="25%" bgcolor="#ffffff"><font color="#ff0033">${p.pro_mount}</font></td>
																				</tr>
																				<tr  bgcolor="#99ccff">
																					<td align="center" width="25%" bgcolor="#f0f0f0">产品型号</td>
																					<td bgcolor="#ffffff" width="25%">${p.proCate.cate_name}</td>
																					<td align="center" width="25%" bgcolor="#f0f0f0">产品价格</td>
																					<td bgcolor="#ffffff" width="25%">${p.product_price}<font color="#ff0033">
																							</font>元</td>
																				</tr>
																			</tbody>

																		</table>


																	</td>
																</tr>

															</tbody>
														</table>
													</td>
												</tr>
			
			</c:forEach>
 
											</tbody>

										</table>
									 <!-- 产品 结束 -->
								</td>
							</tr>

						<tr valign="bottom" align="right">
								<td colspan="3" width="100%">
								<c:if test="${gopage>1}">
									<a href="ProductServlet?method=pro_page&gopage=1">去首页</a>
									<a href="ProductServlet?method=pro_page&gopage=${gopage-1}">上一页</a>
								</c:if>
								<a>当前第${gopage}页</a>
								<a>总共${pageNum}页</a>
								<c:if test="${gopage<pageNum}">
									<a href="ProductServlet?method=pro_page&gopage=${gopage+1}">下一页</a>
									<a href="ProductServlet?method=pro_page&gopage=${pageNum}">去尾页</a>
								</c:if>
								</td>
							</tr>
						</tbody>
					</table> <!-- 产品大框 开始 -->
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	<!-- 下面大边框 开始 -->
	<%@ include file="bottom.jsp"%>
</BODY>
</HTML>
