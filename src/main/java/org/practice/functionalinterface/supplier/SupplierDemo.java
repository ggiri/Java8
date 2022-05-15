package org.practice.functionalinterface.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

//public class SupplierDemo implements Supplier<String> {
//    @Override
//    public String get() {
//        return "Hi! Supplier here";
//    }
public class SupplierDemo{
    public static void main(String[] args) {
        Supplier<String> supplier =  () -> "Hi! Supplier here";
        System.out.println(supplier.get());

        // This function returns a random value.
        Supplier<Double> randomValue = Math::random;

        // Print the random value using get()
        System.out.println(randomValue.get());
    }
}
