package cn.bloghut.servlet.article;

import cn.bloghut.bean.ArticleAndNav;
import cn.bloghut.service.article.ArticleService;
import cn.bloghut.serviceimpl.article.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateArticle")
public class UpdateArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //处理乱码问题
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            //获取要修改的文章id
            String a_id = request.getParameter("a_id");
            //创建对象
            ArticleService articleService = new ArticleServiceImpl();
            //调用方法
            ArticleAndNav an = articleService.queryArticleA_id(a_id);
            //将数据添加到域对象
            request.setAttribute("an",an);
            //请求转发
            request.getRequestDispatcher("admin/editarticle.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误请求UpdateArticle");
            response.getWriter().print("文章查询修改失败<a href=\"index.jsp\">点击返回</a>");
        }
    }
}
