<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>用户添加</title>
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="回首七十年，见证大国崛起，感悟生活变迁。在新的时代，汲取七十年奋斗的勇气与力量，砥砺前行,壮丽七十年，奋斗新时代！">
  <meta http-equiv="description" content="从1949年到2019年，进入新时代，喜迎新中国七十华诞。七十年波澜壮阔，书写着新中国上下求索的风雨历程。七十年风云际会，回荡着新中国建设者的铿锵跫音。七十年沧海桑田，树立起新中国改革者的时代丰碑。">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="icon" type="image/png" href="../admin/images/favicon.png">
  <meta name="apple-mobile-web-app-title" content="" />
  <link rel="stylesheet" href="../admin/css/amazeui.min.css"/>
  <link rel="stylesheet" href="../admin/css/admin.css">
</head>
<body>
<!--静态导入头部 -->
<jsp:include page="../admin-include/top.jsp"></jsp:include>
<!--/end  -->
<div class="am-cf admin-main">
<!--静态导入侧边栏 -->
<jsp:include page="../admin-include/left.jsp"></jsp:include>
<!--/end  -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">添加用户</strong></div>
      </div>
      <hr/>
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-12  am-u-md-pull-12 ">
          <form class="am-form am-form-horizontal" action="${pageContext.request.contextPath}/addUser" method="post" onsubmit="return isSubmit()">
          	<input type="hidden" name="method" value="addUser">
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">账号</label>
              <div class="am-u-sm-6">
                <input maxlength="15" type="text" name="u_user" id="u_use" placeholder="账号" onfocus="showTips('账号不能为空','err_u_use')" onkeyup="user_userKey()" onblur="user_userKey()">
                <span id="err_u_use"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>          
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">密码</label>
              <div class="am-u-sm-6">
                <input maxlength="15" type="password" name="u_pwd" id="u_pwd"  placeholder="密码" onfocus="showTips('密码不能为空','err_u_pwd')" onkeyup="user_pwdKey()" onblur="user_pwdKey()">
                <span id="err_u_pwd"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>          	
          	
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">姓名</label>
              <div class="am-u-sm-6">
                <input maxlength="15" type="text" id="u_name" name="u_name" placeholder="姓名" onfocus="showTips('姓名不能为空','err_u_name')" onkeyup="user_name()" onblur="user_name()">
                <span id="err_u_name"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>

            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">邮箱</label>
              <div class="am-u-sm-6">
                <input maxlength="18" type="email"  name="u_email" id="u_email"  placeholder="邮箱" onfocus="showTips('邮箱不能为空','err_u_email')" onkeyup="user_email()" onblur="user_email()">
                <span id="err_u_email"></span>
              </div>
               <div class="am-u-sm-3"></div>
            </div>

            <div class="am-form-group">
              <label  class="am-u-sm-3 am-form-label">电话</label>
              <div class="am-u-sm-6">
                <input maxlength="11" type="tel" id="u_phone" name="u_phone" placeholder="电话" onfocus="showTips('电话不能为空','err_u_phone')" onkeyup="user_phone()" onblur="user_phone()">
                <span id="err_u_phone"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>

            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">QQ</label>
              <div class="am-u-sm-6">
                <input maxlength="15" type="text" name="u_qq" id="u_qq"  placeholder="输入你的QQ号码" onfocus="showTips('QQ号码不能为空','err_u_qq')" onkeyup="user_qqKey()" onblur="user_qqKey()">
                <span id="err_u_qq"></span>
              </div>
               <div class="am-u-sm-3"></div>
            </div>

            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
                <input maxlength="12" type="submit" class="am-btn am-btn-primary" value="提交">
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>

	<!--静态导入底部 -->
	<jsp:include page="../admin-include/footer.jsp"></jsp:include>
	<!--/end  -->

  </div>

</div>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

<script src="../admin/js/jquery.min.js"></script>
<script src="../admin/js/amazeui.min.js"></script>
<script src="../admin/js/user.js"></script>

</body>
</html>
