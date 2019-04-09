package com.demo.utils;

import java.util.ArrayList;
import java.util.List;

/*
* 封装的分页后的对象
* */
public class PageList<T> {
    //返回的总的条数
    private Long total = 0l;
    //每页的数据
    private List<T> rows = new ArrayList<>();

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageList(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageList() {
    }
}
