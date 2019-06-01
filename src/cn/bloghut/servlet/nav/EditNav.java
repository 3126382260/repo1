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

@WebServlet("/editNav")
public class EditNav extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //处理乱码问题
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            //获取要修改的分类名称和路径
            String n_name = request.getParameter("n_name");
            String en_n_name = request.getParameter("en_n_name");
            String n_url = request.getParameter("n_url");
            //创建对象
            NavService service = new NavServiceImpl();
            //调用方法
            NavBean nb = service.queryNavAndName(n_name,en_n_name,n_url);
            //判断bean是否为空
            if(nb!=null){
                response.getWriter().print("分类名称或路径已经存在,不能重复添加<a href=\"editnav.jsp\">点击返回重新添加</a>");
            }else{
                //获取要修改的n_id
                //获取用户提交的参数
                Map<String, String[]> map = request.getParameterMap();
                NavBean navBean = new NavBean();
                BeanUtils.populate(navBean,map);
                //调用修改方法
                service.updateNav(navBean);
                //程序走到这里说明添加成功走查询所有用户
                response.sendRedirect(request.getContextPath()+"/navList");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误请求editNav");
            response.getWriter().print("分类修改失败<a href=\"editnav.jsp\">点击返回</a>");
        }

    }
}
