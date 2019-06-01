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
 	
//校验账号是否合法
function user_userKey(){
	var atit = document.getElementById("u_use").value;
  var sptit = document.getElementById("err_u_use");
  if(atit.length >= 5){
  	sptit.innerHTML = "";
  	return true;
  }else{
	   	sptit.innerHTML = "账号不能为空";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
  }
  
}
//校验密码是否合法
function user_pwdKey(){
	var atit = document.getElementById("u_pwd").value;
var sptit = document.getElementById("err_u_pwd");
if(atit.length >= 6){
	sptit.innerHTML = "";
	return true;
}else{
	   	sptit.innerHTML = "密码不能为空";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}
//校验姓名是否合法
function  user_name(){
	var atit = document.getElementById("u_name").value;
	var sptit = document.getElementById("err_u_name");
if(atit.length >= 2){
	sptit.innerHTML = "";
	return true;
}else{
	   	sptit.innerHTML = "姓名不能为空";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}
//校验邮箱是否合法
function  user_email(){
	var atit = document.getElementById("u_email").value;
	var sptit = document.getElementById("err_u_email");
if(atit.length >= 5){
	sptit.innerHTML = "";
	return true;
}else{
	   	sptit.innerHTML = "邮箱不合法";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}
//校验电话是否合法
function  user_phone(){
	var atit = document.getElementById("u_phone").value;
	var sptit = document.getElementById("err_u_phone");
if(atit.length >= 11){
	sptit.innerHTML = "";
	return true;
}else{
	   	sptit.innerHTML = "电话不合法";
	  	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}
//校验qq是否合法
function  user_qqKey(){
	var atit = document.getElementById("u_qq").value;
var sptit = document.getElementById("err_u_qq");
if(atit.length >= 6){
	sptit.innerHTML = "";
	return true;
}else{
	sptit.innerHTML = "qq不合法";
	sptit.style.color = "red"; 
		sptit.style.fontSize = "11px";
		return false;
}
}

function isSubmit(){
	var flag  = user_userKey() && user_pwdKey() && user_name() && user_email() && user_phone() && user_qqKey();
	if(flag){
		return true;
	}
	return false;
}





