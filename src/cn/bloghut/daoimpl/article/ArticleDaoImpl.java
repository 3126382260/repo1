package cn.bloghut.daoimpl.article;

import cn.bloghut.bean.ArticleAndNav;
import cn.bloghut.bean.ArticleBean;
import cn.bloghut.bean.PageBean;
import cn.bloghut.dao.article.ArticleDao;
import cn.bloghut.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {
    /**
     * 添加文章
     * @param bean
     */
    @Override
    public void addArticle(ArticleBean bean) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "insert into article values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
        //执行sql
        qr.update(sql,bean.getA_title(),bean.getA_author()
                ,bean.getA_date(),bean.getEn_a_title()
                ,bean.getEn_a_author(),bean.getEn_a_date()
                ,bean.getN_id(),bean.getA_feight(),bean.getA_laiyuan(),bean.getEn_laiyuan()
                ,bean.getA_content(),bean.getEn_a_content());
    }
    /**
     * 查询所有文章
     * @return
     */
    @Override
    public List<ArticleAndNav> queryArticleAll() throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select * from article,nav where article.n_id=nav.n_id order by a_date desc";
        //执行sql
        List<ArticleAndNav> lista = qr.query(sql, new BeanListHandler<ArticleAndNav>(ArticleAndNav.class));
        return lista;
    }

    /**
     * 通过id查询对应文章
     * @param a_id
     * @return
     */
    @Override
    public ArticleAndNav queryArticleA_id(String a_id) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select * from article,nav where article.n_id=nav.n_id and a_id = ?";
        //执行sql
        ArticleAndNav lista = qr.query(sql, new BeanHandler<ArticleAndNav>(ArticleAndNav.class),a_id);
        return lista;
    }

    /**
     * 修改文章
     * @param bean
     */
    @Override
    public void updateArtivle(ArticleBean bean) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "update article set a_title = ?,a_author=?,a_date=?,en_a_title=?,en_a_author=?,en_a_date=?,n_id=?,a_feight=?,a_laiyuan=?,en_laiyuan=?,a_content=?,en_a_content=? where a_id = ?";
        //执行sql
        qr.update(sql,bean.getA_title(),bean.getA_author(),bean.getA_date(),bean.getEn_a_title(),bean.getEn_a_author(),bean.getEn_a_date(),bean.getN_id(),bean.getA_feight(),bean.getA_laiyuan(),bean.getEn_laiyuan(),bean.getA_content(),bean.getEn_a_content(),bean.getA_id());
    }

    /**
     * 根据id删除文章
     * @param a_id
     */
    @Override
    public void deleteArticle(String a_id) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "delete from article where a_id = ?";
        //执行sql
        qr.update(sql,a_id);
    }

    /**
     * 批量删除文章
     * @param s
     */
    @Override
    public void deleteArticlelist(String s) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner();
        //编写sql
        String sql = "delete from article where a_id = ?";
        //执行sql
        qr.update(JDBCUtils.getConnection(),sql,s);
    }

    /**
     * 获取每页展示的数据
     * @param bean
     * @return
     */
    @Override
    public List<ArticleAndNav> queryArticleAllPage(PageBean<ArticleAndNav> bean) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select * from article,nav" +
                " where article.n_id=nav.n_id   " +
                " order by a_date desc " +
                " limit ?,? ";
        //执行sql
        List<ArticleAndNav> query = qr.query(sql, new BeanListHandler<ArticleAndNav>(ArticleAndNav.class), bean.getIndex(), bean.getPageSize());

        return query;
    }

    /**
     * 获取总条数
     * @return
     */
    @Override
    public int getArticlePageCount() throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select count(*) from article,nav  where article.n_id=nav.n_id";
        //执行sql
        int Count = ((Long)qr.query(sql, new ScalarHandler())).intValue();
        return Count;
    }

    /**
     * 分页展示数据---模糊查询
     * @param bean
     * @param n_id
     * @param a_title
     * @return
     */
    @Override
    public List<ArticleAndNav> queryArticleAllPageSeek(PageBean<ArticleAndNav> bean, String n_id, String a_title) throws SQLException {
        List<ArticleAndNav> query = null;
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select * from article,nav" +
                " where article.n_id=nav.n_id   ";
                if((n_id!=null) && (!"".equals(n_id))){
                    sql+=" and nav.n_id = ?  ";
                }
                if((a_title!=null) && (!"".equals(a_title))){
                    sql+=" and a_title like ?  ";
                }
                sql+=" order by a_date desc " +
                " limit ?,? ";
        //执行sql
                if((n_id!=null) && (!"".equals(n_id)) && (a_title!=null) && (!"".equals(a_title))){
                    query = qr.query(sql, new BeanListHandler<ArticleAndNav>(ArticleAndNav.class),n_id,"%"+a_title+"%",bean.getIndex(), bean.getPageSize());
                    return query;
                }else if((n_id!=null) && (!"".equals(n_id))){
                    query = qr.query(sql, new BeanListHandler<ArticleAndNav>(ArticleAndNav.class),n_id,bean.getIndex(), bean.getPageSize());
                    return query;
                }else if((a_title!=null) && (!"".equals(a_title))){
                    query = qr.query(sql, new BeanListHandler<ArticleAndNav>(ArticleAndNav.class),"%"+a_title+"%",bean.getIndex(), bean.getPageSize());
                    return query;
                }else{
                    query = qr.query(sql, new BeanListHandler<ArticleAndNav>(ArticleAndNav.class),bean.getIndex(), bean.getPageSize());
                }
        return query;
    }

    @Override
    public int getCountArticleAllPageSeek(String n_id, String a_title) throws SQLException {
        int Count =0;
        int pop = 0;
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select count(*) from article";

               if((n_id!=null) && (!"".equals(n_id))){
                   sql=" select count(*) from article,nav where article.n_id=nav.n_id and nav.n_id =  ? ";
                   pop = 1;
               }
               if((a_title!=null) && (!"".equals(a_title))){
                   if(pop==1){
                        sql += " and a_title like  ? ";
                        pop++;
                   }else {
                       sql += " where a_title like  ?  ";
                       pop+=3;
                   }
               }
               if(pop==2){
                   Count = ((Long)qr.query(sql, new ScalarHandler(),n_id,"%"+a_title+"%")).intValue();
                   return Count;
               }else  if(pop == 1){
                   Count = ((Long)qr.query(sql, new ScalarHandler(),n_id)).intValue();
                   return Count;
               }else  if(pop == 3){
                   Count = ((Long)qr.query(sql, new ScalarHandler(),"%"+a_title+"%")).intValue();
                   return Count;
               }else if (pop == 0){
                   Count = ((Long)qr.query(sql, new ScalarHandler())).intValue();
                   return Count;
               }
        return Count;
    }

}
