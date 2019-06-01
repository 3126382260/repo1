package cn.bloghut.servlet.user;

import cn.bloghut.bean.UserBean;
import cn.bloghut.service.user.UserService;
import cn.bloghut.serviceimpl.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edituser")
public class Edituser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           response.setCharacterEncoding("utf-8");
           //获取要修改的用户id
           String u_id = request.getParameter("u_id");
           //创建对象-根据该id到数据库查询该id对于的用户
           UserService us = new UserServiceImpl();
           //调用方法
           UserBean ub = us.queryUserBean(u_id);
           //将数据放到域对象
           request.setAttribute("ub",ub);
           //请求转发返回
           request.getRequestDispatcher("admin/edituser.jsp").forward(request,response);
       }catch (Exception e){
           e.printStackTrace();
           System.out.print("错误类---ediuser");
       }

    }
}
