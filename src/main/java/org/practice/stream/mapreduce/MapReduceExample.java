package org.practice.stream.mapreduce;

import org.practice.stream.filter.Database;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapReduceExample {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(2,4,6,9,1,3,7);

        List<String> words = Arrays.asList("coreJava", "spring", "hibernate");

        //add all the numbers
        int sum=0;
        for(int number:array){
            sum+=number;
        }
        System.out.println(sum);
        System.out.println(array.stream().mapToInt(Integer::intValue).sum());
        System.out.println(array.stream().reduce(Integer::sum).get());//returns an Optional object with sum
        System.out.println(array.stream().reduce(0, Integer::sum));

//        max value
        System.out.println(array.stream().reduce(0,(a,b)-> a>b?a:b));
        System.out.println(array.stream().reduce(Integer::max).get());
//        min value
        System.out.println(array.stream().reduce((a,b)-> a<b?a:b).get());
        System.out.println(array.stream().reduce(Integer::min).get());


        //longest string
        System.out.println(words.stream().reduce((a,b)->a.length()>b.length()?a:b).get());

        //Employee whose grade is A
       double avgSalary = EmployeeDatabase.getEmployees().stream().filter(employee ->
                employee.getGrade().equalsIgnoreCase("a")).map(Employee::getSalary)
               .mapToDouble(i->i).average().getAsDouble();
        System.out.println(avgSalary);

        double sumSalary = EmployeeDatabase.getEmployees().stream().filter(employee ->
                        employee.getGrade().equalsIgnoreCase("a")).map(Employee::getSalary)
                .mapToDouble(i->i).sum();
        System.out.println(sumSalary);
    }
}
