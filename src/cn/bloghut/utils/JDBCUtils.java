package cn.bloghut.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtils {
       //创建连接池
        private static ComboPooledDataSource ds = new ComboPooledDataSource();
       //创建多线程
        private static ThreadLocal<Connection> tl = new ThreadLocal<>();
       //获取c3p0线程池
        public static DataSource getDataSource(){
            return  ds;
        }
    /**
     * 从当前获取连接
     */
    public  static Connection getConnection() throws SQLException {
        Connection conn = tl.get();
        //若是第一次获取 是null
        if(conn==null){
            //获取连接
            conn = ds.getConnection();
            //将这个连接和当前线程绑定
            tl.set(conn);
        }
        return conn;
    }

    /**
     * 开启事务
     */
    public static void beginTransaction() throws SQLException {
        //获取连接
        Connection conn = getConnection();
        //提交事务
        conn.setAutoCommit(false);
    }
    /**
     * 提交事务
     */
    public static void comitTransaction() throws SQLException {
        //获取连接
        Connection conn = getConnection();
        try {
        if(conn!=null){
            conn.commit();
        }
            closeConn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    public static void rellbackAndClose(){
        try {
            //获取连接
            Connection conn = getConnection();
            //回滚事务
            if(conn!=null){
                conn.rollback();
            }
            //释放资源
            closeConn(conn);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * 释放资源
     */
    public static void closeConn(Connection conn){
        try {
            if(conn!=null){
                conn.close();
            }
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn =null;
    }
}
