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
  <title>分类添加</title>
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="回首七十年，见证大国崛起，感悟生活变迁。在新的时代，汲取七十年奋斗的勇气与力量，砥砺前行,壮丽七十年，奋斗新时代！">
  <meta http-equiv="description" content="从1949年到2019年，进入新时代，喜迎新中国七十华诞。七十年波澜壮阔，书写着新中国上下求索的风雨历程。七十年风云际会，回荡着新中国建设者的铿锵跫音。七十年沧海桑田，树立起新中国改革者的时代丰碑。">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="icon" type="image/png" href="../admin//images/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="../admin/images/app-icon72x72@2x.png">
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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">添加分类</strong></div>
      </div>
      <hr/>
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-12  am-u-md-pull-12 ">
          <form class="am-form am-form-horizontal" action="${pageContext.request.contextPath}/addNav" method="post" onsubmit="return isSubmit()">
          
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">分类名称</label>
              <div class="am-u-sm-6">
                <input type="text" maxlength="20" name="n_name" id="n_name" placeholder="分类名称" onfocus="showTips('分类名称不能为空','err_n_name')" onblur="nav_nameKey()" onkeyup="nav_nameKey()">
                <span id="err_n_name"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>  
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">英文分类名称</label>
              <div class="am-u-sm-6">
                <input type="text"  maxlength="20" id="en_n_name" name="en_n_name" placeholder="英文分类名称" onfocus="showTips('分类名称不能为空','err_en_n_name')" onblur="en_nav_nameKey()" onkeyup="en_nav_nameKey()">
                <span id="err_en_n_name"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>
            
            <div class="am-form-group">
              <label  class="am-u-sm-3 am-form-label">分类介绍</label>
              <div class="am-u-sm-6">
                  <input type="text" id="n_introduce" placeholder="分类介绍" name="n_introduce" onfocus="showTips('分类介绍不能为空','err_n_introduce')" onblur="nav_n_introduceKey()" onkeyup="nav_n_introduceKey()">
                 <span id="err_n_introduce"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>    
           <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">别名</label>
              <div class="am-u-sm-6">
                <input type="text" maxlength="20" name="n_alias" id="n_alias"  placeholder="别名" onfocus="showTips('别名不能为空','err_n_alias')" onblur="nav_n_aliasKey()" onkeyup="nav_n_aliasKey()">
                 <span id="err_n_alias"></span>
              </div>
               <div class="am-u-sm-3"></div>
            </div>
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">排序权重</label>
              <div class="am-u-sm-6">
                <input type="text" maxlength="20" name="n_feight" id="n_feight"  placeholder="排序权重--只能输入数字" onfocus="showTips('排序权重不能为空，只能输入数字','err_n_feight')" onblur="nav_feightKey()" onkeyup="nav_feightKey()">
                <span id="err_n_feight"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>          	
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">路径</label>
              <div class="am-u-sm-6">
                <input type="text"  maxlength="20"  name="n_url" id="n_url"   placeholder="路径" onfocus="showTips('路径不能为空','err_n_url')" onblur="nav_urlKey()" onkeyup="nav_urlKey()">
                 <span id="err_n_url"></span>
              </div>
               <div class="am-u-sm-3"></div>
            </div>
				 <span></span>
            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
                <input type="submit" class="am-btn am-btn-primary">
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
<script src="../admin/js/nav.js"></script>
</body>
</html>
