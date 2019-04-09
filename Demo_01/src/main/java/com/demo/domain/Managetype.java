package com.demo.domain;

public class Managetype {
    private Long id;

    private String typename;

    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Managetype{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                ", department=" + department +
                '}';
    }
}