package cn.bloghut.serviceimpl.article;

import cn.bloghut.bean.ArticleAndNav;
import cn.bloghut.bean.ArticleBean;
import cn.bloghut.bean.PageBean;
import cn.bloghut.dao.article.ArticleDao;
import cn.bloghut.daoimpl.article.ArticleDaoImpl;
import cn.bloghut.service.article.ArticleService;
import cn.bloghut.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    /**
     * 添加文章
     * @param bean
     */
    @Override
    public void addArticle(ArticleBean bean) throws SQLException {
        //创建对象
        ArticleDao dao = new ArticleDaoImpl();
        //调用方法
        dao.addArticle(bean);
    }

    /**
     * 查询所有文章
     * @return
     */
    @Override
    public List<ArticleAndNav> queryArticleAll() throws SQLException {
        //创建对象
        ArticleDao dao = new ArticleDaoImpl();
        //调用方法
       return dao.queryArticleAll();
    }

    /**
     * 通过id查询对应的文章
     * @param a_id
     * @return
     */
    @Override
    public ArticleAndNav queryArticleA_id(String a_id) throws SQLException {
        //创建对象
        ArticleDao dao = new ArticleDaoImpl();
        //调用方法
        return dao.queryArticleA_id(a_id);
    }

    /**
     * 修改文章
     * @param bean
     */
    @Override
    public void updateArtivle(ArticleBean bean) throws SQLException {
        //创建对象
        ArticleDao dao = new ArticleDaoImpl();
        //调用方法
        dao.updateArtivle(bean);
    }

    /**
     * 根据id删除文章
     * @param a_id
     */
    @Override
    public void deleteArticle(String a_id) throws SQLException {
        //创建对象
        ArticleDao dao = new ArticleDaoImpl();
        //调用方法
        dao.deleteArticle(a_id);
    }

    /**
     * 批量删除文章
     * @param ids
     */
    @Override
    public void deleteArticleList(String[] ids) throws SQLException {
        try {
            //创建对象
            ArticleDao dao = new ArticleDaoImpl();
            //开启事务
            JDBCUtils.beginTransaction();
            if(ids!=null){
                for(String s : ids){
                    //调用方法删除
                    dao.deleteArticlelist(s);
                }
            }
            //提交事务
            JDBCUtils.comitTransaction();
        }catch (Exception e){
            e.printStackTrace();
            JDBCUtils.rellbackAndClose();
            throw e;
        }
    }

    /**
     * 分页显示数据
     * @param pagep
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<ArticleAndNav> queryArticlePage(int pagep, int pageSize) throws SQLException {
        //创建对象
        ArticleDao dao = new ArticleDaoImpl();
        PageBean<ArticleAndNav> bean = new PageBean<>(pagep,pageSize);
        //通过对象获取数据---获取每页显示的内容
        List<ArticleAndNav> list = dao.queryArticleAllPage(bean);
        //通过对象获取数据---取总条数
        bean.setList(list);
        int rows = dao.getArticlePageCount();
        //将数据添加至javabean
        bean.setCount(rows);
        return bean;
    }

    /**
     * 分页展示数据--模糊查询
     * @param pagep
     * @param pageSize
     * @param n_id
     * @param a_title
     * @return
     */
    @Override
    public PageBean<ArticleAndNav> queryArticleAllPageSeek(int pagep, int pageSize, String n_id, String a_title) throws SQLException {
        //创建对象
        ArticleDao dao = new ArticleDaoImpl();
        PageBean<ArticleAndNav> bean = new PageBean<>(pagep,pageSize);
        //通过对象获取数据---获取每页显示的内容
        List<ArticleAndNav> list = dao.queryArticleAllPageSeek(bean,n_id,a_title);
        bean.setList(list);
        int count = dao.getCountArticleAllPageSeek(n_id,a_title);
        //将数据添加至javabean
        bean.setCount(count);
        return bean;
    }
}
