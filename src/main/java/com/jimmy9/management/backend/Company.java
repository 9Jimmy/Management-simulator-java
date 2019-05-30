package com.jimmy9.management.backend;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.jimmy9.management.design.Colors.*;
import static java.lang.System.out;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Company {

    private final Logger logger = LoggerFactory.getLogger(Company.class);
    private List<Workers> workersList = new ArrayList<>();

    /**
     * Add new object 'Workers' with specified parameters in 'workersList'
     *
     * @param key - must be unique
     * */
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
            logger.error("\nEmployee with key \'{}\' already exists. Please enter another key.", key);
            RESET.Color();
        }
    }

    /**
     * Prints to console all 'Workers' objects from 'workersList' where 'company' parameter are equal
     *  to 'company' parameter from this method
     * */
    void showListOfWorkersInSelectedCompany(String company){
        if(workersList.stream().noneMatch(worker -> worker.company().equals(company))){
            RED.Color();
            logger.error("Company \'{}\' not found!", company);
            RESET.Color();
        } else {
            BLUE.Color();
            out.printf("%s%n%n", company);

            workersList.stream()
                    .filter(worker -> worker.company().equals(company))
                    .forEach(out::println);
            RESET.Color();
        }
    }

    /**
     * @return object 'Workers' from 'workersList' where 'key' parameter are equal to 'key' parameter
     * from this method
     * */
    private Workers findByKey(String key){
        if (workersList.stream().noneMatch(worker -> worker.key().equals(key))){
            RED.Color();
            logger.error("Employee with key \'{}\' not found\n", key);
            RESET.Color();
            return null;
        }
        else {
            Optional<Workers> wk =  workersList.stream().filter(worker -> worker.key()
                    .equals(key)).findFirst();

            return wk.orElse(null);
        }
    }

    /**
     * Prints to console object 'Workers' from 'workersList' where 'company' and 'key' parameters are
     * equals to 'company' and 'key' parameters from this method
     * */
    void showSelectedWorker(String company, String key) {
        Workers a = findByKey(key);
        if (Objects.isNull(a) || !a.company().equals(company)){
            RED.Color();
            logger.error("Employee with key \'{}\' in company \'{}\' not found!\n\n", key, company);
            RESET.Color();
        }
        else {
            BLUE.Color();
            out.println("\n" + a);
            RESET.Color();
        }
    }

    /**
     * Changes 'salary' parameter to object 'Workers' from 'workersList' where 'company' and 'key'
     * parameters are equals to 'company' and 'key' parameters from this method
     *
     * @param value - new value of 'salary' parameter
     * */
    void changeSalary(String company, String key, String value){
            Workers a = findByKey(key);
            if (Objects.isNull(a) || !a.company().equals(company)){
                RED.Color();
                logger.error("Employee with key \'{}\' in company \'{}\' not found!\n\n", key, company);
                RESET.Color();
            }
            else {
                a.setSalary(value);
            }
    }

    /**
     * Changes 'position' parameter to object 'Workers' from 'workersList' where 'company' and 'key'
     * parameters are equals to 'company' and 'key' parameters from this method
     *
     * @param position - new value of 'position' parameter
     * */
    void changePosition(String company, String key, String position){
            Workers a = findByKey(key);
            if (Objects.isNull(a) || !a.company().equals(company)){
                RED.Color();
                logger.error("Employee with key \'{}\' in company \'{}\' not found!\n\n", key, company);
                RESET.Color();
            }
            else {
                a.setPosition(position);
            }
    }

    /**
     * Removes object 'Workers' from 'workersList' where 'company' and 'key' parameters are equals to
     * 'company' and 'key' parameters from this method
     * */
    void deleteWorker(String company, String key){
            Workers a = findByKey(key);
            if (Objects.isNull(a) || !a.company().equals(company)) {
                RED.Color();
                logger.error("Employee with key \'{}\' in company \'{}\' not found!\n\n", key, company);
                RESET.Color();
            } else {
                workersList.remove(a);
            }
    }

    /**
     * @return Set of objects without objects with similar specified parameters
     * */
    private static <T>Predicate<T> distinctByCompany(Function<? super T, ?> companyExtractor){
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(companyExtractor.apply(t));
    }

    /**
     * Prints to console all list of 'company' parameters from 'workersList' without copies
     * */
    void showListOfCompanies(){
        if(workersList.isEmpty()){
            RED.Color();
            logger.error("There is no companies!");
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
