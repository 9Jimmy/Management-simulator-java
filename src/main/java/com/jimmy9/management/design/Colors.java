package com.jimmy9.management.design;

public enum  Colors {

    /**
     * List of available colors
     * */
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    BLUE("\u001B[34m");

    private String color;

    Colors(String color){
        this.color = color;
    }

    /**
     * Changes color of text in console
     * */
    public void Color(){
        System.out.println(color);
    }
}
