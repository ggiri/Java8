package org.practice.stream.mapandflatmap;

import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String[] args) {
        List<Customer> customers = EKartDatabase.getAll();

        //get all emailIds
        //customer -> customer.getEmail() one to one mapping
        List<String> emailIds = customers.stream().map(Customer::getEmail).collect(Collectors.toList());

        //[john@gmail.com, smith@gmail.com, peter@gmail.com, kely@gmail.com]
        System.out.println(emailIds);

        //customer -> customer.getEmail() one to many mapping
        List<List<String>> phoneNumbers = customers.stream().map(Customer::getPhoneNumbers).collect(Collectors.toList());
//        [[397937955, 21654725], [89563865, 2487238947], [38946328654, 3286487236], [389246829364, 948609467]]
        System.out.println(phoneNumbers);

        List<String> phones = customers.stream().flatMap(customer -> customer.getPhoneNumbers().stream()).collect(Collectors.toList());
//        [397937955, 21654725, 89563865, 2487238947, 38946328654, 3286487236, 389246829364, 948609467]
        System.out.println(phones);
    }
}
