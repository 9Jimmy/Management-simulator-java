package com.jimmy9.management.backend;

import java.util.*;

class Company {

    private List<Workers> workersList = new ArrayList<>();

    void addWorker(String company, String key, String fname, String sname, String position, String age, String salary){
        for(Workers worker : workersList){
            if(worker.key().equals(key)){
                System.out.printf("\nEmployee with key %s already exists. Please enter another key.", key);
                return;
            }
        }
        workersList.add(new Workers.Builder(company, key, fname)
                .sname(sname)
                .position(position)
                .age(age)
                .salary(salary)
                .build());
    }

    void showListOfWorkersInSelectedCompany(String company){
        boolean containsCompany = false;
        for(Workers worker : workersList){
            if(worker.company().equals(company)){
                containsCompany = true;
                break;
            }
        }
        if(!containsCompany){
            System.out.printf("Company %s not found!", company);
        }
        System.out.printf("%s\n\n", company);
        for(Workers worker : workersList){
            if(worker.company().equals(company)){
                System.out.println(worker);
            }
        }
    }

    private Workers findByKey(String key){
        try{
            for(Workers worker : workersList){
                if (worker.key().equals(key)){
                    return worker;
                }
            }
        } catch (NullPointerException e) {
            System.out.printf("Employee with key %s not found", key);
        }
        return null;
    }

    void showSelectedWorker(String company, String key) {
        try {
            Workers selectedWorker = findByKey(key);
            if (selectedWorker != null && selectedWorker.company().equals(company)){
                System.out.printf("%s\n\n", company);
                System.out.println(selectedWorker);
            } else {
                System.out.printf("Company %s not found!", company);
            }
        } catch (NullPointerException e) {
            System.out.printf("Employee with key %s in company %s not found!\n\n", key, company);
        }
    }

    void changeSalary(String company, String key, String value){
        try {
            Workers selectedWorker = findByKey(key);
            if(selectedWorker != null && selectedWorker.company().equals(company)){
                selectedWorker.setSalary(value);
            } else {
                System.out.printf("Company %s not found!", company);
            }
        } catch (NullPointerException e) {
            System.out.printf("Employee with key %s in company %s not found!\n\n", key, company);
        }
    }

    void changePosition(String company, String key, String position){
        try{
            Workers selectedWorker = findByKey(key);
            if (selectedWorker != null && selectedWorker.company().equals(company)){
                selectedWorker.setPosition(position);

            } else {
                System.out.printf("Company %s not found!", company);
            }
        } catch (NullPointerException e) {
            System.out.printf("Employee with key %s in company %s not found!\n\n", key, company);
        }
    }

    void deleteWorker(String company, String key){
        try{
            for(Workers worker : workersList){
                if(worker.key().equals(key)
                        && worker.company().equals(company)){
                    workersList.remove(worker);
                    break;
                } else {
                    System.out.printf("Employee with key %s in company %s not found!\n\n", key, company);
                }
            }
        } catch (NullPointerException e) {
            System.out.printf("Employee with key %s in company %s not found!\n\n", key, company);
        } catch (ConcurrentModificationException e){}
    }

    void showListOfCompanies(){
        TreeSet<String> listOfCompanies = new TreeSet<String>();
        System.out.printf("List of companies: %n");
        for(Workers worker : workersList){
            if(!listOfCompanies.contains(worker.company())){
                listOfCompanies.add(worker.company());
            }
        }
        for(String company : listOfCompanies){
            System.out.println(company);
        }
    }
}
