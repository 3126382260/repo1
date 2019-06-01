package cn.bloghut.daoimpl.nav;

import cn.bloghut.bean.ArticleBean;
import cn.bloghut.bean.NavBean;
import cn.bloghut.dao.nav.NavDao;
import cn.bloghut.servlet.nav.NavList;
import cn.bloghut.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class NavDaoImpl implements NavDao {
    /**
     * 添加分类
     *
     * @param nb
     */
    @Override
    public void insertNav(NavBean nb) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "insert into nav values(null,?,?,?,?,?,?)";
        //执行sql
        qr.update(sql, nb.getN_name(), nb.getEn_n_name(), nb.getN_introduce(), nb.getEn_n_name(), nb.getN_feight(), nb.getN_url());
    }

    /**
     * 查询分类名称是否存在
     *
     * @param n_name
     * @return
     */
    @Override
    public NavBean queryNav(String n_name) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select n_name from nav where n_name = ? ";
        //执行sql
        NavBean query = qr.query(sql, new BeanHandler<NavBean>(NavBean.class), n_name);
        return query;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<NavBean> queryNavList() throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select * from nav";
        //执行sql
        List<NavBean> list = qr.query(sql, new BeanListHandler<NavBean>(NavBean.class));
        return list;
    }

    /**
     * 根据id查询bean
     *
     * @param n_id
     * @return
     */
    @Override
    public NavBean queryNAvId(String n_id) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select * from nav where n_id = ?";
        //执行sql
        NavBean nb = qr.query(sql, new BeanHandler<NavBean>(NavBean.class), n_id);
        return nb;
    }

    /**
     * 根据分类名称和路径查询该分类是否存在
     *
     * @param n_name
     * @param en_n_name
     * @param n_url
     * @return
     */
    @Override
    public NavBean queryNavAndName(String n_name, String en_n_name, String n_url) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select * from nav where n_name = ? and en_n_name = ? and n_url = ?";
        //执行sql
        NavBean nb = qr.query(sql, new BeanHandler<NavBean>(NavBean.class), n_name, en_n_name, n_url);
        return nb;
    }

    /**
     * 根据id修改分类
     *
     * @param navBean
     */
    @Override
    public void updateNav(NavBean navBean) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "update  nav set n_name = ?,en_n_name = ?,n_introduce = ?,n_alias = ?,n_feight = ?,n_url = ?  where n_id = ? ";
        //执行sql
        qr.update(sql, navBean.getN_name(), navBean.getEn_n_name(), navBean.getN_introduce(), navBean.getN_alias(), navBean.getN_feight(), navBean.getN_url(), navBean.getN_id());
    }

    /**
     * 根据id删除分类
     *
     * @param n_id
     */
    @Override
    public void delete(String n_id) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "delete from nav where n_id = ?";
        //执行sql
        qr.update(sql, n_id);
    }

    /**
     * 根据n_id查询是否有文章引用该分类--有的话不能删除
     * @param n_id
     * @return
     */
    @Override
    public List<ArticleBean> queryArticleAndNid(String n_id) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        //编写sql
        String sql = "select n_id from article where n_id = ?";
        //执行sql
        List<ArticleBean> query = qr.query(sql, new BeanListHandler<ArticleBean>(ArticleBean.class), n_id);
        return query;
    }

    /**
     * 批量删除分类
     * @param s
     */
    @Override
    public void deletelist(String s) throws SQLException {
        //创建对象
        QueryRunner qr = new QueryRunner();
        //编写sql
        String sql = "delete from nav where n_id = ?";
        //执行sql
        qr.update(JDBCUtils.getConnection(),sql,s);
    }
}