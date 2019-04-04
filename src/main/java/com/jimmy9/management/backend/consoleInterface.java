package com.jimmy9.management.backend;

import java.util.Scanner;

public class consoleInterface {
    private Commands commands = new Commands();
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("=====================Management-Simulator=====================\n\n\n");
        System.out.print("\nEnter 'help' to check commands\n");
        System.out.print("Enter 'info' to check information about app");

        boolean session = true;

        while (session) {

            System.out.print("\n\n>>>");
            String i = input.nextLine();
            switch (i){
                case "info":
                    commands.info();
                    break;
                case "help":
                    commands.help();
                    break;
                case "addW":
                    commands.addW();
                    break;
                case "showAll":
                    commands.showAll();
                    break;
                case "showS":
                    commands.showS();
                    break;
                case "changeS":
                    commands.changeS();
                    break;
                case "changeP":
                    commands.changeP();
                    break;
                case "deleteW":
                    commands.deleteW();
                    break;
                case "clist":
                    commands.clist();
                    break;
                case "exit":
                    session = false;
                    break;
                    default:
                        System.out.printf("\nUnknown command \'%s\' enter \'help\' to check list of commands.", i);
            }
        }
    }
}
