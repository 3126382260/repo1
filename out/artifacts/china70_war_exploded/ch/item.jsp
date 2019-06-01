<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>首页</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="博客小屋专注前端技术，后台技术，数据库技术，java，php，mysql，html，css，css3，jsp，jquery，bootstrap，ssh,ssm学习，分享">
    <meta name="description" content="博客小屋专注前前端技术，后台技术，数据库技术java，php，mysql，html，css，css3，jsp，jquery，bootstrap，ssh,ssm,学习，分享">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../public/css/item.css">
</head>
<body>
<!--静态导入头  -->
<!--end  -->

<!--静态导入导航  -->
<div style="clear:both"></div>

<div class="article">
    <!-- 文章 -->
    <div class="left-box">
        <div class="content_box whitebg">
            <h2 class="item-title"><span class="item-nav">您现在的位置是：<a href="index.html">首页</a>><a href="navlist.html?n_id=">${aan.n_name}</a> > <a href="">${aan.a_title}</a></span></h2>
            <h1 class="con_tilte" ></h1>
            <p class="bloginfo">
                <i class="avatar"><img src="picture/9.jpg"></i><span>文章来源：${aan.a_laiyuan}</span><span>作者：${aan.a_author}</span><span></span><span>
				     	${aan.a_feight}人已围观</span>
            </p>

            <div style="clear:both"></div>
            <div class="con_text" style="clear:both">
                ${aan.a_content}
            </div>
            <div style="clear:both"></div>
            <c:if test="${aan.getA_id() == 1}">
                <p class="p-left"><span class="bor-fy">上一篇：<a href="#">没有了</a></span>
                </p>
            </c:if>

            <c:if test="${aan.getA_id() > 1}">
                <p class="p-left"><span class="bor-fy">上一篇：<a href="item.html?a_id=${aan.getA_id() - 1}">${up.getA_title()}</a></span>
                </p>
            </c:if>

            <c:if test="${aan.getA_id() == rows}">
                <p class="p-right"><span class="bor-fy">下一篇：<a href="#">没有了</a></span>
                </p>
            </c:if>

            <c:if test="${aan.getA_id() != rows}">
                <p class="p-right"><span class="bor-fy">下一篇：<a href="item.html?a_id=${aan.getA_id() + 1}">${down.getA_title()}</a></span>
                </p>
            </c:if>

        </div>
    </div>
    <!-- end -->

    <!-- 右边 -->
    <div class="rbox">
            <%--最新发布--%>
            <div class="whitebg paihang">
                <h2 class="item-title">最新发布</h2>
                <ul>
                    <c:if test="${empty latslist}">
                        <li><span style="background: #FF6600">1</span><a href="#">暂无数据</a></li>
                    </c:if>

                    <c:if test="${not empty latslist}">

                        <c:forEach items="${latslist}" var="latslist"  >
    <%--                        <c:if test="${i <= 3}">
                                <li>
                                    <span style="background: #FF6600;"></span>
                                    <a href="item.html?a_id=${latslist.a_id}">${latslist.getA_title()}</a>
                                </li>
                            </c:if>--%>

                           <%-- <c:if test="${i < 3}">--%>
                                <li>
                                    <span></span>
                                    <a href="item.html?a_id=${latslist.a_id}">${latslist.getA_title()}</a>
                                </li>
                           <%-- </c:if>--%>
                        </c:forEach>
                    </c:if>
                </ul>
            </div>
            <!-- end -->
            <%--热门推荐--%>
            <div class="whitebg paihang">
                <h2 class="item-title">热门推荐</h2>
                <ul>
                    <c:if test="${empty remen}">
                        <li><span style="background: #FF6600">1</span><a href="#">暂无数据</a></li>
                    </c:if>

                    <c:if test="${not empty remen}">

                        <c:forEach items="${remen}" var="remen"  >
                            <li>
                                <span></span>
                                <a href="item.html?a_id=${remen.a_id}">${remen.getA_title()}</a>
                            </li>
                        </c:forEach>
                    </c:if>

                </ul>
            </div>
            <!-- end -->
    </div>
</div>
<!-- end -->

<!--静态导入底部  -->
<!--end  -->


</body>


</html>
