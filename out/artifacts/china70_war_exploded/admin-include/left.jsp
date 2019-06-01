<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="${pageContext.request.contextPath}/admin/index.jsp"><span class="am-icon-file"></span>首页</a></li>
        <li><a href="${pageContext.request.contextPath}/articleList?p=1"><span class="am-icon-puzzle-piece"></span>文章管理</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/addarticle.jsp"><span class="am-icon-check"></span>文章添加</a></li>
        <li><a href="${pageContext.request.contextPath}/navList"><span class="am-icon-tag"></span>分类管理</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/addnav.jsp"><span class="am-icon-pencil-square-o"></span>分类添加</a></li>
        <li><a href="${pageContext.request.contextPath}/userList"><span class="am-icon-home"></span>用户管理</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/adduser.jsp"><span class="am-icon-calendar"></span>用户添加</a></li>
        <li><a href="#"><span class="am-icon-users"></span> 待拓展</a></li>
        <li><a href="${pageContext.request.contextPath}/exit.jsp"><span class="am-icon-sign-out"></span> 注销</a></li>
      </ul>

      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-bookmark"></span> 公告</p>
          <p>人生的道理很简单，你想要什么，就去付出足够的努力！早安！</p>
        </div>
      </div>
    </div>
</div>