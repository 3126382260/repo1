package cn.bloghut.servlet.nav;

import cn.bloghut.bean.NavBean;
import cn.bloghut.service.nav.NavService;
import cn.bloghut.serviceimpl.nav.NavServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatenav")
public class Updatenav extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           try {
               //处理乱码问题
               request.setCharacterEncoding("utf-8");
               response.setCharacterEncoding("utf-8");
               //获取要修改的分类id
               String n_id = request.getParameter("n_id");
               //创建对象
               NavService navService = new NavServiceImpl();
               //调用方法
               NavBean nb = navService.queryNAvId(n_id);
               //将数据添加到域对象
               request.setAttribute("nb",nb);
               //请求转发
               request.getRequestDispatcher("admin/editnav.jsp").forward(request,response);
           }catch (Exception e){
               e.printStackTrace();
               System.out.println("错误请求updatenav");
               response.getWriter().print("修改分类失败<a href=\"admin/addnav.jsp\">点击返回</a>");
           }
    }
}
