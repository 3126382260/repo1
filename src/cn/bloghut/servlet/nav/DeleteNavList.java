package cn.bloghut.servlet.nav;

import cn.bloghut.service.nav.NavService;
import cn.bloghut.serviceimpl.nav.NavServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/deleteNavList")
public class DeleteNavList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //处理乱码问题
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            //获取提交的参数
            String[] ids = request.getParameterValues("id");
            //创建对象
            NavService navService = new NavServiceImpl();
            //调用方法
            navService.deletelist(ids);
            //程序走到这里说明删除成功走查询所有用户
            response.sendRedirect(request.getContextPath()+"/navList");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("deleteNavList");
            response.getWriter().print("批量删除分类失败，该分类下有文章不能删除<a href=\"navlist.jsp\">点击返回</a>");
        }

    }
}
