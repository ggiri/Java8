package org.practice.functionalinterface.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateInCollection {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("John", "admin"));
        users.add(new User("Peter", "member"));
        List admins = process(users, (User u) -> u.getRole().equals("admin"));
        System.out.println(admins);
    }

    private static List process(List<User> users, Predicate<User> predicate) {
        return users.stream().filter(predicate).collect(Collectors.toList());
    }
}
