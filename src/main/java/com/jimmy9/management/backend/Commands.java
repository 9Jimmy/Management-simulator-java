package com.jimmy9.management.backend;

import java.util.Scanner;

 class Commands {
    private Company companyObj = new Company();
    private Scanner input = new Scanner(System.in);

     void info(){
        System.out.println("\n\t░░░░░░░█▐▓▓░████▄▄▄█▀▄▓▓▓▌█\n" +
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
        System.out.println("\tManagement-Simulator\n\tCreated by 9Jimmy\n\t03.03.2019");
    }

     void help(){
        System.out.println("***************************************************************************");
        System.out.println("*\tList of commands:                                                     *\n*                                                                         *\n" +
                "*\t1)'addW'-Add new employee (If the specified company                   " +
                "*                                                                         *\n*\tdoes not exist, a new one will be created with the specified name).   *\n" +
                "*                                                                         *\n*\t2)'showAll'-show list of all employees in selected company.           *\n" +
                "*                                                                         *\n*\t3)'showS'-show selected employee in selected company.                 *\n" +
                "*                                                                         *\n*\t4)'changeS'-change salary of specified employee.                      *\n" +
                "*                                                                         *\n*\t5)'changeP'-change position of specified employee.                    *\n" +
                "*                                                                         *\n*\t6)'deleteW'-delete specified employee.                                *\n" +
                "*                                                                         *\n*\t7)'clist'-show list of all companies.                                 *\n" +
                "*                                                                         *\n*\t8)'exit'-exit.                                                        *\n*                                                                         *");
        System.out.println("***************************************************************************");
    }

     void addW(){
        System.out.print("Enter company name: ");
        String company = input.nextLine();
        System.out.print("Enter key of employee (must be unique): ");
        String key = input.nextLine();
        System.out.print("Enter first name of employee: ");
        String fname = input.nextLine();
        System.out.print("Enter second name of employee: ");
        String sname = input.nextLine();
        System.out.print("Enter position of employee: ");
        String position = input.nextLine();
        System.out.print("Enter age of employee: ");
        String age = input.nextLine();
        System.out.print("Enter salary of employee: ");
        String salary = input.nextLine();
        companyObj.addWorker(company, key, fname, sname, position, age, salary);
    }

    void showAll(){
        System.out.print("Enter company name: ");
        String company = input.nextLine();
        companyObj.showListOfWorkersInSelectedCompany(company);
    }

    void showS(){
        System.out.print("Enter company name: ");
        String company = input.nextLine();
        System.out.print("Enter key of employee: ");
        String key = input.nextLine();
        companyObj.showSelectedWorker(company, key);
    }

    void changeS(){
        System.out.print("Enter company name: ");
        String company = input.nextLine();
        System.out.print("Enter key of employee: ");
        String key = input.nextLine();
        System.out.print("Enter new salary: ");
        String value = input.nextLine();
        companyObj.changeSalary(company, key, value);
    }

    void changeP(){
        System.out.print("Enter company name: ");
        String company = input.nextLine();
        System.out.print("Enter key of employee: ");
        String key = input.nextLine();
        System.out.print("Enter new position of employee: ");
        String position = input.nextLine();
        companyObj.changePosition(company, key, position);
    }

    void deleteW(){
        System.out.print("Enter company name: ");
        String company = input.nextLine();
        System.out.print("Enter key of employee: ");
        String key = input.nextLine();
        System.out.print("\nAre you sure? (Y/N): ");
        String confirm = input.nextLine();
        if (confirm.equals("Y")) {
            companyObj.deleteWorker(company, key);
        }
    }

    void clist(){
        companyObj.showListOfCompanies();
    }
}
