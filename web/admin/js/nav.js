/**
 * 
 */

/**表单提交验证*/

  //输入框获取焦点验证
function showTips(msg,spanid){
	 var sp = document.getElementById(spanid);
	 sp.style.color = "red"; 
	 sp.style.fontSize = "11px";
	 sp.innerHTML = msg;
}
 	
//校验分类中文标题是否合法
function nav_nameKey(){
	var atit = document.getElementById("n_name").value;
  var sptit = document.getElementById("err_n_name");
  if(atit.length >= 2){
  	sptit.innerHTML = "";
  	return true;
  }else{
	   	sptit.innerHTML = "标题不能为空";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
  }
  
}
//校验分类英文标题是否合法
function en_nav_nameKey(){
	var atit = document.getElementById("en_n_name").value;
var sptit = document.getElementById("err_en_n_name");
if(atit.length >= 2){
	sptit.innerHTML = "";
	return true;
}else{
	   	sptit.innerHTML = "标题不能为空";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}
//校验分类介绍是否合法
function nav_n_introduceKey(){
	var atit = document.getElementById("n_introduce").value;
	var sptit = document.getElementById("err_n_introduce");
if(atit.length >= 2){
	sptit.innerHTML = "";
	return true;
}else{
	   	sptit.innerHTML = "分类不能为空";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}
//校验别名是否合法
function nav_n_aliasKey(){
	var atit = document.getElementById("n_alias").value;
	var sptit = document.getElementById("err_n_alias");
if(atit.length >= 2){
	sptit.innerHTML = "";
	return true;
}else{
	   	sptit.innerHTML = "别名不能为空";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}
//校验排序权重是否合法
function nav_feightKey(){
	var atit = document.getElementById("n_feight").value;
	var sptit = document.getElementById("err_n_feight");
if(atit.length >= 1){
	sptit.innerHTML = "";
	return true;
}else{
	   	sptit.innerHTML = "排序权重不能为空";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}
//校验路径是否合法
function nav_urlKey(){
	var atit = document.getElementById("n_url").value;
var sptit = document.getElementById("err_n_url");
if(atit.length >= 6){
	sptit.innerHTML = "";
	return true;
}else{
	sptit.innerHTML = "路径不能为空";
	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}

function isSubmit(){
	var flag  = nav_nameKey() && en_nav_nameKey() && nav_n_introduceKey() && nav_n_aliasKey() && nav_feightKey() && nav_urlKey();
	if(flag){
		return true;
	}
	return false;
}





