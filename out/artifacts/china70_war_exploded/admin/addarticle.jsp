<%@ page import="cn.bloghut.serviceimpl.nav.NavServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.bloghut.bean.NavBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  NavServiceImpl navService = new NavServiceImpl();
  List<NavBean> navBeans = navService.queryNavList();
  if(navBeans.size()<1){
    return;
  }
  request.setAttribute("navBeans",navBeans);
%>

<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>文章添加</title>
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="回首七十年，见证大国崛起，感悟生活变迁。在新的时代，汲取七十年奋斗的勇气与力量，砥砺前行,壮丽七十年，奋斗新时代！">
  <meta http-equiv="description" content="从1949年到2019年，进入新时代，喜迎新中国七十华诞。七十年波澜壮阔，书写着新中国上下求索的风雨历程。七十年风云际会，回荡着新中国建设者的铿锵跫音。七十年沧海桑田，树立起新中国改革者的时代丰碑。">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="icon" type="image/png" href="../admin/images/favicon.png">
  <meta name="apple-mobile-web-app-title" content="" />
  <link rel="stylesheet" href="../admin/css/amazeui.min.css"/>
  <link rel="stylesheet" href="../admin/css/admin.css">
  <!-- 网页编辑器 -->
  <link rel="stylesheet" href="kindeditor/themes/default/default.css" />
  <link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />
  <script charset="utf-8" src="kindeditor/kindeditor-all.js"></script>
  <script charset="utf-8" src="kindeditor/lang/zh-CN.js"></script>
  <script charset="utf-8" src="kindeditor/plugins/code/prettify.js"></script>
  <script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="a_content"]', {
				cssPath : 'kindeditor/plugins/code/prettify.css',
				uploadJson : 'upload_json.jsp',
				fileManagerJson : 'file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['frm'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['frm'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
	  <script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="en_a_content"]', {
				cssPath : 'kindeditor/plugins/code/prettify.css',
				uploadJson : 'upload_json.jsp',
				fileManagerJson : 'file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['frm'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['frm'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
	
	<!--end  -->
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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">文章添加</strong></div>
      </div>
      <hr/>
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-12  am-u-md-pull-12 ">
          <form class="am-form am-form-horizontal" action="${pageContext.request.contextPath}/addArticle" method="post" name="frm" onsubmit="return isSubmit()">
          
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">标题</label>
              <div class="am-u-sm-6">
                <input type="text" name="a_title" id="a_title" maxlength="20" placeholder="标题" onfocus="showTips('标题不能为空','err_a_title')" onblur="ar_titleKey()" onkeyup="ar_titleKey()">
                <span id="err_a_title"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>          
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">作者</label>
              <div class="am-u-sm-6">
                <input type="text" name="a_author" id="a_author" maxlength="6" placeholder="作者"  onfocus="showTips('作者不能为空','err_a_author')" onblur="ar_a_authorKey()" onkeyup="ar_a_authorKey()">
                <span id="err_a_author"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>          	
          	
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">发布时间</label>
              <div class="am-u-sm-6">
                <input type="text"name="a_date" id="a_date" maxlength="12" placeholder="发布时间" onfocus="showTips('发布时间不能为空','err_a_date')" onblur="ar_dateKey()" onkeyup="ar_dateKey()">
                 <span id="err_a_date"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">英文-标题</label>
              <div class="am-u-sm-6">
                <input type="text" name="en_a_title" id="en_a_title" maxlength="20" placeholder="英文-标题" onfocus="showTips('英文-标题不能为空','err_en_a_title')" onblur="en_ar_titleKey()" onkeyup="en_ar_titleKey()">
                 <span id="err_en_a_title"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>          
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">英文-作者</label>
              <div class="am-u-sm-6">
                <input type="text" name="en_a_author" id="en_a_author"  maxlength="6"  placeholder="英文-作者" onfocus="showTips('英文-作者不能为空','err_en_a_author')" onblur="en_ar_a_authorKey()" onkeyup="en_ar_a_authorKey()">
                 <span id="err_en_a_author"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>          	
          	
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">英文-发布时间</label>
              <div class="am-u-sm-6">
                <input type="text" name="en_a_date" id="en_a_date"  maxlength="12" placeholder="英文-发布时间" onfocus="showTips('英文-发布时间不能为空','err_en_a_date')" onblur="en_ar_dateKey()" onkeyup="en_ar_dateKey()">
                 <span id="err_en_a_date"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>

            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">文章来源</label>
              <div class="am-u-sm-6">
                <input type="text" name="a_laiyuan" maxlength="12" id="a_laiyuan"  placeholder="文章来源" >
                <span id="err_a_laiyuan"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>

            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">文章来源</label>
              <div class="am-u-sm-6">
                <input type="text" name="en_laiyuan" maxlength="12" id="en_laiyuan"  placeholder="英文文章来源" >
                <span id="err_en_a_laiyuan"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>

            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">分类</label>
              <div class="am-u-sm-6">
                <select name="n_id" id="n_id" data-am-selected="{btnSize: 'sm'}">
                  <option value="">所有类别</option>

	             <c:if test="${empty navBeans}">
                   <option value="">暂无数据</option>
                 </c:if>

                 <c:if test="${not empty navBeans}">
                    <c:forEach items="${navBeans}" var="navBeans">
                      <option value="${navBeans.n_id}">${navBeans.n_name}</option>
                    </c:forEach>
                 </c:if>
           		 </select>
           		 <span id="err_n_id"></span>
              </div>
              <div class="am-u-sm-3"></div>
            </div>
            
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">排序权重</label>
              <div class="am-u-sm-6">
                <input type="text" name="a_feight" id="a_feight" maxlength="5"  placeholder="排序权重从0开始，最大8888" onfocus="showTips('排序权重不能为空','err_a_feight')"  onblur="ar_feightKey()" onkeyup="ar_feightKey()">
                 <span id="err_a_feight"></span>
              </div>
               <div class="am-u-sm-3"></div>
            </div>
            
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">中文内容</label>
              <div class="am-u-sm-6">
               		<textarea rows="35" name="a_content"></textarea>
              </div>
               <div class="am-u-sm-3"></div>
            </div>
            <div class="am-form-group">
              <label class="am-u-sm-3 am-form-label">英文内容</label>
              <div class="am-u-sm-6">
               		<textarea rows="35" name="en_a_content"></textarea>
              </div>
               <div class="am-u-sm-3"></div>
            </div>


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
<script src="../admin/js/article.js"></script>

</body>
</html>
