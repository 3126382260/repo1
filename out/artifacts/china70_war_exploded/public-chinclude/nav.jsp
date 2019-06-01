<%@ page import="cn.bloghut.serviceimpl.nav.NavServiceImpl" %>
<%@ page import="cn.bloghut.bean.NavBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //获取所有分类
    NavServiceImpl navService = new NavServiceImpl();
    List<NavBean> navBeans = navService.queryNavList();
    request.setAttribute("navBeans",navBeans);
%>
<html>
<head>
    <title>nav</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/bootstrap.css">


</head>
<body>
<!-- 顶部区域 -->
<header>
    <!-- 导航菜单 -->
    <nav class="navbar navbar-itcast" data-spy="affix" data-offset-top="200" data-offset-bottom="1000">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav_menu" aria-expanded="false">
                    <span class="sr-only">切换菜单显示</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    <i class="icon-icon"></i><i class="icon-logo"></i>
                </a>
            </div>
            <div class="collapse navbar-collapse" id="nav_menu">
                <ul class="nav navbar-nav">

                    <c:if test="${empty navBeans}">
                        <li class="active"><a href="#">暂无数据</a></li>
                    </c:if>

                    <c:if test="${not empty navBeans}">
                        <c:forEach items="${navBeans}" var="navBeans">
                            <li class="active"><a href="${navBeans.n_url}">${navBeans.n_name}</a></li>
                        </c:forEach>
                    </c:if>

                </ul>
                <ul class="nav navbar-nav navbar-right hidden-sm ">
                    <li><a href="#">个人中心</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- /导航菜单 -->
</header>

<%--底部js--%>
<script src="${pageContext.request.contextPath}/public/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/public/lib/jquery/js/bootstrap.js"></script>
<%--end--%>

</body>
</html>
