package cn.bloghut.servlet.user;

import cn.bloghut.bean.UserBean;
import cn.bloghut.service.user.UserService;
import cn.bloghut.serviceimpl.user.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import sun.plugin.com.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/addUser")
public class AddUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        try {
            //获取用户提交数据--判断账号是否存在
            String user = request.getParameter("u_user");
            //创建对象
            UserService userService = new UserServiceImpl();
            //调用方法查询数据库是否存在该账号
            UserBean ub = userService.queryUserAndU(user);

           if(ub!=null){
               System.out.println("查询用户账号失败-addUser");
               response.getWriter().print("用户添加失败,该账号已经存在！<a href=\"adduser.jsp\">点击返回</a>");
           }else{
               //获取用户提交数据
               Map<String, String[]> parameterMap = request.getParameterMap();
               //创建bena
               UserBean userBean = new UserBean();
               //通过工具类转换
               BeanUtils.populate(userBean,parameterMap);
               //调用方法
               userService.addUser(userBean);
               //程序走到这里说明添加成功走查询所有用户
               response.sendRedirect(request.getContextPath()+"/userList");
           }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误类-addUser");
            response.getWriter().print("用户添加失败！<a href=\"adduser.jsp\">点击返回</a>");
        }


    }
}
