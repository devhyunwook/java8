package com.devhwkang.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        /**
         * PART 4-1 : Stream 소개
         */
        System.out.println("================================================================================");
        System.out.println("== PART 4-1");

        List<String> names = new ArrayList<>();
        names.add("apple");
        names.add("pineapple");
        names.add("carrot");
        names.add("buleberry");
        names.add("diamond");
        // 중개 operator 들은 실행되는것이 아니다. (map은 대표적인 중개 오퍼레이션)
        names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        });

        // 종료 operator 들이 결합되야 실행된다. (collect는 대표적인 종료 operator)
        List<String> upperNames = names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        names.forEach(System.out::println); // 원본소스는 변경되지 않는다
        upperNames.forEach(System.out::println);

        // stream은 병렬처리가 용이하다
        List<String> upperNames2 = names.parallelStream()
                .map(s -> {
                    System.out.println(s + " " + Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .collect(Collectors.toList());
        upperNames2.forEach(System.out::println);

        /**
         * PART 4-2 : Stream API
         */
        System.out.println("================================================================================");
        System.out.println("== PART 4-2");
    }
}
