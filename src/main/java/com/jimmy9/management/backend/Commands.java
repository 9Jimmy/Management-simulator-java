package com.jimmy9.management.backend;

import java.util.Scanner;

import static com.jimmy9.management.design.Colors.*;
import static java.lang.System.out;

class Commands {
    private Company companyObj = new Company();
    private Scanner input = new Scanner(System.in);

    private String company, key, fname, sname, position, age, salary, value;

    private void checkStringValue(String value){
        String a = input.nextLine();

        while (a.equals("")){
            RED.Color();
            out.println("Cannot be empty. Try again.");
            RESET.Color();
            out.print("-> ");
            a = input.nextLine();
        }

        switch (value){
            case "company":
                this.company = a;
                break;
            case "key":
                this.key = a;
                break;
            case "fname":
                this.fname = a;
                break;
            case "sname":
                this.sname = a;
                break;
            case "position":
                this.position = a;
                break;
            case "age":
                this.age = a;
                break;
            case "salary":
                this.salary = a;
                break;
            case "value":
                this.value = a;
                break;
        }
    }

     void info(){
         BLUE.Color();
        out.println("\n\t░░░░░░░█▐▓▓░████▄▄▄█▀▄▓▓▓▌█\n" +
                "\t░░░░░▄█▌▀▄▓▓▄▄▄▄▀▀▀▄▓▓▓▓▓▌█\n" +
                "\t░░░▄█▀▀▄▓█▓▓▓▓▓▓▓▓▓▓▓▓▀░▓▌█\n" +
                "\t░░█▀▄▓▓▓███▓▓▓███▓▓▓▄░░▄▓▐█▌ \n" +
                "\t░█▌▓▓▓▀▀▓▓▓▓███▓▓▓▓▓▓▓▄▀▓▓▐█\n" +
                "\t▐█▐██▐░▄▓▓▓▓▓▀▄░▀▓▓▓▓▓▓▓▓▓▌█▌\n" +
                "\t█▌███▓▓▓▓▓▓▓▓▐░░▄▓▓███▓▓▓▄▀▐█\n" +
                "\t█▐█▓▀░░▀▓▓▓▓▓▓▓▓▓██████▓▓▓▓▐█ \n" +
                "\t▌▓▄▌▀░▀░▐▀█▄▓▓██████████▓▓▓▌█▌\n" +
                "\t▌▓▓▓▄▄▀▀▓▓▓▀▓▓▓▓▓▓▓▓█▓█▓█▓▓▌█▌ \n" +
                "\t█▐▓▓▓▓▓▓▄▄▄▓▓▓▓▓▓█▓█▓█▓█▓▓▓▐█\n");
        out.println("\tManagement-Simulator\n\tCreated by 9Jimmy\n\t03.03.2019");
        RESET.Color();
    }

     void help(){
        BLUE.Color();
        out.println("***************************************************************************");
        out.println("*\t                      List of commands                                *\n*" +
                "                                                                         *\n" +
                "*\t1)'addW'-Add new employee (If the specified company                   " +
                "*                                                                         " +
                "\n*\tdoes not exist, a new one will be created with the specified name).   *\n" +
                "*                                                                         " +
                "*\n*\t2)'showAll'-show list of all employees in selected company.           *\n" +
                "*                                                                         " +
                "*\n*\t3)'showS'-show selected employee in selected company.                 *\n" +
                "*                                                                         " +
                "*\n*\t4)'changeS'-change salary of specified employee.                      *\n" +
                "*                                                                         " +
                "*\n*\t5)'changeP'-change position of specified employee.                    *\n" +
                "*                                                                         " +
                "*\n*\t6)'deleteW'-delete specified employee.                                *\n" +
                "*                                                                         " +
                "*\n*\t7)'clist'-show list of all companies.                                 *\n" +
                "*                                                                         " +
                "*\n*\t8)'exit'-exit.                                                        *\n*" +
                "                                                                         *");
        out.println("***************************************************************************");
        RESET.Color();
    }

     void addW(){
        out.print("Enter company name: ");
        checkStringValue("company");
        out.print("Enter key of employee (must be unique): ");
        checkStringValue("key");
        out.print("Enter first name of employee: ");
        checkStringValue("fname");
        out.print("Enter second name of employee: ");
        checkStringValue("sname");
        out.print("Enter position of employee: ");
        checkStringValue("position");
        out.print("Enter age of employee: ");
        checkStringValue("age");
        out.print("Enter salary of employee: ");
        checkStringValue("salary");
        companyObj.addWorker(company, key, fname, sname, position, age, salary);
    }

    void showAll(){
        out.print("Enter company name: ");
        checkStringValue("company");
        companyObj.showListOfWorkersInSelectedCompany(company);
    }

    void showS(){
        out.print("Enter company name: ");
        checkStringValue("company");
        out.print("Enter key of employee: ");
        checkStringValue("key");
        companyObj.showSelectedWorker(company, key);
    }

    void changeS(){
        out.print("Enter company name: ");
        checkStringValue("company");
        out.print("Enter key of employee: ");
        checkStringValue("key");
        out.print("Enter new salary: ");
        checkStringValue("value");
        companyObj.changeSalary(company, key, value);
    }

    void changeP(){
        out.print("Enter company name: ");
        checkStringValue("company");
        out.print("Enter key of employee: ");
        checkStringValue("key");
        out.print("Enter new position of employee: ");
        checkStringValue("position");
        companyObj.changePosition(company, key, position);
    }

    void deleteW(){
        out.print("Enter company name: ");
        checkStringValue("company");
        out.print("Enter key of employee: ");
        checkStringValue("key");
        out.print("\nAre you sure? (Y/N): ");
        String confirm = input.nextLine();
        if (confirm.toUpperCase().equals("Y")) {
            companyObj.deleteWorker(company, key);
        }
    }

    void clist(){
        companyObj.showListOfCompanies();
    }
}
