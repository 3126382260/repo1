package cn.bloghut.serviceimpl.web;

import cn.bloghut.bean.ArticleAndNav;
import cn.bloghut.bean.ArticleBean;
import cn.bloghut.dao.web.WebDao;
import cn.bloghut.daoimpl.web.WebDaoImpl;
import cn.bloghut.service.web.WebService;

import java.sql.SQLException;
import java.util.List;

public class WebServiceImpl implements WebService {
    /**
     * 根据文章id查询该文章
     * @param a_id
     * @return
     */
    @Override
    public ArticleAndNav queryArticleAndA_id(String a_id) throws SQLException {
        //创建对象
        WebDao webDao = new WebDaoImpl();
        //调用方法
        return webDao.queryArticleAndA_id(a_id);
    }

    /**
     * 获取上一篇文章
     * @param a_id
     * @return
     */
    @Override
    public ArticleAndNav queryArticleAndUp(String a_id) throws SQLException {
        //创建对象
        WebDao webDao = new WebDaoImpl();
        //调用方法
        return webDao.queryArticleAndUp(a_id);
    }

    /**
     * 获取下一篇文章
     * @param a_id
     * @return
     */
    @Override
    public ArticleAndNav queryArticleAndDown(String a_id) throws SQLException {
        //创建对象
        WebDao webDao = new WebDaoImpl();
        //调用方法
        return webDao.queryArticleAndDown(a_id);
    }

    /**
     * 获取文章总数
     * @return
     */
    @Override
    public int queryArticleRow() throws SQLException {
        //创建对象
        WebDao webDao = new WebDaoImpl();
        //调用方法
        return webDao.queryArticleRow();
    }

    /**
     * 获取最新发布的8篇文章
     * @return
     */
    @Override
    public List<ArticleBean> queryLast() throws SQLException {
        //创建对象
        WebDao webDao = new WebDaoImpl();
        //调用方法
        return webDao.queryLast();
    }

    /**
     * 获取热门的8篇文章
     * @return
     */
    @Override
    public List<ArticleBean> queryReMen() throws SQLException {
        //创建对象
        WebDao webDao = new WebDaoImpl();
        //调用方法
        return webDao.queryReMen();
    }
}
