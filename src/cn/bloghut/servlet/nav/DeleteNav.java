package cn.bloghut.servlet.nav;

import cn.bloghut.bean.ArticleBean;
import cn.bloghut.service.nav.NavService;
import cn.bloghut.serviceimpl.nav.NavServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteNav")
public class DeleteNav extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           //处理乱码问题
           request.setCharacterEncoding("utf-8");
           response.setCharacterEncoding("utf-8");
           //获取要删除的分类id
           String n_id = request.getParameter("n_id");
           //创建对象
           NavService navService = new NavServiceImpl();
           //调用方法--查询是否有文章引用该分类，有的话不能删除。
           List<ArticleBean> listbean = navService.queryArticleAndNid(n_id);
           if(listbean.size()< 1){
               //调用方法
               navService.delete(n_id);
               //程序走到这里说明删除成功走查询所有用户
               response.sendRedirect(request.getContextPath()+"/navList");
           }else{
               System.out.println("错误请求deleteNav");
               response.getWriter().print("分类删除失败该分类下有文章，不能删除<a href=\"navlist.jsp\">点击返回</a>");
           }
       }catch (Exception e){
           e.printStackTrace();
           System.out.println("错误请求deleteNav");
           response.getWriter().print("分类删除失败<a href=\"navlist.jsp\">点击返回</a>");
       }
    }
}
