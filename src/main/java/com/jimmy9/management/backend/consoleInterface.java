package com.jimmy9.management.backend;

import java.util.Scanner;

public class consoleInterface {
    private Company companyObj = new Company();

    public void start(){
        System.out.println("=====================Management-Simulator=====================\n\n\n");
        System.out.print("\nEnter 'help' to check commands\n");
        System.out.print("Enter 'info' to check information about app");
        boolean session = true;

        while (session) {
            Scanner input = new Scanner(System.in);
            System.out.print("\n\n>>>");
            String i = input.nextLine();
            if(i.equals("info")){
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

            else if(i.equals("help")){
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

            else if(i.equals("addW")){
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

            else if(i.equals("showAll")){
                System.out.print("Enter company name: ");
                String company = input.nextLine();

                companyObj.showListOfWorkersInSelectedCompany(company);
            }

            else if(i.equals("showS")){
                System.out.print("Enter company name: ");
                String company = input.nextLine();
                System.out.print("Enter key of employee: ");
                String key = input.nextLine();

                companyObj.showSelectedWorker(company, key);
            }

            else if(i.equals("changeS")){
                System.out.print("Enter company name: ");
                String company = input.nextLine();
                System.out.print("Enter key of employee: ");
                String key = input.nextLine();
                System.out.print("Enter new salary: ");
                String value = input.nextLine();

                companyObj.changeSalary(company, key, value);
            }

            else if(i.equals("changeP")){
                System.out.print("Enter company name: ");
                String company = input.nextLine();
                System.out.print("Enter key of employee: ");
                String key = input.nextLine();
                System.out.print("Enter new position of employee: ");
                String position = input.nextLine();

                companyObj.changePosition(company, key, position);
            }

            else if(i.equals("deleteW")){
                System.out.print("Enter company name: ");
                String company = input.nextLine();
                System.out.print("Enter key of employee: ");
                String key = input.nextLine();
                System.out.print("\nAre you sure? (Y/N): ");
                String confirm = input.nextLine();

                if(confirm.equals("Y")){
                    companyObj.deleteWorker(company, key);
                }
            }

            else if(i.equals("clist")){
                companyObj.showListOfCompanies();
            }

            else if(i.equals("exit")){
                session = false;
            }

            else{
                System.out.printf("\nUnknown command \'%s\' enter \'help\' to check list of commands.", i);
            }
        }
    }
}
