package cn.bloghut.servlet.article;

import cn.bloghut.service.article.ArticleService;
import cn.bloghut.serviceimpl.article.ArticleServiceImpl;

import javax.servlet.annotation.WebServlet;

@WebServlet("/deleteArticlelist")
public class DeleteArticlelist extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        try {
            //处理乱码问题
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            //获取要删除的文章id
            String[] ids = request.getParameterValues("id");
            //创建对象
            ArticleService as = new ArticleServiceImpl();
            //调用方法
            as.deleteArticleList(ids);
            //重定向到查询页
            response.sendRedirect(request.getContextPath()+"/articleList?p=1");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误请求DeleteArticlelist");
            response.getWriter().print("批量删除文章失败<a href=\"index.jsp\">点击返回</a>");
        }
    }
}
