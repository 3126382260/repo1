package cn.bloghut.dao.web;

import cn.bloghut.bean.ArticleAndNav;
import cn.bloghut.bean.ArticleBean;

import java.sql.SQLException;
import java.util.List;

public interface WebDao {
    /**
     * 根据文章id查询该文章
     * @param a_id
     * @return
     */
    ArticleAndNav queryArticleAndA_id(String a_id) throws SQLException;

    /**
     * 获取上一篇文章
     * @param a_id
     * @return
     */
    ArticleAndNav queryArticleAndUp(String a_id) throws SQLException;

    /**
     * 获取下一篇文章
     * @param a_id
     * @return
     */
    ArticleAndNav queryArticleAndDown(String a_id) throws SQLException;

    /**
     * 获取文章总数
     * @return
     */
    int queryArticleRow() throws SQLException;

    /**
     * 获取最新发布的8篇文章
     * @return
     */
    List<ArticleBean> queryLast() throws SQLException;

    /**
     * 获取最热门的8篇文章
     * @return
     */
    List<ArticleBean> queryReMen() throws SQLException;
}
