package org.practice.stream.foreach;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ForEachDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Giri", "Giridhar", "Gigo");

        for(String s:list){
            System.out.println("For loop: "+s);
        }

        list.stream().filter(s->s.endsWith("r")).forEach(i-> System.out.println(""));

        Consumer<String> consumer = System.out::println;
        for(String s:list){
            consumer.accept(s);
        }

        Map<Integer, String> map = new HashMap<>();
        map.put(1,"Giri");
        map.put(2, "Giridhar");
        map.put(3, "Gigo");

        map.forEach((key,value)-> System.out.println(key+":"+value));
        map.forEach((key,value)-> System.out.println(key+":"+value));
        map.entrySet().stream().filter(i->i.getKey()%2==0).forEach(System.out::println);
    }
}
