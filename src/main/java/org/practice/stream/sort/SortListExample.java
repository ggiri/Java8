package org.practice.stream.sort;

import org.practice.stream.filter.Database;
import org.practice.stream.filter.Employee;

import java.util.*;

public class SortListExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8,19,2,1,25);
        Collections.sort(list);//ascending
        Collections.reverse(list);//descending
        System.out.println(list);

        //using lamdba
        list.stream().sorted().forEach(l-> System.out.println(l));//ascending
        list.stream().sorted(Comparator.reverseOrder()).forEach(l-> System.out.println(l));//descending

        List<Employee> employees = Database.getEmployees();
        employees.sort((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()));//ascending
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o2.getSalary() - o1.getSalary());//descending
            }
        });
        System.out.println(employees);
        System.out.println("Sort using salary descending");
        employees.stream().sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary())).forEach(System.out::println);//desc
        System.out.println("Sort using dept");
        employees.stream().sorted(Comparator.comparing(Employee::getDept)).forEach(System.out::println);//asc
    }

}

//class MyComparator implements Comparator<Employee> {
//
//    @Override
//    public int compare(Employee o1, Employee o2) {
//        return (int) (o1.getSalary()-o2.getSalary());//ascending
////        return (int) (o2.getSalary()-o1.getSalary());//descending
//    }
//}
