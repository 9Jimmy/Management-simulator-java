package com.jimmy9.management.backend;

import java.util.Scanner;

public class consoleInterface {
    Commands commands = new Commands();
    Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("=====================Management-Simulator=====================\n\n\n");
        System.out.print("\nEnter 'help' to check commands\n");
        System.out.print("Enter 'info' to check information about app");

        boolean session = true;

        while (session) {

            System.out.print("\n\n>>>");
            String i = input.nextLine();
            if (i.equals("info")) {
                commands.info();
            } else if (i.equals("help")) {
                commands.help();
            } else if (i.equals("addW")) {
                commands.addW();
            } else if (i.equals("showAll")) {
                commands.showAll();
            } else if (i.equals("showS")) {
                commands.showS();
            } else if (i.equals("changeS")) {
                commands.changeS();
            } else if (i.equals("changeP")) {
                commands.changeP();
            } else if (i.equals("deleteW")) {
                commands.deleteW();
            } else if (i.equals("clist")) {
                commands.clist();
            } else if (i.equals("exit")) {
                session = false;
            } else {
                System.out.printf("\nUnknown command \'%s\' enter \'help\' to check list of commands.", i);
            }
        }
    }
}

