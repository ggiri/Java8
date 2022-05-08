package org.practice.lambda.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookService {

    public List<Book> getSortedBooks(){
        List<Book> books = new BookDAO().getBooks();
//        Collections.sort(books, (o1,o2) -> o1.getName().compareTo(o2.getName()));
        Collections.sort(books, Comparator.comparing(Book::getName));
        return books;
    }

    public static void main(String[] args) {
        System.out.println(new BookService().getSortedBooks());
    }
}

