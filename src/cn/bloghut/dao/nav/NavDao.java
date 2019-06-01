package cn.bloghut.dao.nav;

import cn.bloghut.bean.ArticleBean;
import cn.bloghut.bean.NavBean;
import cn.bloghut.servlet.nav.NavList;

import java.sql.SQLException;
import java.util.List;

public interface NavDao {
    /**
     * 添加分类
     * @param nb
     */
    void insertNav(NavBean nb) throws SQLException;

    /**
     * 查询分类名称是否存在
     * @param n_name
     * @return
     */
    NavBean queryNav(String n_name) throws SQLException;

    /**
     * 查询所有用户信息
     * @return
     */
    List<NavBean> queryNavList() throws SQLException;

    /**
     * 根据id查询bean
     * @param n_id
     * @return
     */
    NavBean queryNAvId(String n_id) throws SQLException;

    /**
     * 根据分类名称和路径查询该分类是否存在
     * @param n_name
     * @param en_n_name
     * @param n_url
     * @return
     */
    NavBean queryNavAndName(String n_name, String en_n_name, String n_url) throws SQLException;

    /**
     * 根据id修改修改分类
     * @param navBean
     */
    void updateNav(NavBean navBean) throws SQLException;

    /**
     * 根据id删除分类
     * @param n_id
     */
    void delete(String n_id) throws SQLException;

    /**
     * 根据n_id查询是否有文章引用该分类--有的话不能删除
     * @param n_id
     * @return
     */
    List<ArticleBean> queryArticleAndNid(String n_id) throws SQLException;

    /**
     * 批量删除分类
     * @param s
     */
    void deletelist(String s) throws SQLException;
}
