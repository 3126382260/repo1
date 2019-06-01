package cn.bloghut.servlet.user;

import cn.bloghut.bean.UserBean;
import cn.bloghut.dao.user.UserDao;
import cn.bloghut.daoimpl.user.UserDaoimpl;
import cn.bloghut.utils.Config;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码问题
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            //获取用户输入信息
            String yzm = request.getParameter("yzm");
            if(yzm==null || "".equals(yzm)){
                response.sendRedirect("login.jsp?msgg=3");
                return;
            }
            //获取session里的验证码
            HttpSession sess= request.getSession();
            String yzms = (String)sess.getAttribute("CHECKCODE_SERVER");
            //登录成功后移除session
            sess.removeAttribute("CHECKCODE_SERVER");

            //判断seesion的验证码和用户提交上来的是否一样
            if(!yzm.equalsIgnoreCase(yzms)){
                response.sendRedirect("login.jsp?msgg=0");
                return;
            }else{
                Map<String, String[]> map = request.getParameterMap();
                //创建bean
                UserBean bean = new UserBean();
                //通过工具类转换
                BeanUtils.populate(bean,map);
                //创建对象
                UserDao ud = new UserDaoimpl();
                //调用方法
                UserBean ub = ud.queryUser(bean);
                if(ub==null){
                    response.sendRedirect("login.jsp?msgg=2");
                }else {
                    //走到这里,说明用户名密码验证码都正确
                    //往session里放数据
                    HttpSession session = request.getSession();
                    session.setAttribute("ub",ub);
                    session.setAttribute(Config.UID,ub.getU_id());
                    session.setAttribute(Config.LOGIN_SUCCESS,Config.LOGIN_SUCCESS_VALUE);
                    request.getRequestDispatcher("admin/loading.jsp").forward(request,response);
                    //response.sendRedirect("admin/loading.jsp");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
