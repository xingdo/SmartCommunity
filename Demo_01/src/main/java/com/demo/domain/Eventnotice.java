package com.demo.domain;

public class Eventnotice {
    private Long id;

    private String eventname;

    private Managetype managetype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname == null ? null : eventname.trim();
    }

    public Managetype getManagetype() {
        return managetype;
    }

    public void setManagetype(Managetype managetype) {
        this.managetype = managetype;
    }

    @Override
    public String toString() {
        return "Eventnotice{" +
                "id=" + id +
                ", eventname='" + eventname + '\'' +
                ", managetype=" + managetype +
                '}';
    }
}