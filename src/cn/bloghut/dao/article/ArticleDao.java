package cn.bloghut.dao.article;

import cn.bloghut.bean.ArticleAndNav;
import cn.bloghut.bean.ArticleBean;
import cn.bloghut.bean.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDao {
    /**
     * 添加文章
     * @param bean
     */
    void addArticle(ArticleBean bean) throws SQLException;

    /**
     * 查询所有文章
     * @return
     */
    List<ArticleAndNav> queryArticleAll() throws SQLException;

    /**
     * 通过id查询对应的文章
     * @param a_id
     * @return
     */
    ArticleAndNav queryArticleA_id(String a_id) throws SQLException;

    /**
     * 修改文章
     * @param bean
     */
    void updateArtivle(ArticleBean bean) throws SQLException;

    /**
     * 根据id删文章
     * @param a_id
     */
    void deleteArticle(String a_id) throws SQLException;

    /**
     * 批量删除文章
     * @param s
     */
    void deleteArticlelist(String s) throws SQLException;

    /**
     * 分页展示数据--获取每页展示的数据
     * @param bean
     * @return
     */
    List<ArticleAndNav> queryArticleAllPage(PageBean<ArticleAndNav> bean) throws SQLException;

    /**
     * 分页展示数据--获取总条数
     * @return
     */
    int getArticlePageCount() throws SQLException;

    /**
     * 分页展示数据--模糊查询
     * @param bean
     * @param n_id
     * @param a_title
     * @return
     */
    List<ArticleAndNav> queryArticleAllPageSeek(PageBean<ArticleAndNav> bean, String n_id, String a_title) throws SQLException;

    /**
     * 模糊查询获取数据
     * @param n_id
     * @param a_title
     * @return
     */
    int getCountArticleAllPageSeek(String n_id, String a_title) throws SQLException;
}
