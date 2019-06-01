package cn.bloghut.web;

import cn.bloghut.bean.ArticleAndNav;
import cn.bloghut.bean.ArticleBean;
import cn.bloghut.service.web.WebService;
import cn.bloghut.serviceimpl.web.WebServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ch/item.html")
public class Item extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           //处理乱码问题
           request.setCharacterEncoding("utf-8");
           response.setCharacterEncoding("utf-8");
           //获取文章id
           String a_id = request.getParameter("a_id");
           //创建对象
           WebService webService = new WebServiceImpl();
           //调用方法--获取当前文章
           ArticleAndNav aan = webService.queryArticleAndA_id(a_id);
           //调用方法--获取上一篇文章
           ArticleAndNav up = webService.queryArticleAndUp(a_id);
           //调用方法--获取下一篇文章
           ArticleAndNav down = webService.queryArticleAndDown(a_id);
           //调用方法获取文章总数
           int rows = webService.queryArticleRow();
           //获取最新发布的6篇文章
           List<ArticleBean> latslist = webService.queryLast();
           //获取最新热门的6篇文章
           List<ArticleBean> remen = webService.queryReMen();
           //将方法添加到域对象---
            request.setAttribute("aan",aan);
            request.setAttribute("up",up);
            request.setAttribute("down",down);
            request.setAttribute("rows",rows);
            request.setAttribute("latslist",latslist);
            request.setAttribute("remen",remen);
           //请求转发
           request.getRequestDispatcher("/ch/item.jsp").forward(request,response);
       }catch (Exception e){
            e.printStackTrace();
            System.out.println("item.html--错误");
       }

    }
}
