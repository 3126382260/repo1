package cn.bloghut.service.article;

import cn.bloghut.bean.ArticleAndNav;
import cn.bloghut.bean.ArticleBean;
import cn.bloghut.bean.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface ArticleService {
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
     * 通过id查询对于的文章
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
     * 根据id删除文章
     * @param a_id
     */
    void deleteArticle(String a_id) throws SQLException;

    /**
     * 批量删除文章
     * @param ids
     */
    void deleteArticleList(String[] ids) throws SQLException;

    /**
     * 分页显示数据
     * @param pagep
     * @param pageSize
     * @return
     */
    PageBean<ArticleAndNav> queryArticlePage(int pagep, int pageSize) throws SQLException;

    /**
     * 分页展示数据--模糊查询
     * @param pagep
     * @param pageSize
     * @param n_id
     * @param a_title
     * @return
     */
    PageBean<ArticleAndNav> queryArticleAllPageSeek(int pagep, int pageSize, String n_id, String a_title) throws SQLException;
}
