package com.demo.domain;

public class Location {
    private Long id;

    private String loaddress;

    private Employee employee;

    private Long status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoaddress() {
        return loaddress;
    }

    public void setLoaddress(String loaddress) {
        this.loaddress = loaddress == null ? null : loaddress.trim();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", loaddress='" + loaddress + '\'' +
                ", employee=" + employee +
                ", status=" + status +
                '}';
    }
}