package cn.bloghut.servlet.user;

import cn.bloghut.bean.UserBean;
import cn.bloghut.service.user.UserService;
import cn.bloghut.serviceimpl.user.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/editeuserUp")
public class EditeuserUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setCharacterEncoding("utf-8");
        try {
            //获取用户提交的参数
            Map<String, String[]> map = request.getParameterMap();
            UserBean ub = new UserBean();
            BeanUtils.populate(ub,map);
            //创建对象
            UserService us = new UserServiceImpl();
            //调用方法
            us.updateUser(ub);
            //程序走到这里说明添加成功走查询所有用户
            response.sendRedirect(request.getContextPath()+"/userList");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误类-editeuserUp");
            response.getWriter().print("用户修改失败！<a href=\"edituser.jsp\">点击返回</a>");
        }

    }
}
