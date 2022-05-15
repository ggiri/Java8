package org.practice.stream.filter;

import java.util.List;
import java.util.stream.Collectors;

public class TaxService {

    public static void main(String[] args) {
        System.out.println(evaluateTaxableUsers("Tax"));
    }

    static List<Employee> evaluateTaxableUsers(String input){
        return (input.equalsIgnoreCase("tax")) ?
                Database.getEmployees().stream().filter(emp->emp.getSalary()>500000).collect(Collectors.toList()):
                Database.getEmployees().stream().filter(emp->emp.getSalary()<=500000).collect(Collectors.toList());
    }
}
