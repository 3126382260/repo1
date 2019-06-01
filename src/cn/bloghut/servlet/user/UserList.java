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
import java.util.List;

@WebServlet("/userList")
public class UserList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //创建对象
            UserService service = new UserServiceImpl();
            //调用方法
            List<UserBean> list = service.queryUserList();
            //将数据添加到域对象
            request.setAttribute("list",list);
            //请求转发
            request.getRequestDispatcher("admin/userlist.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
