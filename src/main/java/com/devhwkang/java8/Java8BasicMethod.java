package com.devhwkang.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class Java8BasicMethod {
    public static void main(String[] args) {
        /**
         * PART 3-2 : 인터페이스 기본 메소드와 스태틱 메소드2
         */
        System.out.println("================================================================================");
        System.out.println("== PART 3-2");

        List<String> names = new ArrayList<>();
        names.add("apple");
        names.add("carrot");
        names.add("banana");

        names.forEach(System.out::println);

        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("================================================================================");
        while (spliterator1.tryAdvance(System.out::println));

        System.out.println("================================================================================");
        names.removeIf(s -> s.startsWith("a"));
        names.forEach(System.out::println);

        System.out.println("================================================================================");
        // Comparator
        Comparator<String> comparator = String::compareToIgnoreCase;
        names.sort(comparator.reversed());
        names.forEach(System.out::println);
    }
}
