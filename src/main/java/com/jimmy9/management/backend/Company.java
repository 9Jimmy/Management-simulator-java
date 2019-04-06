package com.jimmy9.management.backend;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

class Company {

    private List<Workers> workersList = new ArrayList<>();

    void addWorker(String company, String key, String fname, String sname, String position, String age, String salary){
        if(workersList.stream().noneMatch(worker -> worker.key().equals(key))) {
            workersList.add(new Workers.Builder(company, key, fname)
                    .sname(sname)
                    .position(position)
                    .age(age)
                    .salary(salary)
                    .build());
        }
        else {
            out.printf("%nEmployee with key \'%s\' already exists. Please enter another key.", key);
        }
    }

    void showListOfWorkersInSelectedCompany(String company){
        if(workersList.stream().noneMatch(worker -> worker.company().equals(company))){
            out.printf("Company %s not found!", company);
        }
        out.printf("%s%n%n", company);

        workersList.stream()
                .filter(worker -> worker.company().equals(company))
                .forEach(out::println);
    }

    private Workers findByKey(String key){
        try{
            return workersList.stream()
                    .filter(worker -> worker.key().equals(key))
                    .collect(Collectors.toList()).get(0);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            out.printf("Employee with key \'%s\' not found%n", key);
        }
        return null;
    }

    void showSelectedWorker(String company, String key) {
        //noinspection CatchMayIgnoreException
        try {
            Workers a = findByKey(key);
            //noinspection ConstantConditions
            if (!a.company().equals(company)){
                out.printf("Employee with key \'%s\' in company \'%s\' not found!%n%n", key, company);
            }
            else {
                out.println("\n" + a);
            }
        } catch (NullPointerException e) {}
    }

    void changeSalary(String company, String key, String value){
        //noinspection CatchMayIgnoreException
        try {
            Workers a = findByKey(key);
            //noinspection ConstantConditions
            if (!a.company().equals(company)){
                out.printf("Employee with key \'%s\' in company \'%s\' not found!%n%n", key, company);
            }
            else {
                a.setSalary(value);
            }
        } catch (NullPointerException e) {}
    }

    void changePosition(String company, String key, String position){
        //noinspection CatchMayIgnoreException
        try {
            Workers a = findByKey(key);
            //noinspection ConstantConditions
            if (!a.company().equals(company)){
                out.printf("Employee with key \'%s\' in company \'%s\' not found!%n%n", key, company);
            }
            else {
                a.setPosition(position);
            }
        } catch (NullPointerException e) {}
    }

    void deleteWorker(String company, String key){
        //noinspection CatchMayIgnoreException
        try {
            Workers a = findByKey(key);
            //noinspection ConstantConditions
            if (!a.company().equals(company)) {
                out.printf("Employee with key \'%s\' in company \'%s\' not found!%n%n", key, company);
            } else {
                workersList.remove(a);
            }
        } catch (NullPointerException | ConcurrentModificationException e) {}
    }

    void showListOfCompanies(){
        if(workersList.stream().map(Workers::company).collect(Collectors.toList()).isEmpty()){
            out.println("There is no companies!");
        }
        else{
            workersList.stream().map(Workers::company).forEach(out::println);
        }
    }
}
