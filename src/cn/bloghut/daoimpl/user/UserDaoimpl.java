package cn.bloghut.daoimpl.user;

import cn.bloghut.bean.UserBean;
import cn.bloghut.dao.user.UserDao;
import cn.bloghut.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoimpl implements UserDao {
    /**
     * 用户登录
     * @param bean
     * @return
     */
    @Override
    public UserBean queryUser(UserBean bean) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select u_user,u_pwd,u_name from user where u_user = ? and  u_pwd = ?";
        //执行sql
        UserBean userBean = qr.query(sql, new BeanHandler<UserBean>(UserBean.class), bean.getU_user(), bean.getU_pwd());
        return userBean;
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<UserBean> queryUserList() throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select * from user";
        //执行sql
        List<UserBean> userBeans = qr.query(sql, new BeanListHandler<UserBean>(UserBean.class));
        return userBeans;
    }

    /**
     * 添加用户
     */
    @Override
    public void addUser(UserBean userBean) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "insert into user values(null,?,?,?,?,?,?)";
        //执行sql
        qr.update(sql,userBean.getU_user(),userBean.getU_pwd(),userBean.getU_name(),userBean.getU_email(),userBean.getU_phone(),userBean.getU_qq());
    }

    /**
     * 根据账号查询该账号是否存在
     * @param user
     * @return
     */
    @Override
    public UserBean queryUserAndU(String user) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select u_user from user where u_user =  ? ";
        //select u_user from user where u_user=?
        //执行sql
        UserBean userBean = qr.query(sql, new BeanHandler<UserBean>(UserBean.class), user);
        return userBean;
    }

    /**
     * 修改用户信息-回显数据
     * @param u_id
     * @return
     */
    @Override
    public UserBean queryUserBean(String u_id) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select * from user where u_id =  ? ";
        //select u_user from user where u_user=?
        //执行sql
        UserBean userBean = qr.query(sql, new BeanHandler<UserBean>(UserBean.class), u_id);
        return userBean;
    }

    /**
     * 修改用户信息
     * @param ub
     */
    @Override
    public void updateUser(UserBean ub) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "update user set u_pwd=?,u_name=?,u_email=?,u_phone=?,u_qq=? where u_id =  ? ";
        //执行sql
        qr.update(sql,ub.getU_pwd(),ub.getU_name(),ub.getU_email(),ub.getU_phone(),ub.getU_qq(),ub.getU_id());
    }

    /**
     * 根据id删除用户
     * @param u_id
     */
    @Override
    public void deleteUser(String u_id) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "delete  from user where u_id =  ? ";
        //select u_user from user where u_user=?
        //执行sql
        qr.update(sql,u_id);
    }

    /**
     * 批量删除用户
     * @param id
     */
    @Override
    public void deleteUserlist(String id) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner();
        //编写sql
        String sql = "delete  from user where u_id =  ? ";
        //select u_user from user where u_user=?
        //执行sql
        qr.update(JDBCUtils.getConnection(),sql,id);
    }

}
