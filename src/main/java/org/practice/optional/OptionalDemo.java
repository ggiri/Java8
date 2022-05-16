package org.practice.optional;

import org.practice.stream.mapandflatmap.Customer;
import org.practice.stream.mapandflatmap.EKartDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) throws Exception {
        Customer customer=new Customer(101, "john", null,
                Arrays.asList("397937955", "21654725"));

        //empty
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        //of -- use only when you know the value is not null
//        Optional<String> emailOptional= Optional.of(customer.getEmail());
//        System.out.println(emailOptional);


        //returns empty optional when the value is null
        Optional<String> email = Optional.ofNullable(customer.getEmail());
        System.out.println(email);

//        if(email.isPresent()){
//            System.out.println(email.get());
//        }
        email.ifPresent(System.out::println);

        System.out.println(email.orElse("dummy"));

        //throw custom exception
//        System.out.println(email.orElseThrow(()->new IllegalArgumentException("Email is null")));

        System.out.println(email.map(String::toUpperCase).orElseGet(()->"default..."));

        System.out.println(getCustomerByEmailId("pqr"));
    }

    static Customer getCustomerByEmailId(String email) throws Exception {
        List<Customer> customers = EKartDatabase.getAll();
       return  customers.stream().filter(customer -> customer.getEmail().equals(email)).findAny()
               .orElseThrow(()->new Exception("Customer with given email not found"));
    }
}
