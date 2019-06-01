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
 	
//校验中文标题是否合法
function ar_titleKey(){
	var atit = document.getElementById("a_title").value;
  var sptit = document.getElementById("err_a_title");
  if(atit.length >= 2){
  	sptit.innerHTML = "";
  	return true;
  }else{
	   	sptit.innerHTML = "标题不合法";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
  }
  
}
//校验作者名称是否合法
function ar_a_authorKey(){
	var atit = document.getElementById("a_author").value;
var sptit = document.getElementById("err_a_author");
if(atit.length >= 2){
	sptit.innerHTML = "";
	return true;
}else{
	   	sptit.innerHTML = "名称不合法";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}
//校验发布时间是否合法
function ar_dateKey(){
	var atit = document.getElementById("a_date").value;
	var sptit = document.getElementById("err_a_date");
if(atit.length >= 2){
	sptit.innerHTML = "";
	return true;
}else{
	   	sptit.innerHTML = "发布时间不合法";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}

//校验英文标题是否合法
function en_ar_titleKey(){
	var atit = document.getElementById("en_a_title").value;
var sptit = document.getElementById("err_en_a_title");
if(atit.length >= 2){
	sptit.innerHTML = "";
	return true;
}else{
	   	sptit.innerHTML = "标题不合法";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}

}
//校验英文作者名称是否合法
function en_ar_a_authorKey(){
	var atit = document.getElementById("en_a_author").value;
var sptit = document.getElementById("err_en_a_author");
if(atit.length >= 2){
	sptit.innerHTML = "";
	return true;
}else{
	   	sptit.innerHTML = "名称不合法";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}
//校验英文发布时间是否合法
function en_ar_dateKey(){
	var atit = document.getElementById("en_a_date").value;
	var sptit = document.getElementById("err_en_a_date");
if(atit.length >= 2){
	sptit.innerHTML = "";
	return true;
}else{
	   	sptit.innerHTML = "发布时间不合法";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}
//校验英文章来源是否合法
/*function laiyuanKey(){
	var atit = document.getElementById("a_laiyuan").value;
	var sptit = document.getElementById("err_a_laiyuan");
	if(atit.length >= 2){
		sptit.innerHTML = "";
		return true;
	}else{
		sptit.innerHTML = "文章来源不合法";
		sptit.style.color = "red";
		sptit.style.fontSize = "11px";
		return false;
	}
}*/

//校验分类是否合法
function ar_n_nameKey(){
	var atit = document.getElementById("n_id").value;
	var sptit = document.getElementById("err_n_id");
if(atit.length >= 1){
	sptit.innerHTML = "";
	return true;
}else{
	sptit.innerHTML = "分类不合法";
	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}
//校验排序权重是否合法
function ar_feightKey(){
	var atit = document.getElementById("a_feight").value;
	var sptit = document.getElementById("err_a_feight");
if(atit.length >= 1){
	sptit.innerHTML = "";
	return true;
}else{
	   	sptit.innerHTML = "排序权重不合法";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}

function isSubmit(){
	var flag  = ar_titleKey() && ar_a_authorKey() && ar_dateKey() && en_ar_titleKey() && en_ar_a_authorKey() && en_ar_dateKey() && ar_n_nameKey() && ar_feightKey();
	if(flag){
		return true;
	}
	return false;
}





