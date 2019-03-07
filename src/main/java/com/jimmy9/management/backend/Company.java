package com.jimmy9.management.backend;

import java.util.*;

public class Company {

    Map<Double, Workers> workersList = new HashMap<Double, Workers>();

    void addWorker(String company, String key, String fname, String sname, String position, String age, String salary){
        double identy_key = Math.random()*100;
        for(Map.Entry<Double, Workers> personKey : workersList.entrySet()){
            if(personKey.getValue().key().equals(key)){
                System.out.printf("\nEmployee with key %s already exists. Please enter another key.", key);
                return;
            }
        }
        workersList.put(identy_key, new Workers.Builder(company, key, fname)
                                .sname(sname)
                                .position(position)
                                .age(age)
                                .salary(salary)
                                .build());
    }

    public Map<Double, Workers> showListOfWorkersInSelectedCompany(String company){
        boolean containsCompany = false;
        for(Map.Entry<Double, Workers> personCompany : workersList.entrySet()){
            if(personCompany.getValue().company().equals(company)){
                containsCompany = true;
                break;
            }
        }
        if(containsCompany == false){
            System.out.printf("Company %s not found!", company);
            return null;
        }
        System.out.printf("%s\n\n", company);
        for(Map.Entry<Double, Workers> person : workersList.entrySet()){
            if(person.getValue().company().equals(company)){
                System.out.printf("|%s|_|FName: %s|_|SName: %s|_|Position: %s|_|Age: %s|_|Salary: %s| \n",
                        person.getValue().key(), person.getValue().fname(), person.getValue().sname(),
                        person.getValue().position(), person.getValue().age(), person.getValue().salary());
            }
        }
        return workersList;
    }

    public Workers findByKey(String key){
        try{
            for(Map.Entry<Double, Workers> person : workersList.entrySet()){
                if (person.getValue().key().equals(key)){
                    return workersList.get(person.getKey());
                }
            }
        } catch (NullPointerException e) {
            System.out.printf("Employee with key %s not found", key);
        }
        return null;
    }

    public Workers showSelectedWorker(String company, String key) {
        try {
            Workers selectedWorker = findByKey(key);
            if (selectedWorker.company().equals(company)){
                System.out.printf("%s\n\n", company);
                System.out.printf("|" + selectedWorker.key() + "|_" + "|FName: %s|_|SName: %s|_|Position: %s|_|Age: %s|_|Salary: %s| \n",
                        selectedWorker.fname(), selectedWorker.sname(),
                        selectedWorker.position(), selectedWorker.age(), selectedWorker.salary());
                return selectedWorker;
            } else {
                System.out.printf("Company %s not found!", company);
            }
        } catch (NullPointerException e) {
            System.out.printf("Employee with key %s in company %s not found!\n\n", key, company);
        }
        return null;
    }

    public Workers changeSalary(String company, String key, String value){
        try {
            Workers selectedWorker = findByKey(key);
            if(selectedWorker.company().equals(company)){
                selectedWorker.setSalary(value);
                return selectedWorker;
            } else {
                System.out.printf("Company %s not found!", company);
            }
        } catch (NullPointerException e) {
            System.out.printf("Employee with key %s in company %s not found!\n\n", key, company);
        }
        return null;
    }

    public Workers changePosition(String company, String key, String position){
        try{
            Workers selectedWorker = findByKey(key);
            if (selectedWorker.company().equals(company)){
                selectedWorker.setPosition(position);
                return selectedWorker;
            } else {
                System.out.printf("Company %s not found!", company);
            }
        } catch (NullPointerException e) {
            System.out.printf("Employee with key %s in company %s not found!\n\n", key, company);
        }
        return null;
    }

    void deleteWorker(String company, String key){
        try{
            for(Map.Entry<Double, Workers> person : workersList.entrySet()){
                if(person.getValue().key().equals(key)
                        && person.getValue().company().equals(company)){
                    workersList.remove(person.getKey());
                    break;
                } else {
                    System.out.printf("Employee with key %s in company %s not found!\n\n", key, company);
                }
            }
        } catch (NullPointerException e) {
            System.out.printf("Employee with key %s in company %s not found!\n\n", key, company);
        } catch (ConcurrentModificationException e){}
    }

    public void showListOfCompanies(){
        TreeSet<String> listOfCompanies = new TreeSet<String>();
        System.out.printf("List of companies: %n");
        for(Map.Entry<Double, Workers> companies : workersList.entrySet()){
            if(!listOfCompanies.contains(companies.getValue().company())){
                listOfCompanies.add(companies.getValue().company());
            }
        }
        for(String company : listOfCompanies){
            System.out.println(company);
        }
    }
}