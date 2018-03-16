function addCheck(){
	if(addCheckProName()&&addCheckProPrice()&&addCheckProMount&&addCheckCateId&&addCheckProPicture){
		return true;
	}else{
		return false;
	}
}
function addCheckProName(){
	var pro_name=document.getElementById("pro_name").value;
	if(pro_name==""){
		document.getElementById("pro_nameSpan").innerHTML="商品名称不能为空";
		return false;
	}else{
		return true;
	}
}
function addCheckSpanProName(){
	document.getElementById("pro_nameSpan").innerHTML="";
}
function addCheckProPrice(){
	var pro_price=document.getElementById("pro_price").value;
	var reg=/^[0-9]{1,4}(\.{0,1}\d{1,2})?$/;
	if(pro_price==""){
		document.getElementById("pro_priceSpan").innerHTML="单价不能为空";
		return false;
	}else if(!reg.test(pro_price)){
		document.getElementById("pro_priceSpan").innerHTML="单价格式不对";
		return false;
	}else{
		return true;
	}
}
function addCheckSpanProPrice(){
	document.getElementById("pro_priceSpan").innerHTML="";
}
function addCheckProMount(){
	var pro_mount=document.getElementById("pro_mount").value;
	var reg=/^[0-9]{1,10}$/;
	if(pro_mount==""){
		document.getElementById("pro_mountSpan").innerHTML="数量不能为空";
		return false;
	}else if(!reg.test(pro_mount)){
		document.getElementById("pro_mountSpan").innerHTML="数量格式不对";
		return false;
	}else{
		return true;
	}
}
function addCheckSpanProMount(){
	document.getElementById("pro_mountSpan").innerHTML="";
}
function addCheckCateId(){
	var cate_id=document.getElementById("cate_id").value;
	if(cate_id=="0"){
		document.getElementById("cate_idSpan").innerHTML="商品类型不能为空";
		return false;
	}else{
		return true;
	}
}
function addCheckSpanCateId(){
	document.getElementById("cate_idSpan").innerHTML="";
}
function addCheckProPicture(){
	var pro_picture=document.getElementById("pro_picture").value;
	if(pro_picture==""){
		document.getElementById("pro_pictureSpan").innerHTML="商品类型不能为空";
		return false;
	}else{
		return true;
	}
}
function addCheckSpanProPicture(){
	document.getElementById("pro_pictureSpan").innerHTML="";
}