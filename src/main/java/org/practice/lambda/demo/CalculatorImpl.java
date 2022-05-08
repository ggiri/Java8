package org.practice.lambda.demo;

public class CalculatorImpl {
    public static void main(String[] args) {
//        Calculator calc = () -> {
//            System.out.println("Switch on");
//        };
//        calc.switchOn();

//        Calculator calc = (int input) -> {
//            System.out.println("Sum: " +input);
//        };
//        calc.printValue(1234);
//        Calculator calc = ( i1,  i2) -> i1+i2;
        Calculator calc = Integer::sum;
        System.out.println("Sum:"+calc.sum(1,2));
    }
}
