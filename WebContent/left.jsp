<%@ page language="java" pageEncoding="UTF-8"%>
<link href="image/css.css" rel="stylesheet" type="text/css" />
<table width="193" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="center" valign="middle"><a
			href="NewsServlet?method=showNewsList"><img
				src="image/cg1_r1_c2.jpg" width="175" height="25" border="0" /></a></td>
	</tr>
	<tr>
		<td align="center" valign="middle"><a
			href="ProductServlet?method=showProductList"><img
				src="image/cg1_r2_c2.jpg" width="175" height="25" border="0" /></a></td>
	</tr>
	<tr>
		<td align="center" valign="middle"><a href="after.jsp"><img
				src="image/cg1_r4_c2.jpg" width="175" height="25" border="0" /></a></td>
	</tr>
	<tr>
		<td align="center" valign="middle"><a href="about.jsp"><img
				src="image/cg1_r6_c2.jpg" width="175" height="25" border="0" /></a></td>
	</tr>
	<tr height="1">
		<td align="center" valign="middle">&nbsp;</td>
	</tr>
	<tr>
		<td><table width="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td colspan="2"><img src="image/cg1_r10_c1.jpg" width="188"
						height="28" /></td>
				</tr>
				<tr>
					<td width="33"><img src="image/cg5_1.jpg" width="21"
						height="28" /></td>
					<td width="158" class="d06">业务专线:010-88888888</td>
				</tr>
				<tr>
					<td width="33" colspan="2"><img src="image/tiao.jpg" /></td>
				</tr>
				<tr>
					<td width="33"><img src="image/cg5_1.jpg" width="21"
						height="28" /></td>
					<td width="158" class="d06">售后服务:010-66666666</td>
				</tr>
				<tr>
					<td width="33" colspan="2"><img src="image/tiao.jpg" /></td>
				</tr>
				<tr>
					<td width="33"><img src="image/cg5_1.jpg" width="21"
						height="28" /></td>
					<td width="158" class="d06">传&nbsp;&nbsp;&nbsp;&nbsp;真:010-12345678</td>
				</tr>
							<tr>
					<td width="33"><img src="image/cg5_1.jpg" width="21"
						height="28" /></td>
					<td width="158" class="d06">欢迎<font color="blue" size=+2><b>${sessionScope.loginUser.role_name}</b></font>登录</td>
				</tr>
				<tr>
					<td width="33" colspan="2"><img src="image/tiao.jpg" /></td>
				</tr>
			</table></td>
	</tr>
</table>
