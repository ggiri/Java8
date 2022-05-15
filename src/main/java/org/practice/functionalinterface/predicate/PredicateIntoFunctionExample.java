package org.practice.functionalinterface.predicate;

import java.util.function.Predicate;

public class PredicateIntoFunctionExample {
    static void predicateFunction(int number, Predicate<Integer> predicate)
    {
        if (predicate.test(number)) {
            System.out.println("Number: " + number);
        }
    }
    public static void main(String[] args) {
        predicateFunction(10, (i) -> i > 7);
    }
}
