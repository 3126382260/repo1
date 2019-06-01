<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.bloghut.serviceimpl.nav.NavServiceImpl" %>
<%@ page import="cn.bloghut.bean.NavBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  NavServiceImpl navService = new NavServiceImpl();
  List<NavBean> navBeans = navService.queryNavList();
  if(navBeans==null){
    return;
  }
  request.setAttribute("navBeans",navBeans);

%>


<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>文章管理</title>
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
  <link rel="stylesheet" href="admin/css/articlelist.css">
</head>
<body>

<!--静态导入头部 -->
<jsp:include page="../admin-include/top.jsp"></jsp:include>
<!--/end  -->

<div class="am-cf admin-main">

<!--静态导入侧边栏 -->
<jsp:include page="../admin-include/left.jsp"></jsp:include>
<!--/end  -->

  <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">文章管理</strong></div>
      </div>
      <hr>
      <form action="${pageContext.request.contextPath}/articleList" id="frmseek" method="post">
      <div class="am-g">
      	<div class="am-u-sm-12 am-u-md-1 aone">
      		<div class="am-form-group">
              <input type="button" value="删除勾选" id="btn" style="padding:2px 5px;background:#3d7878;color:#fff;font-size:14px;">
         	</div>
      	</div>
        <div class="am-u-sm-12 am-u-md-1 atwo">
          <div class="am-form-group">
            <input type="button" value="文章添加" id="add" style="padding:2px 5px;background:#3d7878;color:#fff;font-size:14px;">
          </div>
        </div>

          <div class="am-u-sm-12 am-u-md-1 athree">
            <div class="am-form-group">
              <select data-am-selected="{btnSize: 'sm'}"  name="n_id">

                <option value="" data-am-selected="{btnSize: 'sm'}">所有类别</option>

                <c:if test="${empty navBeans}">
                  <option value="">暂无数据</option>
                </c:if>

                <c:if test="${not empty navBeans}">
                      <option    value="0" >所有类别</option>
                    <c:forEach items="${navBeans}" var="navBeans">
                      <option ${nn_id == navBeans.n_id ? "selected" : ""}  value="${navBeans.n_id}">${navBeans.n_name}</option>
                    </c:forEach>

                </c:if>

              </select>
            </div>
          </div>
          <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">

              <input  type="hidden" name="p" value="1" id="gp_page_bunber">
              <input style="height: 32px" type="text" value="${a_title}" name="a_title" class="am-form-field" placeholder="请输入要搜索的标题">

            <span class="am-input-group-btn">
              <input style="height: 32px" class="am-btn am-btn-default" type="submit" value="搜索">
            </span>

            </div>
         </div>

        <div class="am-u-sm-12 am-u-md-6">

        </div>
      </div>
      </form>
      <div class="am-g">
        <div class="am-u-sm-12">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                <th class="table-check"><input type="checkbox" id="che" /></th>
                <th class="table-id">ID</th>
                <th class="table-title">标题</th>
                <th class="en-table-title">英文标题</th>
                <th class="table-n_id">类别</th>
                <th class="table-a_author am-hide-sm-only">作者</th>
                <th class="table-en_a_author am-hide-sm-only">英文作者</th>
                <th class="table-a_date am-hide-sm-only">发布时间</th>
                <th class="table-en_a_date am-hide-sm-only">英文发布时间</th>
                <th class="table-laiyuan am-hide-sm-only">文章来源</th>
                <th class="table-en_laiyuan am-hide-sm-only">英文文章来源</th>
                <th class="table-a_feight am-hide-sm-only">排序权重</th>
                <th class="table-set">操作</th>
              </tr>
              </thead>
              <tbody>
              <c:if test="${empty pbtwo.list}">
                <td colspan="11">暂无数据</td>
              </c:if>
              <c:if test="${not empty pbtwo.list}">

                <form action="${pageContext.request.contextPath}/deleteArticlelist" id="frm">
                <c:forEach items="${pbtwo.list}" var="list">
                    <tr>
                      <td class="table-check"><input type="checkbox" name="id" value="${list.a_id}"/></td>
                      <td class="table-id">${list.a_id}</td>
                      <td class="table-title">${list.a_title}</td>
                      <td class="table-table-title">${list.en_a_title}</td>
                      <td class="table-n_id">${list.n_name}</td>
                      <td class="table-a_author">${list.a_author}</td>
                      <td class="table-en_a_author">${list.en_a_author}</td>
                      <td class="table-a_date">${list.a_date}</td>
                      <td class="table-en_a_date">${list.en_a_date}</td>
                      <td class="table-laiyuan">${list.a_laiyuan}</td>
                      <td class="table-en_laiyuan">${list.en_laiyuan}</td>
                      <td class="table-a_feight">${list.a_feight}</td>
                      <td class="table-set">
                        <div class="am-btn-toolbar">
                          <div class="am-btn-group am-btn-group-xs">
                            <a href="${pageContext.request.contextPath}/updateArticle?a_id=${list.a_id}" class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 编辑</a>
                            <a onclick="del(${list.a_id})" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</a>
                          </div>
                        </div>
                      </td>
                    </tr>
                </c:forEach>
                </form>
              </c:if>
              </tbody>
            </table>
            <div class="am-cf">
              共 ${pbtwo.count} 条记录
              <div class="am-fr">
                <ul class="am-pagination">

                  <c:if test="${pbtwo.p!=1}">
                    <li><a onclick="go2Page(1)" href="javascript:void(0)">第一页</a></li>
                    <li><a onclick="go2Page(${pbtwo.p-1})" href="javascript:void(0)">«</a></li>
                  </c:if>

                  <c:choose>
                    <c:when test="${pbtwo.rows <= 5}">
                      <c:set var="begin" value="1"></c:set>
                      <c:set var="end" value="${pbtwo.rows}"></c:set>
                    </c:when>
                   <c:otherwise>
                      <c:set var="begin" value="${pbtwo.p - 2}"></c:set>
                      <c:set var="end" value="${pbtwo.p + 2}"></c:set>
                      <c:if test="${begin - 1 <= 0}">
                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="5"/>
                      </c:if>
                      <c:if test="${end > pbtwo.rows}">
                        <c:set var="begin" value="${pbtwo.rows - 5}"/>
                        <c:set var="end" value="${pbtwo.rows}"/>
                      </c:if>
                    </c:otherwise>
                  </c:choose>
                  <%--遍历--%>
                  <c:forEach var="i" begin="${begin}" end="${end}">
                      <c:choose>
                        <c:when test="${i == pbtwo.p}">
                          <li style="cursor: pointer;" class="am-active"><a href="#" style="background: #3d7878;border-color: #3d7878;">${i}</a></li>
                        </c:when>
                        <c:otherwise>
                          <li style="cursor: pointer;" ><a onclick="go2Page(${i})">${i}</a></li>
                        </c:otherwise>
                      </c:choose>
                   </c:forEach>


                  <c:if test="${pbtwo.p != pbtwo.rows}">
                    <li><a onclick="go2Page(${pbtwo.p+1})" href="javascript:void(0)">»</a></li>
                    <li><a onclick="go2Page(${pbtwo.rows})" href="javascript:void(0)" >最后一页</a></li>
                  </c:if>

                </ul>
              </div>
            </div>
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

  //批量删除
  $("#btn").click(function () {
    if(confirm("你确定要删除吗")){
      $("#frm").submit();
    }
  })

  //文章添加
  $("#add").click(function () {
      location.href = "${pageContext.request.contextPath}/admin/addarticle.jsp";
  });
  //文章删除
  function del(a_id) {
    if(confirm("您确定要删除吗？")){
      location.href = "${pageContext.request.contextPath}/dleteArticle?a_id="+a_id;
    }
  }
  //实现全选全不选
  $("#che").click(function () {
    $("[name='id']").prop("checked",$("#che").prop("checked"))
  })
  //模糊查询
  function go2Page(n) {
    document.getElementById("gp_page_bunber").value=n;
    document.getElementById("frmseek").submit();
  }

</script>
</body>
</html>
