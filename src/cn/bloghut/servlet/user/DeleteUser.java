package cn.bloghut.servlet.user;

import cn.bloghut.service.user.UserService;
import cn.bloghut.serviceimpl.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //解决乱码问题
            response.setCharacterEncoding("utf-8");
            //获取要删除的用户id
            String u_id = request.getParameter("u_id");
            //创建对象
            UserService us = new UserServiceImpl();
            //调用方法
            us.deleteUser(u_id);
            //程序走到这里说明添加成功走查询所有用户
            response.sendRedirect(request.getContextPath()+"/userList");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误类-deleteUser");
            response.getWriter().print("用户删除失败！<a href=\"edituser.jsp\">点击返回</a>");
        }
    }
}
