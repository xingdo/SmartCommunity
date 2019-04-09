package com.demo.domain;

public class Department {

    private Long deid;

    private String department;

    private Employee employee;

    public Long getDeid() {
        return deid;
    }

    public void setDeid(Long deid) {
        this.deid = deid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deid=" + deid +
                ", department='" + department + '\'' +
                ", employee=" + employee +
                '}';
    }
}