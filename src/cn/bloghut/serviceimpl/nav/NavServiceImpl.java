package cn.bloghut.serviceimpl.nav;

import cn.bloghut.bean.ArticleBean;
import cn.bloghut.bean.NavBean;
import cn.bloghut.dao.nav.NavDao;
import cn.bloghut.daoimpl.nav.NavDaoImpl;
import cn.bloghut.service.nav.NavService;
import cn.bloghut.servlet.nav.NavList;
import cn.bloghut.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class NavServiceImpl implements NavService {
    /**
     * 添加分类
     * @param nb
     */
    @Override
    public void insertNav(NavBean nb) throws SQLException {
        //创建对象
        NavDao navDao = new NavDaoImpl();
        //调用方法
        navDao.insertNav(nb);
    }

    /**
     * 查询分类名称是否存在
     * @param n_name
     * @return
     */
    @Override
    public NavBean queryNav(String n_name) throws SQLException {
        //创建对象
        NavDao navDao = new NavDaoImpl();
        //调用方法
       return navDao.queryNav(n_name);
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<NavBean> queryNavList() throws SQLException {
        //创建对象
        NavDao navDao = new NavDaoImpl();
        //调用方法
        return navDao.queryNavList();
    }

    /**
     * 根据id查询该bean
     * @param n_id
     * @return
     */
    @Override
    public NavBean queryNAvId(String n_id) throws SQLException {
        //创建对象
        NavDao navDao = new NavDaoImpl();
        //调用方法
        return navDao.queryNAvId(n_id);
    }

    /**
     * 根据分类名称和路径查询该分类是否存在
     * @param n_name
     * @param en_n_name
     * @param n_url
     * @return
     */
    @Override
    public NavBean queryNavAndName(String n_name, String en_n_name, String n_url) throws SQLException {
        //创建对象
        NavDao navDao = new NavDaoImpl();
        //调用方法
        return navDao.queryNavAndName(n_name,en_n_name,n_url);
    }

    /**
     * 根据id修改修改分类
     * @param navBean
     */
    @Override
    public void updateNav(NavBean navBean) throws SQLException {
        //创建对象
        NavDao navDao = new NavDaoImpl();
        //调用方法
        navDao.updateNav(navBean);
    }

    @Override
    public void delete(String n_id) throws SQLException {
        //创建对象
        NavDao navDao = new NavDaoImpl();
        //调用方法
        navDao.delete(n_id);
    }

    /**
     * 根据n_id查询是否有文章引用该分类--有的话不能删除
     * @param n_id
     * @return
     */
    @Override
    public List<ArticleBean> queryArticleAndNid(String n_id) throws SQLException {
        //创建对象
        NavDao navDao = new NavDaoImpl();
        //调用方法
        return navDao.queryArticleAndNid(n_id);
    }

    /**
     * 批量删除分类
     * @param ids
     */
    @Override
    public void deletelist(String[] ids) throws SQLException {
        int i = 10;
        try {
            //创建对象
            NavDao navDao = new NavDaoImpl();
            //开启事务
            JDBCUtils.beginTransaction();
            if(ids!=null){
                for(String s : ids){
                    //调用方法
                    //拿着id去数据库查询--如果查询到-该分类下有数据-则不能删除
                    List<ArticleBean> list = navDao.queryArticleAndNid(s);
                    if(list.size()<1){
                        //如果没有文章引用该分类-执行删除操作
                        navDao.deletelist(s);
                    }else{
                        //如果有文章引用分类-不能删除
                        i = 10/0;
                    }
                }
            }
            //提交事务
            JDBCUtils.comitTransaction();
        }catch (Exception e){
            e.printStackTrace();
            //回滚事务
            JDBCUtils.rellbackAndClose();
            throw e;
        }
    }
}
