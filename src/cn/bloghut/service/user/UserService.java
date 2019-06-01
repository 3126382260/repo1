package cn.bloghut.service.user;

import cn.bloghut.bean.UserBean;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    /**
     * 用户登录
     * @param bean
     * @return
     */
    UserBean queryUser(UserBean bean) throws SQLException;

    /**
     * 查询所有用户
     * @return
     */
    List<UserBean> queryUserList() throws SQLException;

    /**
     * 添加用户
     * @param userBean
     */
    void addUser(UserBean userBean) throws SQLException;

    /**
     * 根据账号查询该账号是否存在
     * @param user
     * @return
     */
    UserBean queryUserAndU(String user) throws SQLException;

    /**
     * 修改用户信息回显数据
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
     * @param ids
     */
    void delList(String[] ids) throws SQLException;
}
