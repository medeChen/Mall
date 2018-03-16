<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript">

function openChat(){
	var status= document.getElementById("userStatus").value;
	if(status==""){
		window.open("chat/index.jsp","","left=250   top=200   width=500   height=400");
	}else{
		window.open("chat/main.jsp","","left=250   top=200   width=500   height=400");
	}
	
}
function openMessage(){
	var status= document.getElementById("userStatus").value;
	var message= document.getElementById("message");
	if(status==""){
		message.href="messageLogin.jsp";
	}else{
		message.href="MessageServlet?method=findAllMessages";
	}
}
function openManager(){
	var status= document.getElementById("userStatus").value;
	var manager= document.getElementById("manager");
	if(status==""){
		manager.href="login.jsp";
	}else{
		if(status==0) {
			manager.href="admin/index.jsp";
		}else {
			manager.href="login.jsp";
		}
		
	}
	
}
</script>
<input type="hidden" id="userStatus"
	value="">
<table width="799" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="3" background="image/d.jpg"></td>
	</tr>
</table>
<table width="799" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
				codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0"
				width="799" height="161" title="pinhong">
				<param name="movie" value="image/2.swf" />
				<param name="quality" value="high" />
				<embed src="image/2.swf" quality="high"
					pluginspage="http://www.macromedia.com/go/getflashplayer"
					type="application/x-shockwave-flash" width="799" height="161"></embed>
			</object></td>
	</tr>
</table>
<table width="799" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="3" background="image/d.jpg"></td>
	</tr>
</table>
<table width="799" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td><img src="image/d_r3_c1.jpg" width="60" height="40" /><img
			src="image/top_red.jpg" width="20" height="40" border="0" /><img
			src="image/top_red.jpg" width="20" height="40" border="0" /><a
			href="index.jsp"><img src="image/d_r3_c5.jpg" width="64"
				height="40" border="0" /></a><img src="image/top_red.jpg" width="20"
			height="40" border="0" /><a
			href="ProductServlet?method=showProductList"><img
				src="image/d_r3_c7.jpg" name="image1" width="94" height="40"
				border="0" id="image1" /></a><img src="image/top_red.jpg" width="20"
			height="40" border="0" /><a href="NewsServlet?method=showNewsList"><img
				src="image/d_r3_c8.jpg" width="93" height="40" border="0" /></a><img
			src="image/top_red.jpg" width="20" height="40" border="0" /><a
			href="#" onclick="openChat()"><img src="image/d_r3_c9.jpg"
				width="95" height="40" border="0" /></a><img src="image/top_red.jpg"
			width="20" height="40" border="0" /><a href="" target="_blank"
			onClick="openMessage()" id="message"><img
				src="image/d_r3_c10.jpg" width="93" height="40" border="0" /></a><img
			src="image/top_red.jpg" width="20" height="40" border="0" /><a
			href="" onClick="openManager()" id="manager"><img
				src="image/d_r3_c13.jpg" width="85" height="40" border="0" /></a><img
			src="image/top_red.jpg" width="20" height="40" border="0" /><img
			src="image/top_red.jpg" width="20" height="40" border="0" /><img
			src="image/d_r3_c25.jpg" width="36" height="40" /></td>
	</tr>
</table>
