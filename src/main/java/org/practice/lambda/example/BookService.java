package org.practice.lambda.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookService {

    public List<Book> getSortedBooks(){
        List<Book> books = new BookDAO().getBooks();
        books.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        books.sort(Comparator.comparing(Book::getName));
        return books;
    }

    public static void main(String[] args) {
        System.out.println(new BookService().getSortedBooks());
    }
}

