<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>分类管理</title>
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="回首七十年，见证大国崛起，感悟生活变迁。在新的时代，汲取七十年奋斗的勇气与力量，砥砺前行,壮丽七十年，奋斗新时代！">
  <meta http-equiv="description" content="从1949年到2019年，进入新时代，喜迎新中国七十华诞。七十年波澜壮阔，书写着新中国上下求索的风雨历程。七十年风云际会，回荡着新中国建设者的铿锵跫音。七十年沧海桑田，树立起新中国改革者的时代丰碑。">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="icon" type="image/png" href="admin/images/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="admin/images/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="" />
  <link rel="stylesheet" href="admin/css/amazeui.min.css"/>
  <link rel="stylesheet" href="admin/css/admin.css">
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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">分类管理</strong></div>
      </div>
      <hr>
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-1">
          <div class="am-form-group">
            <input type="button" value="删除勾选" id="btn" style="padding:2px 5px;background:#3d7878;color:#fff;font-size:14px;">
          </div>
        </div>
        <div class="am-u-sm-12 am-u-md-1">
          <div class="am-form-group">
            <input type="button" value="添加分类" id="add" style="padding:2px 5px;background:#3d7878;color:#fff;font-size:14px;">
          </div>
        </div>
        <div class="am-u-sm-12 am-u-md-10">
          <div class="am-form-group">
          </div>
        </div>
      </div>
      <div class="am-g">
        <div class="am-u-sm-12">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                <th class="table-check"><input type="checkbox" id="che" /></th>
                <th class="table-id">ID</th>
                <th class="table-title">名称</th>
                <th class="table-title">英文名称</th>
                <th class="table-title">分类介绍</th>
                <th class="table-title">别名</th>
                <th class="table-title">排序权重</th>
                <th class="table-title">路径</th>
                <th class="table-set">操作</th>
              </tr>
              </thead>
              <tbody>
              <c:if test="${empty list}">
                <tr>
                  <td colspan="7">暂无数据</td>
                </tr>
              </c:if>

              <c:if test="${not empty list}">

                <form class="am-form" action="${pageContext.request.contextPath}/deleteNavList" id="frm">

                 <c:forEach items="${list}" var="list">
                  <tr>
                    <td><input type="checkbox" name="id" value="${list.n_id}" /></td>
                    <td>${list.n_id}</td>
                    <td>${list.n_name}</td>
                    <td>${list.en_n_name}</td>
                    <td>${list.n_introduce}</td>
                    <td>${list.n_alias}</td>
                    <td>${list.n_feight}</td>
                    <td>${list.n_url}</td>
                    <td>
                      <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                          <a href="${pageContext.request.contextPath}/updatenav?n_id=${list.n_id}" class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</a>
                          <a onclick="del(${list.n_id})" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</a>
                        </div>
                      </div>
                    </td>
                  </tr>
                 </c:forEach>

                </form>

              </c:if>

              </tbody>
            </table>
        </div>
      </div>
    </div>
	<!--静态导入底部 -->
	<jsp:include page="../admin-include/footer.jsp"></jsp:include>
	<!--/end  -->

  </div>
</div>
<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>
<script src="admin/js/jquery.min.js"></script>
<script src="admin/js/amazeui.min.js"></script>
<script>
  //删除单条记录
  function del(n_id) {
    if(confirm("你确定要删吗")){
      location.href = "${pageContext.request.contextPath}/deleteNav?n_id="+n_id;
    }
  }
  //实现全选全不选
  $("#che").click(function () {
    $("[name='id']").prop("checked",$("#che").prop("checked"));
  })

  //批量删除
  $("#btn").click(function () {
    if(confirm("你确定要删除吗")){
      $("#frm").submit();
    }
  })
  //文章添加
  $("#add").click(function () {
     location.href = "${pageContext.request.contextPath}/admin/addnav.jsp"
  })
</script>
</body>
</html>
