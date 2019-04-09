package com.jimmy9.management.backend;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.jimmy9.management.design.Colors.*;
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
            RED.Color();
            out.printf("%nEmployee with key \'%s\' already exists. Please enter another key.", key);
            RESET.Color();
        }
    }

    void showListOfWorkersInSelectedCompany(String company){
        if(workersList.stream().noneMatch(worker -> worker.company().equals(company))){
            RED.Color();
            out.printf("Company %s not found!", company);
            RESET.Color();
        }
        BLUE.Color();
        out.printf("%s%n%n", company);

        workersList.stream()
                .filter(worker -> worker.company().equals(company))
                .forEach(out::println);
        RESET.Color();
    }

    private Workers findByKey(String key){
        try{
            return workersList.stream()
                    .filter(worker -> worker.key().equals(key))
                    .collect(Collectors.toList()).get(0);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            RED.Color();
            out.printf("Employee with key \'%s\' not found%n", key);
            RESET.Color();
        }
        return null;
    }

    void showSelectedWorker(String company, String key) {
        //noinspection CatchMayIgnoreException
        try {
            Workers a = findByKey(key);
            //noinspection ConstantConditions
            if (!a.company().equals(company)){
                RED.Color();
                out.printf("Employee with key \'%s\' in company \'%s\' not found!%n%n", key, company);
                RESET.Color();
            }
            else {
                BLUE.Color();
                out.println("\n" + a);
                RESET.Color();
            }
        } catch (NullPointerException e) {}
    }

    void changeSalary(String company, String key, String value){
        //noinspection CatchMayIgnoreException
        try {
            Workers a = findByKey(key);
            //noinspection ConstantConditions
            if (!a.company().equals(company)){
                RED.Color();
                out.printf("Employee with key \'%s\' in company \'%s\' not found!%n%n", key, company);
                RESET.Color();
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
                RED.Color();
                out.printf("Employee with key \'%s\' in company \'%s\' not found!%n%n", key, company);
                RESET.Color();
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
                RED.Color();
                out.printf("Employee with key \'%s\' in company \'%s\' not found!%n%n", key, company);
                RESET.Color();
            } else {
                workersList.remove(a);
            }
        } catch (NullPointerException | ConcurrentModificationException e) {}
    }

    static <T>Predicate<T> distinctByCompany(Function<? super T, ?> companyExtractor){
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(companyExtractor.apply(t));
    }

    void showListOfCompanies(){
        if(new ArrayList<>(workersList).isEmpty()){
            RED.Color();
            out.println("There is no companies!");
            RESET.Color();
        }
        else{
            BLUE.Color();
            workersList.stream().filter(distinctByCompany(Workers::company))
                    .map(Workers::company).forEach(out::println);
            RESET.Color();
        }
    }
}
