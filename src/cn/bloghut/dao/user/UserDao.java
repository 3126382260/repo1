package cn.bloghut.dao.user;

import cn.bloghut.bean.UserBean;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    /**
     * 用户登录
     * @param bean
     * @return
     */
    UserBean queryUser(UserBean bean) throws SQLException;

    /**
     * 查询所有用户信息
     * @return
     */
    List<UserBean> queryUserList() throws SQLException;
    /**
     * 添加用户
     */
    void addUser(UserBean userBean) throws SQLException;

    /**
     * 查询用户是否存在
     * @param user
     * @return
     */
    UserBean queryUserAndU(String user) throws SQLException;

    /**
     * 修改用户信息，回显数据
     * @param u_id
     * @return
     */
    UserBean queryUserBean(String u_id) throws SQLException;

    /**
     * 修改用户信息
     * @param ub
     */
    void updateUser(UserBean ub) throws SQLException;

    /**
     * 根据id删除用户
     * @param u_id
     */
    void deleteUser(String u_id) throws SQLException;

    /**
     * 批量删除用户
     * @param id
     */
    void deleteUserlist(String id) throws SQLException;
}
