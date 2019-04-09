package com.demo.domain;

public class Employee {
    private Long id;

    private String username;

    private String password;

    private String phone;

    private Department department;

    private String policecode;

    private String headimage;
    //验证码接收
    private String rannum;

    public String getRannum() {
        return rannum;
    }

    public void setRannum(String rannum) {
        this.rannum = rannum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPolicecode() {
        return policecode;
    }

    public void setPolicecode(String policecode) {
        this.policecode = policecode == null ? null : policecode.trim();
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage == null ? null : headimage.trim();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", department=" + department +
                ", policecode='" + policecode + '\'' +
                ", headimage='" + headimage + '\'' +
                '}';
    }
}