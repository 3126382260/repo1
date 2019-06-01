<%@ page import="cn.bloghut.utils.Config" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

    HttpSession sess = request.getSession();
    //移除session
    sess.removeAttribute(Config.UID);
    sess.removeAttribute(Config.LOGIN_SUCCESS);
    //跳转到登录界面
    response.sendRedirect("login.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
