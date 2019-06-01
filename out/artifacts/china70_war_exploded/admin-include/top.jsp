<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.bloghut.bean.UserBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<header class="am-topbar am-topbar-inverse admin-header" style="background:#3d7878;border:none;">
  <div class="am-topbar-brand">
    <strong style="font-size: 25px;">辉煌七十载</strong> <small>后台管理系统</small>
  </div>
  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class=""></span>${ub.u_name}  欢迎回来!<span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="${pageContext.request.contextPath}/userList"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="${pageContext.request.contextPath}/admin/adduser.jsp"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="${pageContext.request.contextPath}/exit.jsp"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
    </ul>
  </div>
</header>