//function editState(id,state){
//	var div=document.getElementById("messagediv");
//	//根据id 把当前的状态改为相反的状态
//	var mes="";
//	if(state==0){
//		mes="上架";
//		state=1;
//	}else{
//		mes="下架";
//		state=0;
//	}
//	//去一个servlet处理修改操作
//	if(confirm("你确定"+mes+"吗？")){
//		window.location.href="ProductServlet?method=editState&id="+id+"&state="+state;
//	}
//	
//	//拼接字符串带走两个值
//}
function editState(id,state){
	var mes="";
	if(state==0){
		mes="上架";
		state=1;
	}else{
		mes="下架";
		state=0;
	}
	document.getElementById("mesfield").innerHTML="你确定"+mes+"吗？";
	document.getElementById("forId").value=id;
	document.getElementById("forState").value=state;
}
function set(index){
	var id=document.getElementById("forId").value;
	var state=document.getElementById("forState").value;
	if(index==1){
		window.location.href="ProductServlet?method=editState&id="+id+"&state="+state;
		window.event.returnValue=false;
	}else if(index==0){
		window.location.href="ProductServlet?method=productList";
		window.event.returnValue=false;
	}
}