package org.practice.functionalinterface.predicate;

import java.util.function.Predicate;

public class PredicateChainingDemo {
    public static void main(String[] args) {
        Predicate<Integer> greaterThanTen = i -> i > 10;

        // Creating predicate
        Predicate<Integer> lesserThanTwenty = i -> i < 20;
        boolean result = greaterThanTen.and(lesserThanTwenty).test(15);
        System.out.println(result);

        System.out.println(greaterThanTen.or(lesserThanTwenty).test(9));

        // Calling Predicate method
        boolean result2 = greaterThanTen.and(lesserThanTwenty).negate().test(15);
        System.out.println(result2);
    }
}
