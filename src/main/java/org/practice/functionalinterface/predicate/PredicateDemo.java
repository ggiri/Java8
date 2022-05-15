package org.practice.functionalinterface.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//public class PredicateDemo implements Predicate<Integer> {
//
//    @Override
//    public boolean test(Integer integer) {
//        return integer % 2 == 0;
//    }
public class PredicateDemo{
        public static void main(String[] args) {
            Predicate<Integer> isEven = integer -> integer % 2 == 0;
            System.out.println(isEven.test(4));

            List<Integer> list = Arrays.asList(1,2,3,4,5);

            list.stream().filter(isEven).forEach(i-> System.out.println("Even: "+i));
    }
}
