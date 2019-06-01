package cn.bloghut.daoimpl.web;

import cn.bloghut.bean.ArticleAndNav;
import cn.bloghut.bean.ArticleBean;
import cn.bloghut.dao.web.WebDao;
import cn.bloghut.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class WebDaoImpl implements WebDao {
    /**
     * 根据文章id查询该文章
     * @param a_id
     * @return
     */
    @Override
    public ArticleAndNav queryArticleAndA_id(String a_id) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写ssql
        String sql = "select * from article,nav  where article.n_id = nav.n_id and a_id = ?";
        //执行sql
        ArticleAndNav query = (ArticleAndNav) qr.query(sql, new BeanHandler<ArticleAndNav>(ArticleAndNav.class), a_id);
        return query;
    }

    /**
     * 获取上一篇文章
     * @param a_id
     * @return
     */
    @Override
    public ArticleAndNav queryArticleAndUp(String a_id) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select * from article where a_id < ? order by a_id desc  limit 0,1 ";
        //执行sql
        ArticleAndNav query = (ArticleAndNav) qr.query(sql, new BeanHandler<ArticleAndNav>(ArticleAndNav.class), a_id);
        return query;
    }
    /**
     * 获取下一篇文章
     * @param a_id
     * @return
     */
    @Override
    public ArticleAndNav queryArticleAndDown(String a_id) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql  = "select * from article where a_id > ?   limit 0,1";
        //执行sql
        ArticleAndNav query = (ArticleAndNav)qr.query(sql, new BeanHandler<ArticleAndNav>(ArticleAndNav.class), a_id);
        return query;
    }

    /**
     * 获取文章总数
     * @return
     */
    @Override
    public int queryArticleRow() throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql  = "select count(*) from article,nav  where article.n_id = nav.n_id ";
        //执行sql
        int rows = ((Long)qr.query(sql, new ScalarHandler())).intValue();
        return rows;
    }

    /**
     * 获取最新发布的8篇文章
     * @return
     */
    @Override
    public List<ArticleBean> queryLast() throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写ssql
        String sql = "select a_id,a_title,en_a_title from article order by a_date desc limit 0,6";
        //执行sql
        List<ArticleBean> query = qr.query(sql, new BeanListHandler<ArticleBean>(ArticleBean.class));
        return query;
    }

    /**
     * 获取最热门的6篇文章
     * @return
     */
    @Override
    public List<ArticleBean> queryReMen() throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写ssql
        String sql = "select a_id,a_title,en_a_title from article order by a_feight asc  limit 0,6";
        //执行sql
        List<ArticleBean> query = qr.query(sql, new BeanListHandler<ArticleBean>(ArticleBean.class));
        return query;
    }
}
