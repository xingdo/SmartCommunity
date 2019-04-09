package com.demo.base;
/*
 * 高级查询
 * */
public class BaseQuery {
    //当前页
    private Integer page =1;
    //每页条数
    private Integer rows =10;
    //查询的条件
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    //从那一页开始显示数据
    public int getStart(){
        return (this.page-1)*rows;
    }
}