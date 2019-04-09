package com.demo.domain;

import java.util.Date;

public class Eventhandle {
    private Long id;

    private Eventnotice eventnotice;

    private String photopath;

    private Employee employee;

    private Long status;

    private Date createdate;

    private Date donetime;

    private String address;

    private String describe;

    private Managetype managetype;

    public Managetype getManagetype() {
        return managetype;
    }

    public void setManagetype(Managetype managetype) {
        this.managetype = managetype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Eventnotice getEventnotice() {
        return eventnotice;
    }

    public void setEventnotice(Eventnotice eventnotice) {
        this.eventnotice = eventnotice;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getDonetime() {
        return donetime;
    }

    public void setDonetime(Date donetime) {
        this.donetime = donetime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    @Override
    public String toString() {
        return "Eventhandle{" +
                "id=" + id +
                ", eventnotice=" + eventnotice +
                ", photopath='" + photopath + '\'' +
                ", employee=" + employee +
                ", status=" + status +
                ", createdate=" + createdate +
                ", donetime=" + donetime +
                ", address='" + address + '\'' +
                ", describe='" + describe + '\'' +
                ", managetype=" + managetype +
                '}';
    }
}