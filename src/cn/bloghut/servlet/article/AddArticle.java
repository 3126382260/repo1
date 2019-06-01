package cn.bloghut.servlet.article;

import cn.bloghut.bean.ArticleBean;
import cn.bloghut.service.article.ArticleService;
import cn.bloghut.serviceimpl.article.ArticleServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/addArticle")
public class AddArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //处理乱码问题
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");

            //获取用户提交参数
            Map<String, String[]> map = request.getParameterMap();
            ArticleBean bean = new ArticleBean();
            BeanUtils.populate(bean,map);
            //创建对象
            ArticleService service = new ArticleServiceImpl();
            //调用方法
            service.addArticle(bean);
            //跳转到查询页面
            response.sendRedirect(request.getContextPath()+"/articleList?p=1");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误请求addArticle");
            response.getWriter().print("文章添加失败<a href=\"addarticle.jsp\">点击返回</a>");

        }
    }
}
