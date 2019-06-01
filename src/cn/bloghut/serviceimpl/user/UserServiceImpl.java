package cn.bloghut.serviceimpl.user;

import cn.bloghut.bean.UserBean;
import cn.bloghut.dao.user.UserDao;
import cn.bloghut.daoimpl.user.UserDaoimpl;
import cn.bloghut.service.user.UserService;
import cn.bloghut.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    /**
     * 用户登录
     * @param bean
     * @return
     */
    @Override
    public UserBean queryUser(UserBean bean) throws SQLException {
        //创建对象
        UserDao ud = new UserDaoimpl();
        //调用方法
        return ud.queryUser(bean);
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<UserBean> queryUserList() throws SQLException {
        //创建对象
        UserDao ud = new UserDaoimpl();
        //调用方法
        return ud.queryUserList();
    }

    /**
     * 添加用户
     * @param userBean
     */
    @Override
    public void addUser(UserBean userBean) throws SQLException {
        //创建对象
        UserDao ud = new UserDaoimpl();
        //调用方法
        ud.addUser(userBean);
    }

    /**
     * 根据账号查询用户是否存在
     * @param user
     * @return
     */
    @Override
    public UserBean queryUserAndU(String user) throws SQLException {
        //创建对象
        UserDao ud = new UserDaoimpl();
        //调用方法
        return ud.queryUserAndU(user);
    }

    /**
     * 修改用户信息回显数据
     * @param u_id
     * @return
     */
    @Override
    public UserBean queryUserBean(String u_id) throws SQLException {
        //创建对象
        UserDao ud = new UserDaoimpl();
        //调用方法
        return ud.queryUserBean(u_id);
    }

    /**
     * 修改用户信息
     * @param ub
     */
    @Override
    public void updateUser(UserBean ub) throws SQLException {
        //创建对象
        UserDao ud = new UserDaoimpl();
        //调用方法
        ud.updateUser(ub);
    }

    /**
     * 根据id删除用户
     * @param u_id
     */
    @Override
    public void deleteUser(String u_id) throws SQLException {
        //创建对象
        UserDao ud = new UserDaoimpl();
        //调用方法
        ud.deleteUser(u_id);
    }

    /**
     * 批量删除用户
     * @param ids
     */
    @Override
    public void delList(String[] ids) throws SQLException {
        try {
            //创建对象
            UserDao ud = new UserDaoimpl();
            //开启事务
            JDBCUtils.beginTransaction();
            if(ids!=null){
                for(String id : ids){
                    //调用方法删除
                    ud.deleteUserlist(id);
                }
            }
            //提交事务
            JDBCUtils.comitTransaction();
        }catch (Exception e){
            e.printStackTrace();
            //回滚事务
            JDBCUtils.rellbackAndClose();
            throw  e;
        }
    }
}
