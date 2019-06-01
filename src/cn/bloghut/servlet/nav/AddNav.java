package cn.bloghut.servlet.nav;

import cn.bloghut.bean.NavBean;
import cn.bloghut.service.nav.NavService;
import cn.bloghut.serviceimpl.nav.NavServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/addNav")
public class AddNav extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //处理乱码问题
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");

            //获取用户提交数据
            String n_name = request.getParameter("n_name");
            //创建对象
            NavService nav = new NavServiceImpl();
            //调用方法--查询该类名是否存在
            NavBean isnb = nav.queryNav(n_name);
            if(isnb!=null){
                response.getWriter().print("添加分类失败<a href=\"addnav.jsp\">点击返回</a>");
            }else{
                Map<String, String[]> map = request.getParameterMap();
                NavBean nb = new NavBean();
                BeanUtils.populate(nb,map);
                //调用方法
                nav.insertNav(nb);
                //程序走到这里说明添加成功走查询所有用户
                response.sendRedirect(request.getContextPath()+"/navList");
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误请求addNav");
            response.getWriter().print("分类添加失败<a href=\"addnav.jsp\">点击返回</a>");
        }
    }
}
