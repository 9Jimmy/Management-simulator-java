package com.jimmy9.management.backend;

class Workers{

    private String company;
    private String key;
    private String fname;
    private String sname;
    private String position;
    private String age;
    private String salary;

    static class Builder{
        private String company;
        private String key;
        private String fname;

        private String sname = "???";
        private String position = "???";
        private String age = "???";
        private String salary = "???";

        Builder(String company, String key, String fname){
            this.company = company;
            this.key = key;
            this.fname = fname;
        }

        Builder sname(String sname) {
            this.sname = sname;
            return this;
        }

        Builder position(String position) {
            this.position = position;
            return this;
        }

        Builder age(String age) {
            this.age = age;
            return this;
        }

        Builder salary(String salary) {
            this.salary = salary;
            return this;
        }

        Workers build(){
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

    String company() {
        return company;
    }

    String key() {
        return key;
    }

    void setSalary(String salary) {
        this.salary = salary;
    }

    void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "{key='" + key + '\'' +
                ", fname='" + fname + '\'' +
                ", sname='" + sname + '\'' +
                ", position='" + position + '\'' +
                ", age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
