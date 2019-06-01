package cn.bloghut.servlet.article;

import cn.bloghut.bean.ArticleAndNav;
import cn.bloghut.bean.ArticleBean;
import cn.bloghut.bean.PageBean;
import cn.bloghut.service.article.ArticleService;
import cn.bloghut.serviceimpl.article.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/articleList")
public class ArticleList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    /**
     *  分页需求
     *  1.当前页           p  默认从1开始
     *  2.每页显示的数量   pagesize            字节规定
     *  3.每页显示的内容   List<ArticleAndNav>
     *  4.总条数           count               select count(*)  article,nav where article.n_id=nav.n_id
     *  5.总页数           rows                总条数/每页显示的条数
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //处理乱码问题
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");

            //获取搜索的条件
            String n_id = request.getParameter("n_id");             //获取搜索的分类
            String a_title = request.getParameter("a_title");       //获取搜索的标题
            if(n_id== "0" || "0".equals(n_id)){
                n_id = null;
            }
            int pagep = Integer.parseInt(request.getParameter("p"));  //获取当前页
            int pageSize = 10;                                          //每页显示的条数

            //创建对象
            ArticleService service = new ArticleServiceImpl();
            //调用方法
            //List<ArticleAndNav> list = service.queryArticleAll();                 //单单查询
            //PageBean<ArticleAndNav> pb = service.queryArticlePage(pagep,pageSize);  //分页


            PageBean<ArticleAndNav> pbtwo =   service.queryArticleAllPageSeek(pagep,pageSize,n_id,a_title);

            //List<ArticleAndNav> pageList = service.queryArticleAllPage();
            //将数据添加到域对象
            //request.setAttribute("pb",pb);
            //request.setAttribute("list",list);                            //单单查询
            request.setAttribute("a_title",a_title);                     //执行回显操作
            request.setAttribute("nn_id",n_id);                          //执行回显操作
            request.setAttribute("pbtwo",pbtwo);                         //分页-模糊查询
            //请求转发
            request.getRequestDispatcher("admin/articlelist.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误请求---articleList");
            response.getWriter().print("文章查询失败<a href=\"index.jsp\">点击返回</a>");
        }
    }
}
