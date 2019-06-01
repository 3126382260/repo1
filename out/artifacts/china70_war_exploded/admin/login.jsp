<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    response.sendRedirect("login.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
