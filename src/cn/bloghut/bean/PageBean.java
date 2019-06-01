package cn.bloghut.bean;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
    List<T> list;                        //每页显示的数据
    private int  pageSize;               //每页显示的数量
    private int  rows;                   //总页数
    private int  count;                  //总条数
    private int  p;                      //当前页

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRows() {
        return  (int)Math.ceil(count*1.0/pageSize);
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getP() {
        return p;
    }
    public void setP(int p) {
        this.p = p;
    }
    //获取总页数
    public int getPageTotle(){
        return  (int)Math.ceil(count*1.0/pageSize);
    }
    //设置构造方法赋值
    public PageBean() {

    }
    public PageBean(int p, int pageSize) {
        this.pageSize = pageSize;
        this.p = p;
    }
    //获取数据索引
    public int getIndex(){
        return (p-1)*pageSize;
    }

}
