package com.jimmy9.management.design;

public enum  Colors {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    BLUE("\u001B[34m");

    private String color;

    Colors(String color){
        this.color = color;
    }

    public String Color(){
        System.out.println(color);
        return color;
    }
}
