package com.demo.utils;
//模板标签
public class FieldVo {

    private String field;//domain的field
    private String title;//domain的title:标签上的值


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "FieldVo{" +
                "field='" + field + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
