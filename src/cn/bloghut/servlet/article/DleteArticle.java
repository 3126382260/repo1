package cn.bloghut.servlet.article;

import cn.bloghut.service.article.ArticleService;
import cn.bloghut.serviceimpl.article.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dleteArticle")
public class DleteArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //处理乱码问题
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            //获取要删除的文章id
            String a_id = request.getParameter("a_id");
            //创建对象
            ArticleService as = new ArticleServiceImpl();
            //调用方法
            as.deleteArticle(a_id);
            //重定向到查询页
            response.sendRedirect(request.getContextPath()+"/articleList?p=1");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误请求dleteArticle");
            response.getWriter().print("删除文章失败<a href=\"index.jsp\">点击返回</a>");
        }

    }
}
