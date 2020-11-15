package com.devhwkang.java8;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        /**
         * PART 2-4 : 메소드 레퍼런스
         */
        System.out.println("================================================================================");
        System.out.println("== PART 2-4");

        // 스태틱 메소드 참조하는 방법 : 타입::스태틱 메소드
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("devhwkang"));

        // 특정 객체의 인스턴스 메소드 참조하는 방법 : 타입::인스턴스 메소드
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("devhwkang"));

        // 생성자 참조1
        Function<String, Greeting> overGreeting = Greeting::new;
        Greeting tempGreeting = overGreeting.apply("devhwkang");
        System.out.println(tempGreeting.getName());

        // 생성자 참조2
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting tempGreeting2 = newGreeting.get();
        System.out.println(tempGreeting2.getName());

        // 임의의 객체의 인스턴스 메소드 참조하는 방법 : 타입::인스턴스 메소드
        String[] names = {"carrot", "apple", "banna"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

        Integer[] numbers = {3,2,1,4,6,5,1,1,2};
        Arrays.sort(numbers, Integer::compareTo);
        System.out.println(Arrays.toString(numbers));
    }
}
