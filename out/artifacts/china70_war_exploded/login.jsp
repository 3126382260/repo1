<%@ page import="cn.bloghut.utils.Config" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String msgg = request.getParameter("msgg")==null?"":("0".equals(request.getParameter("msgg"))?"验证码错误":("2".equals(request.getParameter("msgg")))?"账号或密码错误":("3".equals(request.getParameter("msgg"))?"验证码不能为空":""));
    //系统强转跳转功能--判断session是否存在
    if(session.getAttribute(Config.UID.toString()) != null && !"".equals(session.getAttribute(Config.UID).toString())){
        response.sendRedirect("admin/index.jsp");
        return;
    }

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>博客小屋管理员登录</title>
    <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
    <meta name="author" content="Vincent Garreau" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" media="screen" href="web/css/style.css">
    <link rel="stylesheet" type="text/css" href="web/css/reset.css"/>
</head>
<body>

<div id="particles-js">
    <div class="login">
        <div class="login-top">
            登录
        </div>
        <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div class="login-center clearfix">
            <div class="login-center-img"><img src="web/img/name.png"/></div>
            <div class="login-center-input">
                <input type="text" name="u_user" value="" placeholder="请输入您的账号" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
                <div class="login-center-input-text">账号</div>
            </div>
        </div>
        <div class="login-center clearfix">
            <div class="login-center-img"><img src="web/img/password.png"/></div>
            <div class="login-center-input">
                <input type="password" name="u_pwd"value="" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
                <div class="login-center-input-text">密码</div>
            </div>
        </div>
        <div class="login-center clearfix">
            <div class="login-center-img"><img src="web/img/password.png"/></div>
            <div class="login-center-input">
                <input type="text" name="yzm" value="" placeholder="请输入验证码" style="width:50%"/>
               <a href="javascript:refreshCode()"> <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" alt="" id="vcode"></a>
                <div class="login-center-input-text">验证码</div>
            </div>
        </div>

        <div class="login-center">
            <input class="login-button" type="submit" style="background-color: #1e90ff;border:none;color: #fff;">
        </div>

        </form>
        <div style="text-align: center;margin-top: 10px;color:red;">
            <%= msgg %>
        </div>
    </div>
    <div class="sk-rotating-plane"></div>
</div>

<!-- scripts -->
<script src="web/js/particles.min.js"></script>
<script src="web/js/app.js"></script>
<script>
    //切换验证码
    function refreshCode(){
        //1.获取验证码图片对象
        var vcode = document.getElementById("vcode");
        //2.设置其src属性，加时间戳
        vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
    }

</script>
<div style="text-align:center;">
    <p><a href="#" target="_blank">©博客小屋</a></p>
</div>
</body>
</html>