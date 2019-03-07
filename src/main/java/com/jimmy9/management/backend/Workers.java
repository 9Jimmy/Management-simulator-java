package com.jimmy9.management.backend;

public class Workers{

    private String company;
    private String key;
    private String fname;
    private String sname;
    private String position;
    private String age;
    private String salary;

    public static class Builder{
        private String company;
        private String key;
        private String fname;

        private String sname = "???";
        private String position = "???";
        private String age = "???";
        private String salary = "???";

        public Builder(String company, String key, String fname){
            this.company = company;
            this.key = key;
            this.fname = fname;
        }

        public Builder sname(String sname) {
            this.sname = sname;
            return this;
        }

        public Builder position(String position) {
            this.position = position;
            return this;
        }

        public Builder age(String age) {
            this.age = age;
            return this;
        }

        public Builder salary(String salary) {
            this.salary = salary;
            return this;
        }

        public Workers build(){
            return new Workers(this);
        }
    }

    private Workers(Builder builder){
        company = builder.company;
        key = builder.key;
        fname = builder.fname;
        sname = builder.sname;
        position = builder.position;
        age = builder.age;
        salary = builder.salary;
    }

    public String company() {
        return company;
    }

    public String key() {
        return key;
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
}