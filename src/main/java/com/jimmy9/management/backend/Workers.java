package com.jimmy9.management.backend;

public class Workers{

    private String company;
    private String key;
    private String fname;
    private String sname;
    private String position;
    private String age;
    private String salary;

    Workers(String company, String key, String fname, String sname, String position, String age, String salary){
        this.company = company;
        this.key = key;
        this.fname = fname;
        this.sname = sname;
        this.position = position;
        this.age = age;
        this.salary = salary;
    }

    public String fname() {
        return fname;
    }

    public String sname() {
        return sname;
    }

    public String position() {
        return position;
    }

    public String age() {
        return age;
    }

    public String salary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String company() {
        return company;
    }

    public String key() {
        return key;
    }
}