function loginCheck(){
//	document.loginFrm.submit();
	if(loginCheckUname()&&loginCheckUpwd()){
		return true;
	}else{
		return false;
	}
}
function loginCheckUname(){
	var uname=document.getElementById("uname").value;
	if(uname==""){
		document.getElementById("unameSpan").innerHTML="用户名不能为空";
		return false;
	}else{
		return true;
	}
}
function loginSpanUname(){
	document.getElementById("unameSpan").innerHTML="";
}
function loginCheckUpwd(){
	var upwd=document.getElementById("upwd").value;
	var reg=/^\d{6}$/;
	if(upwd==""){
		document.getElementById("upwdSpan").innerHTML="密码不能为空";
		return false;
	}else if(!reg.test(upwd)){
		document.getElementById("upwdSpan").innerHTML="密码少于6位";
		return false;
	}else{
		return true;
	}
}
function loginSpanUpwd(){
	document.getElementById("upwdSpan").innerHTML="";
}