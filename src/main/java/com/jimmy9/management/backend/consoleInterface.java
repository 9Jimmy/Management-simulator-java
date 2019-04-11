package com.jimmy9.management.backend;

import java.util.Scanner;

import static com.jimmy9.management.design.Colors.RED;
import static com.jimmy9.management.design.Colors.RESET;

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
            switch (i.toUpperCase()){
                case "INFO":
                    commands.info();
                    break;
                case "HELP":
                    commands.help();
                    break;
                case "ADDW":
                    commands.addW();
                    break;
                case "SHOWALL":
                    commands.showAll();
                    break;
                case "SHOWS":
                    commands.showS();
                    break;
                case "CHANGES":
                    commands.changeS();
                    break;
                case "CHANGEP":
                    commands.changeP();
                    break;
                case "DELETEW":
                    commands.deleteW();
                    break;
                case "CLIST":
                    commands.clist();
                    break;
                case "EXIT":
                    session = false;
                    break;
                    default:
                        RED.Color();
                        System.out.printf("%nUnknown command \'%s\' enter \'help\' to check list of commands.", i);
                        RESET.Color();
            }
        }
    }
}
