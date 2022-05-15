package org.practice.functionalinterface.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//public class ConsumerDemo implements Consumer<Integer> {
//    @Override
//    public void accept(Integer integer) {
//        System.out.println("Printing: "+integer);
//    }
public class ConsumerDemo {
    public static void main(String[] args) {
       Consumer<Integer> consumer = integer -> System.out.println("Printing: "+integer);

       consumer.accept(100);

       List<Integer> l = Arrays.asList(1,2,3,4,5);

       l.stream().forEach(consumer);

        // Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer> > modify = list -> list.replaceAll(integer -> 2 * integer);

        //consumer to display the list
        Consumer<List<Integer>> display = list -> list.forEach(i-> System.out.println(i+ " "));

        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(3);
        modify.accept(list);
        display.accept(list);

        //using andThen
        modify.andThen(display).accept(list);

        try{
            modify.andThen(null).accept(list);
        }catch(Exception e){
            System.out.println("Exception: " +e);
        }

        // Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer> > multiply = newList ->
        {
            for (int i = 0; i <= newList.size(); i++)
                newList.set(i, 2 * newList.get(i));
        };
        List<Integer> newList = new ArrayList<>();
        newList.add(4);
        newList.add(5);
        newList.add(6);

        try{
            modify.andThen(display).accept(newList);
        }catch(Exception e){
            System.out.println("Exception: " +e);
        }
    }
}
